package interface_utilisateur;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import databaseDAOs.DAO_Lycee;
import objet.Lycee;
import utilitaire.Outil;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import org.jdesktop.swingx.HorizontalLayout;

public class AjoutLyceePanel extends JPanel {

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
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjoutLyceePanel frame = new AjoutLyceePanel(new JFrame());
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
	public AjoutLyceePanel(JFrame parent) {
		this.setBackground(Outil.CENTER_PANE_COLOR);
		this.parent = parent;
		lyceeDAO = new DAO_Lycee();
		initialize();
	}

	private void initialize() {
		// setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// setBounds(100, 100, 614, 418);
		this.contentPane = this; // this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		setLayout(new MigLayout(
				"",
				"[grow,left][10px][230px:270px,fill][grow]",
				"[30px:80px:80px][29px][][29px][29px][29px][29px][30px:n:100px,grow][29px,fill][grow]"));

		this.lblNomDuLycee = new JLabel("Nom du lycee :");
		this.lblNomDuLycee
				.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));
		this.lblNomDuLycee.setBounds(53, 39, 120, 29);
		this.contentPane.add(this.lblNomDuLycee, "cell 0 1,alignx right,growy");

		this.textFieldNomLycee = new JTextField();
		this.textFieldNomLycee.setHorizontalAlignment(SwingConstants.CENTER);
		this.textFieldNomLycee.setFont(new Font("Arial Unicode MS", Font.PLAIN,
				15));
		this.textFieldNomLycee.setBounds(170, 39, 252, 29);
		this.contentPane.add(this.textFieldNomLycee, "cell 2 1,grow");
		this.textFieldNomLycee.setColumns(10);

		this.lblNombreDePlaces = new JLabel(
				"Nombre de places pour la serie L :");
		this.lblNombreDePlaces.setFont(new Font("Arial Unicode MS", Font.PLAIN,
				15));
		this.lblNombreDePlaces.setBounds(53, 100, 252, 23);
		this.contentPane.add(this.lblNombreDePlaces,
				"cell 0 3,alignx right,growy");

		this.lblNombreDePlaces_1 = new JLabel(
				"Nombre de places pour la serie S :");
		this.lblNombreDePlaces_1.setFont(new Font("Arial Unicode MS",
				Font.PLAIN, 15));
		this.lblNombreDePlaces_1.setBounds(53, 145, 252, 23);
		this.contentPane.add(this.lblNombreDePlaces_1,
				"cell 0 4,alignx right,growy");

		this.textFieldNbplacesS = new JTextField();
		this.textFieldNbplacesS.setHorizontalAlignment(SwingConstants.CENTER);
		this.textFieldNbplacesS.setFont(new Font("Arial Unicode MS",
				Font.PLAIN, 15));
		this.textFieldNbplacesS.setColumns(10);
		this.textFieldNbplacesS.setBounds(308, 147, 114, 19);
		this.contentPane.add(this.textFieldNbplacesS,
				"cell 2 4,alignx left,aligny center");

		this.lblNombreDePlaces_2 = new JLabel(
				"Nombre de places pour la serie G :");
		this.lblNombreDePlaces_2.setFont(new Font("Arial Unicode MS",
				Font.PLAIN, 15));
		this.lblNombreDePlaces_2.setBounds(53, 192, 252, 23);
		this.contentPane.add(this.lblNombreDePlaces_2,
				"cell 0 5,alignx right,growy");

		this.textFieldNbplacesG = new JTextField();
		this.textFieldNbplacesG.setHorizontalAlignment(SwingConstants.CENTER);
		this.textFieldNbplacesG.setFont(new Font("Arial Unicode MS",
				Font.PLAIN, 15));
		this.textFieldNbplacesG.setColumns(10);
		this.textFieldNbplacesG.setBounds(308, 194, 114, 19);
		this.contentPane.add(this.textFieldNbplacesG, "cell 2 5");

		this.lblNombreDePlaces_3 = new JLabel(
				"Nombre de places pour la serie T :");
		this.lblNombreDePlaces_3.setFont(new Font("Arial Unicode MS",
				Font.PLAIN, 15));
		this.lblNombreDePlaces_3.setBounds(53, 239, 252, 23);
		this.contentPane.add(this.lblNombreDePlaces_3,
				"cell 0 6,alignx right,growy");

		this.textFieldNbPlacesL = new JTextField();
		this.textFieldNbPlacesL.setHorizontalAlignment(SwingConstants.CENTER);
		this.textFieldNbPlacesL.setFont(new Font("Arial Unicode MS",
				Font.PLAIN, 15));
		this.textFieldNbPlacesL.setBounds(303, 102, 114, 19);
		this.contentPane.add(this.textFieldNbPlacesL, "cell 2 3");
		this.textFieldNbPlacesL.setColumns(10);

		this.textFieldNbplacesT = new JTextField();
		this.textFieldNbplacesT.setHorizontalAlignment(SwingConstants.CENTER);
		this.textFieldNbplacesT.setFont(new Font("Arial Unicode MS",
				Font.PLAIN, 15));
		this.textFieldNbplacesT.setColumns(10);
		this.textFieldNbplacesT.setBounds(308, 241, 114, 19);
		this.contentPane.add(this.textFieldNbplacesT, "cell 2 6");

		this.panel = new JPanel();
		this.panel.setBackground(Outil.CENTER_PANE_COLOR);
		add(this.panel, "cell 0 8 2097051 1,alignx center,growy");
		this.panel.setLayout(new MigLayout("",
				"[190px:n,fill][10px:30px:30px,grow][190px:n,fill]",
				"[29px:29px,fill]"));

		this.btnAjouter = new JButton("Ajouter");
		this.panel.add(this.btnAjouter, "flowx,cell 0 0,grow");
		this.btnAjouter.addActionListener(new BtnAjouterActionListener());
		this.btnAjouter.setBounds(193, 334, 117, 25);

		this.btnAnnuler = new JButton("Annuler\n");
		this.panel.add(this.btnAnnuler, "cell 2 0,grow");
		this.btnAnnuler.setBounds(339, 334, 117, 25);
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

			Lycee lycee = new Lycee(nomLycee, nbrePlacesL, nbrePlacesS,
					nbrePlacesG, nbrePlacesT);
			lyceeDAO.ajoutLycee(lycee, "Inspection");
		}
	}
}
