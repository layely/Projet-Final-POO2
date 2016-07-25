package interface_utilisateur;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import net.miginfocom.swing.MigLayout;
import objet.Ecole;
import objet.Inspection;
import objet.Lycee;

import org.jdesktop.swingx.JXFormattedTextField;
import org.jdesktop.swingx.JXList;
import org.jdesktop.swingx.JXTextField;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.autocomplete.ObjectToStringConverter;
import org.jdesktop.swingx.prompt.PromptSupport;
import org.jdesktop.swingx.prompt.PromptSupport.FocusBehavior;

import utilitaire.Outil;
import databaseDAOs.DAO_Ecole;
import databaseDAOs.DAO_Inspection;

public class LoginFrame extends JFrame {
	protected JPanel panelTop;
	protected JPanel panelCenter;
	protected JPanel panelBottom;
	protected JLabel lblEcoleOuInspection;
	protected JLabel lblMotDePasse;
	protected JTextField textFieldlogin;
	protected JPasswordField textFieldPassword;
	protected JButton btnSeConnecter;
	protected JButton btnAnnuler;
	private JLabel lblGestionnaireDesOrientations;
	private JLabel lblConnection;

	private DAO_Ecole ecoleDAO = new DAO_Ecole();
	private DAO_Inspection inspectionDAO = new DAO_Inspection();
	private ArrayList<Ecole> listEcoles;
	private ArrayList<Inspection> listInspection;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager
					.setLookAndFeel("de.muntjak.tinylookandfeel.TinyLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		initialize();
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	setBounds(100, 100, 719, 420);
		
		int width = 650;
		int height = 400;
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width - width) / 2;
		int y = (screen.height - height) / 2;
		setBounds(x, y, width, height);
		
		JPanel content = new JPanel();
		content.setBackground(new Color(0, 153, 255));
		content.setForeground(new Color(0, 153, 255));
		setContentPane(content);
		content.setLayout(new MigLayout("", "[grow]",
				"[60px,fill][grow,center][60px,fill]"));

		this.panelTop = new JPanel();
		this.panelTop.setBackground(new Color(0, 153, 255));
		content.add(this.panelTop, "cell 0 0,grow");
		this.panelTop.setLayout(new BorderLayout(0, 0));

		this.lblGestionnaireDesOrientations = new JLabel(
				"GESTIONNAIRE DES ORIENTATIONS POST-BFEM");
		this.lblGestionnaireDesOrientations.setForeground(new Color(255, 255,
				255));
		this.lblGestionnaireDesOrientations
				.setBackground(new Color(0, 153, 255));
		this.lblGestionnaireDesOrientations.setFont(new Font(
				"Footlight MT Light", Font.PLAIN, 24));
		this.lblGestionnaireDesOrientations
				.setHorizontalAlignment(SwingConstants.CENTER);
		this.panelTop.add(this.lblGestionnaireDesOrientations,
				BorderLayout.CENTER);

		this.panelCenter = new JPanel();
		this.panelCenter.setBackground(Outil.CENTER_PANE_COLOR);
		content.add(this.panelCenter, "cell 0 1,grow");
		this.panelCenter
				.setLayout(new MigLayout(
						"",
						"[grow,right][10px:n][80px:100px:120px,grow,fill][10px:n][80px:100px:120px,grow,fill][grow]",
						"[grow][30px,fill][10px][30px,fill][30px][30px,fill][grow]"));

		this.lblEcoleOuInspection = new JLabel("Nom d'utilisateur :");
		this.lblEcoleOuInspection.setFont(new Font("Footlight MT Light",
				Font.PLAIN, 17));
		this.panelCenter.add(this.lblEcoleOuInspection,
				"cell 0 1,alignx trailing");

