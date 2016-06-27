package objet;

public class Ecole {
	String nom;
	String motDePasse;

	public Ecole(String nom, String motDePasse) {
		this.setNom(nom);
		this.setMotDePasse(motDePasse);
	}


	/////////////////////////////////////
	// Getters and Setters
	/////////////////////////////////////
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

}