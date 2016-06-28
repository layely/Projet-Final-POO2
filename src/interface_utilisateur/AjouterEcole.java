package interface_utilisateur;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import objet.Ecole;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AjouterEcole extends JFrame {

	private JPanel contentPane;
	protected JLabel lblNomDeLecole;
	protected JTextField textFieldNom;
	protected JLabel lblMotDePasse;
	protected JTextField textfieldPass;
	protected JButton btnAjouter;
	protected JButton btnAnnuler;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterEcole frame = new AjouterEcole();
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
	public AjouterEcole() {
		initialize();
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);

		this.lblNomDeLecole = new JLabel("Nom de l'ecole");
		this.lblNomDeLecole.setBounds(59, 70, 113, 36);
		this.contentPane.add(this.lblNomDeLecole);

		this.textFieldNom = new JTextField();
		this.textFieldNom.setBounds(190, 70, 246, 46);
		this.contentPane.add(this.textFieldNom);
		this.textFieldNom.setColumns(10);

		this.lblMotDePasse = new JLabel("Mot de Passe");
		this.lblMotDePasse.setBounds(62, 132, 110, 36);
		this.contentPane.add(this.lblMotDePasse);

		this.textfieldPass = new JTextField();
		this.textfieldPass.setBounds(193, 132, 243, 46);
		this.contentPane.add(this.textfieldPass);
		this.textfieldPass.setColumns(10);

		this.btnAjouter = new JButton("Ajouter");
		this.btnAjouter.addActionListener(new BtnAjouterActionListener());
		this.btnAjouter.setBounds(190, 221, 117, 25);
		this.contentPane.add(this.btnAjouter);

		this.btnAnnuler = new JButton("Annuler");
		this.btnAnnuler.addActionListener(new BtnAnnulerActionListener());
		this.btnAnnuler.setBounds(319, 221, 117, 25);
		this.contentPane.add(this.btnAnnuler);
	}

	private class BtnAjouterActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String nomEcole = textFieldNom.getText();
			String pass = textfieldPass.getText();

			Ecole ecole = new Ecole(nomEcole, pass);
		}
	}
	private class BtnAnnulerActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			AjouterEcole.this.dispose();
		}
	}
}
