package fr.eni.encheres.bo;

import java.time.LocalDate;

public class Article {

	private int no_article;

	private String nom_article;

	private String description;

	private LocalDate date_debut_encheres;

	private LocalDate date_fin_encheres;

	private int prix_initial;

	private int prix_vente;

	private int no_categorie;			// implementation de l association unidirectionnel


	private Utilisateur utilisateur;	// proprietaire de l'article
	
	private String image_article;


	// constructeur

	

	public Article() {

	}

	public Article(int no_article, String nom_article, String description, LocalDate date_debut_encheres,
			LocalDate date_fin_encheres, int prix_initial, int prix_vente, int no_categorie, Utilisateur utilisateur,
			String image_article) {
		super();
		this.no_article = no_article;
		this.nom_article = nom_article;
		this.description = description;
		this.date_debut_encheres = date_debut_encheres;
		this.date_fin_encheres = date_fin_encheres;
		this.prix_initial = prix_initial;
		this.prix_vente = prix_vente;
		this.no_categorie = no_categorie;
		this.utilisateur = utilisateur;
		this.image_article = image_article;
	}

	public int getNo_categorie() {
		return no_categorie;
	}

	public void setNo_categorie(int no_categorie) {
		this.no_categorie = no_categorie;
	}

	public String getImage_article() {
		return image_article;
	}

	public void setImage_article(String image_article) {
		this.image_article = image_article;
	}

	public Article(int no_article, String nom_article, String description, LocalDate date_debut_encheres,
			LocalDate date_fin_encheres, int prix_initial, int prix_vente, int no_categorie, Utilisateur utilisateur) {
		super();
		this.no_article = no_article;
		this.nom_article = nom_article;
		this.description = description;
		this.date_debut_encheres = date_debut_encheres;
		this.date_fin_encheres = date_fin_encheres;
		this.prix_initial = prix_initial;
		this.prix_vente = prix_vente;
		this.no_categorie = no_categorie;
		this.utilisateur = utilisateur;
	}

	// getter et setter

	public int getNo_article() {
		return no_article;
	}

	public void setNo_article(int no_article) {
		this.no_article = no_article;
	}

	public String getNom_article() {
		return nom_article;
	}

	public void setNom_article(String nom_article) {
		this.nom_article = nom_article;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDate_debut_encheres() {
		return date_debut_encheres;
	}

	public void setDate_debut_encheres(LocalDate date_debut_encheres) {
		this.date_debut_encheres = date_debut_encheres;
	}

	public LocalDate getDate_fin_encheres() {
		return date_fin_encheres;
	}

	public void setDate_fin_encheres(LocalDate date_fin_encheres) {
		this.date_fin_encheres = date_fin_encheres;
	}

	public int getPrix_initial() {
		return prix_initial;
	}

	public void setPrix_initial(int prix_initial) {
		this.prix_initial = prix_initial;
	}

	public int getPrix_vente() {
		return prix_vente;
	}

	public void setPrix_vente(int prix_vente) {
		this.prix_vente = prix_vente;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
		
}
