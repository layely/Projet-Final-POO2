package objet;

public class Inspection {
	String nom;
	String motDePasse;
	
	
   ////////////////////////////////
   // Getters and Setters
   ////////////////////////////////
	
	public Inspection(String nom2, String password) {
		this.nom = nom2;
			this.motDePasse = password;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getMot() {
		return motDePasse;
	}
	public void setMot(String mot) {
		this.motDePasse = mot;
	}
	
	
	
}


