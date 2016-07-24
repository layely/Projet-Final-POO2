package databaseDAOs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import objet.Lycee;

public class DAO_Lycee {
	public final static String TABLE_LYCEE = "Lycee";
	public final static String COLONNE_NOM_LYCEE = "nom_lycee";
	public final static String COLONNE_NB_PLACE_S = "nb_place_S";
	public final static String COLONNE_NB_PLACE_L = "nb_place_L";
	public final static String COLONNE_NB_PLACE_G = "nb_place_G";
	public final static String COLONNE_NB_PLACE_T = "nb_place_T";

	Connection connect = DBConnection.getConnection();

	public ArrayList<Lycee> getAllLycee() {
		try {
			Statement stm = connect.createStatement();
			ResultSet resultSet = stm.executeQuery("SELECT * FROM " + TABLE_LYCEE);
			return commListLycee(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int nbPlacesSerie(String serie)  {
		switch (serie.toUpperCase()) {
		case "L":
			return nbPlacesSerieL();
		case "S":
			return nbPlacesSerieS();
		case "G":
			return nbPlacesSerieG();
		case "T":
			return nbPlacesSerieT();
		default:
			return -1;
		}
	}

	public int nbPlacesSerieL() {
		int somme = 0;
		for (Lycee lycee : this.getAllLycee()) {
			somme += lycee.getNbPlacesSerieL();
		}
		return somme;
	}

	public int nbPlacesSerieS() {
		int somme = 0;
		for (Lycee lycee : this.getAllLycee()) {
			somme += lycee.getNbPlacesSerieS();
		}
		return somme;
	}

	public int nbPlacesSerieG() {
		int somme = 0;
		for (Lycee lycee : this.getAllLycee()) {
			somme += lycee.getNbPlacesSerieG();
		}
		return somme;
	}

	public int nbPlacesSerieT() {
		int somme = 0;
		for (Lycee lycee : this.getAllLycee()) {
			somme += lycee.getNbPlacesSerieT();
		}
		return somme;
	}

	private ArrayList<Lycee> commListLycee(ResultSet resultSet) {
		ArrayList<Lycee> listLycee = new ArrayList<>();
		try {
			while (resultSet.next()) {
				String nom = resultSet.getString(COLONNE_NOM_LYCEE);
				int S = resultSet.getInt(COLONNE_NB_PLACE_S);
				int L = resultSet.getInt(COLONNE_NB_PLACE_L);
				int G = resultSet.getInt(COLONNE_NB_PLACE_G);
				int T = resultSet.getInt(COLONNE_NB_PLACE_T);

				Lycee lycee = new Lycee(nom, L, S, G, T);
				listLycee.add(lycee);
			}
			return listLycee;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listLycee;
	}

	public void ajoutLycee(Lycee lycee, String nom_inspection) {
		try {
			Statement stm = connect.createStatement();
			stm.executeUpdate("INSERT INTO " + TABLE_LYCEE + " VALUES('" + lycee.getNom() + "',"
					+ lycee.getNbPlacesSerieS() + "," + lycee.getNbPlacesSerieL() + "," + lycee.getNbPlacesSerieG()
					+ "," + lycee.getNbPlacesSerieT() + ",'" + nom_inspection + "')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(String nom) {
		try {
			Statement stm = connect.createStatement();

			stm.executeUpdate("DELETE FROM " + TABLE_LYCEE + " WHERE " + COLONNE_NOM_LYCEE + "='" + nom +"'");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
