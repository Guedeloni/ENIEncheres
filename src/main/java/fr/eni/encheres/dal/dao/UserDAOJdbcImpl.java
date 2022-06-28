package fr.eni.encheres.dal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.eni.encheres.dal.ConnectionProvider;
import fr.eni.encheres.dal.DALException;

public class UserDAOJdbcImpl {

private ConnectionProvider provider;
	
	public UserDAOJdbcImpl() {
		provider = new ConnectionProvider();
	}

	public String getPWByPseudo(String pseudo) throws DALException {
		try (Connection cnx = createConnexion();){
			PreparedStatement selectPWByPseudo = cnx.prepareStatement(SELECT_PW_BY_PSEUDO);
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
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

}
