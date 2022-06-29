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
@WebServlet(name = "ModifProfil", urlPatterns = { "/ModiferProfil" })
public class ModifierProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Utilisateur utilisateur;
	UserManager userMng = UserManager.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierProfil() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");
		//request.getServletContext().getRequestDispatcher("/WEB-INF/jsp/modifierProfil.jsp").forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean activeInput = false;
		utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");
		String choixUtilisateur = request.getParameter("choixUtilisateur");
		
		
		if(choixUtilisateur.equals("Enregistrer")) {
			
			
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
			
			int no_utilisateur = Integer.valueOf(request.getParameter("no_utilisateur"));
			
			if (mot_de_passe.equals(utilisateur.getMot_de_passe())) {
				
				activeInput = true;
				
				
				
			}
			if (nouveauMdp.equals(confirmationMdp)) {
				
				try {
					userMng.updateProfil(utilisateur);
				} catch (BLLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				request.getSession().setAttribute("utilisateur", utilisateur);
				String message = "Votre profil a été modifié!";
				request.setAttribute("message", message);
				
				
				
			}
			//supprimer un utilisateur
			if(choixUtilisateur.equals("Supprimer mon compte")) {
//				request.getSession().getAttribute("utilisateur");
//				System.out.println(utilisateur.toString());
				int numeroUtilisateur = Integer.valueOf(request.getParameter("no_utilisateur"));
				//System.out.println(no_utilisateur);
				userMng.removeUser(numeroUtilisateur);
				request.getSession().removeAttribute("utilisateur");
				String message = "Votre compte a été supprimé!";
				request.setAttribute("message", message);
				doGet(request, response);
			}
		}
			
			
			
		doGet(request, response);
	}

}
