package interface_utilisateur;

import java.awt.BorderLayout;
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
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import net.miginfocom.swing.MigLayout;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	protected JPanel panelLeft;
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
	private JMenuBar menuBar;
	private JPanel panelTop;
	private JPanel panel_1;
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
		JPanel parentPane = new JPanel(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 855, 530);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAide = new JMenu("Aide");
		menuBar.add(mnAide);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(parentPane);
		parentPane.add(this.contentPane, BorderLayout.CENTER);

		initialiseCenterPanel();
		
		this.panelLeft = new JPanel();
		this.contentPane.add(this.panelLeft, "cell 0 1,growy");
		this.panelLeft.setLayout(new GridLayout(15, 1, 0, 0));

		this.btnIdentifierUnEleve = new JButton("Identifier un(e) eleve");
		this.btnIdentifierUnEleve.addActionListener(new BtnIdentifierUnEleveActionListener());

		this.btnModifierUnEleve = new JButton("Rechercher un(e) eleve");
		this.panelLeft.add(this.btnModifierUnEleve);
		this.panelLeft.add(this.btnIdentifierUnEleve);

		this.btnListeDeTous = new JButton("Liste de tous les eleves");
		btnListeDeTous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelList.setTableModel(new EleveModel());
				showInCenterPanel(PANEL_LIST_NAME);
			}
		});
		this.panelLeft.add(this.btnListeDeTous);

		this.btnListeDesOrientes_1 = new JButton("Liste des orientes en L");
		btnListeDesOrientes_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				new ListPanel(MainFrame.this, "L").setVisible(true);
				panelList.setTableModel(new EleveModel("L"));
				showInCenterPanel(PANEL_LIST_NAME);
			}
		});
		this.panelLeft.add(this.btnListeDesOrientes_1);

		this.btnListeDesOrientes = new JButton("Liste des Orientes en S");
		btnListeDesOrientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				new ListPanel(MainFrame.this, "S").setVisible(true);
				panelList.setTableModel(new EleveModel("S"));
				showInCenterPanel(PANEL_LIST_NAME);
			}
		});
		this.panelLeft.add(this.btnListeDesOrientes);

		this.btnListeDesOrientes_2 = new JButton("Liste des orientes en G");
		btnListeDesOrientes_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				new ListPanel(MainFrame.this, "G").setVisible(true);
				panelList.setTableModel(new EleveModel("G"));
				showInCenterPanel(PANEL_LIST_NAME);
			}
		});
		this.panelLeft.add(this.btnListeDesOrientes_2);

		this.btnListeDesOrientes_3 = new JButton("Liste des orientes en T");
		btnListeDesOrientes_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				new ListPanel(MainFrame.this, "T").setVisible(true);
				panelList.setTableModel(new EleveModel("T"));
				showInCenterPanel(PANEL_LIST_NAME);
			}
		});
		this.panelLeft.add(this.btnListeDesOrientes_3);

		this.btnNewButton = new JButton("Ajouter une ecole");
		this.btnNewButton.addActionListener(new BtnNewButtonActionListener());
		this.panelLeft.add(this.btnNewButton);

		this.btnAjouterUnLyce = new JButton("Ajouter un lycée");
		this.btnAjouterUnLyce.addActionListener(new BtnAjouterUnLyceActionListener());
		this.panelLeft.add(this.btnAjouterUnLyce);

		btnListeDesEcoles = new JButton("Liste des ecoles");
		btnListeDesEcoles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				new ListPanel(MainFrame.this, new EcoleModel()).setVisible(true);
				panelList.setTableModel(new EcoleModel());
				showInCenterPanel(PANEL_LIST_NAME);
			}
		});
		panelLeft.add(btnListeDesEcoles);

		btnListeDesLycees = new JButton("Liste des lycees");
		btnListeDesLycees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				new ListPanel(MainFrame.this, new LyceeModel()).setVisible(true);
				panelList.setTableModel(new LyceeModel());
				showInCenterPanel(PANEL_LIST_NAME);
			}
		});
		panelLeft.add(btnListeDesLycees);

		this.btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		this.panelLeft.add(this.btnQuitter);
		
		this.panel_1 = new JPanel();
		this.contentPane.add(this.panel_1, "cell 0 2 2 1,growx");

		
	}

	private void initialiseCenterPanel() {
		this.contentPane.setLayout(new MigLayout("debug", "[:160px:160px,fill][732px,grow]", "[grow][500px][grow]"));
		
		this.panelTop = new JPanel();
		this.contentPane.add(this.panelTop, "cell 0 0 2 1,growx");
		panelCenter.setLayout(new CardLayout());
		contentPane.add(panelCenter, "cell 1 1,grow");
		
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
