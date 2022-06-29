package fr.eni.encheres.dal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.ConnectionProvider;
import fr.eni.encheres.dal.DALException;

public class UserDAOJdbcImpl {

	private static final String SELECT_USER_BY_PSEUDO_MDP = "SELECT no_utilisateur, pseudo, nom, prenom,\r\n"
			+ "		email, telephone, rue, code_postal, ville,\r\n" + "		mot_de_passe, credit, administrateur\r\n"
			+ "		FROM utilisateurs\r\n" + "		WHERE pseudo = ? AND mot_de_passe = ?";

	private static final String INSERT_USER = "INSERT INTO utilisateurs(pseudo, nom, prenom, email, "
			+ " telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) "
			+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	private static final String SQL_UPDATE_USER = "UPDATE utilisateurs SET no_utilisateur = ?, pseudo = ?, nom = ?, "
			+ "prenom = ?, email = ?, telephone = ?, rue = ?, code_postal = ?, ville = ?, "
			+ "mot_de_passe = ?, credit = ?, administrateur = ? WHERE no_utilisateur = ?";
	
	private static final String SQL_DELETE_USER = "DELETE FROM utilisateurs WHERE no_utilisateur = ?";

	private ConnectionProvider provider;

	public UserDAOJdbcImpl() {
	}

	public Utilisateur selectUserByPseudoMdP(String pseudo, String MdP) throws DALException {
		Utilisateur userTrouve = new Utilisateur();
		try (Connection cnx = createConnexion();) {
			PreparedStatement ordreSelect = cnx.prepareStatement(SELECT_USER_BY_PSEUDO_MDP);
			ordreSelect.setString(1, pseudo);
			ordreSelect.setString(2, MdP);
			ResultSet ligneResultante = ordreSelect.executeQuery();
			if (!ligneResultante.next()) {
				System.out.println("DAO : user non trouvé");
				userTrouve = null;
			} else {
				System.out.println("DAO : user trouvé");
				System.out.println(ligneResultante.getString(2) + " - " + ligneResultante.getString(9));
				userTrouve = userBuilder(ligneResultante);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userTrouve;
	}

	// METHODES INTERNES
	private Connection createConnexion() throws DALException {
		try {
			Connection cnx = ConnectionProvider.getConnection();
			return cnx;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DALException("Problème sur la création d'une connexion", e);
		}
	}

	private Utilisateur userBuilder(ResultSet ligneResultante) throws DALException {
		Utilisateur user = null;
		try {
			user = new Utilisateur(ligneResultante.getString(2), ligneResultante.getString(3),
					ligneResultante.getString(4), ligneResultante.getString(5), ligneResultante.getString(6),
					ligneResultante.getString(7), ligneResultante.getString(8), ligneResultante.getString(9),
					ligneResultante.getString(10), ligneResultante.getInt(11), ligneResultante.getInt(12));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Problème à la construction d'un utilisateur à partir du ResultSet", e);
		}
		return user;
	}

	public void insert(Utilisateur newUser) {

		// s'il n'y a pas de parametre, cela ne sert à rien de continuer.
		if (newUser == null) {
			return;
		}

		try (Connection cnx = ConnectionProvider.getConnection()) // la connexion va être automatiquement fermée
		{
			try {
				cnx.setAutoCommit(false);

				// ********************
				// Ajout dans la table Utilisateur

				PreparedStatement pstmt = cnx.prepareStatement(INSERT_USER, PreparedStatement.RETURN_GENERATED_KEYS);

				// Valorisation des parametres du PreparedStatement
				pstmt.setString(1, newUser.getPseudo());
				pstmt.setString(2, newUser.getNom());
				pstmt.setString(3, newUser.getPrenom());
				pstmt.setString(4, newUser.getEmail());
				pstmt.setString(5, newUser.getTelephone());
				pstmt.setString(6, newUser.getRue());
				pstmt.setString(7, newUser.getCode_postal());
				pstmt.setString(8, newUser.getVille());
				pstmt.setLong(9, newUser.getCredit());
				pstmt.setLong(10, newUser.getAdministrateur());

				// Execution de la requete
				pstmt.executeUpdate();

				// Récupération de l'ID généré pour le Utilisateur
				ResultSet rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					newUser.setNo_utilisateur(rs.getInt(1)); // l' Utilisateur du Modèle est mis à jour
				}

				rs.close();
				pstmt.close();

				// ********************
				// Ajout dans la table UTILISATEURS

				// Création d'une nouvelle instance de PreparedStatement pour les utilisateurs
				// (la variable locale pstmt peut être réutilisée)
				pstmt = cnx.prepareStatement(INSERT_USER, PreparedStatement.RETURN_GENERATED_KEYS);

				pstmt.close();

				// Tout s'est bien passé => transaction validée
				cnx.commit();
			} catch (Exception e) {
				// Journalisation
				e.printStackTrace();

				// Il y a eu une probleme => transaction annulée
				cnx.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}