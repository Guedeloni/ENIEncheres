package fr.eni.encheres.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.ArticleManager;
import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bo.Article;

/**
 * Servlet implementation class accueilEnchères
 */
public class AccueilEncheres extends HttpServlet {
	private static final String PAGE_ACCUEIL_JSP = "/WEB-INF/jsp/accueil.jsp";
	private static final long serialVersionUID = 1L;

	private int categories;
	private String searchBar;
	private String achatsVentes;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ArticleManager articleMng = ArticleManager.getInstance();

		/*
		 * Quand la servlet est appellé avec un GET, il s'agit de l'affichage initial de
		 * la page d'accueil avec la liste d'enchères et de l' affichage de l'url
		 * http://localhost:8080/ENIEncheres/encheres/ comme demandé dans la liste des
		 * exigences
		 */

		List<Article> articlesVendus = new ArrayList<>();
		try {
			articlesVendus = articleMng.afficherArticle();
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// request.getSession().getAttribute("artilce");.
		request.setAttribute("article", articlesVendus);

		RequestDispatcher rd = request.getRequestDispatcher(PAGE_ACCUEIL_JSP);
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Valeur saisie dans la barre de recherche
		searchBar = request.getParameter("searchBar").toLowerCase();
		// Valeur de la catégorie choisi
		categories = Integer.parseInt(request.getParameter("categories"));

		request.setAttribute("categories", categories);
		request.setAttribute("searchBar", searchBar);
		doGet(request, response);

	}

}
