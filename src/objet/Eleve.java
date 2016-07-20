package objet;

import java.util.Calendar;
import java.util.GregorianCalendar;

import utilitaire.Outil;

public class Eleve {

	int numTable;
	String nom;
	String prenom;
	String lieuNaissance;
	Calendar dateNaissance;
	char sex; // M or F
	String email;
	Resultat resultat;
	String choix; // Format :o LSG, LST, LGS ....
	String etablissement;

	/////////////////////////////////////////
	// Constructeur

	public Eleve(int numTable, String nom, String prenom, String lieuNaissance, Calendar dateNaissance, String email,
			Resultat resultat, String etablissement) {
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

	public Eleve(int numTable, String nom, String prenom, String lieuNaissance, Calendar dateNaissance, char sex,
			String etablissement) {
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

	public int compareCumul(Eleve autreEleve, String serie) {
		return this.getResultat().compareTo(autreEleve.getResultat(), serie);
	}

	public String getChoix1() {
		return String.valueOf(this.choix.charAt(0));
	}

	public String getChoix2() {
		return String.valueOf(this.choix.charAt(1));
	}

	public String getChoix3() {
		return String.valueOf(this.choix.charAt(2));
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Informations personnelles \n");
		str.append("----------------------------------------------------------------------------------------------------------------------------\n");
		str.append("Numero de Table : " + this.numTable + "\n");
		str.append("Nom : " + this.nom + "\n");
		str.append("Prénom : " + this.prenom + "\n");
		str.append("Lieu de naissance : " + this.lieuNaissance + "\n");
		str.append("Date de naissance : " + Outil.calendarToString(this.dateNaissance) + "\n");
		str.append("Sexe : " + this.sex + "\n");
		str.append("Etablissement : " + this.etablissement + "\n");
		str.append("Email : " + this.email + "\n");
		str.append("\n\n");
		
		str.append(this.getResultat().toString());
		str.append("\n\n");
		
		str.append("Les choix \n");
		str.append("----------------------------------------------------------------------------------------------------------------------------\n");
		str.append("Choix n°1: " + this.getChoix1() + "\n");
		str.append("Choix n°2: " + this.getChoix2() + "\n");
		str.append("Choix n°3: " + this.getChoix3() + "\n");
		return str.toString();
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

	public String getChoix() {
		return choix;
	}

	public void setChoix(String choix) {
		this.choix = choix;
	}

	public void setDateNaissance(Calendar dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public String getSexToString() {
		if (this.estMaculin())
			return "Masculin";
		else if (this.estFeminin())
			return "Feminin";
		return null;
	}

	public boolean estMaculin() {
		return (this.sex == 'M' || this.sex == 'm') ? true : false;
	}

	public boolean estFeminin() {
		return (this.sex == 'F' || this.sex == 'f') ? true : false;
	}
}
