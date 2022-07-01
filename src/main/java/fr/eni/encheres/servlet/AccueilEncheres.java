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
import fr.eni.encheres.bll.CategorieManager;
import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Categorie;

/**
 * Servlet implementation class accueilEnchères
 */
public class AccueilEncheres extends HttpServlet {
	private static final String PAGE_ACCUEIL_JSP = "/WEB-INF/jsp/accueil.jsp";
	private static final long serialVersionUID = 1L;

	private int categories;
	private String searchBar;
	private String achatsVentes;

	/*
	 * Quand la servlet est appellé avec un GET, il s'agit de l'affichage initial de
	 * la page d'accueil avec la liste d'enchères et de l' affichage de l'url
	 * http://localhost:8080/ENIEncheres/encheres/ comme demandé dans la liste des
	 * exigences
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("passage dans la servlet");

		//************************ Articles ************************ /

		ArticleManager articleMng = ArticleManager.getInstance();

		List<Article> articlesVendus = new ArrayList<>();
		try {
			articlesVendus = articleMng.afficherArticle();
		} catch (BLLException e) {
			e.printStackTrace();
		}

		request.setAttribute("listeArticle", articlesVendus);

		
		//************************ Catégories ************************ /
		CategorieManager catMng = CategorieManager.getInstance();
		
		List<Categorie> allCategories = new ArrayList<>();
		
		System.out.println("CATEGORIES => passage dans la servlet");

		try {
			allCategories = catMng.getAllCategories();
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("listeCategorie", allCategories);

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
