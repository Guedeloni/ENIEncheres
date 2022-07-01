package fr.eni.encheres.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Article;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.dao.ArticleDAOJdbcImpl;

public class ArticleManager {

	private static ArticleManager instance;
	private ArticleDAOJdbcImpl dao;

	private ArticleManager() {
		dao = new ArticleDAOJdbcImpl();
	}

	// Gestion pour avoir une classe Manager singleton
	public static ArticleManager getInstance() {
		if (instance == null)
			instance = new ArticleManager();
		return instance;
	}

	public List<Article> afficherArticle() throws BLLException {

		try {
			List<Article> listarticle = dao.afficherArticle();
			return listarticle;
		} catch (Exception e) {

			e.printStackTrace();
		}
		// return List<>;
		return new ArrayList<Article>();

	}

	public int creationArticle(Article article) throws BLLException {
		int articleId = 0;

		try {
			articleId = dao.insert(article);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Problème à la création d'un nouvel article", e);
		}
		return articleId;

	}

}
