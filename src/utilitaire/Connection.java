package utilitaire;

import com.sun.org.apache.bcel.internal.generic.GETSTATIC;

public class Connection {
	private final static String STATUS_ECOLE = "ECOLE";
	private final static String STATUS_INSPECTION = "INSPECTION";

	private static String status;
	private static String nom;
	private static String motDePasse;



	public static String getStatus() {
		return status;
	}

	public static void setStatus(String status) {
		Connection.status = status;
	}

	public static String getNom() {
		return nom;
	}

	public static void setNom(String nom) {
		Connection.nom = nom;
	}

	public static String getMotDePasse() {
		return motDePasse;
	}

	public static void setMotDePasse(String motDePasse) {
		Connection.motDePasse = motDePasse;
	}

	public static void setStatusEcole() {
		status = STATUS_ECOLE;
	}

	public static void setStatusInspection() {
		status = STATUS_INSPECTION;
	}

	public static boolean estUneEcole() {
		if (status.equals(STATUS_ECOLE))
			return true;
		return false;
	}

	public static boolean estInspection() {
		return !estUneEcole();
	}

}
