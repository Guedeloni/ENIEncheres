package fr.eni.encheres.dal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.ConnectionProvider;
import fr.eni.encheres.dal.DALException;

public class UserDAOJdbcImpl {

	private static final String SELECT_USER_BY_PSEUDO_MDP_ACTIF = "SELECT no_utilisateur, pseudo, nom, prenom,"
			+ " email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur"
			+ " FROM utilisateurs WHERE pseudo = ? AND mot_de_passe = ? AND user_actif = 1";

	private static final String INSERT_USER = "INSERT INTO utilisateurs(pseudo, nom, prenom, email,"
			+ " telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur, user_actif)"
			+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	private static final String SQL_UPDATE_USER = "UPDATE UTILISATEURS SET pseudo=?, nom=?,"
			+ " prenom=?, email=?, telephone=?, rue=?, code_postal=?, ville=?, mot_de_passe=?"
			+ " WHERE no_utilisateur=?";
	
	private static final String SQL_UPDATE_USER_TO_INACTIF = "UPDATE UTILISATEURS SET user_actif = 0"
			+ " WHERE no_utilisateur=?";
	
//	private static final String SQL_DELETE_USER = "DELETE FROM utilisateurs WHERE no_utilisateur = ?";


	public UserDAOJdbcImpl() {
	}

	/**
	 * selectUserByPseudoMdP(pseudo, MdP)
	 * @param pseudo	String
	 * @param MdP		String
	 * @return			Utilisateur
	 * @throws DALException
	 */
	public Utilisateur selectUserByPseudoMdP(String pseudo, String MdP) throws DALException {
		Utilisateur userTrouve = new Utilisateur();
		try (Connection cnx = createConnexion();) {
			PreparedStatement ordreSelect = cnx.prepareStatement(SELECT_USER_BY_PSEUDO_MDP_ACTIF);
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

	/**
	 * insert(newUser)
	 * Renvoi l'identifiant genere
	 * @param	Utilisateur
	 * @return	Integer
	 * @throws DALException
	 */
	public int insert(Utilisateur newUser) throws DALException {
		int userId = -1;
		// s'il n'y a pas de parametre, cela ne sert à rien de continuer.
		if (newUser == null) {
			return userId;
		}
		
		try (Connection cnx = createConnexion();) // la connexion va être automatiquement fermée
		{
			try {
				// Preparation ajout dans la table Utilisateur
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
				pstmt.setString(9, newUser.getMot_de_passe());
				pstmt.setInt(10, newUser.getCredit());
				pstmt.setByte(11, (byte)newUser.getAdministrateur());
				pstmt.setInt(12, 1);

				// Execution de la requete
				pstmt.executeUpdate();

				// Récupération de l'ID généré pour le Utilisateur
				ResultSet rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					userId = rs.getInt(1);
				}

				rs.close();
				pstmt.close();

			} catch (Exception e) {
				e.printStackTrace();
				// Il y a eu une probleme => transaction annulée
				cnx.rollback();
				throw new DALException("Problème à l'insertion d'un nouvel utilisateur => rollback", e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return userId;
	}
	
	/**
	 * updateProfil(utilisateur)
	 * @param utilisateur	Utilisateur
	 * @throws DALException
	 */
	public void updateProfil(Utilisateur utilisateur) throws DALException {
		// s'il n'y a pas de parametre, cela ne sert à rien de continuer.
				if (utilisateur == null) {
					return;
				}

				System.out.println(utilisateur.toString());
				try (Connection cnx = createConnexion();) // la connexion va être automatiquement fermée
				{
					try {
						// Preparation modif de la table Utilisateur
						PreparedStatement pstmt = cnx.prepareStatement(SQL_UPDATE_USER);

						// Valorisation des parametres du PreparedStatement
						pstmt.setString(1, utilisateur.getPseudo());
						pstmt.setString(2, utilisateur.getNom());
						pstmt.setString(3, utilisateur.getPrenom());
						pstmt.setString(4, utilisateur.getEmail());
						pstmt.setString(5, utilisateur.getTelephone());
						pstmt.setString(6, utilisateur.getRue());
						pstmt.setString(7, utilisateur.getCode_postal());
						pstmt.setString(8, utilisateur.getVille());
						pstmt.setString(9, utilisateur.getMot_de_passe());
						pstmt.setInt(10, utilisateur.getNo_utilisateur());
						

						// Execution de la requete
						pstmt.executeUpdate();

						pstmt.close();

					} catch (Exception e) {
						e.printStackTrace();
						// Il y a eu une probleme => transaction annulée
						cnx.rollback();
						throw new DALException("Problème à la modification de l' utilisateur => rollback", e);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}


	public void removeUser( int no_utilisateur) throws DALException {

		try (Connection cnx = createConnexion();) // la connexion va être automatiquement fermée
		{
			try {
				cnx.setAutoCommit(false);

				PreparedStatement pstmt = cnx.prepareStatement(SQL_UPDATE_USER_TO_INACTIF);
				pstmt.setInt(1, no_utilisateur);
				pstmt.executeUpdate();

				pstmt.close();

				// Tout s'est bien passé => transaction validée
				cnx.commit();
			} catch (Exception e) {
				e.printStackTrace();
				// Il y a eu une probleme => transaction annulée
				cnx.rollback();
				throw new DALException("Problème à la suppresion  de l' utilisateur => rollback", e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

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
			user = new Utilisateur(ligneResultante.getInt(1), ligneResultante.getString(2), ligneResultante.getString(3),
					ligneResultante.getString(4), ligneResultante.getString(5), ligneResultante.getString(6),
					ligneResultante.getString(7), ligneResultante.getString(8), ligneResultante.getString(9),
					ligneResultante.getString(10), ligneResultante.getInt(11), ligneResultante.getInt(12));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Problème à la construction d'un utilisateur à partir du ResultSet", e);
		}
		return user;
	}
	
}