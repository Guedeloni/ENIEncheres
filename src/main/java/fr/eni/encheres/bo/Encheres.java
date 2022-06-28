package fr.eni.encheres.bo;

import java.time.LocalDate;

public class Encheres {

	private LocalDate date_enchere = LocalDate.now();

	private int montant_enchere;

	private Utilisateur utilisateur; // implementation de l association unidirectionnel
	private Article article;

	// constructeur

	public Encheres(LocalDate date_enchere, int montant_enchere) {
		super();
		this.date_enchere = date_enchere;
		this.montant_enchere = montant_enchere;
	}

	public Encheres() {

	}

	public LocalDate getDate_enchere() {
		return date_enchere;
	}

	// getter

	public int getMontant_enchere() {
		return montant_enchere;
	}

	// setter

	public void setMontant_enchere(int montant_enchere) {
		this.montant_enchere = montant_enchere;
	}

	public void setDate_enchere(LocalDate date_enchere) {
		this.date_enchere = date_enchere;
	}

}
