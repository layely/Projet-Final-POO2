package objet;

public class Resultat {

	public static int ECHEC = 0;
	public static int TOUR_1 = 1;
	public static int TOUR_2 = 2;

	private Double noteMaths;
	private Double noteSVT;
	private Double noteFrancais;
	private Double noteHistoGeo;
	private Double notePC;
	private Double moyenneGenerale;

	private int passageExam; // echec = 0, 1er tour = 1, 2eme tour = 2;

	public Resultat(double maths, double francais, double svt, double histoGeo, double pc, double moyenneGenerale,
			int passageExam) {
		this.setNoteMaths(maths);
		this.setNoteFrancais(francais);
		this.setNoteHistoGeo(histoGeo);
		this.setNotePC(pc);
		this.setNoteSVT(svt);
		this.setMoyenneGenerale(moyenneGenerale);
		this.setPassageExam(passageExam);
	}

	public Double moyenneChoixSerieL() {
		return moyenneChoix(noteFrancais, noteHistoGeo);
	}

	public Double moyenneChoixSerieS() {
		return moyenneChoix(noteMaths, noteSVT);
	}

	public Double moyenneChoixSerieG() {
		return moyenneChoix(noteFrancais, noteMaths);
	}

	public Double moyenneChoixSerieT() {
		return moyenneChoix(noteMaths, notePC);
	}

	public Double moyenneChoix(String serie) {
		switch (serie.toUpperCase()) {
		case "L":
			return moyenneChoixSerieL();
		case "S":
			return moyenneChoixSerieS();
		case "G":
			return moyenneChoixSerieG();

		case "T":
			return moyenneChoixSerieT();
		default:
			return null; //TODO
		}
	}

	public int compareTo(Resultat autreResultat, String serie) {
		if(this.moyenneChoix(serie) > autreResultat.moyenneChoix(serie))
			return 1;
		if(this.moyenneChoix(serie) < autreResultat.moyenneChoix(serie))
			return -1;
		return 0;
	}

	private Double moyenneChoix(double d1, double d2) {
		double coefficient = 0;

		if (passageExam == 0) // A échoué au bfem
			coefficient = 0.75;
		if (passageExam == 1) // A réussi au premier tour
			coefficient = 2.5;
		if (passageExam == 2) // A réussi au second tour
			coefficient = 1.25;

		return moyenneGenerale + d1 + d2 + coefficient;
	}

	////////////////////////////////////////////
	// Getters and Setters
	////////////////////////////////////////////
	public Double getNoteMaths() {
		return noteMaths;
	}

	public void setNoteMaths(Double noteMaths) {
		this.noteMaths = noteMaths;
	}

	public Double getNoteSVT() {
		return noteSVT;
	}

	public void setNoteSVT(Double noteSVT) {
		this.noteSVT = noteSVT;
	}

	public Double getNoteFrancais() {
		return noteFrancais;
	}

	public void setNoteFrancais(Double noteFrancais) {
		this.noteFrancais = noteFrancais;
	}

	public Double getNoteHistoGeo() {
		return noteHistoGeo;
	}

	public void setNoteHistoGeo(Double noteHistoGeo) {
		this.noteHistoGeo = noteHistoGeo;
	}

	public Double getNotePC() {
		return notePC;
	}

	public void setNotePC(Double notePC) {
		this.notePC = notePC;
	}

	public Double getMoyenneGenerale() {
		return moyenneGenerale;
	}

	public void setMoyenneGenerale(Double moyenneGenerale) {
		this.moyenneGenerale = moyenneGenerale;
	}

	public int getPassageExam() {
		return passageExam;
	}

	public void setPassageExam(int passageExam) {
		this.passageExam = passageExam;
	}

	public String getBfemResutatString() {
		if(this.passageExam == ECHEC)
			return "ECHEC";
		if(this.passageExam == TOUR_1)
			return "1er TOUR";
		if(this.passageExam == TOUR_2)
			return "2nd TOUR";
		return null;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Résulat Scolaire\n");
		str.append("----------------------------------------------------------------------------------------------------------------------------\n");
		str.append("Notes :\n");
		str.append("Français: " + this.noteFrancais + "     ");
		str.append("Mathématiques: " + this.noteMaths + "     ");
		str.append("SVT: " + this.noteSVT + "     ");
		str.append("Histoire-Géographie: " + this.noteHistoGeo + "     ");
		str.append("Physique-Chimie: " + this.notePC + "\n");
		str.append("Moyenne Générale :  " + this.getMoyenneGenerale() + "\n");
		str.append("BFEM :  " + this.getBfemResutatString() + "\n");
		return str.toString();
	}
}
