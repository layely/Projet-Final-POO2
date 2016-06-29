package databaseDAOs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAO_Lycee {
	public final static String TABLE_LYCEE = "Lycee" ;
	public final static String COLONNE_NOM_LYCEE = "nom_lycee" ;
	public final static String COLONNE_NB_PLACE_S = "nb_place_S" ;
	public final static String COLONNE_NB_PLACE_L = "nb_place_L" ;
	public final static String COLONNE_NB_PLACE_G = "nb_place_G" ;
	public final static String COLONNE_NB_PLACE_T = "nb_place_T" ;
	
	Connection connect = DBConnection.getConnection() ;
	
	public void getAllLycee(){
		try{
			Statement stm = connect.createStatement() ;
			ResultSet resultSet = stm.executeQuery("SELECT * FROM "+TABLE_LYCEE) ;
			commListLycee(resultSet);
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	
	
	
	
	public void commListLycee(ResultSet resultSet){
		
		try{
			while(resultSet.next()){
				String nom = resultSet.getString(COLONNE_NOM_LYCEE) ;
				int S = resultSet.getInt(COLONNE_NB_PLACE_S) ;
				int L = resultSet.getInt(COLONNE_NB_PLACE_L) ;
				int G =resultSet.getInt(COLONNE_NB_PLACE_G) ;
				int T = resultSet.getInt(COLONNE_NB_PLACE_T) ;
				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	
	public void ajouLycee(){
		
	}




	
}
