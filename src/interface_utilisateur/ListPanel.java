package interface_utilisateur;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.text.MessageFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable.PrintMode;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;

import net.miginfocom.swing.MigLayout;
import objet.Ecole;
import objet.Eleve;
import objet.Lycee;

import org.jdesktop.swingx.JXLabel;
import org.jdesktop.swingx.JXPanel;
import org.jdesktop.swingx.JXTable;

import tablemodels.EcoleModel;
import tablemodels.EleveModel;
import tablemodels.LyceeModel;
import tablemodels.MyTableModel;
import utilitaire.Outil;
import databaseDAOs.DAO_Eleve;
import org.jdesktop.swingx.JXLabel.TextAlignment;
import javax.swing.SwingConstants;

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

	private JXLabel labelEmptyTable;

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
		this.table.setSelectionBackground(new java.awt.Color(102, 153, 255));
		this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.table.setColumnControlVisible(true);
		this.table.setSelectionForeground(java.awt.Color.WHITE);
		this.table.setBackground(Outil.CENTER_PANE_COLOR);

		if (tableModel != null)
			table.setModel(tableModel);
		table.setIntercellSpacing(new Dimension(10, 0));
		table.setAutoCreateRowSorter(true);
		table.setRowHeight(30);
		table.setFont(new Font("Footlight MT Light", Font.PLAIN, 17));
		table.packAll();
		setLayout(new MigLayout("", "[grow,fill]",
				"[::500px,grow,fill][:40px:40px]"));
		
		JXPanel panelTable = new JXPanel(new BorderLayout());
		panelTable.add(new JScrollPane(table), BorderLayout.CENTER);
		labelEmptyTable = new JXLabel();
		this.labelEmptyTable.setFont(new Font("Footlight MT Light", Font.PLAIN, 20));
		this.labelEmptyTable.setHorizontalAlignment(SwingConstants.CENTER);
		this.labelEmptyTable.setVerticalTextPosition(SwingConstants.TOP);
		this.labelEmptyTable.setVerticalAlignment(SwingConstants.TOP);
		this.labelEmptyTable.setTextAlignment(TextAlignment.CENTER);
		panelTable.add(labelEmptyTable, BorderLayout.SOUTH);
		add(panelTable, "cell 0 0,grow");
		
		add(this.panel, "cell 0 1,growx");
		this.panel
				.setLayout(new MigLayout(
						"",
						"[grow][40px:190px,fill][40px:190px,fill][40px:190px,fill][40px:190px,fill][grow]",
						"[29px:29px,fill]"));
		this.btnImprimer
				.setFont(new Font("Footlight MT Light", Font.PLAIN, 17));
		this.btnImprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnImprimer_actionPerformed(arg0);
			}
		});

		this.panel.add(this.btnImprimer, "cell 1 0,grow");
		this.btnPlusDinfo
				.setFont(new Font("Footlight MT Light", Font.PLAIN, 17));
		this.btnPlusDinfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnPlusDinfo_actionPerformed(arg0);
			}
		});

		this.panel.add(this.btnPlusDinfo, "cell 2 0");
		this.btnSupprimer
				.setFont(new Font("Footlight MT Light", Font.PLAIN, 17));
		this.btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnSupprimer_actionPerformed(arg0);
			}
		});

		this.panel.add(this.btnSupprimer, "cell 3 0");
		this.btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnModifier_actionPerformed(arg0);
			}
		});
		this.btnModifier
				.setFont(new Font("Footlight MT Light", Font.PLAIN, 17));

		this.panel.add(this.btnModifier, "cell 4 0");

		this.clearTableSelection();
	}

	private void initialize() {
		eleveModel = new EleveModel(serie);
		initialize(eleveModel);

	}

	public void setTableModel(AbstractTableModel tableModel) {
		if (table != null) {
			table.setModel(tableModel);
			table.repaint();
			table.packAll();
			labelEmptyTable.setText("");
		}
		
		if(table.getRowCount() <= 0) {
			labelEmptyTable.setText("Aucun élément à afficher");
		}
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
		MyTableModel model = (MyTableModel) table.getModel();
		int selectedRow = table.getSelectedRow();
		if (selectedRow < 0) {
			return null;
		}

		if (Outil.showConfirmationDialog(this)) {
			model.delete(table.convertRowIndexToModel(selectedRow));
		}
		return null;
	}

	protected void do_btnSupprimer_actionPerformed(ActionEvent arg0) {
		this.deleteObject();
	}

	protected void do_btnModifier_actionPerformed(ActionEvent arg0) {
		this.modifierObject();
	}

	private Object modifierObject() {
		Object model = table.getModel();
		if (model instanceof EleveModel) {
			EleveModel modelEleve = (EleveModel) model;
			int selectedRow = table.getSelectedRow();
			if (selectedRow < 0) {
				System.out.println("pfff : pas de selection");
				return null;
			}
			Eleve eleve = (Eleve) modelEleve.get(table
					.convertRowIndexToModel(selectedRow));

			ModificationDialog modifFrame = new ModificationDialog(this.parent,
					this, eleve, modelEleve);
			modifFrame.setVisible(true);

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

			ModificationDialog modifFrame = new ModificationDialog(this.parent,
					this, ecole, modelEcole);
			modifFrame.setVisible(true);
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
			ModificationDialog modifFrame = new ModificationDialog(this.parent,
					this, lycee, modelLycee);
			modifFrame.setVisible(true);

			return lycee;
		}

		System.out.println("pas d'instance");
		return null;

	}

	private void clearTableSelection() {
		Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
			@Override
			public void eventDispatched(AWTEvent event) {
				if (event.getID() == MouseEvent.MOUSE_CLICKED) {
					MouseEvent mevent = (MouseEvent) event;
					int row = table.rowAtPoint(mevent.getPoint());
					if (row == -1) {
						table.clearSelection();
					}
				}
			}
		}, AWTEvent.MOUSE_EVENT_MASK);

	}
}