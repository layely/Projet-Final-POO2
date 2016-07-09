package interface_utilisateur;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import tablemodels.EleveModel;
import tablemodels.LyceeModel;

public class ListFrame extends JFrame {
	protected JTable table;

	private JFrame parent;
	private EleveModel eleveModel;
	private String serie;
	
	/**
	 * Create the panel.
	 */
	public ListFrame(JFrame parent, String serie) {
		this.parent = parent;
		this.serie = serie;
		this.setSize(400, 400);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		initialize();
	}
	
	public ListFrame(JFrame parent, AbstractTableModel tableModel) {
		this.parent = parent;
		this.setSize(400, 400);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		initialize(tableModel);
	}
	
	private void initialize(AbstractTableModel tableModel) {
		setLayout(new BorderLayout(0, 0));
		this.table = new JTable();
		table.setModel(tableModel);
		table.setIntercellSpacing(new Dimension(10, 10));
		table.setAutoCreateRowSorter(true);
		add(new JScrollPane(table), BorderLayout.CENTER);
	}
	
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		this.table = new JTable();
		eleveModel = new EleveModel(serie);
		table.setModel(eleveModel);
		add(new JScrollPane(table), BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		JFrame frame = new ListFrame(new JFrame(), "S");
		frame.setVisible(true);
	}

}
