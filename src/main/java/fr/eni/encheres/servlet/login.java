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
 * Servlet implementation class login
 */
//@WebServlet(name = "login_page", urlPatterns = { "/login" })
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserManager userMng = UserManager.getInstance() ;
		
		//recuperer les infos de connexion saisies par l'utilisateur
				String pseudoInput = request.getParameter("pseudoInput");
				String mdpInput = request.getParameter("mdpInput");
				String choixUtilisateur = request.getParameter("choixUtilisateur");

				//System.out.println(choixUtilisateur);
				if(choixUtilisateur.equals("connexion")) {
					//chercher ces logins dans la bdd pour voir s'ils existent ou non
					Utilisateur utilisateur = new Utilisateur();
					try {
						utilisateur = userMng.utilisateurReconnu(pseudoInput, mdpInput);
					} catch (BLLException e) {
						
						e.printStackTrace();
					}
					if (utilisateur == null){
						//System.out.println("non");
						String message = "vous n'êtes pas inscrits";
						request.setAttribute("message", message);
						doGet(request, response);

					} else {
					//System.out.println("oui");
					request.getSession().setAttribute("utilisateur", utilisateur);
					response.sendRedirect("/encheres");

					}
				}

					
					if(choixUtilisateur.equals("creer un compte")) {
						response.sendRedirect("/inscription");
					}

				}
	}


