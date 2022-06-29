package fr.eni.encheres.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class accueilEnchères
 */
public class AccueilEncheres extends HttpServlet {
	private static final String PAGE_ACCUEIL_JSP = "/WEB-INF/jsp/accueil.jsp";
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * Quand la servlet est appellé avec un GET, il s'agit de l'affichage initial de
		 * la page d'accueil avec la liste d'enchères et de l' affichage de l'url
		 * http://localhost:8080/ENIEncheres/encheres/ comme demandé dans la liste des
		 * exigences
		 */

		RequestDispatcher rd = request.getRequestDispatcher(PAGE_ACCUEIL_JSP);
		rd.forward(request, response);

	}

}