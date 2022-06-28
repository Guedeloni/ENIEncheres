package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Fournit des connexions a la DB
 *
 * @return	Connection
 */
public class ConnectionProvider {
	
	private DataSource pool;
	
	public ConnectionProvider() {
		pool = obtenirPool();
	}
	
	private DataSource obtenirPool() {
		DataSource poolDeConnexions = null;
		// -> necessite que le pool de connexions soit mis en place via context.xml
		// 1. Obtenir l'annuaire
		InitialContext annuaire = null;
		try {
			annuaire = new InitialContext();
		} catch (NamingException e) {
			e.printStackTrace();
			System.out.println("Problème pour obtenir l'annuaire");
		}
		
		// 2. Obtenir le pool en cherchant ds. l'annuaire
		String repertoireAnnuaire = "java:/comp/env/";
		String nomPool = "EncheresPool";
		
		try {
			poolDeConnexions = (DataSource) annuaire.lookup(repertoireAnnuaire + nomPool);
		} catch (NamingException e) {
			e.printStackTrace();
			System.out.println("Problème pour obtenir le pool de connexion");
		}
		
		return poolDeConnexions;
	}
	
	public Connection getConnexion() {
		Connection cnx = null;
		
		// 3. Demander une connnexion au pool
		try {
			cnx = pool.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Problème pour obtenir une connexion");
		}

		return cnx;
	}

}
