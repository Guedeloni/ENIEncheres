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
import fr.eni.encheres.dal.DALException;

public class ArticleDAOJdbcImpl {

	private final String SELECT_ALL_ARTICLES = "SELECT no_article, nom_article, description,\r\n"
			+ "		date_debut_encheres, date_fin_encheres, prix_initial,\r\n"
			+ "		prix_vente, no_categorie, pseudo, image_article\r\n" + "		FROM ARTICLES AS ART\r\n"
			+ "		INNER JOIN UTILISATEURS AS UTIL\r\n" + "		ON (ART.no_utilisateur = UTIL.no_utilisateur)";

	private final String INSERT_ARTICLE = "INSERT INTO ARTICLES(nom_article, description, date_debut_encheres, "
			+ "date_fin_encheres, prix_initial, prix_vente, no_categorie, no_utilisateur ) "
			+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

	public List<Article> afficherArticle() {

		List<Article> listeArticle = new ArrayList<Article>();

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL_ARTICLES);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Article nouvelArticle = new Article
						(
						rs.getInt("no_article"), 
						rs.getString("nom_article"),
						rs.getString("description"), 
						rs.getDate("date_debut_encheres").toLocalDate(),
						rs.getDate("date_fin_encheres").toLocalDate(), 
						rs.getInt("prix_initial"),
						rs.getInt("prix_vente"), 
						rs.getInt("no_categorie"),
						rs.getString("image_article"),
						new Utilisateur(rs.getString("pseudo"))
				);
				
				listeArticle.add(nouvelArticle);
			}
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println(listeArticle.toString());
		return listeArticle;
	}

	public int insert(Article newArticle) throws DALException {
		int articleId = -1;

		if (newArticle == null) {
			return articleId;
		}

		System.out.println(newArticle.toString());

		try (Connection cnx = createConnexion();) // la connexion va être automatiquement fermée
		{
			try {
				// Preparation ajout dans la table Utilisateur
				PreparedStatement pstmt = cnx.prepareStatement(INSERT_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);

				// Valorisation des parametres du PreparedStatement
				pstmt.setString(1, newArticle.getNom_article());
				pstmt.setString(2, newArticle.getDescription());
				pstmt.setDate(3, java.sql.Date.valueOf(newArticle.getDate_debut_encheres()));
				pstmt.setDate(4, java.sql.Date.valueOf(newArticle.getDate_fin_encheres()));
				pstmt.setInt(5, newArticle.getPrix_initial());
				pstmt.setInt(6, newArticle.getPrix_vente());
				pstmt.setInt(7, newArticle.getNo_utilisateur());
				pstmt.setInt(8, newArticle.getNo_article());
				pstmt.setString(9, newArticle.getImage_article());

				// Execution de la requete
				pstmt.executeUpdate();

				// Récupération de l'ID généré pour le Utilisateur
				ResultSet rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					articleId = rs.getInt(1);
				}

				rs.close();
				pstmt.close();

			} catch (Exception e) {
				e.printStackTrace();
				// Il y a eu une probleme => transaction annulée
				cnx.rollback();
				throw new DALException("Problème à l'insertion d'un nouvel article => rollback", e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return articleId;

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

}
