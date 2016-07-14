package interface_utilisateur;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import utilitaire.Outil;

import java.awt.Color;
import java.awt.SystemColor;

public class LoginFrame extends JFrame {
	protected JPanel panelTop;
	protected JPanel panelCenter;
	protected JPanel panelBottom;
	protected JLabel lblEcoleOuInspection;
	protected JLabel lblMotDePasse;
	protected JTextField textFieldlogin;
	protected JPasswordField textFieldPassword;
	protected JPanel panel;
	protected JButton btnSeConnecter;
	protected JButton btnAnnuler;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		initialize();
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 719, 420);
		JPanel content = new JPanel();
		content.setForeground(Color.WHITE);
		setContentPane(content);
		content.setLayout(new MigLayout("", "[grow]", "[60px,fill][grow,center][60px,fill]"));

		this.panelTop = new JPanel();
		content.add(this.panelTop, "cell 0 0,grow");

		this.panelCenter = new JPanel();
		content.add(this.panelCenter, "cell 0 1,growx,aligny center");
		this.panelCenter.setLayout(new MigLayout("", "[grow,right][10px:n][100px,grow,fill][grow]", "[][][40px]"));

		this.lblEcoleOuInspection = new JLabel("Ecole/Inspection :");
		this.panelCenter.add(this.lblEcoleOuInspection, "cell 0 0,alignx trailing");

		this.textFieldlogin = new JTextField();
		this.panelCenter.add(this.textFieldlogin, "cell 2 0");
		this.textFieldlogin.setColumns(10);

		this.lblMotDePasse = new JLabel("Mot de passe :");
		this.panelCenter.add(this.lblMotDePasse, "cell 0 1,alignx trailing");

		this.textFieldPassword = new JPasswordField();
		this.panelCenter.add(this.textFieldPassword, "cell 2 1");
		this.textFieldPassword.setColumns(10);

		this.panel = new JPanel();
		this.panelCenter.add(this.panel, "cell 0 2 4 1,alignx center");
		this.panel.setLayout(new MigLayout("", "[fill][fill]", "[]"));

		this.btnSeConnecter = new JButton("Connextion");
		this.btnSeConnecter.addActionListener(new ButtonActionListener());
		this.panel.add(this.btnSeConnecter, "cell 0 0");

		this.btnAnnuler = new JButton("Annuler");
		this.btnAnnuler.addActionListener(new BtnAnnulerActionListener());
		this.panel.add(this.btnAnnuler, "cell 1 0");

		this.panelBottom = new JPanel();
		content.add(this.panelBottom, "cell 0 2,growx");
	}
	private class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String login = textFieldlogin.getText();
			String pass = textFieldPassword.getText();

			if(Outil.getConnection(login, pass)) {
				Outil.openHome();
				LoginFrame.this.dispose();
			} else {

			}
		}
	}
	private class BtnAnnulerActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		}
	}
}
