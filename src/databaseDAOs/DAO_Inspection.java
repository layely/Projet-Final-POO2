package databaseDAOs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import objet.Ecole;
import objet.Inspection;

public class DAO_Inspection {

	public final static String TABLE_INSPECTION = "Inspection";
	public final static String COLONNE_NOM_INSPECTION = "nom_inspection";
	public final static String COLONNE_PASSWORD_INSPECTION = "password_inspection";

	Connection connect = DBConnection.getConnection();

	// tous les Inspection
	public ArrayList<Inspection> getAllInspection() {
		try {
			Statement stm = connect.createStatement();
			ResultSet resultSet = stm.executeQuery("SELECT * FROM " + TABLE_INSPECTION);

			return commeListeInspection(resultSet);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public void ajout(Inspection inspection) {
		try {
			Statement stm = connect.createStatement();
			stm.executeUpdate("INSERT INTO " + TABLE_INSPECTION + " VALUES('" + inspection.getNom() + "','"
					+ inspection.getMot() + "')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Inspection> commeListeInspection(ResultSet resultSet) {
		ArrayList<Inspection> myInspection = new ArrayList<>();
		try {
			while (resultSet.next()) {
				String nom = resultSet.getString(COLONNE_NOM_INSPECTION);
				String password = resultSet.getString(COLONNE_PASSWORD_INSPECTION);

				Inspection insp = new Inspection();

				myInspection.add(insp);

			}
			return myInspection;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

}
