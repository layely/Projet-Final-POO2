package interface_utilisateur;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class Resultat extends JPanel {
	protected JLabel lblSaisieDeNotes;
	protected JLabel lblD;
	protected JTextField textField;
	protected JLabel lblD_1;
	protected JTextField textField_1;
	protected JRadioButton rdbtnerTour;
	protected JRadioButton rdbtnmeTour;
	protected JRadioButton rdbtnchec;
	protected JButton btnValider;
	protected JButton btnPrcdent;
	protected JTextField textField_2;
	protected JLabel lblNewLabel;
	protected JLabel lblRsultatDuBfem;
	protected JLabel lblHistogo;
	protected JTextField textField_3;
	protected JTextField textField_4;
	protected JLabel lblPc;
	protected JLabel lblSvt;
	protected JTextField textField_5;

	/**
	 * Create the panel.
	 */
	public Resultat() {

		initialize();
	}
	private void initialize() {
		setLayout(null);

		this.lblSaisieDeNotes = new JLabel("Résultat scolaire");
		this.lblSaisieDeNotes.setBounds(76, 26, 278, 31);
		add(this.lblSaisieDeNotes);

		this.lblD = new JLabel("Français");
		this.lblD.setBounds(39, 69, 83, 15);
		add(this.lblD);

		this.textField = new JTextField();
		this.textField.setBounds(183, 67, 114, 19);
		add(this.textField);
		this.textField.setColumns(10);

		this.lblD_1 = new JLabel("Mathématiques");
		this.lblD_1.setBounds(39, 95, 117, 15);
		add(this.lblD_1);

		this.textField_1 = new JTextField();
		this.textField_1.setBounds(183, 93, 114, 19);
		add(this.textField_1);
		this.textField_1.setColumns(10);

		this.rdbtnerTour = new JRadioButton("1er tour");
		this.rdbtnerTour.setBounds(45, 332, 94, 23);
		add(this.rdbtnerTour);

		this.rdbtnmeTour = new JRadioButton("2ème tour");
		this.rdbtnmeTour.setBounds(145, 332, 108, 23);
		add(this.rdbtnmeTour);

		this.rdbtnchec = new JRadioButton("échec");
		this.rdbtnchec.setBounds(276, 332, 94, 23);
		add(this.rdbtnchec);

		this.btnValider = new JButton("Valider");
		this.btnValider.setBounds(251, 376, 117, 25);
		add(this.btnValider);

		this.btnPrcdent = new JButton("Précédent");
		this.btnPrcdent.setBounds(396, 376, 117, 25);
		add(this.btnPrcdent);

		this.textField_2 = new JTextField();
		this.textField_2.setBounds(197, 258, 114, 19);
		add(this.textField_2);
		this.textField_2.setColumns(10);

		this.lblNewLabel = new JLabel("Moyenne générale");
		this.lblNewLabel.setBounds(42, 260, 137, 15);
		add(this.lblNewLabel);

		this.lblRsultatDuBfem = new JLabel("Résultat du BFEM");
		this.lblRsultatDuBfem.setBounds(53, 309, 150, 15);
		add(this.lblRsultatDuBfem);

		this.lblHistogo = new JLabel("Histo-Géo");
		this.lblHistogo.setBounds(39, 122, 70, 15);
		add(this.lblHistogo);

		this.textField_3 = new JTextField();
		this.textField_3.setBounds(183, 124, 114, 19);
		add(this.textField_3);
		this.textField_3.setColumns(10);

		this.textField_4 = new JTextField();
		this.textField_4.setBounds(183, 155, 114, 19);
		add(this.textField_4);
		this.textField_4.setColumns(10);

		this.lblPc = new JLabel("PC");
		this.lblPc.setBounds(39, 184, 70, 15);
		add(this.lblPc);

		this.lblSvt = new JLabel("SVT");
		this.lblSvt.setBounds(39, 157, 70, 15);
		add(this.lblSvt);

		this.textField_5 = new JTextField();
		this.textField_5.setBounds(183, 186, 114, 19);
		add(this.textField_5);
		this.textField_5.setColumns(10);
	}
}
