package interface_utilisateur;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AjouterLycee extends JFrame {

	private JPanel contentPane;
	protected JLabel lblNomDuLycee;
	protected JTextField textFieldNomLycee;
	protected JLabel lblNombreDePlace;
	protected JTextField textFieldNbPlaceS;
	protected JLabel lblNombreDePlace_1;
	protected JLabel lblNombreDePlace_2;
	protected JLabel lblNombreDePlace_3;
	protected JTextField textFieldNbPlaceL;
	protected JTextField textFieldNbPlaceG;
	protected JTextField textFieldNbPlaceT;
	protected JButton btnAjouter;
	protected JButton btnAnnuler;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterLycee frame = new AjouterLycee();
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
	public AjouterLycee() {
		initialize();
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 471);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);

		this.lblNomDuLycee = new JLabel("Nom du lycee");
		this.lblNomDuLycee.setBounds(48, 40, 127, 25);
		this.contentPane.add(this.lblNomDuLycee);

		this.textFieldNomLycee = new JTextField();
		this.textFieldNomLycee.setBounds(247, 40, 268, 25);
		this.contentPane.add(this.textFieldNomLycee);
		this.textFieldNomLycee.setColumns(10);

		this.lblNombreDePlace = new JLabel("Nombre de place pour Serie S");
		this.lblNombreDePlace.setBounds(48, 87, 281, 32);
		this.contentPane.add(this.lblNombreDePlace);

		this.textFieldNbPlaceS = new JTextField();
		this.textFieldNbPlaceS.setBounds(374, 91, 141, 25);
		this.contentPane.add(this.textFieldNbPlaceS);
		this.textFieldNbPlaceS.setColumns(10);

		this.lblNombreDePlace_1 = new JLabel("Nombre de place pour Serie L");
		this.lblNombreDePlace_1.setBounds(48, 147, 281, 32);
		this.contentPane.add(this.lblNombreDePlace_1);

		this.lblNombreDePlace_2 = new JLabel("Nombre de place pour Serie G");
		this.lblNombreDePlace_2.setBounds(48, 208, 281, 32);
		this.contentPane.add(this.lblNombreDePlace_2);

		this.lblNombreDePlace_3 = new JLabel("Nombre de place pour Serie T");
		this.lblNombreDePlace_3.setBounds(48, 269, 281, 32);
		this.contentPane.add(this.lblNombreDePlace_3);

		this.textFieldNbPlaceL = new JTextField();
		this.textFieldNbPlaceL.setColumns(10);
		this.textFieldNbPlaceL.setBounds(374, 142, 141, 25);
		this.contentPane.add(this.textFieldNbPlaceL);

		this.textFieldNbPlaceG = new JTextField();
		this.textFieldNbPlaceG.setColumns(10);
		this.textFieldNbPlaceG.setBounds(374, 215, 141, 25);
		this.contentPane.add(this.textFieldNbPlaceG);

		this.textFieldNbPlaceT = new JTextField();
		this.textFieldNbPlaceT.setColumns(10);
		this.textFieldNbPlaceT.setBounds(374, 276, 141, 25);
		this.contentPane.add(this.textFieldNbPlaceT);

		this.btnAjouter = new JButton("Ajouter");
		this.btnAjouter.addActionListener(new BtnAjouterActionListener());
		this.btnAjouter.setBounds(267, 378, 117, 25);
		this.contentPane.add(this.btnAjouter);

		this.btnAnnuler = new JButton("Annuler");
		this.btnAnnuler.setBounds(421, 378, 117, 25);
		this.contentPane.add(this.btnAnnuler);
	}

	private class BtnAjouterActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String nomLycee = textFieldNomLycee.getText();
			String strNbPlaces_S = textFieldNbPlaceS.getText();
			String strNbPlaces_L = textFieldNbPlaceL.getText();
			String strNbPlaces_G = textFieldNbPlaceG.getText();
			String strNbPlaces_T = textFieldNbPlaceT.getText();

			int nbPlaces_S = Integer.parseInt(strNbPlaces_S);
			int nbPlaces_L = Integer.parseInt(strNbPlaces_L);
			int nbPlaces_G = Integer.parseInt(strNbPlaces_G);
			int nbPlaces_T = Integer.parseInt(strNbPlaces_T);


		}
	}
}
