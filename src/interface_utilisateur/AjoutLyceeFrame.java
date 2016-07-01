package interface_utilisateur;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import databaseDAOs.DAO_Lycee;
import objet.Lycee;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AjoutLyceeFrame extends JFrame {

	private JPanel contentPane;
	protected JLabel lblNomDuLycee;
	protected JTextField textFieldNomLycee;
	protected JLabel lblNombreDePlaces;
	protected JLabel lblNombreDePlaces_1;
	protected JLabel lblNombreDePlaces_2;
	protected JLabel lblNombreDePlaces_3;
	protected JTextField textFieldNbPlacesL;
	protected JTextField textFieldNbplacesS;
	protected JTextField textFieldNbplacesG;
	protected JTextField textFieldNbplacesT;
	protected JButton btnAjouter;
	protected JButton btnAnnuler;

	private DAO_Lycee lyceeDAO;
	private JFrame parent;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjoutLyceeFrame frame = new AjoutLyceeFrame(new JFrame());
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
	public AjoutLyceeFrame(JFrame parent) {
		this.parent = parent;
		lyceeDAO = new DAO_Lycee();
		initialize();
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 418);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);

		this.lblNomDuLycee = new JLabel("Nom du lycee");
		this.lblNomDuLycee.setBounds(53, 39, 120, 29);
		this.contentPane.add(this.lblNomDuLycee);

		this.textFieldNomLycee = new JTextField();
		this.textFieldNomLycee.setBounds(170, 39, 252, 29);
		this.contentPane.add(this.textFieldNomLycee);
		this.textFieldNomLycee.setColumns(10);

		this.lblNombreDePlaces = new JLabel("Nombre de places pour la serie L");
		this.lblNombreDePlaces.setBounds(53, 100, 252, 23);
		this.contentPane.add(this.lblNombreDePlaces);

		this.lblNombreDePlaces_1 = new JLabel("Nombre de places pour la serie S");
		this.lblNombreDePlaces_1.setBounds(53, 145, 252, 23);
		this.contentPane.add(this.lblNombreDePlaces_1);

		this.lblNombreDePlaces_2 = new JLabel("Nombre de places pour la serie G");
		this.lblNombreDePlaces_2.setBounds(53, 192, 252, 23);
		this.contentPane.add(this.lblNombreDePlaces_2);

		this.lblNombreDePlaces_3 = new JLabel("Nombre de places pour la serie T");
		this.lblNombreDePlaces_3.setBounds(53, 239, 252, 23);
		this.contentPane.add(this.lblNombreDePlaces_3);

		this.textFieldNbPlacesL = new JTextField();
		this.textFieldNbPlacesL.setBounds(303, 102, 114, 19);
		this.contentPane.add(this.textFieldNbPlacesL);
		this.textFieldNbPlacesL.setColumns(10);

		this.textFieldNbplacesS = new JTextField();
		this.textFieldNbplacesS.setColumns(10);
		this.textFieldNbplacesS.setBounds(308, 147, 114, 19);
		this.contentPane.add(this.textFieldNbplacesS);

		this.textFieldNbplacesG = new JTextField();
		this.textFieldNbplacesG.setColumns(10);
		this.textFieldNbplacesG.setBounds(308, 194, 114, 19);
		this.contentPane.add(this.textFieldNbplacesG);

		this.textFieldNbplacesT = new JTextField();
		this.textFieldNbplacesT.setColumns(10);
		this.textFieldNbplacesT.setBounds(308, 241, 114, 19);
		this.contentPane.add(this.textFieldNbplacesT);

		this.btnAjouter = new JButton("Ajouter");
		this.btnAjouter.addActionListener(new BtnAjouterActionListener());
		this.btnAjouter.setBounds(193, 334, 117, 25);
		this.contentPane.add(this.btnAjouter);

		this.btnAnnuler = new JButton("Annuler\n");
		this.btnAnnuler.setBounds(339, 334, 117, 25);
		this.contentPane.add(this.btnAnnuler);
	}

	private class BtnAjouterActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String nomLycee = textFieldNomLycee.getText();
			String strNbrL = textFieldNbPlacesL.getText();
			String strNbrS = textFieldNbplacesS.getText();
			String strNbrG = textFieldNbplacesG.getText();
			String strNbrT = textFieldNbplacesT.getText();

			int nbrePlacesL = Integer.parseInt(strNbrL);
			int nbrePlacesS = Integer.parseInt(strNbrS);
			int nbrePlacesG = Integer.parseInt(strNbrG);
			int nbrePlacesT = Integer.parseInt(strNbrT);

			Lycee lycee = new Lycee(nomLycee, nbrePlacesL, nbrePlacesS, nbrePlacesG, nbrePlacesT);
			lyceeDAO.ajoutLycee(lycee, "Inspection");
		}
	}
}
