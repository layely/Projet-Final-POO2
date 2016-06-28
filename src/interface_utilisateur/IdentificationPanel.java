package interface_utilisateur;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.jbundle.thin.base.screen.jcalendarbutton.JCalendarButton;

import objet.Eleve;
import utilitaire.Connection;
import utilitaire.Outil;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class IdentificationPanel extends JPanel {
	protected JLabel lblNom;
	protected JTextField textFieldNom;
	protected JLabel lblPrenom;
	protected JTextField textFieldPrenom;
	protected JLabel lblNumroDeTable;
	protected JTextField textFieldNumTable;
	protected JLabel lblDateDeNaissace;
	protected JTextField textFieldDateNaissance;
	protected JLabel lblLieuDeNaissance;
	protected JTextField textFieldLieuNaissance;
	protected JRadioButton rdbtnM;
	protected JRadioButton rdbtnF;
	protected final ButtonGroup buttonGroup = new ButtonGroup();
	protected JButton btnValider;
	protected JButton btnAnnuller;
	protected JLabel lblIdentificationDunlve;
	private JLabel lblSexe;
	private JCalendarButton jcalendarbutton;

	public static Eleve dernierIdentifie;

	/**
	 * Create the panel.
	 */
	public IdentificationPanel() {

		initialize();
	}

	private void initialize() {
		setLayout(null);

		this.lblNom = new JLabel("Nom");
		this.lblNom.setBounds(46, 101, 78, 19);
		add(this.lblNom);

		this.textFieldNom = new JTextField();
		this.textFieldNom.setBounds(180, 101, 248, 19);
		add(this.textFieldNom);
		this.textFieldNom.setColumns(10);

		this.lblPrenom = new JLabel("Prenom");
		this.lblPrenom.setBounds(46, 137, 78, 33);
		add(this.lblPrenom);

		this.textFieldPrenom = new JTextField();
		this.textFieldPrenom.setBounds(180, 144, 248, 19);
		add(this.textFieldPrenom);
		this.textFieldPrenom.setColumns(10);

		this.lblNumroDeTable = new JLabel("Numero de table");
		this.lblNumroDeTable.setBounds(46, 60, 127, 15);
		add(this.lblNumroDeTable);

		this.textFieldNumTable = new JTextField();
		this.textFieldNumTable.setBounds(180, 58, 248, 19);
		add(this.textFieldNumTable);
		this.textFieldNumTable.setColumns(10);

		this.lblDateDeNaissace = new JLabel("Date de Naissace");
		this.lblDateDeNaissace.setBounds(46, 210, 127, 15);
		add(this.lblDateDeNaissace);

		this.textFieldDateNaissance = new JTextField();
		this.textFieldDateNaissance.addActionListener(new TextFieldDateNaissanceActionListener());
		this.textFieldDateNaissance.setBounds(180, 208, 248, 19);
		add(this.textFieldDateNaissance);
		this.textFieldDateNaissance.setColumns(10);

		this.lblLieuDeNaissance = new JLabel("Lieu de naissance");
		this.lblLieuDeNaissance.setBounds(46, 253, 127, 15);
		add(this.lblLieuDeNaissance);

		jcalendarbutton = new JCalendarButton();
		jcalendarbutton.setBounds(180, 251, 248, 19);

		this.textFieldLieuNaissance = new JTextField();
		this.textFieldLieuNaissance.setBounds(180, 251, 248, 19);
		add(this.textFieldLieuNaissance);
		this.textFieldLieuNaissance.setColumns(10);

		this.rdbtnM = new JRadioButton("M");
		this.buttonGroup.add(this.rdbtnM);
		this.rdbtnM.setBounds(211, 173, 68, 23);
		add(this.rdbtnM);

		this.rdbtnF = new JRadioButton("F");
		this.buttonGroup.add(this.rdbtnF);
		this.rdbtnF.setBounds(289, 173, 78, 23);
		add(this.rdbtnF);

		this.btnValider = new JButton("Valider");
		this.btnValider.addActionListener(new BtnValiderActionListener());
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

	private class BtnValiderActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String strNumTable = textFieldNumTable.getText();
			int numTable = Integer.parseInt(strNumTable);
			String nom = textFieldNom.getText();
			String prenom = textFieldPrenom.getText();
			String lieuNaissance = textFieldLieuNaissance.getText();
			String strDate = textFieldDateNaissance.getText();
			Calendar dateNaissance = null;
			try {
				dateNaissance = Outil.stringToCalendar(strDate);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			char sexe = '0';
			String etablissement = Connection.getNom();

			if (rdbtnM.isSelected())
				sexe = 'M';
			else if (rdbtnF.isSelected())
				sexe = 'F';

			Eleve eleve = new Eleve(numTable, nom, prenom, lieuNaissance, dateNaissance, sexe, etablissement);
			dernierIdentifie = eleve;
		}
	}

	private class TextFieldDateNaissanceActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

		}
	}
}
