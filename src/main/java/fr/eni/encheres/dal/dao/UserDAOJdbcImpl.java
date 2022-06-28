package fr.eni.encheres.dal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.ConnectionProvider;
import fr.eni.encheres.dal.DALException;

public class UserDAOJdbcImpl {

private static final String SELECT_USER_BY_PSEUDO = "SELECT no_utilisateur, pseudo, nom, prenom,\r\n"
													+ "		email, telephone, rue, code_postal, ville,\r\n"
													+ "		mot_de_passe, credit, administrateur\r\n"
													+ "		FROM utilisateurs\r\n"
													+ "		WHERE pseudo = ?";

private ConnectionProvider provider;
	
	public UserDAOJdbcImpl() {
		provider = new ConnectionProvider();
	}

	public Utilisateur selectUserByPseudo(String pseudo) throws DALException {
		Utilisateur userTrouve = new Utilisateur();
		try (Connection cnx = createConnexion();){
			PreparedStatement ordreSelect = cnx.prepareStatement(SELECT_USER_BY_PSEUDO);
			ordreSelect.setString(1, pseudo);
			ResultSet ligneResultante = ordreSelect.executeQuery();
			if (!ligneResultante.next()) userTrouve = null;
			else {
				userTrouve = userBuilder(ligneResultante);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userTrouve;
	}
	
	// METHODES INTERNES
	private Connection createConnexion() throws DALException {
		try {
			Connection cnx = provider.getConnexion();
			return cnx;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new DALException("Problème sur la création d'une connexion", e);
		}
	}

	private Utilisateur userBuilder(ResultSet ligneResultante) {
		Boolean admin = false;
		if (ligneResultante.getByte(12) == 1) admin = true;
		Utilisateur user = new Utilisateur(ligneResultante.getInt(1), ligneResultante.getString(2),
				 						ligneResultante.getString(3), ligneResultante.getString(4),
				 						ligneResultante.getString(5), ligneResultante.getString(6),
				 						ligneResultante.getString(7), ligneResultante.getInt(8),
				 						ligneResultante.getString(9), ligneResultante.getString(10),
				 						ligneResultante.getInt(11), admin);
		return user;
	}

}
