package tablemodels;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.mysql.fabric.xmlrpc.base.Array;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import databaseDAOs.DAO_Eleve;
import objet.Eleve;

public class EleveModel extends AbstractTableModel {

	private final String[] entetes = { "Numero de Table", "Prenom", "Nom", "Date de naissance", "Lieu de naissance",
			"Moyenne choix" };

	ArrayList<Eleve> listEleves;
	String serie;

	public EleveModel(String serie) {
		this.serie = serie;
		listEleves =  new ArrayList<>(); //new DAO_Eleve().getAllEleves(); //TODO
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
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return listEleves.get(rowIndex).getNumTable();

		case 1:
			return listEleves.get(rowIndex).getPrenom();

		case 2:
			return listEleves.get(rowIndex).getNom();

		case 3:
			return listEleves.get(rowIndex).getDateNaissance().toString();

		case 4:
			return listEleves.get(rowIndex).getLieuNaissance();

		case 5:
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
