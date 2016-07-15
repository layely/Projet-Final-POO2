package interface_utilisateur;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.AbstractTableModel;

import net.miginfocom.swing.MigLayout;

import org.jdesktop.swingx.JXImageView;
import org.jdesktop.swingx.JXLabel;
import org.jdesktop.swingx.JXLabel.TextAlignment;
import org.jdesktop.swingx.JXTitledPanel;

import tablemodels.EcoleModel;
import tablemodels.EleveModel;
import tablemodels.LyceeModel;
import utilitaire.Outil;
import databaseDAOs.DAO_Eleve;

public class MainFrame extends JFrame {

	final static Color COLOR_THEME = Color.BLUE;
	static Color DEFAULT_BUTTON_COLOR;
	
	String imageName = "icon.jpg";
	URL uriIcon = getClass().getResource(imageName);

	private ArrayList<JButton> allButtons;

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
	JXTitledPanel panelTitledCenter;
	DAO_Eleve eleveDAO;
	private JButton btnListeDesEcoles;
	private JButton btnListeDesLycees;

	// Panels
	JPanel panelAjoutEcole;
	JPanel panelAjoutLycee;
	JPanel panelIdentificationEleve;
	ListPanel panelList;

	// Constantes
	private static final String PANEL_AJOUT_ECOLE_NAME = "panelAjoutEcole";
	private static final String PANEL_AJOUT_LYCEE_NAME = "panelAjoutLycee";
	private static final String PANEL_IDENTFICATION_NAME = "panelIdentificationEleve";
	private static final String PANEL_LIST_NAME = "panelList";
	private JMenuBar menuBar;
	private JPanel panelTop;
	private JPanel panelBottom;
	protected JXImageView panelIcon;
	protected JMenu mnTest;
	private JXTitledPanel panelTitledLeft;
	private JXLabel lblGestion;
	private final ButtonGroup buttonGroup = new ButtonGroup();

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
		this.panelLeft.setLayout(new GridLayout(15, 1, 0, 0));

		this.btnIdentifierUnEleve = new JButton("Identifier un(e) eleve");
		buttonGroup.add(btnIdentifierUnEleve);
		this.btnIdentifierUnEleve
				.addActionListener(new BtnIdentifierUnEleveActionListener());

		panelTitledLeft = new JXTitledPanel();
		panelTitledLeft.setTitle("Menu\r\n");
		// titledPanel.setBorder(new MatteBorder(1, 1, 1, 1, COLOR_THEME));
		// titledPanel.setBackground(Color.BLUE);
		panelTitledLeft.getContentContainer().setLayout(new BorderLayout());
		panelTitledLeft.getContentContainer().add(panelLeft, BorderLayout.CENTER);
		this.contentPane.add(this.panelTitledLeft, "cell 0 1,growx");

		this.btnModifierUnEleve = new JButton("Rechercher un(e) eleve");
		btnModifierUnEleve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		buttonGroup.add(btnModifierUnEleve);
		this.panelLeft.add(this.btnModifierUnEleve);
		this.panelLeft.add(this.btnIdentifierUnEleve);

