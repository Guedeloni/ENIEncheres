package fr.eni.encheres.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class inscription
 */

public class inscription extends HttpServlet {
	private static final String PAGE_ACCUEIL = "/WEB-INF/jsp/accueil.jsp";

	private static final long serialVersionUID = 1L;

	private int credit = 0;
	private int administrateur = 0;

	Utilisateur newUtilisateur;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public inscription() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// récupération des données du formulaire

		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String code_postal = request.getParameter("codepostal");
		String ville = request.getParameter("ville");
		String mot_de_passe = request.getParameter("motDePasse");
		String confirmationMdp = request.getParameter("confirmationMdp");
		String choixUtilisateur = request.getParameter("choixUtilisateur");

		newUtilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe,
				credit, administrateur);

		if (choixUtilisateur.equals("créer")) {
			if (mot_de_passe.equals(confirmationMdp)) {

				if (!pseudo.isEmpty() && !nom.isEmpty() && !prenom.isEmpty() && !ville.isEmpty() && !rue.isEmpty()
						&& !code_postal.isEmpty() && !email.isEmpty() && !mot_de_passe.isEmpty()
						&& !confirmationMdp.isEmpty())
					;

			}
			// Transfert de l'affichage à la JSP
			RequestDispatcher rd = request.getRequestDispatcher(PAGE_ACCUEIL);
			rd.forward(request, response);

			doGet(request, response);

		}
	}
}
