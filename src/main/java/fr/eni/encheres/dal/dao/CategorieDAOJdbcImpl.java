package fr.eni.encheres.dal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.dal.ConnectionProvider;

public class CategorieDAOJdbcImpl {

	private static final String SELECT_CATEGORIES = "SELECT no_categorie, libelle FROM categories";

	private ConnectionProvider provider;

	public List<Categorie> selectAllCategories() {

		List<Categorie> listeCategorie = new ArrayList<Categorie>();

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_CATEGORIES);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				int id_categorie = rs.getInt("no_categorie");
				String libelleCat = rs.getString("libelle");

				Categorie categorie = new Categorie(id_categorie, libelleCat);

				listeCategorie.add(categorie);
				System.out.println("catégories" + categorie);
				System.out.println("liste catégories" + listeCategorie);
			}

			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listeCategorie;

	}

}