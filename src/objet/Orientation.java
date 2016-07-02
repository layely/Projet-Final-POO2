package objet;

import java.text.ParseException;
import java.util.LinkedList;

import databaseDAOs.DAO_Eleve;
import databaseDAOs.DAO_Lycee;

public class Orientation {
	private static DAO_Eleve eleveDAO = new DAO_Eleve();
	private static DAO_Lycee lyceeDAO = new DAO_Lycee();

	private static LinkedList<Eleve> listdesOrientesL = new LinkedList<>();
	private static LinkedList<Eleve> listdesOrientesS = new LinkedList<>();
	private static LinkedList<Eleve> listdesOrientesG = new LinkedList<>();
	private static LinkedList<Eleve> listdesOrientesT = new LinkedList<>();

	private static LinkedList<Eleve> listDesNonOrientes = new LinkedList<>();

	public LinkedList<Eleve> getListCompletDesOrientes(String serie) throws ParseException {
		genererListDesOrientes();
		switch (serie.toUpperCase()) {
		case "L":
			return listdesOrientesL;
		case "S":
			return listdesOrientesS;
		case "G":
			return listdesOrientesG;
		case "T":
			return listdesOrientesT;
		default:
			return null;
		}
	}

	public LinkedList<Eleve> getListCompletDesNonOrientes() throws ParseException {
		genererListDesOrientes();
		return listDesNonOrientes;

	}

	private static void genererListDesOrientes() throws ParseException {
		listdesOrientesL.clear();
		listdesOrientesS.clear();
		listdesOrientesG.clear();
		listdesOrientesT.clear();
		listDesNonOrientes.clear();
		for (Eleve eleve : eleveDAO.getAllEleves()) {
			oriente(eleve);
		}
	}

	private static void oriente(Eleve eleve) {
		// TODO Auto-generated method stub
		String choix1 = eleve.getChoix1();
		String choix2 = eleve.getChoix2();
		String choix3 = eleve.getChoix3();

		if (!oriente(eleve, choix1))
			if (!oriente(eleve, choix2))
				if (!oriente(eleve, choix3))
					listDesNonOrientes.add(eleve);

	}

	private static boolean oriente(Eleve eleve, String choix) {

		// Oriente dans son choix numero 1 si possible
		if (getListDesOrientes(choix).size() < lyceeDAO.nbPlacesSerie(choix)) {
			getListDesOrientes(choix).add(eleve);
			return true;
		} else { // Liste pleine
			Eleve plusFaible = plusFaibleCumul(choix);
			// dispose d'un meilleur cumul
			if (plusFaible == null || eleve.compareCumul(plusFaible, choix) > 0) {
				getListDesOrientes(choix).remove(plusFaible);
				getListDesOrientes(choix).add(eleve);
				oriente(plusFaible);
				return true;
			} else
				return false;
		}
	}

	private static LinkedList<Eleve> getListDesOrientes(String serie) {
		switch (serie.toUpperCase()) {
		case "L":
			return listdesOrientesL;
		case "S":
			return listdesOrientesS;
		case "G":
			return listdesOrientesG;
		case "T":
			return listdesOrientesT;
		default:
			return null;
		}
	}

	private static Eleve plusFaibleCumul(String serie) {
		Eleve eleve = null;
		for (Eleve e : getListDesOrientes(serie)) {
			if (eleve == null)
				eleve = e;
			else if (eleve.getResultat().moyenneChoix(serie) > e.getResultat().moyenneChoix(serie))
				eleve = e;
			else if (eleve.getResultat().moyenneChoix(serie) == e.getResultat().moyenneChoix(serie)) {
				if (eleve.dateNaissance.compareTo(e.dateNaissance) > 0)
					eleve = e;
			}
		}

		return eleve;
	}
}
