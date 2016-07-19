package tablemodels;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import databaseDAOs.DAO_Ecole;
import objet.Ecole;

public class EcoleModel extends AbstractTableModel {

	private final String[] entetes = {"Nom ecole", "Mot de passe" };

	private DAO_Ecole ecoleDAO;

	ArrayList<Ecole> listeEcoles;

	public EcoleModel() {
		this.ecoleDAO = new DAO_Ecole();

		try {
			// listEleves = eleveDAO.getAllEleves();
			listeEcoles = ecoleDAO.getAllEcole();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // new DAO_Eleve().getAllEleves();
			// //TODO
	}
	
	public Object get(int rowIndex){
		return listeEcoles.get(rowIndex);
	} 
	
	@Override
	public int getRowCount() {	
		return listeEcoles.size();
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
			return listeEcoles.get(rowIndex).getNom();

		case 1:
			return listeEcoles.get(rowIndex).getMotDePasse();

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
			return String.class;
		default:
			return Object.class;
		}
	}

}
