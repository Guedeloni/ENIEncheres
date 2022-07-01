package fr.eni.encheres.dal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.ConnectionProvider;

public class ArticleDAOJdbcImpl {
	

	private final String SELECT_ALL_ARTICLES = "SELECT no_article, nom_article, description,\r\n"
			+ "		date_debut_encheres, date_fin_encheres, prix_initial,\r\n"
			+ "		prix_vente, no_article, pseudo\r\n"
			+ "		FROM ARTICLES AS ART\r\n"
			+ "		INNER JOIN UTILISATEURS AS UTIL\r\n"
			+ "		ON (ART.no_utilisateur = UTIL.no_utilisateur)";
	
	
	
	
	
	public List<Article> afficherArticle() {
		
		List<Article> listeArticle = new ArrayList<Article>();
		
		
		 try(Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL_ARTICLES);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				Article nouvelArticle = new Article(
				rs.getInt("no_article"),
				rs.getString("nom_article"),
				rs.getString("description"),
				rs.getDate("date_debut_encheres").toLocalDate(),
				rs.getDate("date_fin_encheres").toLocalDate(),
				rs.getInt("prix_initial"),

				rs.getInt("prix_vente"),
				
				rs.getInt("no_categorie"),
				new Utilisateur(rs.getString("pseudo"))

				
				);
				listeArticle.add(nouvelArticle);
			}
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
		 System.out.println(listeArticle.toString() );
		return listeArticle;
	}
		
		
		
		
		
	}
	


