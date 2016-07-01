package interface_utilisateur;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import databaseDAOs.DAO_Eleve;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	protected JPanel panel;
	protected JButton btnIdentifierUnEleve;
	protected JButton btnModifierUnEleve;
	protected JButton btnListeDeTous;
	protected JButton btnListeDesOrientes;
	protected JButton btnListeDesOrientes_1;
	protected JButton btnListeDesOrientes_2;
	protected JButton btnListeDesOrientes_3;
	protected JButton btnNewButton;
	protected JButton btnAjouterUnLyce;
	protected JButton btnQuitter;

	DAO_Eleve eleveDAO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		initialize();
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(this.contentPane);

		this.panel = new JPanel();
		this.contentPane.add(this.panel, BorderLayout.CENTER);
		this.panel.setLayout(new GridLayout(10, 1, 0, 0));

		this.btnIdentifierUnEleve = new JButton("Identifier un eleve");
		this.btnIdentifierUnEleve.addActionListener(new BtnIdentifierUnEleveActionListener());

		this.btnModifierUnEleve = new JButton("Rechercher un(e) eleve");
		this.panel.add(this.btnModifierUnEleve);
		this.panel.add(this.btnIdentifierUnEleve);

		this.btnListeDeTous = new JButton("Liste de tous les eleves");
		this.panel.add(this.btnListeDeTous);

		this.btnListeDesOrientes_1 = new JButton("Liste des orientes en L");
		this.panel.add(this.btnListeDesOrientes_1);

		this.btnListeDesOrientes = new JButton("Liste des Orientes en S");
		this.panel.add(this.btnListeDesOrientes);

		this.btnListeDesOrientes_2 = new JButton("Liste des orientes en G");
		this.panel.add(this.btnListeDesOrientes_2);

		this.btnListeDesOrientes_3 = new JButton("Liste des orientes en T");
		this.panel.add(this.btnListeDesOrientes_3);

		this.btnNewButton = new JButton("Ajouter une ecole");
		this.panel.add(this.btnNewButton);

		this.btnAjouterUnLyce = new JButton("Ajouter un lycée");
		this.btnAjouterUnLyce.addActionListener(new BtnAjouterUnLyceActionListener());
		this.panel.add(this.btnAjouterUnLyce);

		this.btnQuitter = new JButton("Quitter");
		this.panel.add(this.btnQuitter);
	}

	private class BtnIdentifierUnEleveActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new IdentificationFrame().setVisible(true);
		}
	}
	private class BtnAjouterUnLyceActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new AjoutLyceeFrame(MainFrame.this).setVisible(true);
		}
	}
}
