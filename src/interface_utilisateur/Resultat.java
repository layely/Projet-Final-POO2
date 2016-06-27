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

		this.lblD = new JLabel("D1");
		this.lblD.setBounds(39, 69, 46, 15);
		add(this.lblD);

		this.textField = new JTextField();
		this.textField.setBounds(183, 79, 114, 19);
		add(this.textField);
		this.textField.setColumns(10);

		this.lblD_1 = new JLabel("D2");
		this.lblD_1.setBounds(42, 112, 57, 15);
		add(this.lblD_1);

		this.textField_1 = new JTextField();
		this.textField_1.setBounds(183, 110, 114, 19);
		add(this.textField_1);
		this.textField_1.setColumns(10);

		this.rdbtnerTour = new JRadioButton("1er tour");
		this.rdbtnerTour.setBounds(39, 233, 94, 23);
		add(this.rdbtnerTour);

		this.rdbtnmeTour = new JRadioButton("2ème tour");
		this.rdbtnmeTour.setBounds(142, 233, 108, 23);
		add(this.rdbtnmeTour);

		this.rdbtnchec = new JRadioButton("échec");
		this.rdbtnchec.setBounds(274, 233, 94, 23);
		add(this.rdbtnchec);

		this.btnValider = new JButton("Valider");
		this.btnValider.setBounds(251, 300, 117, 25);
		add(this.btnValider);

		this.btnPrcdent = new JButton("Précédent");
		this.btnPrcdent.setBounds(397, 300, 117, 25);
		add(this.btnPrcdent);

		this.textField_2 = new JTextField();
		this.textField_2.setBounds(183, 151, 114, 19);
		add(this.textField_2);
		this.textField_2.setColumns(10);

		this.lblNewLabel = new JLabel("Moyenne générale");
		this.lblNewLabel.setBounds(39, 153, 137, 15);
		add(this.lblNewLabel);

		this.lblRsultatDuBfem = new JLabel("Résultat du BFEM");
		this.lblRsultatDuBfem.setBounds(39, 210, 150, 15);
		add(this.lblRsultatDuBfem);
	}
}
