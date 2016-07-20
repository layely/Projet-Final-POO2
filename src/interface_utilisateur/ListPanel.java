package interface_utilisateur;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.text.MessageFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable.PrintMode;
import javax.swing.table.AbstractTableModel;

import net.miginfocom.swing.MigLayout;
import objet.Ecole;
import objet.Eleve;
import objet.Lycee;

import org.jdesktop.swingx.JXTable;

import databaseDAOs.DAO_Eleve;
import tablemodels.EcoleModel;
import tablemodels.EleveModel;
import tablemodels.LyceeModel;
import utilitaire.Outil;

public class ListPanel extends JPanel {
	protected JXTable table;
	
	private JFrame parent;
	private EleveModel eleveModel;
	private String serie;
	private final JPanel panel = new JPanel();
	private final JButton btnImprimer = new JButton("Imprimer");
	private final JButton btnModifier = new JButton("Modifier");
	private final JButton btnSupprimer = new JButton("Supprimer");
	private final JButton btnPlusDinfo = new JButton("+ d'info");
	
	private DAO_Eleve eleveDAO = new DAO_Eleve();
	
	/**
	 * Create the panel.
	 * 
	 * @wbp.parser.constructor
	 */
	public ListPanel(JFrame parent, String serie) {
		this.parent = parent;
		this.serie = serie;
		this.setSize(725, 451);
		// this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		initialize();
	}

	public ListPanel(JFrame parent, AbstractTableModel tableModel) {
		this.parent = parent;
		this.setBackground(Outil.CENTER_PANE_COLOR);
		this.setSize(400, 400);
		// this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		initialize(tableModel);
	}

	private void initialize(AbstractTableModel tableModel) {
		this.table = new JXTable();
		this.table.setColumnControlVisible(true);
		this.table.setBackground(Outil.CENTER_PANE_COLOR);
		if (tableModel != null)
			table.setModel(tableModel);
		table.setIntercellSpacing(new Dimension(10, 0));
		table.setAutoCreateRowSorter(true);
		table.setRowHeight(30);
		table.setFont(new Font(table.getFont().getName(), table.getFont()
				.getStyle(), (int) (table.getFont().getSize() * 1.2)));
		table.packAll();
		setLayout(new MigLayout("", "[grow,fill]",
				"[::400px,grow,fill][40px,grow]"));
		add(new JScrollPane(table), "cell 0 0,grow");

		add(this.panel, "cell 0 1,grow");
		this.panel.setLayout(new MigLayout("", "[][][][]", "[]"));
		this.btnImprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnImprimer_actionPerformed(arg0);
			}
		});

		this.panel.add(this.btnImprimer, "cell 0 0");
		this.btnPlusDinfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnPlusDinfo_actionPerformed(arg0);
			}
		});

		this.panel.add(this.btnPlusDinfo, "cell 1 0");
		this.btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnSupprimer_actionPerformed(arg0);
			}
		});

		this.panel.add(this.btnSupprimer, "cell 2 0");

		this.panel.add(this.btnModifier, "cell 3 0");
	}

	private void initialize() {
		eleveModel = new EleveModel(serie);
		initialize(eleveModel);

	}

	public void setTableModel(AbstractTableModel tableModel) {
		if (table != null)
			table.setModel(tableModel);
		table.repaint();
		table.packAll();
	}

	protected void do_btnPlusDinfo_actionPerformed(ActionEvent arg0) {
		getObject();
	}

	protected void do_btnImprimer_actionPerformed(ActionEvent arg0) {
		try {
			boolean complete = table.print(PrintMode.FIT_WIDTH,
					new MessageFormat("Bon just un test pour l'instant"),
					new MessageFormat("Page - {0}"), true, null, true, null);
		} catch (PrinterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Object getObject() {
		Object model = table.getModel();
		if (model instanceof EleveModel) {
			EleveModel modelEleve = (EleveModel) table.getModel();
			int selectedRow = table.getSelectedRow();
			if (selectedRow < 0) {
				System.out.println("pfff : pas de selection");
				return null;
			}
			Eleve eleve = (Eleve) modelEleve.get(table
					.convertRowIndexToModel(selectedRow));
			
			JOptionPane.showMessageDialog(this.parent, eleve.toString());
			// Eleve eleve = (Eleve) model.get(selectedRow);
			System.out.println("yuppi : on a : " + eleve.getNumTable());
			return eleve;
		}

		if (model instanceof EcoleModel) {
			EcoleModel modelEcole = (EcoleModel) table.getModel();
			int selectedRow = table.getSelectedRow();
			if (selectedRow < 0) {
				System.out.println("pfff : pas de selection");
				return null;
			}
			Ecole ecole = (Ecole) modelEcole.get(table
					.convertRowIndexToModel(selectedRow));

			System.out.println("yuppi : on a : " + ecole.getNom());
			return ecole;
		}

		if (model instanceof LyceeModel) {
			LyceeModel modelLycee = (LyceeModel) table.getModel();
			int selectedRow = table.getSelectedRow();
			if (selectedRow < 0) {
				System.out.println("pfff : pas de selection");
				return null;
			}
			Lycee lycee = (Lycee) modelLycee.get(table
					.convertRowIndexToModel(selectedRow));
			System.out.println("yuppi : on a : " + lycee.getNom());
			return lycee;
		}

		System.out.println("pas d'instance");
		return null;
	}
	
	public Object deleteObject() {
		Object model = table.getModel();
		if (model instanceof EleveModel) {
			EleveModel modelEleve = (EleveModel) table.getModel();
			int selectedRow = table.getSelectedRow();
			if (selectedRow < 0) {
				System.out.println("pfff : pas de selection");
				return null;
			}
			Eleve eleve = (Eleve) modelEleve.get(table
					.convertRowIndexToModel(selectedRow));
			
			modelEleve.delete(table.convertRowIndexToModel(selectedRow));
			
			// Eleve eleve = (Eleve) model.get(selectedRow);
			System.out.println("yuppi : on a : " + eleve.getNumTable());
			return eleve;
		}

		if (model instanceof EcoleModel) {
			EcoleModel modelEcole = (EcoleModel) table.getModel();
			int selectedRow = table.getSelectedRow();
			if (selectedRow < 0) {
				System.out.println("pfff : pas de selection");
				return null;
			}
			Ecole ecole = (Ecole) modelEcole.get(table
					.convertRowIndexToModel(selectedRow));

			System.out.println("yuppi : on a : " + ecole.getNom());
			return ecole;
		}

		if (model instanceof LyceeModel) {
			LyceeModel modelLycee = (LyceeModel) table.getModel();
			int selectedRow = table.getSelectedRow();
			if (selectedRow < 0) {
				System.out.println("pfff : pas de selection");
				return null;
			}
			Lycee lycee = (Lycee) modelLycee.get(table
					.convertRowIndexToModel(selectedRow));
			System.out.println("yuppi : on a : " + lycee.getNom());
			return lycee;
		}

		System.out.println("pas d'instance");
		return null;
	}
	protected void do_btnSupprimer_actionPerformed(ActionEvent arg0) {
		this.deleteObject();
	}
}