		this.btnListeDeTous = new JButton("Liste de tous les eleves");
		buttonGroup.add(btnListeDeTous);
		btnListeDeTous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelList.setTableModel(new EleveModel());
				showInCenterPanel(PANEL_LIST_NAME);
			}
		});
		this.panelLeft.add(this.btnListeDeTous);

		this.btnListeDesOrientes_1 = new JButton("Liste des orientes en L");
		buttonGroup.add(btnListeDesOrientes_1);
		btnListeDesOrientes_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// new ListPanel(MainFrame.this, "L").setVisible(true);
				panelList.setTableModel(new EleveModel("L"));
				showInCenterPanel(PANEL_LIST_NAME);
			}
		});
		this.panelLeft.add(this.btnListeDesOrientes_1);

		this.btnListeDesOrientes = new JButton("Liste des Orientes en S");
		buttonGroup.add(btnListeDesOrientes);
		btnListeDesOrientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// new ListPanel(MainFrame.this, "S").setVisible(true);
				panelList.setTableModel(new EleveModel("S"));
				showInCenterPanel(PANEL_LIST_NAME);
			}
		});
		this.panelLeft.add(this.btnListeDesOrientes);

		this.btnListeDesOrientes_2 = new JButton("Liste des orientes en G");
		buttonGroup.add(btnListeDesOrientes_2);
		btnListeDesOrientes_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// new ListPanel(MainFrame.this, "G").setVisible(true);
				panelList.setTableModel(new EleveModel("G"));
				showInCenterPanel(PANEL_LIST_NAME);
			}
		});
		this.panelLeft.add(this.btnListeDesOrientes_2);

		this.btnListeDesOrientes_3 = new JButton("Liste des orientes en T");
		buttonGroup.add(btnListeDesOrientes_3);
		btnListeDesOrientes_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// new ListPanel(MainFrame.this, "T").setVisible(true);
				panelList.setTableModel(new EleveModel("T"));
				showInCenterPanel(PANEL_LIST_NAME);
			}
		});
		this.panelLeft.add(this.btnListeDesOrientes_3);

		this.btnNewButton = new JButton("Ajouter une ecole");
		buttonGroup.add(btnNewButton);
		this.btnNewButton.addActionListener(new BtnNewButtonActionListener());
		this.panelLeft.add(this.btnNewButton);

		this.btnAjouterUnLyce = new JButton("Ajouter un lycée");
		buttonGroup.add(btnAjouterUnLyce);
		this.btnAjouterUnLyce
				.addActionListener(new BtnAjouterUnLyceActionListener());
		this.panelLeft.add(this.btnAjouterUnLyce);

		btnListeDesEcoles = new JButton("Liste des ecoles");
		buttonGroup.add(btnListeDesEcoles);
		btnListeDesEcoles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// new ListPanel(MainFrame.this, new
				// EcoleModel()).setVisible(true);
				panelList.setTableModel(new EcoleModel());
				showInCenterPanel(PANEL_LIST_NAME);
			}
		});
		panelLeft.add(btnListeDesEcoles);

		btnListeDesLycees = new JButton("Liste des lycees");
		buttonGroup.add(btnListeDesLycees);
		btnListeDesLycees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// new ListPanel(MainFrame.this, new
				// LyceeModel()).setVisible(true);
				panelList.setTableModel(new LyceeModel());
				showInCenterPanel(PANEL_LIST_NAME);
			}
		});
		panelLeft.add(btnListeDesLycees);

		this.btnQuitter = new JButton("Quitter");
		buttonGroup.add(btnQuitter);
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		this.panelLeft.add(this.btnQuitter);

		this.panelBottom = new JPanel();
		this.contentPane.add(this.panelBottom, "cell 0 2 2 1,growx");
		this.panelBottom.setLayout(new GridLayout(1, 1));
		JXTitledPanel tpanel = new JXTitledPanel("All right reserved");
		tpanel.setTitle("All right reserved                                                                                                                                  Profile: Inspecteur                                                                                                                                Inspection de Thiaroye                                                                                                                          ");
		// tpanel.setBackground(COLOR_THEME);
		this.getContentPane().add(tpanel, BorderLayout.SOUTH);
		
		actionHighlightMenu();
	}

	private void initialiseCenterPanel() {
		this.contentPane.setLayout(new MigLayout("debug",
				"[180px:n:180px,leading][grow]",
				"[50px:n:50px][grow,top][20px:n]"));
		panelCenterContainer.setBorder(new BevelBorder(BevelBorder.LOWERED,
				new Color(0, 102, 204), null, null, null));

		// panelCenterContainer.add(panelCenter, BorderLayout.CENTER);
		panelTitledCenter = new JXTitledPanel("Hello Every body");
		panelTitledCenter.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0,
				0, 204)));
		// panelTitled.setBackground(COLOR_THEME);
		panelTitledCenter.getContentContainer().setLayout(new BorderLayout());
		panelCenterContainer.add(panelTitledCenter, BorderLayout.CENTER);
		panelTitledCenter.getContentContainer().add(panelCenter, BorderLayout.CENTER);
		this.panelIcon = new JXImageView();
		contentPane.add(panelIcon, "cell 0 0");
		panelIcon.setLayout(new MigLayout("", "[299px]", "[138px]"));

		this.panelTop = new JPanel();
		panelTop.setBackground(SystemColor.activeCaption);
		this.contentPane.add(this.panelTop, "flowx,cell 1 0,grow");
		this.panelTop.setLayout(new BorderLayout());

		lblGestion = new JXLabel();
		lblGestion.setForeground(new Color(248, 248, 255));
		lblGestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestion.setTextAlignment(TextAlignment.CENTER);
		lblGestion.setFont(new Font("Dialog", Font.BOLD, 19));
		panelTop.add(lblGestion, BorderLayout.CENTER);
		lblGestion.setText("GESTIONNAIRE DES ORIENTATIONS POST-BFEM");
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
		CardLayout c = (CardLayout) panelCenter.getLayout();
		c.show(panelCenter, panelName);
	}

	private class BtnIdentifierUnEleveActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// new IdentificationFrame().setVisible(true);
			showInCenterPanel(PANEL_IDENTFICATION_NAME);
		}
	}

	private class BtnAjouterUnLyceActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// new AjoutLyceePanel(MainFrame.this).setVisible(true);
			showInCenterPanel(PANEL_AJOUT_LYCEE_NAME);
		}
	}

	private class BtnNewButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// new AjouterEcolePanel(MainFrame.this).setVisible(true);
			showInCenterPanel(PANEL_AJOUT_ECOLE_NAME);
		}
	}

	private void initializeAllButtons() {
		allButtons = new ArrayList<>();
			allButtons.add(btnIdentifierUnEleve);
			allButtons.add(btnModifierUnEleve);
			allButtons.add(btnListeDeTous);
			allButtons.add(btnListeDesOrientes);
			allButtons.add(btnListeDesOrientes_1);
			allButtons.add(btnListeDesOrientes_2);
			allButtons.add(btnListeDesOrientes_3);
			allButtons.add(btnNewButton);
			allButtons.add(btnAjouterUnLyce);
			allButtons.add(btnQuitter);
			allButtons.add(btnListeDesEcoles);
			allButtons.add(btnListeDesLycees);
			
			DEFAULT_BUTTON_COLOR = allButtons.get(0).getBackground();
	}
	
	private void restoreAllButtonsColor() {
		for(JButton button : allButtons)
			button.setBackground(DEFAULT_BUTTON_COLOR);
	}
	
	private void highLight(JButton button) {
		restoreAllButtonsColor();
		button.setBackground(Outil.CENTER_PANE_COLOR);
	}
	
	private void actionHighlightMenu() {
		initializeAllButtons();
		for(JButton b : allButtons) {
			b.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					restoreAllButtonsColor();
					JButton b = ((JButton) e.getSource());
					b.setBackground(Outil.CENTER_PANE_COLOR);
					panelTitledCenter.setTitle(b.getText());
				}
			});
		}
	}
}
