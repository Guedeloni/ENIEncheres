package fr.eni.encheres.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.dal.dao.CategorieDAOJdbcImpl;

public class CategorieManager {
	private static CategorieManager instance;
	private static CategorieDAOJdbcImpl dao;

	private CategorieManager() {
		dao = new CategorieDAOJdbcImpl();
	}

	public static CategorieManager getInstance() {
		if (instance == null)
			instance = new CategorieManager();
		return instance;
	}

	public List<Categorie> getAllCategories() throws BLLException {
		try {
			return dao.selectAllCategories();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<Categorie>();
	}

}
