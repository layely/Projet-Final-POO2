package interface_utilisateur;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import databaseDAOs.DAO_Eleve;
import tablemodels.EcoleModel;
import tablemodels.EleveModel;
import tablemodels.LyceeModel;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	protected JPanel panel;
	protected JButton btnIdentifierUnEleve;
	protected JButton btnModifierUnEleve;
	protected JButton btnListeDeTous;
	protected JButton btnListeDesOrientes;
	protected JButton btnListeDesOrientes_1;
	protected JButton btnListeDesOrientes_2;
	protected JButton btnListeDesOrientes_3;
	protected JButton btnNewButton;
	protected JButton btnAjouterUnLyce;
	protected JButton btnQuitter;
	
	
	JPanel panelCenter = new JPanel();
	
	DAO_Eleve eleveDAO;
	private JButton btnListeDesEcoles;
	private JButton btnListeDesLycees;
	
	//Panels 
	JPanel panelAjoutEcole;
	JPanel panelAjoutLycee;
	JPanel panelIdentificationEleve;
	ListPanel panelList;
	
	
	//Constantes
	private static final String PANEL_AJOUT_ECOLE_NAME = "panelAjoutEcole";
	private static final String PANEL_AJOUT_LYCEE_NAME = "panelAjoutLycee";
	private static final String PANEL_IDENTFICATION_NAME = "panelIdentificationEleve";
	private static final String PANEL_LIST_NAME = "panelList";
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		initialize();
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 928, 581);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(null);
		setContentPane(this.contentPane);

		initialiseCenterPanel();
		
		this.panel = new JPanel();
		this.contentPane.add(this.panel);
		this.panel.setLayout(new GridLayout(15, 1, 0, 0));
		this.panel.setBounds(0, 40, 160, 491);

		this.btnIdentifierUnEleve = new JButton("Identifier un(e) eleve");
		this.btnIdentifierUnEleve.addActionListener(new BtnIdentifierUnEleveActionListener());

		this.btnModifierUnEleve = new JButton("Rechercher un(e) eleve");
		this.panel.add(this.btnModifierUnEleve);
		this.panel.add(this.btnIdentifierUnEleve);

		this.btnListeDeTous = new JButton("Liste de tous les eleves");
		btnListeDeTous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelList.setTableModel(new EleveModel());
				showInCenterPanel(PANEL_LIST_NAME);
			}
		});
		this.panel.add(this.btnListeDeTous);

		this.btnListeDesOrientes_1 = new JButton("Liste des orientes en L");
		btnListeDesOrientes_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				new ListPanel(MainFrame.this, "L").setVisible(true);
				panelList.setTableModel(new EleveModel("L"));
				showInCenterPanel(PANEL_LIST_NAME);
			}
		});
		this.panel.add(this.btnListeDesOrientes_1);

		this.btnListeDesOrientes = new JButton("Liste des Orientes en S");
		btnListeDesOrientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				new ListPanel(MainFrame.this, "S").setVisible(true);
				panelList.setTableModel(new EleveModel("S"));
				showInCenterPanel(PANEL_LIST_NAME);
			}
		});
		this.panel.add(this.btnListeDesOrientes);

		this.btnListeDesOrientes_2 = new JButton("Liste des orientes en G");
		btnListeDesOrientes_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				new ListPanel(MainFrame.this, "G").setVisible(true);
				panelList.setTableModel(new EleveModel("G"));
				showInCenterPanel(PANEL_LIST_NAME);
			}
		});
		this.panel.add(this.btnListeDesOrientes_2);

		this.btnListeDesOrientes_3 = new JButton("Liste des orientes en T");
		btnListeDesOrientes_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				new ListPanel(MainFrame.this, "T").setVisible(true);
				panelList.setTableModel(new EleveModel("T"));
				showInCenterPanel(PANEL_LIST_NAME);
			}
		});
		this.panel.add(this.btnListeDesOrientes_3);

		this.btnNewButton = new JButton("Ajouter une ecole");
		this.btnNewButton.addActionListener(new BtnNewButtonActionListener());
		this.panel.add(this.btnNewButton);

		this.btnAjouterUnLyce = new JButton("Ajouter un lycée");
		this.btnAjouterUnLyce.addActionListener(new BtnAjouterUnLyceActionListener());
		this.panel.add(this.btnAjouterUnLyce);

		btnListeDesEcoles = new JButton("Liste des ecoles");
		btnListeDesEcoles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				new ListPanel(MainFrame.this, new EcoleModel()).setVisible(true);
				panelList.setTableModel(new EcoleModel());
				showInCenterPanel(PANEL_LIST_NAME);
			}
		});
		panel.add(btnListeDesEcoles);

		btnListeDesLycees = new JButton("Liste des lycees");
		btnListeDesLycees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				new ListPanel(MainFrame.this, new LyceeModel()).setVisible(true);
				panelList.setTableModel(new LyceeModel());
				showInCenterPanel(PANEL_LIST_NAME);
			}
		});
		panel.add(btnListeDesLycees);

		this.btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		this.panel.add(this.btnQuitter);

		
	}

	private void initialiseCenterPanel() {
		panelCenter.setLayout(new CardLayout());
		panelCenter.setLocation(170, 40);
		panelCenter.setSize(732, 500);
		contentPane.add(panelCenter);
		
		panelAjoutEcole = new AjouterEcolePanel(this);
		panelAjoutLycee = new AjoutLyceePanel(this);
		panelIdentificationEleve = new IdentificationFrame();
		AbstractTableModel tablemodel = null;
		panelList = new ListPanel(this, tablemodel);
		
		panelCenter.add(PANEL_AJOUT_ECOLE_NAME, panelAjoutEcole);
		panelCenter.add(PANEL_AJOUT_LYCEE_NAME, panelAjoutLycee);
		panelCenter.add(PANEL_IDENTFICATION_NAME, panelIdentificationEleve);
		panelCenter.add(PANEL_LIST_NAME, panelList);
	}

	private void showInCenterPanel(String panelName) {
		CardLayout c = (CardLayout)panelCenter.getLayout();
		c.show(panelCenter, panelName);
	}

	private class BtnIdentifierUnEleveActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
//			new IdentificationFrame().setVisible(true);
			showInCenterPanel(PANEL_IDENTFICATION_NAME);
		}
	}

	private class BtnAjouterUnLyceActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
//			new AjoutLyceePanel(MainFrame.this).setVisible(true);
			showInCenterPanel(PANEL_AJOUT_LYCEE_NAME);
		}
	}

	private class BtnNewButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
//			new AjouterEcolePanel(MainFrame.this).setVisible(true);		
			showInCenterPanel(PANEL_AJOUT_ECOLE_NAME);
		}
	}
}
