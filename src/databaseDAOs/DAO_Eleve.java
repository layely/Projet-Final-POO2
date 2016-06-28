package databaseDAOs;

import com.sun.corba.se.pept.transport.Connection;

public class DAO_Eleve {
	public final static String TABLE_ELEVE = "Eleve" ;
	public final static String COLONNE_NUM_TABLE = "numeroTable" ;
	public final static String COLONNE_PRENOM = "Prenom" ;
	public final static String COLONNE_NOM = "Nom" ;
	public final static String COLONNE_DATE_NAISSANCE = "dateNaissance" ;
	public final static String COLONNE_LIEU_NAISSANCE = "lieu_Naissance" ;
	public final static String COLONNE_SEXE = "sexe" ;
	public final static String COLONNE_EMAIL = "email" ;
	
	
	Connection connect = (Connection) DBConnection.getConnection() ;
	
	public 

}
