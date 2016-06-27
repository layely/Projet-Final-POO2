package objet;

import java.util.GregorianCalendar;

public class Eleve {

	int numTable;
	String nom;
	String prenom;
	String lieuNaissance;
	GregorianCalendar dateNaissance;
	String email;
	Resultat resultat;
	Ecole etablissement;
	
	
	/////////////////////////////////////////
	// Constructeur
	public Eleve(int numTable, String nom, String prenom, String lieuNaissance, GregorianCalendar dateNaissance,
			String email, Resultat resultat, Ecole etablissement) {
		super();
		this.numTable = numTable;
		this.nom = nom;
		this.prenom = prenom;
		this.lieuNaissance = lieuNaissance;
		this.dateNaissance = dateNaissance;
		this.email = email;
		this.resultat = resultat;
		this.etablissement = etablissement;
	}
	
	
	
	////////////////////////////////
	// Getters and Setters
	////////////////////////////////
	public int getNumTable() {
		return numTable;
	}
	public void setNumTable(int numTable) {
		this.numTable = numTable;
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
	public String getLieuNaissance() {
		return lieuNaissance;
	}
	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}
	public GregorianCalendar getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(GregorianCalendar dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Resultat getResultat() {
		return resultat;
	}
	public void setResultat(Resultat resultat) {
		this.resultat = resultat;
	}
	public Ecole getEtablissement() {
		return etablissement;
	}
	public void setEtablissement(Ecole etablissement) {
		this.etablissement = etablissement;
	}
	
}
