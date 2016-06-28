package interface_utilisateur;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Choix extends JPanel {
	protected JLabel lblChoix;
	protected JLabel label;
	protected JLabel label_1;
	protected JLabel label_2;
	protected JTextField textFieldChoix1;
	protected JTextField textFieldChoix2;
	protected JTextField textFieldChoix3;
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

		this.textFieldChoix1 = new JTextField();
		this.textFieldChoix1.setBounds(98, 61, 180, 19);
		add(this.textFieldChoix1);
		this.textFieldChoix1.setColumns(10);

		this.textFieldChoix2 = new JTextField();
		this.textFieldChoix2.setBounds(98, 104, 114, 19);
		add(this.textFieldChoix2);
		this.textFieldChoix2.setColumns(10);

		this.textFieldChoix3 = new JTextField();
		this.textFieldChoix3.setBounds(98, 148, 114, 19);
		add(this.textFieldChoix3);
		this.textFieldChoix3.setColumns(10);

		this.btnValider = new JButton("Valider");
		this.btnValider.addActionListener(new BtnValiderActionListener());
		this.btnValider.setBounds(176, 263, 117, 25);
		add(this.btnValider);

		this.btnAnnuler = new JButton("Precendent");
		this.btnAnnuler.setBounds(308, 263, 117, 25);
		add(this.btnAnnuler);
	}
	private class BtnValiderActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			String choix1 = textFieldChoix1.getText();
			String choix2 = textFieldChoix2.getText();
			String choix3 = textFieldChoix3.getText();
		}
	}
}
