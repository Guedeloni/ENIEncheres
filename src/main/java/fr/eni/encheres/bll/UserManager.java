package fr.eni.encheres.bll;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.dao.UserDAOJdbcImpl;

public class UserManager {
	private static UserManager instance;
	private UserDAOJdbcImpl dao;

	private UserManager() {
		dao = new UserDAOJdbcImpl();

	}

	// Gestion pour avoir une classe Manager singleton
	public static UserManager getInstance() {
		if (instance == null)
			instance = new UserManager();
		return instance;
	}

	/**
	 * utilisateurReconnu(pseudo, MdP) Renvoie utilisateur si 'Pseudo' existe ds. la
	 * DB ET si 'MdP' correspond au mot de passe du pseudo trouve Renvoi utilisateur
	 * avec pseudo null sinon
	 * 
	 * @param String pseudo
	 * @param String MdP
	 * @return Utilisateur
	 * @throws BLLException
	 */
	public Utilisateur utilisateurReconnu(String pseudo, String MdP) throws BLLException {
		try {
			Utilisateur utilisateurTrouve = dao.selectUserByPseudoMdP(pseudo, MdP);
			if (utilisateurTrouve != null) return utilisateurTrouve;
			return null;
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Problème à la récupération de l'utilisateur via pseudo", e);
		}
	}

	/**
	 * creationUtilisateur(utilisateur)
	 * Appel la DAO pour creation d'un utilisateur
	 * Renvoi l'identifiant genere
	 * @param	Utilisateur
	 * @return	Integer
	 * @throws BLLException
	 */
	public int creationUtilisateur(Utilisateur utilisateur) throws BLLException {
		int userId = 0;
		try {
			userId = dao.insert(utilisateur);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Problème à la création d'un nouvel utilisateur", e);
		}
		return userId;
	}
	
	
	//

	public void updateProfil(Utilisateur utilisateur) throws BLLException {
		System.out.println("Passage ds. BLL");
		try {
			dao.updateProfil(utilisateur);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Problème à la mise à jour d'un utilisateur", e);
		}

	}

	public void removeUser(int no_utilisateur) throws BLLException {
		System.out.println("Passage ds. BLL");
		try {
			dao.removeUser(no_utilisateur);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Problème à la suppression d'un utilisateur", e);
		}
		
	}
}