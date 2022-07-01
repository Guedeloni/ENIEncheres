package fr.eni.encheres.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class VenteArticleServlet
 */

public class VenteArticleServlet extends HttpServlet {

	private static final String PAGE_VENTE_ARTICLE_JSP = "/WEB-INF/jsp/vente-article.jsp";

	Article newArticle;

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ************************ Catégories ************************ /
		CategorieManager catMng = CategorieManager.getInstance();

		List<Categorie> allCategories = new ArrayList<>();

		try {
			allCategories = catMng.getAllCategories();
		} catch (BLLException e) {

			e.printStackTrace();
		}

		request.setAttribute("listeCategorie", allCategories);
		request.getRequestDispatcher(PAGE_VENTE_ARTICLE_JSP).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String article = request.getParameter("nom_article");
		String description = request.getParameter("description");
		LocalDate date_debut_encheres = LocalDate.parse(request.getParameter("date_debut_encheres"));
		LocalDate date_fin_encheres = LocalDate.parse(request.getParameter("date_fin_encheres"));
		int prix_vente = Integer.valueOf(request.getParameter("prix_vente"));
		Integer categorie = Integer.valueOf(request.getParameter("no_categorie"));
		String image_article = request.getParameter("image_article");

		newArticle = new Article(article, description, date_debut_encheres, date_fin_encheres, prix_vente, categorie,
				image_article);

		int articleId = -1;

		ArticleManager articleMng = ArticleManager.getInstance();
		
		System.out.println("article :" + article);
		System.out.println("description :" + description);
		System.out.println("date début :" + date_debut_encheres);
		System.out.println("date fin :" + date_fin_encheres);
		System.out.println("prix :" + prix_vente);
		
		if (!article.isEmpty() && !description.isEmpty() && date_debut_encheres != null && date_fin_encheres != null
				&& prix_vente != 0) {

			try {
				articleId = articleMng.creationArticle(newArticle);
			} catch (BLLException e) {
				e.printStackTrace();
			}

			newArticle.setNo_article(articleId);
			request.getSession().setAttribute("article", newArticle);
			getServletContext().getRequestDispatcher("/encheres").forward(request, response);

		} else {
			response.sendRedirect(request.getContextPath() + "/vente-article");
		}
	}

}
