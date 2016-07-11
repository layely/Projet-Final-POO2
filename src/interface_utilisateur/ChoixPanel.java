package interface_utilisateur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import databaseDAOs.DAO_Eleve;
import databaseDAOs.DAO_Resultat;

public class ChoixPanel extends JPanel {
	protected JLabel lblChoix;
	protected JLabel label;
	protected JLabel label_1;
	protected JLabel label_2;
	protected JTextField textFieldChoix1;
	protected JTextField textFieldChoix2;
	protected JTextField textFieldChoix3;
	protected JButton btnValider;
	protected JButton btnAnnuler;
	protected JButton btnDown1;
	protected JButton btnUp2;
	protected JButton btnDown2;
	protected JButton btnUp3;
	protected JButton btnDown3;
	protected JLabel lblX;
	protected JTextField txtFieldChoix4;
	protected JButton buttonUPX;

	JPanel parentPanel;
	DAO_Eleve eleveDAO;
	DAO_Resultat resultatDAO;

	/**
	 * Create the panel.
	 */
	public ChoixPanel(JPanel parent) {
		parentPanel = parent;
		eleveDAO = new DAO_Eleve();
		resultatDAO = new DAO_Resultat();
		initialize();
	}

	private void initialize() {
		setLayout(null);

		this.lblChoix = new JLabel("CHOIX");
		this.lblChoix.setBounds(98, 12, 70, 15);
		add(this.lblChoix);

		this.label = new JLabel("1");
		this.label.setBounds(44, 63, 45, 31);
		add(this.label);

		this.label_1 = new JLabel("2");
		this.label_1.setBounds(44, 106, 36, 32);
		add(this.label_1);

		this.label_2 = new JLabel("3");
		this.label_2.setBounds(46, 150, 45, 32);
		add(this.label_2);

		this.textFieldChoix1 = new JTextField();
		this.textFieldChoix1.setText("L");
		this.textFieldChoix1.setBounds(98, 61, 90, 33);
		add(this.textFieldChoix1);
		this.textFieldChoix1.setColumns(10);

		this.textFieldChoix2 = new JTextField();
		this.textFieldChoix2.setText("S");
		this.textFieldChoix2.setBounds(98, 106, 90, 33);
		add(this.textFieldChoix2);
		this.textFieldChoix2.setColumns(10);

		this.textFieldChoix3 = new JTextField();
		this.textFieldChoix3.setText("G");
		this.textFieldChoix3.setBounds(98, 148, 90, 33);
		add(this.textFieldChoix3);
		this.textFieldChoix3.setColumns(10);

		this.btnValider = new JButton("Valider");
		this.btnValider.addActionListener(new BtnValiderActionListener());
		this.btnValider.setBounds(176, 263, 117, 25);
		add(this.btnValider);

		this.btnAnnuler = new JButton("Precendent");
		this.btnAnnuler.addActionListener(new BtnAnnulerActionListener());
		this.btnAnnuler.setBounds(308, 263, 117, 25);
		add(this.btnAnnuler);

		this.btnDown1 = new JButton("down");
		this.btnDown1.addActionListener(new BtnDown1ActionListener());
		this.btnDown1.setBounds(282, 66, 117, 15);
		add(this.btnDown1);

		this.btnUp2 = new JButton("up");
		this.btnUp2.addActionListener(new BtnUp2ActionListener());
		this.btnUp2.setBounds(282, 106, 117, 15);
		add(this.btnUp2);

		this.btnDown2 = new JButton("down");
		this.btnDown2.addActionListener(new BtnDown2ActionListener());
		this.btnDown2.setBounds(282, 123, 117, 15);
		add(this.btnDown2);

		this.btnUp3 = new JButton("up");
		this.btnUp3.addActionListener(new BtnUp_1ActionListener());
		this.btnUp3.setBounds(282, 146, 117, 15);
		add(this.btnUp3);

		this.btnDown3 = new JButton("down");
		this.btnDown3.addActionListener(new BtnDown3ActionListener());
		this.btnDown3.setBounds(282, 161, 117, 15);
		add(this.btnDown3);

		this.lblX = new JLabel("x");
		this.lblX.setBounds(44, 205, 36, 15);
		add(this.lblX);

		this.txtFieldChoix4 = new JTextField();
		this.txtFieldChoix4.setText("T");
		this.txtFieldChoix4.setBounds(98, 193, 90, 32);
		add(this.txtFieldChoix4);
		this.txtFieldChoix4.setColumns(10);

		this.buttonUPX = new JButton("up");
		this.buttonUPX.addActionListener(new ButtonUPXActionListener());
		this.buttonUPX.setBounds(282, 200, 117, 15);
		add(this.buttonUPX);
	}

	private class BtnValiderActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			String choix1 = textFieldChoix1.getText();
			String choix2 = textFieldChoix2.getText();
			String choix3 = textFieldChoix3.getText();

			String choix = choix1 + choix2 + choix3;
			IdentificationPanel.dernierIdentifie.setChoix(choix);

			eleveDAO.ajoutEleve(IdentificationPanel.dernierIdentifie);
			// TODO enregistrement du resultat aussi
			resultatDAO.ajoutResultat(IdentificationPanel.dernierIdentifie.getResultat(),
					IdentificationPanel.dernierIdentifie.getNumTable());
			System.out.println(IdentificationPanel.dernierIdentifie);
//			parentPanel.dispose();
		}
	}

	private class BtnUp_1ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String s2 = textFieldChoix2.getText();
			String s3 = textFieldChoix3.getText();

			textFieldChoix2.setText(s3);
			textFieldChoix3.setText(s2);
		}
	}

	private class BtnDown1ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String s1 = textFieldChoix1.getText();
			String s2 = textFieldChoix2.getText();

			textFieldChoix1.setText(s2);
			textFieldChoix2.setText(s1);
		}
	}

	private class BtnUp2ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String s1 = textFieldChoix1.getText();
			String s2 = textFieldChoix2.getText();

			textFieldChoix1.setText(s2);
			textFieldChoix2.setText(s1);
		}
	}

	private class BtnDown2ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String s2 = textFieldChoix2.getText();
			String s3 = textFieldChoix3.getText();

			textFieldChoix2.setText(s3);
			textFieldChoix3.setText(s2);
		}
	}

	private class BtnDown3ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String s3 = textFieldChoix3.getText();
			String s4 = txtFieldChoix4.getText();

			textFieldChoix3.setText(s4);
			txtFieldChoix4.setText(s3);
		}
	}

	private class ButtonUPXActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String s3 = textFieldChoix3.getText();
			String s4 = txtFieldChoix4.getText();

			textFieldChoix3.setText(s4);
			txtFieldChoix4.setText(s3);
		}
	}

	private class BtnAnnulerActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			((IdentificationFrame) parentPanel).precedent();
		}
	}
}
