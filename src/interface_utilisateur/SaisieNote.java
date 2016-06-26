package interface_utilisateur;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class SaisieNote extends JPanel {
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

	/**
	 * Create the panel.
	 */
	public SaisieNote() {

		initialize();
	}
	private void initialize() {
		setLayout(null);

		this.lblSaisieDeNotes = new JLabel("Saisie de notes");
		this.lblSaisieDeNotes.setBounds(76, 26, 278, 31);
		add(this.lblSaisieDeNotes);

		this.lblD = new JLabel("D1");
		this.lblD.setBounds(39, 92, 46, 15);
		add(this.lblD);

		this.textField = new JTextField();
		this.textField.setBounds(103, 90, 114, 19);
		add(this.textField);
		this.textField.setColumns(10);

		this.lblD_1 = new JLabel("D2");
		this.lblD_1.setBounds(39, 140, 57, 15);
		add(this.lblD_1);

		this.textField_1 = new JTextField();
		this.textField_1.setBounds(103, 138, 114, 19);
		add(this.textField_1);
		this.textField_1.setColumns(10);

		this.rdbtnerTour = new JRadioButton("1er tour");
		this.rdbtnerTour.setBounds(39, 192, 94, 23);
		add(this.rdbtnerTour);

		this.rdbtnmeTour = new JRadioButton("2ème tour");
		this.rdbtnmeTour.setBounds(144, 192, 108, 23);
		add(this.rdbtnmeTour);

		this.rdbtnchec = new JRadioButton("échec");
		this.rdbtnchec.setBounds(279, 192, 94, 23);
		add(this.rdbtnchec);

		this.btnValider = new JButton("Valider");
		this.btnValider.setBounds(155, 241, 117, 25);
		add(this.btnValider);

		this.btnPrcdent = new JButton("Précédent");
		this.btnPrcdent.setBounds(292, 241, 117, 25);
		add(this.btnPrcdent);
	}

}
