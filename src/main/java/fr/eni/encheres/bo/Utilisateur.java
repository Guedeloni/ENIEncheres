package fr.eni.encheres.bo;

import java.util.List;

public class Utilisateur {

	private int no_utilisateur;

	private String pseudo;

	private String nom;

	private String prenom;

	private String email;

	private String telephone;

	private String rue;
	// code_postal est un String dans les cas où par ex on tape 01 pour Laon
	// car il va croire que c'est 1 car 0+1 ou encore quand il y a des lettres dans
	// les départements
	private String code_postal;

	private String ville;

	private String mot_de_passe;

	private int credit;

	private int administrateur = 0;

	private List<Article> articlesvendu; // attribut de relation

	private List<Article> articlesachete; // attribut de relation

	// constructeur

	public Utilisateur() {
	}

	public Utilisateur(int no_utilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String code_postal, String ville, String mot_de_passe) {
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
	}

	public Utilisateur(int no_utilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String code_postal, String ville, String mot_de_passe, int credit, int administrateur) {
		this(no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe);
		this.credit = credit;
		this.administrateur = administrateur;
	}

	public Utilisateur(int no_utilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String code_postal, String ville, String mot_de_passe, int credit, int administrateur,
			List<Article> articlesvendu, List<Article> articlesachete) {
		this(no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit,
				administrateur);
		this.articlesvendu = articlesvendu;
		this.articlesachete = articlesachete;
	}

	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String code_postal, String ville, String mot_de_passe, int credit, int administrateur) {
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
	}


	// getters et setter
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {

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

	public String getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(String code_postal) {
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

				+ prenom + ", email=" + email + ", telephone=" + telephone + ", rue=" + rue + ", code_postal="

				+ code_postal + ", ville=" + ville + ", mot_de_passe=" + mot_de_passe + ", credit=" + credit
				+ ", administrateur=" + administrateur + ", articlesvendu=" + articlesvendu + ", articlesachete="
				+ articlesachete + "]";
	}

}

//package fr.eni.encheres.bo;
//
//import java.util.List;
//
//public class Utilisateur {
//
//	private int no_utilisateur;
//
//	private String pseudo;
//
//	private String nom;
//
//	private String prenom;
//
//	private String email;
//
//	private String telephone;
//
//	private String rue;
//	// code_postal est un String dans les cas où par ex on tape 01 pour Laon
//	// car il va croire que c'est 1 car 0+1 ou encore quand il y a des lettres dans
//	// les départements
//	private String code_postal;
//
//	private String ville;
//
//	private String mot_de_passe;
//
//	private int credit;
//
//	private int administrateur = 0;
//
//	private List<Article> articlesvendu;	// attribut de relation
//
//	private List<Article> articlesachete;	// attribut de relation
//
//	// constructeur
//
//	public Utilisateur() {
//	}
//
//	public Utilisateur(int no_utilisateur, String pseudo, String nom, String prenom, String email, String telephone, String rue,
//			String code_postal, String ville, String mot_de_passe) {
//		this.no_utilisateur = no_utilisateur;
//		this.pseudo = pseudo;
//		this.nom = nom;
//		this.prenom = prenom;
//		this.email = email;
//		this.telephone = telephone;
//		this.rue = rue;
//		this.code_postal = code_postal;
//		this.ville = ville;
//		this.mot_de_passe = mot_de_passe;
//	}
//
//	public Utilisateur(int no_utilisateur, String pseudo, String nom, String prenom, String email, String telephone, String rue,
//			String code_postal, String ville, String mot_de_passe, int credit, int administrateur) {
//		this(no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe);
//		this.credit = credit;
//		this.administrateur = administrateur;
//	}
//
//	public Utilisateur(int no_utilisateur, String pseudo, String nom, String prenom, String email, String telephone,
//			String rue, String code_postal, String ville, String mot_de_passe, int credit, int administrateur,
//			List<Article> articlesvendu, List<Article> articlesachete) {
//		this(no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur);
//		this.articlesvendu = articlesvendu;
//		this.articlesachete = articlesachete;
//	}
//
//
//
//	// getters et setter
//	public int getNo_utilisateur() {
//		return no_utilisateur;
//	}
//
//	public void setNo_utilisateur(int no_utilisateur) {
//		this.no_utilisateur = no_utilisateur;
//	}
//
//	public String getPseudo() {
//		return pseudo;
//	}
//
//	public void setPseudo(String pseudo) {
//		this.pseudo = pseudo;
//	}
//
//	public String getNom() {
//		return nom;
//	}
//
//	public void setNom(String nom) {
//		this.nom = nom;
//	}
//
//	public String getPrenom() {
//		return prenom;
//	}
//
//	public void setPrenom(String prenom) {
//		this.prenom = prenom;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//
//		this.email = email;
//	}
//
//	public String getTelephone() {
//		return telephone;
//	}
//
//	public void setTelephone(String telephone) {
//		this.telephone = telephone;
//	}
//
//	public String getRue() {
//		return rue;
//	}
//
//	public void setRue(String rue) {
//		this.rue = rue;
//	}
//
//	public String getCode_postal() {
//		return code_postal;
//	}
//
//	public void setCode_postal(String code_postal) {
//		this.code_postal = code_postal;
//	}
//
//	public String getVille() {
//		return ville;
//	}
//
//	public void setVille(String ville) {
//		this.ville = ville;
//	}
//
//	public String getMot_de_passe() {
//		return mot_de_passe;
//	}
//
//	public void setMot_de_passe(String mot_de_passe) {
//		this.mot_de_passe = mot_de_passe;
//	}
//
//	public int getCredit() {
//		return credit;
//	}
//
//	public void setCredit(int credit) {
//		this.credit = credit;
//	}
//
//	public int getAdministrateur() {
//		return administrateur;
//	}
//
//	public void setAdministrateur(int administrateur) {
//		this.administrateur = administrateur;
//	}
//
//	public List<Article> getArticlesvendu() {
//		return articlesvendu;
//	}
//
//	public void setArticlesvendu(List<Article> articlesvendu) {
//		this.articlesvendu = articlesvendu;
//	}
//
//	public List<Article> getArticlesachete() {
//		return articlesachete;
//	}
//
//	public void setArticlesachete(List<Article> articlesachete) {
//		this.articlesachete = articlesachete;
//	}
//
//	@Override
//	public String toString() {
//		return "Utilisateur [no_utilisateur=" + no_utilisateur + ", pseudo=" + pseudo + ", nom=" + nom + ", prenom="
//
//				+ prenom + ", email=" + email + ", telephone=" + telephone + ", rue=" + rue + ", code_postal="
//
//				+ code_postal + ", ville=" + ville + ", mot_de_passe=" + mot_de_passe + ", credit=" + credit
//				+ ", administrateur=" + administrateur + ", articlesvendu=" + articlesvendu + ", articlesachete="
//				+ articlesachete + "]";
//	}
//
//}