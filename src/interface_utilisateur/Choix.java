package interface_utilisateur;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Choix extends JPanel {
	protected JLabel lblChoix;
	protected JLabel label;
	protected JLabel label_1;
	protected JLabel label_2;
	protected JTextField textField;
	protected JTextField textField_1;
	protected JTextField textField_2;
	protected JButton btnValider;
	protected JButton btnAnnuler;

	/**
	 * Create the panel.
	 */
	public Choix() {

		initialize();
	}
	private void initialize() {
		setLayout(null);

		this.lblChoix = new JLabel("Choix");
		this.lblChoix.setBounds(98, 12, 70, 15);
		add(this.lblChoix);

		this.label = new JLabel("1");
		this.label.setBounds(44, 63, 36, 15);
		add(this.label);

		this.label_1 = new JLabel("2");
		this.label_1.setBounds(44, 106, 70, 15);
		add(this.label_1);

		this.label_2 = new JLabel("3");
		this.label_2.setBounds(46, 150, 70, 15);
		add(this.label_2);

		this.textField = new JTextField();
		this.textField.setBounds(98, 61, 180, 19);
		add(this.textField);
		this.textField.setColumns(10);

		this.textField_1 = new JTextField();
		this.textField_1.setBounds(98, 104, 114, 19);
		add(this.textField_1);
		this.textField_1.setColumns(10);

		this.textField_2 = new JTextField();
		this.textField_2.setBounds(98, 148, 114, 19);
		add(this.textField_2);
		this.textField_2.setColumns(10);

		this.btnValider = new JButton("Valider");
		this.btnValider.setBounds(176, 263, 117, 25);
		add(this.btnValider);

		this.btnAnnuler = new JButton("Annuler");
		this.btnAnnuler.setBounds(308, 263, 117, 25);
		add(this.btnAnnuler);
	}
}
