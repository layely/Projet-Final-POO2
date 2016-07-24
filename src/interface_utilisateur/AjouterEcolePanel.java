package interface_utilisateur;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import objet.Ecole;

import org.jdesktop.swingx.JXTitledPanel;

import utilitaire.Outil;
import databaseDAOs.DAO_Ecole;
import net.miginfocom.swing.MigLayout;

import java.awt.Font;

import javax.swing.SwingConstants;

public class AjouterEcolePanel extends JPanel {

	private JPanel contentPane;
	protected JLabel lblNomDeLecole;
	protected JTextField textFieldNom;
	protected JLabel lblMotDePasse;
	protected JTextField textfieldPass;
	protected JButton btnAjouter;
	protected JButton btnAnnuler;

	private DAO_Ecole ecoleDAO;
	private Ecole ecoleToModif = null;

	private JFrame parent;

	private JXTitledPanel titledPanel;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterEcolePanel frame = new AjouterEcolePanel(
							new JFrame());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @wbp.parser.constructor
	 */
	public AjouterEcolePanel(JFrame parent) {
		setBackground(Outil.CENTER_PANE_COLOR);
		this.parent = parent;
		this.ecoleDAO = new DAO_Ecole();
		initialize();
	}

	public AjouterEcolePanel(JFrame parent, Ecole ecole) {
		this(parent);
		this.ecoleToModif = ecole;
		this.load(ecole);
	}

	private void load(Ecole ecole) {
		textFieldNom.setText(ecole.getNom());
		textfieldPass.setText(ecole.getMotDePasse());
		btnAjouter.setText("Modifier");
	}

	private void initialize() {
		// setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// setBounds(100, 100, 450, 300);
		this.contentPane = this; // this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		setLayout(new MigLayout("",
				"[grow,right][20px:n][230px:270px,fill][grow]",
				"[100px:n][30px][15px:n][30px][20px:40px][50px][grow]"));

		this.lblNomDeLecole = new JLabel("Nom de l'ecole :");
		this.lblNomDeLecole.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.lblNomDeLecole.setBounds(59, 70, 113, 36);
		this.contentPane
				.add(this.lblNomDeLecole, "cell 0 1,alignx right,growy");

		this.textFieldNom = new JTextField();
		this.textFieldNom.setHorizontalAlignment(SwingConstants.CENTER);
		this.textFieldNom
				.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		this.textFieldNom.setBounds(190, 70, 246, 46);
		this.contentPane.add(this.textFieldNom, "cell 2 1,growy");
		this.textFieldNom.setColumns(10);

		this.lblMotDePasse = new JLabel("Mot de Passe :");
		this.lblMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.lblMotDePasse.setBounds(62, 132, 110, 36);
		this.contentPane.add(this.lblMotDePasse, "cell 0 3,alignx right,growy");

		this.textfieldPass = new JTextField();
		this.textfieldPass.setHorizontalAlignment(SwingConstants.CENTER);
		this.textfieldPass.setFont(new Font("Microsoft YaHei UI", Font.PLAIN,
				15));
		this.textfieldPass.setBounds(193, 132, 243, 46);
		this.contentPane.add(this.textfieldPass, "cell 2 3,grow");
		this.textfieldPass.setColumns(10);

		this.panel = new JPanel();
		add(this.panel, "cell 0 5 2097051 1,push ,alignx center,aligny bottom");
		this.panel.setLayout(new MigLayout("",
				"[190px,fill][20px][190px,fill]", "[30px:n]"));
		this.panel.setBackground(Outil.CENTER_PANE_COLOR);

		this.btnAjouter = new JButton("Ajouter");
		this.panel.add(this.btnAjouter, "cell 0 0,grow");
		this.btnAjouter.addActionListener(new BtnAjouterActionListener());
		this.btnAjouter.setBounds(190, 221, 117, 25);

		this.btnAnnuler = new JButton("Annuler");
		this.panel.add(this.btnAnnuler, "cell 2 0,growy");
		this.btnAnnuler.addActionListener(new BtnAnnulerActionListener());
		this.btnAnnuler.setBounds(319, 221, 117, 25);
	}

	private class BtnAjouterActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			String nomEcole = textFieldNom.getText();
			String pass = textfieldPass.getText();

			Ecole ecole = new Ecole(nomEcole, pass);
			if (ecoleToModif == null) {
				ecoleDAO.ajoutEcole(ecole, "inspection de thiaroye");
				JOptionPane.showMessageDialog(AjouterEcolePanel.this,
						"Enregistrement effectué avec succès");
			} else {
				//TODO ecoleDAO.modifier(String nomEcoleAModifier, Ecole nvEcole);
				JOptionPane.showMessageDialog(AjouterEcolePanel.this,
						"Modification effectuée avec succès");
			}
		}
	}

	private class BtnAnnulerActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// AjouterEcoleFrame.this.dispose();
		}
	}
}
