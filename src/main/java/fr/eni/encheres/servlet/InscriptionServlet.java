package fr.eni.encheres.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bll.UserManager;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class inscription
 */

public class InscriptionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String PAGE_USER_CONNECTED = "/WEB-INF/jsp/user_connected.jsp";
	private static final String MSG_CHAMPS_OBLIGATOIRES = "Tous les champs sont obligatoires";
	private static final String MSG_MDP_INCOHERENTS = "Mot de passe incohérent avec la confirmation";

	private int credit = 0;
	private int administrateur = 0;

	Utilisateur newUtilisateur;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InscriptionServlet() {
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
		String code_postal = request.getParameter("code_postal");
		String ville = request.getParameter("ville");
		String mot_de_passe = request.getParameter("mot_de_passe");
		String confirmationMdp = request.getParameter("confirmation_mdp");

		// Creation nouvel Utilisateur
		newUtilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe,
				credit, administrateur);

		// Appel au manager si mdp = confirmation ET champs non vides
		UserManager userMng = UserManager.getInstance();
		if (mot_de_passe.equals(confirmationMdp)) {

			if (!pseudo.isEmpty() && !nom.isEmpty() && !prenom.isEmpty() && !ville.isEmpty() && !rue.isEmpty()
					&& !code_postal.isEmpty() && !email.isEmpty() && !mot_de_passe.isEmpty()
					&& !confirmationMdp.isEmpty()) {
				try {
					userMng.creationUtilisateur(newUtilisateur);
				} catch (BLLException e) {
					e.printStackTrace();
				}
				// Redirection vers page utilisateur
				RequestDispatcher rd = request.getRequestDispatcher(PAGE_USER_CONNECTED);
				rd.forward(request, response);
			}
			else {
				// MSG ERREUR "tt. les champs sont obligatoires"
				String message = MSG_CHAMPS_OBLIGATOIRES;
				request.setAttribute("message", message);
				getServletContext().getRequestDispatcher("/inscription").forward(request, response);
			}
		}
		else {
			// MSG ERREUR "Mot de passe incoherent avec la confirmation"
			String message = MSG_MDP_INCOHERENTS;
			request.setAttribute("message", message);
			getServletContext().getRequestDispatcher("/inscription").forward(request, response);
		}
	}
}
