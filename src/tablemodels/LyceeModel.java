package tablemodels;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import databaseDAOs.DAO_Lycee;
import objet.Lycee;

public class LyceeModel extends AbstractTableModel {

	private final String[] entetes = { "Nom de Lycee", "Nombre de place en L", "Nombre de place en S",
			"Nombre de place en G", "Nombre de place en T" };

	private DAO_Lycee lyceeDAO;

	ArrayList<Lycee> listLycee;

	public LyceeModel() {
		this.lyceeDAO = new DAO_Lycee();

		try {
			// listEleves = eleveDAO.getAllEleves();
			listLycee = lyceeDAO.getAllLycee();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // new DAO_Eleve().getAllEleves();
			// //TODO
	}

	public Object get(int rowIndex){
		return listLycee.get(rowIndex);
	} 
	
	@Override
	public int getRowCount() {
		return listLycee.size();
	}

	@Override
	public int getColumnCount() {
		return entetes.length;
	}

	@Override
	public String getColumnName(int column) {
		return entetes[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return listLycee.get(rowIndex).getNom();

		case 1:
			return listLycee.get(rowIndex).getNbPlacesSerieL();

		case 2:
			return listLycee.get(rowIndex).getNbPlacesSerieS();

		case 3:
			return listLycee.get(rowIndex).getNbPlacesSerieG();

		case 4:
			return listLycee.get(rowIndex).getNbPlacesSerieT();

		default:
			throw new IllegalArgumentException();
		}

	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return String.class;
		case 1:

		case 2:

		case 3:

		case 4:
			return Integer.class;

		default:
			return Object.class;
		}
	}

}
