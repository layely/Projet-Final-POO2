package tablemodels;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

import com.mysql.fabric.xmlrpc.base.Array;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import databaseDAOs.DAO_Eleve;
import objet.Eleve;
import objet.Orientation;
import utilitaire.Outil;

public class EleveModel extends AbstractTableModel {

	private final String[] entetes = { "Numero de Table", "Prenom", "Nom", "Date de naissance", "Lieu de naissance",
			"Moyenne choix" };
	
	private final String[] entetes2 = { "Numero de Table", "Prenom", "Nom", "Date de naissance", "Lieu de naissance",
	"Moyenne général" };
	
	private DAO_Eleve eleveDAO;

	ArrayList<Eleve> listEleves;
	String serie = null;

	public EleveModel(String serie) {
		this.eleveDAO = new DAO_Eleve();
		this.serie = serie;

		try {
			listEleves = new ArrayList<>();
			listEleves.addAll(Orientation.getListCompletDesOrientes(serie));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // new DAO_Eleve().getAllEleves();
			// //TODO
	}

	public EleveModel() {
		this.eleveDAO = new DAO_Eleve();

		try {
			listEleves = eleveDAO.getAllEleves();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Object get(int rowIndex) {
		return listEleves.get(rowIndex);
	}
	
	@Override
	public int getRowCount() {
		return listEleves.size();
	}

	@Override
	public int getColumnCount() {
		return entetes.length;
	}

	@Override
	public String getColumnName(int column) {
		if(serie == null)
			return entetes2[column];
		return entetes[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return listEleves.get(rowIndex).getNumTable();

		case 1:
			return listEleves.get(rowIndex).getPrenom();

		case 2:
			return listEleves.get(rowIndex).getNom();

		case 3:
			return Outil.calendarToString(listEleves.get(rowIndex).getDateNaissance());

		case 4:
			return listEleves.get(rowIndex).getLieuNaissance();

		case 5:
			if(serie == null)
				return listEleves.get(rowIndex).getResultat().getMoyenneGenerale();
			return listEleves.get(rowIndex).getResultat().moyenneChoix(serie);
		default:
			throw new IllegalArgumentException();
		}

	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return Integer.class;
		case 1:

		case 2:

		case 3:

		case 4:
			return String.class;

		case 5:
			return Double.class;

		default:
			return Object.class;
		}
	}

}
