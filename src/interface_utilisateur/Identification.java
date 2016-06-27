package interface_utilisateur;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class Identification extends JPanel {
	protected JLabel lblNom;
	protected JTextField textField;
	protected JLabel lblPrenom;
	protected JTextField textField_1;
	protected JLabel lblNumroDeTable;
	protected JTextField textField_2;
	protected JLabel lblDateDeNaissace;
	protected JTextField textField_3;
	protected JLabel lblLieuDeNaissance;
	protected JTextField textField_4;
	protected JRadioButton rdbtnM;
	protected JRadioButton rdbtnF;
	protected final ButtonGroup buttonGroup = new ButtonGroup();
	protected JButton btnValider;
	protected JButton btnAnnuller;
	protected JLabel lblIdentificationDunlve;
	private JLabel lblSexe;

	/**
	 * Create the panel.
	 */
	public Identification() {

		initialize();
	}
	private void initialize() {
		setLayout(null);


		this.lblNom = new JLabel("Nom");
		this.lblNom.setBounds(46, 101, 78, 19);
		add(this.lblNom);

		this.textField = new JTextField();
		this.textField.setBounds(180, 101, 248, 19);
		add(this.textField);
		this.textField.setColumns(10);

		this.lblPrenom = new JLabel("Prenom");
		this.lblPrenom.setBounds(46, 137, 78, 33);
		add(this.lblPrenom);

		this.textField_1 = new JTextField();
		this.textField_1.setBounds(180, 144, 248, 19);
		add(this.textField_1);
		this.textField_1.setColumns(10);

		this.lblNumroDeTable = new JLabel("Numero de table");
		this.lblNumroDeTable.setBounds(46, 60, 127, 15);
		add(this.lblNumroDeTable);

		this.textField_2 = new JTextField();
		this.textField_2.setBounds(180, 58, 248, 19);
		add(this.textField_2);
		this.textField_2.setColumns(10);

		this.lblDateDeNaissace = new JLabel("Date de Naissace");
		this.lblDateDeNaissace.setBounds(46, 210, 127, 15);
		add(this.lblDateDeNaissace);

		this.textField_3 = new JTextField();
		this.textField_3.setBounds(180, 208, 248, 19);
		add(this.textField_3);
		this.textField_3.setColumns(10);

		this.lblLieuDeNaissance = new JLabel("Lieu de naissance");
		this.lblLieuDeNaissance.setBounds(46, 253, 127, 15);
		add(this.lblLieuDeNaissance);

		this.textField_4 = new JTextField();
		this.textField_4.setBounds(180, 251, 248, 19);
		add(this.textField_4);
		this.textField_4.setColumns(10);

		this.rdbtnM = new JRadioButton("M");
		this.buttonGroup.add(this.rdbtnM);
		this.rdbtnM.setBounds(211, 173, 68, 23);
		add(this.rdbtnM);

		this.rdbtnF = new JRadioButton("F");
		this.buttonGroup.add(this.rdbtnF);
		this.rdbtnF.setBounds(289, 173, 78, 23);
		add(this.rdbtnF);

		this.btnValider = new JButton("Valider");
		this.btnValider.setBounds(150, 295, 117, 25);
		add(this.btnValider);

		this.btnAnnuller = new JButton("Annuler");
		this.btnAnnuller.setBounds(311, 295, 117, 25);
		add(this.btnAnnuller);

		this.lblIdentificationDunlve = new JLabel("IDENTIFICATION D'UN ELEVE");
		this.lblIdentificationDunlve.setBounds(230, 12, 148, 36);
		add(this.lblIdentificationDunlve);
		
		lblSexe = new JLabel("Sexe");
		lblSexe.setBounds(46, 162, 96, 33);
		add(lblSexe);
	}
}
