package tablemodels;

import javax.swing.table.AbstractTableModel;

public abstract class MyTableModel extends AbstractTableModel {
	
	
	public abstract boolean delete(int rowIndex);
}
