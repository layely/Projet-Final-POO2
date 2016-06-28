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

public class Login extends JFrame {
	protected JLabel lblLogin;
	protected JTextField txtfielLogin;
	protected JLabel lblMotDePasse;
	protected JPasswordField txtFieldPass;
	protected JButton btnConnection;
	protected JButton btnQuitter;
	protected JLabel lblConnection;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		initialize();
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		JPanel content = new JPanel();
		setContentPane(content);
		content.setLayout(null);

		this.lblLogin = new JLabel("Login");
		this.lblLogin.setBounds(52, 76, 107, 31);
		content.add(this.lblLogin);

		this.txtfielLogin = new JTextField();
		this.txtfielLogin.setBounds(177, 76, 220, 31);
		content.add(this.txtfielLogin);
		this.txtfielLogin.setColumns(10);

		this.lblMotDePasse = new JLabel("Mot de passe");
		this.lblMotDePasse.setBounds(52, 130, 107, 31);
		content.add(this.lblMotDePasse);

		this.txtFieldPass = new JPasswordField();
		this.txtFieldPass.setBounds(177, 130, 220, 31);
		content.add(this.txtFieldPass);
		this.txtFieldPass.setColumns(10);

		this.btnConnection = new JButton("Connection");
		this.btnConnection.addActionListener(new BtnConnectionActionListener());
		this.btnConnection.setBounds(125, 208, 117, 25);
		content.add(this.btnConnection);

		this.btnQuitter = new JButton("Quitter");
		this.btnQuitter.addActionListener(new BtnQuitterActionListener());
		this.btnQuitter.setBounds(293, 208, 117, 25);
		content.add(this.btnQuitter);

		this.lblConnection = new JLabel("CONNECTION");
		this.lblConnection.setBounds(113, 31, 154, 15);
		content.add(this.lblConnection);
	}

	private class BtnQuitterActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	private class BtnConnectionActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String login = txtfielLogin.getText();
			String motDePasse = String.valueOf(txtFieldPass.getPassword());
			
		}
	}
}
