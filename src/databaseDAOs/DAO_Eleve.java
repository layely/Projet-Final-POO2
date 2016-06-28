package databaseDAOs;

import java.sql.*;
import java.util.ArrayList;

import objet.Eleve;

public class DAO_Eleve {
	public final static String TABLE_ELEVE = "Eleve";
	public final static String COLONNE_NUM_TABLE = "numeroTable";
	public final static String COLONNE_PRENOM = "Prenom";
	public final static String COLONNE_NOM = "Nom";
	public final static String COLONNE_DATE_NAISSANCE = "dateNaissance";
	public final static String COLONNE_LIEU_NAISSANCE = "lieu_Naissance";
	public final static String COLONNE_SEXE = "sexe";
	public final static String COLONNE_EMAIL = "email";

	Connection connect = (Connection) DBConnection.getConnection();

	public void getAllEleves() {
		//ArrayList<Eleve> eleve = new ArrayList<>();
		try {
			Statement stm = connect.createStatement();
			ResultSet resultSet = stm.executeQuery("SELECT * FROM " + TABLE_ELEVE);
			commeListeEleve(resultSet);
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// insérer eleve
	public void insertEleve(int num_table, String prenom, String nom, String date_naissance, String lieu_naissance,
			String sexe, String email) {
		try {
			Statement stm = connect.createStatement();
			stm.executeUpdate("INSERTINTO " + TABLE_ELEVE + " VALUES(" + num_table + ",'" + prenom + "','" + nom + "','"
					+ date_naissance + "','" + lieu_naissance + "','" + sexe + "','" + email + "')");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	//supprimer un eleve
	public void deleteEleve(int num_table) {
		try {
			Statement stm = connect.createStatement();
			int row = stm.executeUpdate("DELETE FROM " + TABLE_ELEVE + " WHERE " + COLONNE_NUM_TABLE + "=" + num_table);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// information sur un eleve
	public void infoEleve(int num_table){
		try{
			Statement stm = connect.createStatement() ;
			ResultSet resultSet = stm.executeQuery("SELECT FROM "+TABLE_ELEVE+" WHERE "+COLONNE_NUM_TABLE+"="+num_table) ;
			commeListeEleve(resultSet);
		}catch(SQLException e){
			e.printStackTrace();
			//TODO
		}
	}

	public void commeListeEleve(ResultSet resultSet) {
		try {
			while (resultSet.next()) {
				int numeroTable = resultSet.getInt(COLONNE_NUM_TABLE);
				String prenom = resultSet.getString(COLONNE_PRENOM);
				String nom = resultSet.getString(COLONNE_NOM);
				String date_Naissance = resultSet.getString(COLONNE_DATE_NAISSANCE);
				String lieu_Naissance = resultSet.getString(COLONNE_LIEU_NAISSANCE);
				String sexe = resultSet.getString(COLONNE_SEXE);
				String email = resultSet.getString(COLONNE_EMAIL);
				
				//Eleve eleve = new Eleve(numeroTable, prenom, nom, date_Naissance, dateNaissance, email, resultat, etablissement);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
