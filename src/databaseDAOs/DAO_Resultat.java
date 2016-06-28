package databaseDAOs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import objet.Resultat;

public class DAO_Resultat {
	public final static String TABLE_RESULTAT = "Resultat";
	public final static String NUM_RESULT = "num_result";
	public final static String PASSAGE = "passage";
	public final static String MOY_GENERAL = "Moyennne_General";
	public final static String MOY_MATHS = "moyenne_Maths";
	public final static String MOY_FRANCAIS = "moyenne_Francais";
	public final static String MOY_SVT = "moyenne_SVT";
	public final static String MOY_HISTO_GEO = "moyenne_HistoGeo";
	public final static String MOY_PC = "moyenne_PC";
	public final static String NUM_TABLE_ELEVE = "eleve_numerotable";

	Connection connect = DBConnection.getConnection();

	public ArrayList<Resultat> getAllResultats() {
		try {
			Statement stm = connect.createStatement();
			ResultSet resultSet = stm.executeQuery("SELECT * FROM " + TABLE_RESULTAT);
			
			return commeListResultat(resultSet);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null ;
	}

	// recuperation d'un resultat

	public ArrayList<Resultat> getOneResultat(int num_table) {
		
		try {
			Statement stm = connect.createStatement();
			ResultSet resultat =  stm
					.executeQuery("SELECT FROM " + TABLE_RESULTAT + " WHERE " + NUM_TABLE_ELEVE + "=" + num_table);
			return commeListResultat(resultat);
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null ;
	}

	public ArrayList<Resultat> commeListResultat(ResultSet resultat) {
		ArrayList<Resultat> myResultat = new ArrayList<>() ;
		try {
			while (resultat.next()) {
				int num_result = resultat.getInt(NUM_RESULT);
				int passable = resultat.getInt(PASSAGE);
				float moy_general = resultat.getFloat(MOY_GENERAL);
				float moy_maths = resultat.getFloat(MOY_MATHS);
				float moy_francais = resultat.getFloat(MOY_FRANCAIS);
				float moy_svt = resultat.getFloat(MOY_SVT);
				float moy_histogeo = resultat.getFloat(MOY_HISTO_GEO);
				float moy_pc = resultat.getFloat(MOY_PC);
				
				Resultat res = new Resultat(moy_maths, moy_francais, moy_svt, moy_histogeo, moy_pc, moy_general, passable) ;
				myResultat.add(res) ;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myResultat ;
	}

}
