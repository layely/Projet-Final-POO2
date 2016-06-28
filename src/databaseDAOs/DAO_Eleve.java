package databaseDAOs;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;

import objet.Ecole;
import objet.Eleve;
import objet.Resultat;
import utilitaire.Outil;

public class DAO_Eleve {
	public final static String TABLE_ELEVE = "Eleve";
	public final static String COLONNE_NUM_TABLE = "numeroTable";
	public final static String COLONNE_PRENOM = "Prenom";
	public final static String COLONNE_NOM = "Nom";
	public final static String COLONNE_DATE_NAISSANCE = "dateNaissance";
	public final static String COLONNE_LIEU_NAISSANCE = "lieu_Naissance";
	public final static String COLONNE_SEXE = "sexe";
	public final static String COLONNE_EMAIL = "email";
	public final static String COLONNE_NOM_ECOLE = "nom_ecole" ;
	

	Connection connect = (Connection) DBConnection.getConnection();

	public void getAllEleves() throws ParseException {
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
	public void infoEleve(int num_table) throws ParseException{
		try{
			Statement stm = connect.createStatement() ;
			ResultSet resultSet = stm.executeQuery("SELECT FROM "+TABLE_ELEVE+" WHERE "+COLONNE_NUM_TABLE+"="+num_table) ;
			commeListeEleve(resultSet);
		}catch(SQLException e){
			e.printStackTrace();
			//TODO
		}
	}

	public void commeListeEleve(ResultSet resultSet) throws ParseException {
		try {
			while (resultSet.next()) {
				int numeroTable = resultSet.getInt(COLONNE_NUM_TABLE);
				String prenom = resultSet.getString(COLONNE_PRENOM);
				String nom = resultSet.getString(COLONNE_NOM);
				String date_Naissance = resultSet.getString(COLONNE_DATE_NAISSANCE);
				String lieu_Naissance = resultSet.getString(COLONNE_LIEU_NAISSANCE);
				String sexe = resultSet.getString(COLONNE_SEXE);
				String email = resultSet.getString(COLONNE_EMAIL);
				Resultat resultat = DAO_Resultat.getOneResultat(numeroTable) ;
				Ecole ecole = DAO_Ecole.getOneEcole(COLONNE_NOM_ECOLE) ;
				String nom_ecole = ecole.getNom() ;
				Calendar dateNaissance = Outil.stringToCalendar(date_Naissance) ;
				
				Eleve eleve = new Eleve(numeroTable,nom, prenom,lieu_Naissance, dateNaissance, email, resultat, nom_ecole);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
