package fr.eni.encheres.bll;

import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.dao.UserDAOJdbcImpl;

public class UserManager {
	private static UserManager instance;
	private UserDAOJdbcImpl dao;
	
//	private ArrayList<Repas> repasList;
	
	private UserManager() {
		dao = new UserDAOJdbcImpl();
//		repasList = new ArrayList<>();
	}
	
	// Gestion pour avoir une classe Manager singleton
	public static UserManager getInstance() {
		if (instance == null) instance = new UserManager();
		return instance;
	}
	
	/**
	 * utilisateurReconnu(pseudo, MdP)
	 * Renvoie 'true' si 'Pseudo' existe ds. la DB ET si 'MdP' correspond au mot de passe du pseudo trouve
	 * @param pseudo
	 * @param MdP
	 * @return	Boolean
	 * @throws BLLException
	 */
	public boolean utilisateurReconnu(String pseudo, String MdP) throws BLLException {
		try {
			Boolean utilisateurTrouve = false;
			String MdPTrouve = dao.getPWByPseudo(pseudo);
			if (MdPTrouve.equals(MdP)) utilisateurTrouve = true;
			return utilisateurTrouve;
		}
		catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Problème à la récupération du mot de passe via pseudo", e);
		}
	}
}
