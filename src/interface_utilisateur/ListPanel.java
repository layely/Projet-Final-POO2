package interface_utilisateur;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JTable;

public class ListPanel extends JPanel {
	protected JTable table;

	/**
	 * Create the panel.
	 */
	public ListPanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		this.table = new JTable();
		add(new JScrollPane(table), BorderLayout.CENTER);
	}

}
