package fr.eni.encheres.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bll.UserManager;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class ModifierProfil
 */
//@WebServlet(name = "ModifProfil", urlPatterns = { "/ModiferProfil" })
public class ModifierProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String MSG_PROFIL_MODIFIE = "Votre profil a bien été modifié !";
	private static final String MSG_COHERENCE_NEW_MDP = "Problème de confirmation du mot de passe";
	private static final String MSG_ERREUR_MDP = "Mot de passe actuel incorrect";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//supprimer un utilisateur
//		if(choixUtilisateur.equals("Supprimer mon compte")) {
//			request.getSession().getAttribute("utilisateur");
//			System.out.println(utilisateur.toString());
			int numeroUtilisateur = Integer.valueOf(request.getParameter("no_utilisateur"));
			//System.out.println(no_utilisateur);
			UserManager userMng = UserManager.getInstance();
			try {
				userMng.removeUser(numeroUtilisateur);
			} catch (BLLException e) {
				e.printStackTrace();
			}
			request.getSession().removeAttribute("utilisateur");
			String message = "Votre compte a été supprimé!";
			request.setAttribute("message", message);
//			doGet(request, response);
//		}

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Recuperation des donnees de la session en cours
		System.out.println(request.getSession().getAttribute("utilisateur").toString());
		Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");
		int no_utilisateur = utilisateur.getNo_utilisateur();
		
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

			Utilisateur utilisateurAModifier = new Utilisateur(no_utilisateur, pseudo, nom, prenom, email, telephone,
																rue, code_postal, ville, mot_de_passe);
			
			UserManager userMng = UserManager.getInstance();
			// Verification de coherence entre MdP du formulaire et MdP de l'utilisateur de la session
			if (mot_de_passe.equals(utilisateur.getMot_de_passe())) {

				// Verification de coherence pour le nouveau MdP
				if (nouveauMdp.equals(confirmationMdp)) {
					
					try {userMng.updateProfil(utilisateurAModifier);}
					catch (BLLException e) {
						e.printStackTrace();
					}
					
//					request.getSession().setAttribute("utilisateur", utilisateur);
					String message = MSG_PROFIL_MODIFIE;
					request.setAttribute("message", message);
					getServletContext().getRequestDispatcher("/modif_profil").forward(request, response);
					
				}
				// En cas d'erreur => retour au formulaire avec msg d'erreur + reaffichage des valeurs saisies
				request.getSession().setAttribute("utilisateur", utilisateur);
				String message = MSG_COHERENCE_NEW_MDP;
				request.setAttribute("message", message);
				getServletContext().getRequestDispatcher("/modif_profil").forward(request, response);
				
				
			}
			// En cas d'erreur => retour au formulaire avec msg d'erreur + reaffichage des valeurs saisies
			request.getSession().setAttribute("utilisateur", utilisateur);
			String message = MSG_ERREUR_MDP;
			request.setAttribute("message", message);
			getServletContext().getRequestDispatcher("/modif_profil").forward(request, response);
				
	}

}
