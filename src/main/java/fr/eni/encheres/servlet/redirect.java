package fr.eni.encheres.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class redirect
 */

public class redirect extends HttpServlet {
	
	private static final String PAGE_ACCUEIL_JSP = "/WEB-INF/jsp/accueil.jsp";
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher(PAGE_ACCUEIL_JSP);
		rd.forward(request, response);
	}

}
