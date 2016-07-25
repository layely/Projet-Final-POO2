package interface_utilisateur;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
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
import org.jdesktop.swingx.JXTaskPane;
import org.jdesktop.swingx.JXTaskPaneContainer;
import org.jdesktop.swingx.JXTitledPanel;

import tablemodels.EcoleModel;
import tablemodels.EleveModel;
import tablemodels.LyceeModel;
import utilitaire.Outil;
import databaseDAOs.DAO_Eleve;
import de.muntjak.tinylookandfeel.TinyLookAndFeel;

public class MainFrame extends JFrame {

	final static Color COLOR_THEME = Color.BLUE;
	static Color DEFAULT_BUTTON_COLOR;

	String imageName = "icon.jpg";
	URL uriIcon = getClass().getResource(imageName);

	private ArrayList<JButton> allButtons;

	private JPanel contentPane;
	protected JXTaskPaneContainer panelLeft;
	protected JButton btnIdentifierUnEleve;
	protected JButton btnListeDeTousLesEleves;
	protected JButton btnListeDesOrientes_S;
	protected JButton btnListeDesOrientes_L;
	protected JButton btnListeDesOrientes_G;
	protected JButton btnListeDesOrientes_T;
	protected JButton btnAjouterEcole;
	protected JButton btnAjouterUnLycee;
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
	private static final String PANEL_BUZY = "panelBuzy";
	private JMenuBar menuBar;
	private JPanel panelTop;
	private JPanel panelBottom;
	protected JXImageView panelIcon;
	protected JMenu mnTest;
	private JXTitledPanel panelTitledLeft;
	private JXLabel lblGestion;
	private BuzyPane panelBuzy;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		try {
			// UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			UIManager.setLookAndFeel(new TinyLookAndFeel()); // statisfation : 5
			// UIManager.setLookAndFeel(new QuaquaLookAndFeel());
			// UIManager.setLookAndFeel(new QuaquaLookAndFeel15());
			// UIManager.setLookAndFeel(new LiquidLookAndFeel());
			// UIManager.setLookAndFeel(new EaSynthLookAndFeel());
			// UIManager.setLookAndFeel(new SeaGlassLookAndFeel()); not working

			// JTatoo
			// UIManager.setLookAndFeel(new AcrylLookAndFeel());
			// UIManager.setLookAndFeel(new AeroLookAndFeel());
			// UIManager.setLookAndFeel(new AluminiumLookAndFeel());
			// UIManager.setLookAndFeel(new BernsteinLookAndFeel());
			// UIManager.setLookAndFeel(new FastLookAndFeel());
			// UIManager.setLookAndFeel(new HiFiLookAndFeel()); //Dark
			// UIManager.setLookAndFeel(new McWinLookAndFeel());
			// UIManager.setLookAndFeel(new MintLookAndFeel());
			// UIManager.setLookAndFeel(new NoireLookAndFeel()); //Dark
			// UIManager.setLookAndFeel(new TextureLookAndFeel());

			// JGoodies
			// UIManager.setLookAndFeel("com.jgoodies.looks.windows.WindowsLookAndFeel");
			// UIManager.setLookAndFeel(new PlasticLookAndFeel());
			// UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
			//
			// UIManager.setLookAndFeel(new SyntheticaStandardLookAndFeel());

			// UIManager.setLookAndFeel(new WebLookAndFeel());

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

		this.coverTheWholeScreen();

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

		this.panelLeft = new JXTaskPaneContainer();
		// this.panelLeft.setLayout(new GridLayout(15, 1, 0, 0));

		this.btnIdentifierUnEleve = new JButton("Identifier un(e) eleve");
		this.btnIdentifierUnEleve
				.addActionListener(new BtnIdentifierUnEleveActionListener());

		panelTitledLeft = new JXTitledPanel();
		panelTitledLeft.setTitle("Menu\r\n");
		// titledPanel.setBorder(new MatteBorder(1, 1, 1, 1, COLOR_THEME));
		// titledPanel.setBackground(Color.BLUE);
		panelTitledLeft.getContentContainer().setLayout(new BorderLayout());
		/*
		 * new JScrollPane(panelLeft)
		 */
		panelTitledLeft.getContentContainer().add(panelLeft,
				BorderLayout.CENTER);
		this.contentPane.add(this.panelTitledLeft, "cell 0 1,grow");
		// this.panelLeft.add(this.btnIdentifierUnEleve);

		this.btnListeDeTousLesEleves = new JButton("Liste de tous les eleves");
		btnListeDeTousLesEleves.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelList.setTableModel(new EleveModel());
				showInCenterPanel(PANEL_LIST_NAME);
			}
		});
		// this.panelLeft.add(this.btnListeDeTousLesEleves);

		this.btnListeDesOrientes_L = new JButton("Liste des orientes en L");
		btnListeDesOrientes_L.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// new ListPanel(MainFrame.this, "L").setVisible(true);
				panelList.setTableModel(new EleveModel("L"));
				showInCenterPanel(PANEL_LIST_NAME);
			}
		});
		// this.panelLeft.add(this.btnListeDesOrientes_L);

		this.btnListeDesOrientes_S = new JButton("Liste des Orientes en S");
		btnListeDesOrientes_S.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// new ListPanel(MainFrame.this, "S").setVisible(true);
				panelList.setTableModel(new EleveModel("S"));
				showInCenterPanel(PANEL_LIST_NAME);
			}
		});
		// this.panelLeft.add(this.btnListeDesOrientes_S);

		this.btnListeDesOrientes_G = new JButton("Liste des orientes en G");
		btnListeDesOrientes_G.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// new ListPanel(MainFrame.this, "G").setVisible(true);
				panelList.setTableModel(new EleveModel("G"));
				showInCenterPanel(PANEL_LIST_NAME);
			}
		});
		// this.panelLeft.add(this.btnListeDesOrientes_G);

		this.btnListeDesOrientes_T = new JButton("Liste des orientes en T");
		btnListeDesOrientes_T.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// new ListPanel(MainFrame.this, "T").setVisible(true);
				panelList.setTableModel(new EleveModel("T"));
				showInCenterPanel(PANEL_LIST_NAME);
			}
		});
		// this.panelLeft.add(this.btnListeDesOrientes_T);

		this.btnAjouterEcole = new JButton("Ajouter une ecole");
		this.btnAjouterEcole
				.addActionListener(new BtnNewButtonActionListener());
		// this.panelLeft.add(this.btnAjouterEcole);

		this.btnAjouterUnLycee = new JButton("Ajouter un lycée");
		this.btnAjouterUnLycee
				.addActionListener(new BtnAjouterUnLyceActionListener());
		// this.panelLeft.add(this.btnAjouterUnLycee);

		btnListeDesEcoles = new JButton("Liste des ecoles");
		btnListeDesEcoles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// new ListPanel(MainFrame.this, new
				// EcoleModel()).setVisible(true);
				panelList.setTableModel(new EcoleModel());
				showInCenterPanel(PANEL_LIST_NAME);
			}
		});
		// this.panelLeft.add(btnListeDesEcoles);

		btnListeDesLycees = new JButton("Liste des lycees");
		btnListeDesLycees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// new ListPanel(MainFrame.this, new
				// LyceeModel()).setVisible(true);
				panelList.setTableModel(new LyceeModel());
				showInCenterPanel(PANEL_LIST_NAME);
			}
		});
		// this.panelLeft.add(btnListeDesLycees);

		this.btnQuitter = new JButton("Déconnection");
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.this.dispose();
				new LoginFrame().setVisible(true);
			}
		});
		// this.panelLeft.add(this.btnQuitter);

		this.panelBottom = new JPanel();
		this.contentPane.add(this.panelBottom, "cell 0 2 2 1,growx");
		this.panelBottom.setLayout(new GridLayout(1, 1));
		JXTitledPanel tpanel = new JXTitledPanel("All right reserved");
		tpanel.setTitle("All right reserved                                                                                                                                  Profile: Inspecteur                                                                                                                                Inspection de Thiaroye                                                                                                                          ");

		// tpanel.setBackground(COLOR_THEME);
		this.getContentPane().add(tpanel, BorderLayout.SOUTH);

		initPanelLeft();
		chargerIcon();
		actionHighlightMenu();
	}

	private void coverTheWholeScreen() {
		
		java.awt.Rectangle rec = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
		
		this.setBounds(rec);
		
//		// TODO Auto-generated method stub
//		// size of the screen
//		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//
//		// height of the task bar
//		Insets scnMax = Toolkit.getDefaultToolkit().getScreenInsets(
//				getGraphicsConfiguration());
//		int taskBarSize = scnMax.bottom;
//
//		// available size of the screen
//		setSize(screenSize.width - getWidth(), screenSize.height
//				- taskBarSize - getHeight());
	}

	private void initialiseCenterPanel() {
		this.contentPane.setLayout(new MigLayout("",
				"[180px:n:180px,leading][grow]",
				"[50px:n:50px][grow,top][20px:n]"));
		panelCenterContainer.setBorder(new BevelBorder(BevelBorder.LOWERED,
				new Color(0, 102, 204), null, null, null));

		// panelCenterContainer.add(panelCenter, BorderLayout.CENTER);
		panelTitledCenter = new JXTitledPanel("Identification d'une élève");
		panelTitledCenter.setBorder(new MatteBorder(1, 1, 1, 1,
				(Color) new Color(0, 0, 204)));
		// panelTitled.setBackground(COLOR_THEME);
		panelTitledCenter.getContentContainer().setLayout(new BorderLayout());
		panelCenterContainer.add(panelTitledCenter, BorderLayout.CENTER);
		panelTitledCenter.getContentContainer().add(panelCenter,
				BorderLayout.CENTER);
		this.panelIcon = new JXImageView();
		contentPane.add(panelIcon, "cell 0 0");
		panelIcon.setLayout(new MigLayout("", "[299px]", "[138px]"));

		this.panelTop = new JPanel();
		panelTop.setBackground(new Color(102, 51, 255));
		this.contentPane.add(this.panelTop, "flowx,cell 1 0,grow");
		this.panelTop.setLayout(new BorderLayout());

		lblGestion = new JXLabel();
		this.lblGestion.setBackground(new Color(0, 153, 255));
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
		AbstractTableModel tablemodel = null;
		panelList = new ListPanel(this, tablemodel);
		panelIdentificationEleve = new IdentificationFrame();
		panelCenter.add(PANEL_IDENTFICATION_NAME, panelIdentificationEleve);

		panelBuzy = new BuzyPane();

		panelCenter.add(PANEL_AJOUT_ECOLE_NAME, panelAjoutEcole);
		panelCenter.add(PANEL_AJOUT_LYCEE_NAME, panelAjoutLycee);
		panelCenter.add(PANEL_LIST_NAME, panelList);
		panelCenter.add(PANEL_BUZY, panelBuzy);

	}

	private void chargerIcon() {
		try {
			 Image image = ImageIO.read(new File("icon1.jpg"));
			 Image scaledImage = image.getScaledInstance(200, 70, Image.SCALE_SMOOTH);
			 panelIcon.setImage(scaledImage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void showInCenterPanel(final String panelName) {
		final CardLayout c = (CardLayout) panelCenter.getLayout();

		c.show(panelCenter, PANEL_BUZY);
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				if (panelName.equals(PANEL_LIST_NAME))
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				EventQueue.invokeLater(new Runnable() {

					@Override
					public void run() {
						c.show(panelCenter, panelName);
					}
				});
			}
		});

		t.start();
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
		allButtons.add(btnListeDeTousLesEleves);
		allButtons.add(btnListeDesOrientes_S);
		allButtons.add(btnListeDesOrientes_L);
		allButtons.add(btnListeDesOrientes_G);
		allButtons.add(btnListeDesOrientes_T);
		allButtons.add(btnAjouterEcole);
		allButtons.add(btnAjouterUnLycee);
		allButtons.add(btnQuitter);
		allButtons.add(btnListeDesEcoles);
		allButtons.add(btnListeDesLycees);

		DEFAULT_BUTTON_COLOR = allButtons.get(0).getBackground();
	}

	// JXTaskPaneContainer
	private void initPanelLeft() {
		// TaskPane Eleve
		JXTaskPane eleveTaskPane = new JXTaskPane();
		eleveTaskPane.setTitle("Eleve");
		eleveTaskPane.setSpecial(true);
		eleveTaskPane.add(this.btnIdentifierUnEleve);
		eleveTaskPane.add(this.btnListeDeTousLesEleves);
		this.panelLeft.add(eleveTaskPane);

		// TaskPane Ecole
		JXTaskPane ecoleTaskPane = new JXTaskPane();
		ecoleTaskPane.setTitle("Ecole");
		ecoleTaskPane.setSpecial(true);
		ecoleTaskPane.add(this.btnAjouterEcole);
		ecoleTaskPane.add(this.btnListeDesEcoles);
		this.panelLeft.add(ecoleTaskPane);

		// TaskPane Lycee
		JXTaskPane lyceeTaskPane = new JXTaskPane();
		lyceeTaskPane.setTitle("Lycee");
		lyceeTaskPane.setSpecial(true);
		lyceeTaskPane.add(this.btnAjouterUnLycee);
		lyceeTaskPane.add(this.btnListeDesLycees);
		this.panelLeft.add(lyceeTaskPane);

		// TaskPane orientation
		JXTaskPane orientationTaskPane = new JXTaskPane();
		orientationTaskPane.setTitle("Orientation");
		orientationTaskPane.setSpecial(true);
		orientationTaskPane.add(this.btnListeDesOrientes_L);
		orientationTaskPane.add(this.btnListeDesOrientes_S);
		orientationTaskPane.add(this.btnListeDesOrientes_G);
		orientationTaskPane.add(this.btnListeDesOrientes_T);
		this.panelLeft.add(orientationTaskPane);

		// TaskPane Autre
		JXTaskPane autreTaskPane = new JXTaskPane();
		autreTaskPane.setTitle("Autre");
		autreTaskPane.setSpecial(true);
		autreTaskPane.add(this.btnQuitter);
		// autreTaskPane.add(this.btnListeDesLycees);
		this.panelLeft.add(autreTaskPane);
	}

	private void restoreAllButtonsColor() {
		for (JButton button : allButtons)
			button.setBackground(DEFAULT_BUTTON_COLOR);
	}

	private void highLight(JButton button) {
		restoreAllButtonsColor();
		button.setBackground(Outil.CENTER_PANE_COLOR);
	}

	private void actionHighlightMenu() {
		initializeAllButtons();
		for (JButton b : allButtons) {
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
