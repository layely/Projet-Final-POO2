package interface_utilisateur;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.AbstractTableModel;

import net.miginfocom.swing.MigLayout;

import org.jdesktop.swingx.JXImageView;
import org.jdesktop.swingx.JXTitledPanel;

import tablemodels.EcoleModel;
import tablemodels.EleveModel;
import tablemodels.LyceeModel;
import databaseDAOs.DAO_Eleve;

import java.awt.Dimension;
import java.io.IOException;
import java.net.URL;

public class MainFrame extends JFrame {
	
	final Color COLOR_THEME = Color.BLUE;
	
	String imageName = "icon.jpg";
	URL uriIcon = getClass().getResource(imageName);
	
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

	JPanel panelCenterContainer = new JPanel(new BorderLayout());
	JPanel panelCenter = new JPanel();
	JXTitledPanel panelTitled ;
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
	private JPanel panelBottom;
	protected JXImageView panelIcon;
	protected JPanel panel_2;
	protected JPanel panel_3;
	protected JLabel lblProfile;
	protected JLabel lblLabelprofile;
	protected JLabel lblLabelinspection;
	protected JMenu mnTest;
	protected JButton btnDconnection;
	protected JPanel panel_4;
	protected JTextField txtRecherche;
	protected JButton btnRec;
	private JXTitledPanel titledPanel;
	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
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
		mnAide.setBackground(Color.BLACK);
		mnAide.setEnabled(false);
		menuBar.add(mnAide);

		this.mnTest = new JMenu("test");
		this.mnTest.setVisible(false);
		this.menuBar.add(this.mnTest);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(parentPane);
		parentPane.add(this.contentPane, BorderLayout.CENTER);

		initialiseCenterPanel();

		this.panelLeft = new JPanel();
		this.contentPane.add(this.panelLeft, "cell 0 1,pushx");
		this.panelLeft.setLayout(new GridLayout(15, 1, 0, 0));

		this.btnIdentifierUnEleve = new JButton("Identifier un(e) eleve");
		this.btnIdentifierUnEleve.addActionListener(new BtnIdentifierUnEleveActionListener());
		
		titledPanel = new JXTitledPanel("Hello Every body");
		titledPanel.setTitle("Menu\r\n");
		titledPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 102, 204)));
		titledPanel.setBackground(Color.BLUE);
		panelLeft.add(titledPanel);

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

		this.panelBottom = new JPanel();
		this.contentPane.add(this.panelBottom, "cell 0 2 2 1,growx");
		this.panelBottom.setLayout(new GridLayout(1,1));
		JXTitledPanel tpanel = new JXTitledPanel("All right reserved");
		tpanel.setBackground(COLOR_THEME);
		this.getContentPane().add(tpanel, BorderLayout.SOUTH);


	}

	private void initialiseCenterPanel() {
		this.contentPane.setLayout(new MigLayout("debug", "[leading][grow]", "[50px:n][grow,top][20px:n]"));
		panelCenterContainer.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 102, 204), null, null, null));
		
		panelCenterContainer.add(panelCenter, BorderLayout.CENTER);
		panelTitled = new JXTitledPanel("Hello Every body");
		panelTitled.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 102, 204)));
		panelTitled.setBackground(COLOR_THEME);
		panelCenterContainer.add(panelTitled, BorderLayout.NORTH);
		
		this.panelTop = new JPanel();
		this.contentPane.add(this.panelTop, "cell 0 0 2 1,grow");
		this.panelTop.setLayout(new MigLayout("", "[:180px:180px,fill][grow]", "[fill]"));

		this.panelIcon = new JXImageView();
		this.panelTop.add(this.panelIcon, "cell 0 0");
		panelIcon.setLayout(new MigLayout("", "[299px]", "[138px]"));

		this.panel_2 = new JPanel();
		this.panelTop.add(this.panel_2, "cell 1 0,grow");
		this.panel_2.setLayout(new MigLayout("", "[grow]", "[grow]"));

		this.panel_3 = new JPanel();
		this.panel_2.add(this.panel_3, "cell 0 0,growx,aligny bottom");
		this.panel_3.setLayout(new MigLayout("", "[][][][][][][][][][][][][grow]", "[grow]"));

		this.lblProfile = new JLabel("Profile:");
		this.panel_3.add(this.lblProfile, "cell 0 0");

		this.lblLabelprofile = new JLabel("labelProfile");
		this.panel_3.add(this.lblLabelprofile, "cell 1 0");

		this.lblLabelinspection = new JLabel("labelInspection");
		this.panel_3.add(this.lblLabelinspection, "cell 4 0");

		this.btnDconnection = new JButton("Déconnection");
		this.panel_3.add(this.btnDconnection, "cell 8 0");

		this.panel_4 = new JPanel();
		this.panel_3.add(this.panel_4, "cell 12 0,alignx right");
		this.panel_4.setLayout(new MigLayout("", "[grow][]", "[]"));

		this.txtRecherche = new JTextField();
		this.txtRecherche.setText("recherche");
		this.panel_4.add(this.txtRecherche, "cell 0 0,grow");
		this.txtRecherche.setColumns(10);

		this.btnRec = new JButton("Rec");
		this.panel_4.add(this.btnRec, "cell 1 0");
		panelCenter.setLayout(new CardLayout());
		contentPane.add(panelCenterContainer, "cell 1 1,grow");

		panelAjoutEcole = new AjouterEcolePanel(this);
		panelAjoutLycee = new AjoutLyceePanel(this);
		panelIdentificationEleve = new IdentificationFrame();
		AbstractTableModel tablemodel = null;
		panelList = new ListPanel(this, tablemodel);

		panelCenter.add(PANEL_AJOUT_ECOLE_NAME, panelAjoutEcole);
		panelCenter.add(PANEL_AJOUT_LYCEE_NAME, panelAjoutLycee);
		panelCenter.add(PANEL_IDENTFICATION_NAME, panelIdentificationEleve);
		panelCenter.add(PANEL_LIST_NAME, panelList);
		
		chargerIcon();
	}
	
	private void chargerIcon() {
		try {
			Image image = ImageIO.read(uriIcon);
			panelIcon.setImage(image);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