		this.textFieldlogin = new JXFormattedTextField("Ecole ou Inspection");
		this.textFieldlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_textFieldlogin_actionPerformed(e);
			}
		});
		this.textFieldlogin.setHorizontalAlignment(SwingConstants.CENTER);
		this.textFieldlogin.setFont(new Font("Footlight MT Light", Font.PLAIN,
				17));
		// PromptSupport.setPrompt("Ecole ou Inspection", this.textFieldlogin);
		PromptSupport.setFocusBehavior(FocusBehavior.SHOW_PROMPT,
				this.textFieldlogin);
		// PromptSupport.setForeground(Color.darkGray, this.textFieldlogin);
		
		if(Outil.getProfileName() != null) {
			textFieldlogin.setText(Outil.getProfileName());
		}
		
		listEcoles = ecoleDAO.getAllEcole();
		listInspection = inspectionDAO.getAllInspection();

		ArrayList<String> listAutoComplete = getListAutoComplete();
		JXList jlist = new JXList(listAutoComplete.toArray());

		this.panelCenter.add(this.textFieldlogin, "cell 2 1 3 1");
		this.textFieldlogin.setColumns(10);
		AutoCompleteDecorator.decorate(jlist, this.textFieldlogin,
				ObjectToStringConverter.DEFAULT_IMPLEMENTATION);

		this.lblMotDePasse = new JLabel("Mot de passe :");
		this.lblMotDePasse.setFont(new Font("Footlight MT Light", Font.PLAIN,
				17));
		this.panelCenter.add(this.lblMotDePasse, "cell 0 3,alignx trailing");

		this.textFieldPassword = new JPasswordField();
		this.textFieldPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_textFieldPassword_actionPerformed(arg0);
			}
		});
		this.textFieldPassword.setHorizontalAlignment(SwingConstants.CENTER);
		this.textFieldPassword.setFont(new Font("Footlight MT Light",
				Font.PLAIN, 17));
		this.panelCenter.add(this.textFieldPassword, "cell 2 3 3 1");
		this.textFieldPassword.setColumns(10);

		this.btnSeConnecter = new JButton("Connextion");
		this.btnSeConnecter.setFont(new Font("Footlight MT Light", Font.PLAIN,
				17));
		this.panelCenter.add(this.btnSeConnecter, "cell 2 5");
		this.btnSeConnecter.addActionListener(new ButtonActionListener());

		this.btnAnnuler = new JButton("Annuler");
		this.btnAnnuler.setFont(new Font("Footlight MT Light", Font.PLAIN, 17));
		this.panelCenter.add(this.btnAnnuler, "cell 4 5");
		this.btnAnnuler.addActionListener(new BtnAnnulerActionListener());

		this.panelBottom = new JPanel();
		this.panelBottom.setBackground(new Color(0, 153, 255));
		content.add(this.panelBottom, "cell 0 2,growx");
		this.panelBottom.setLayout(new BorderLayout(0, 0));

		this.lblConnection = new JLabel("CONNECTION");
		this.lblConnection.setForeground(new Color(255, 255, 255));
		this.lblConnection.setBackground(new Color(0, 153, 255));
		this.lblConnection.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblConnection
				.setFont(new Font("Footlight MT Light", Font.BOLD, 17));
		this.panelBottom.add(this.lblConnection, BorderLayout.CENTER);
	}

	private ArrayList<String> getListAutoComplete() {
		ArrayList<String> list = new ArrayList<>();
		for (Ecole ecole : listEcoles) {
			list.add(ecole.getNom());
			System.out.println(ecole.getNom());
		}
		for (Inspection inspection : listInspection) {
			list.add(inspection.getNom());
			System.out.println(inspection.getNom());
		}
		// list.add("CEM Scat Urbam");
		// list.add("CEM HLM Grand Yoff 2");
		// list.add("CEM HLM Grand Yoff 1");
		// list.add("Les Pedagogues");
		return list;
	}

	private class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String login = textFieldlogin.getText();
			String pass = textFieldPassword.getText();

			if (Outil.getConnection(login, pass)) {
				Outil.openHome();
				LoginFrame.this.dispose();
			}
			else {
				JOptionPane.showMessageDialog(LoginFrame.this, "Nom d'utilisateur/Mot de passe incorrect !");
//				textFieldlogin.requestFocus();
				textFieldPassword.requestFocus();
			}
		}
	}

	private class BtnAnnulerActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			textFieldlogin.setText("");
			textFieldPassword.setText("");
		}
	}
	protected void do_textFieldPassword_actionPerformed(ActionEvent arg0) {
		this.btnSeConnecter.doClick();
	}
	protected void do_textFieldlogin_actionPerformed(ActionEvent e) {
		this.textFieldPassword.requestFocus();
	}
}
