package fr.eni.encheres.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bll.UserManager;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class ModifierProfil
 */
public class ModifierProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String MSG_PROFIL_MODIFIE = "Votre profil a bien été modifié !";
	private static final String MSG_COHERENCE_NEW_MDP = "Problème de confirmation du mot de passe";
	private static final String MSG_ERREUR_MDP = "Mot de passe actuel incorrect";
	private static final String MSG_CPT_SUPPRIME = "Votre compte a été supprimé !";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Supprimer un utilisateur (et enregistrements liés en cascade)
		System.out.println("Passage ds. le doGet de la servlet ModifierProfil => user inactif");
		
		Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");
		int numeroUtilisateur = utilisateur.getNo_utilisateur();

		UserManager userMng = UserManager.getInstance();

		try {
			userMng.removeUser(numeroUtilisateur);
		} catch (BLLException e) {
			e.printStackTrace();
		}
		
		// Suppression de la session et envoi vers l'accueil
		String message = MSG_CPT_SUPPRIME;
		request.setAttribute("message", message);
//		request.getSession().removeAttribute("utilisateur");
//		getServletContext().getRequestDispatcher("/modif_profil").forward(request, response);
		if (request.getSession(true) != null)
			request.getSession().invalidate();
		request.getRequestDispatcher("/encheres").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Recuperation des donnees de la session en cours
		System.out.println(request.getSession().getAttribute("utilisateur").toString());
		Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");

		// Recuperation des valeurs du formulaire

		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String code_postal = request.getParameter("code_postal");
		String ville = request.getParameter("ville");
		String mot_de_passe = request.getParameter("mot_de_passe");
		String nouveauMdp = request.getParameter("nouveau_mdp");
		String confirmationMdp = request.getParameter("confirmation_mdp");

		Utilisateur utilisateurModifie = new Utilisateur(utilisateur.getNo_utilisateur(), pseudo, nom, prenom, email,
				telephone, rue, code_postal, ville, mot_de_passe, utilisateur.getCredit(),
				utilisateur.getAdministrateur(), utilisateur.getArticlesvendu(), utilisateur.getArticlesachete());

		UserManager userMng = UserManager.getInstance();
		String message = "";
		String message_new_mdp = "";
		String message_profil_modifie = "";
		
		// Verification de coherence entre MdP du formulaire et MdP de l'utilisateur de
		// la session
		if (!mot_de_passe.equals(utilisateur.getMot_de_passe())) {
			message = MSG_ERREUR_MDP;
		}

		// Verification de coherence pour le nouveau MdP
		if (!nouveauMdp.equals(confirmationMdp)) {
			message_new_mdp = MSG_COHERENCE_NEW_MDP;
		}

		if (mot_de_passe.equals(utilisateur.getMot_de_passe()) && nouveauMdp.equals(confirmationMdp)) {

			try {
				userMng.updateProfil(utilisateurModifie);
				message_profil_modifie = MSG_PROFIL_MODIFIE;
			} catch (BLLException e) {
				e.printStackTrace();
			}

		}

		// Modification de l'utilisateur en cours de session (reaffichage des valeurs
		// saisies)
		request.getSession().setAttribute("utilisateur", utilisateurModifie);
		request.setAttribute("message", message);
		request.setAttribute("message_error", message_new_mdp);
		request.setAttribute("message_profil_modifie", message_profil_modifie);
		getServletContext().getRequestDispatcher("/modif_profil").forward(request, response);

	}

}
