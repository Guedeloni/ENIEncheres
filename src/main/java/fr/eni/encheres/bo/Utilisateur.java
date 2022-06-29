package fr.eni.encheres.bo;

import java.util.List;

public class Utilisateur {
	
	private int  no_utilisateur ;
	
	private String  pseudo; 
	
	private String nom;
	
	
	private String  prenom;
	
	private String email;
	
	private String  telephone;   
	
	private String  rue;
	
	private int  code_postal;
	
	
	private String ville;
	
	private String mot_de_passe ;
	
	private int credit ;
	
	private int administrateur = 0;
	 
	 
	 //
	 
	 private List<Article>articlesvendu; //relation
	 
	 private List<Article>articlesachete;
	 
	 //constructeur


	public Utilisateur(int no_utilisateur, String pseudo, String nom, String prenom, String emai, String telephone,
			String rue, int code_postal, String ville, String mot_de_passe, int credit, int administrateur,
			List<Article> articlesvendu, List<Article> articlesachete) {
		super();
		this.no_utilisateur = no_utilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
		this.mot_de_passe = mot_de_passe;
		this.credit = credit;
		this.administrateur = administrateur;
		this.articlesvendu = articlesvendu;
		this.articlesachete = articlesachete;
	}

	
	
	
	
	
	public Utilisateur(String pseudo2, String nom2, String prenom2, String email, String telephone2, String rue2,
			String code_postal2, String ville2, String mot_de_passe2, int credit2, int administrateur2) {
	
	}


		



	public Utilisateur() {
		
		
	}






	//getters et setter 
	public int getNo_utilisateur() {
		return no_utilisateur;
	}

	public void setNo_utilisateur(int no_utilisateur) {
		this.no_utilisateur = no_utilisateur;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmai() {
		return email;
	}

	public void setEmai(String emai) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(int code_postal) {
		this.code_postal = code_postal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getMot_de_passe() {
		return mot_de_passe;
	}

	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public int getAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(int administrateur) {
		this.administrateur = administrateur;
	}

	public List<Article> getArticlesvendu() {
		return articlesvendu;
	}

	public void setArticlesvendu(List<Article> articlesvendu) {
		this.articlesvendu = articlesvendu;
	}

	public List<Article> getArticlesachete() {
		return articlesachete;
	}

	public void setArticlesachete(List<Article> articlesachete) {
		this.articlesachete = articlesachete;
	}






	@Override
	public String toString() {
		return "Utilisateur [no_utilisateur=" + no_utilisateur + ", pseudo=" + pseudo + ", nom=" + nom + ", prenom="
				+ prenom + ", emai=" + email + ", telephone=" + telephone + ", rue=" + rue + ", code_postal="
				+ code_postal + ", ville=" + ville + ", mot_de_passe=" + mot_de_passe + ", credit=" + credit
				+ ", administrateur=" + administrateur + ", articlesvendu=" + articlesvendu + ", articlesachete="
				+ articlesachete + "]";
	}
	 
	 
	
	
	 
	 
	
	 
	
	

}
