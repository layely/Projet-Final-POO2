package objet;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Eleve {

	int numTable;
	String nom;
	String prenom;
	String lieuNaissance;
	Calendar dateNaissance;
	char sex;
	String email;
	Resultat resultat;
	String etablissement;


	/////////////////////////////////////////
	// Constructeur


	public Eleve(int numTable, String nom, String prenom, String lieuNaissance, Calendar dateNaissance,
			String email, Resultat resultat, String etablissement) {
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



	public Eleve(int numTable, String nom, String prenom, String lieuNaissance, Calendar dateNaissance,
			char sex, String etablissement) {
		super();
		this.numTable = numTable;
		this.nom = nom;
		this.prenom = prenom;
		this.lieuNaissance = lieuNaissance;
		this.dateNaissance = dateNaissance;
		this.sex = sex;
		this.etablissement = etablissement;
	}



	public Eleve(int numTable, String nom, String prenom, String lieuNaissance, Calendar dateNaissance,
			String etablissement) {
		super();
		this.numTable = numTable;
		this.nom = nom;
		this.prenom = prenom;
		this.lieuNaissance = lieuNaissance;
		this.dateNaissance = dateNaissance;
		this.etablissement = etablissement;
	}



	public Eleve() {
		// TODO Auto-generated constructor stub
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
	public Calendar getDateNaissance() {
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
	public String getEtablissement() {
		return etablissement;
	}
	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
	}

}
