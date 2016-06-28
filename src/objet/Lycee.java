package objet;

public class Lycee {
	String nom;
	int nbPlacesSerieL;
	int nbPlacesSerieS;
	int nbPlacesSerieG;
	int nbPlacesSerieT;

	public Lycee(String nom, int nbPlacesSerieL, int nbPlacesSerieS, int nbPlacesSerieG, int nbPlacesSerieT) {
		super();
		this.nom = nom;
		this.nbPlacesSerieL = nbPlacesSerieL;
		this.nbPlacesSerieS = nbPlacesSerieS;
		this.nbPlacesSerieG = nbPlacesSerieG;
		this.nbPlacesSerieT = nbPlacesSerieT;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNbPlacesSerieL() {
		return nbPlacesSerieL;
	}

	public void setNbPlacesSerieL(int nbPlacesSerieL) {
		this.nbPlacesSerieL = nbPlacesSerieL;
	}

	public int getNbPlacesSerieS() {
		return nbPlacesSerieS;
	}

	public void setNbPlacesSerieS(int nbPlacesSerieS) {
		this.nbPlacesSerieS = nbPlacesSerieS;
	}

	public int getNbPlacesSerieG() {
		return nbPlacesSerieG;
	}

	public void setNbPlacesSerieG(int nbPlacesSerieG) {
		this.nbPlacesSerieG = nbPlacesSerieG;
	}

	public int getNbPlacesSerieT() {
		return nbPlacesSerieT;
	}

	public void setNbPlacesSerieT(int nbPlacesSerieT) {
		this.nbPlacesSerieT = nbPlacesSerieT;
	}

}
