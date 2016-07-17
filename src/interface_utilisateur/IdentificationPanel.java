package interface_utilisateur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.jbundle.thin.base.screen.jcalendarbutton.JCalendarButton;
import org.jdesktop.swingx.JXDatePicker;

import objet.Eleve;
import utilitaire.Connection;
import utilitaire.Outil;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import org.jdesktop.swingx.JXTitledSeparator;

public class IdentificationPanel extends JPanel {
	protected JLabel lblNom;
	protected JTextField textFieldNom;
	protected JLabel lblPrenom;
	protected JTextField textFieldPrenom;
	protected JLabel lblNumroDeTable;
	protected JTextField textFieldNumTable;
	protected JLabel lblDateDeNaissace;
	protected JXDatePicker textFieldDateNaissance;
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

	private JPanel parentframe = null;
	private JXTitledSeparator titledSeparator;

	/**
	 * Create the panel.
	 */
	public IdentificationPanel(JFrame parent) {
//		parentframe = parent;
		initialize();
	}
	
	/**
	 * @wbp.parser.constructor
	 */
	public IdentificationPanel(JPanel parent) {
		parentframe = parent;
		initialize();
	}

	private void initialize() {
		this.setBackground(Outil.CENTER_PANE_COLOR);
		setLayout(new MigLayout("", "[grow,right][139px][][10px][139px][grow]", "[30px][:50px:50px,grow][30px:n,top][30px,fill][30px,fill][30px,fill][30px,fill][30px,fill][30px,fill][25][25px]"));
		
//		this.titledSeparator = new JXTitledSeparator();
//		this.titledSeparator.setTitle("");
//		add(this.titledSeparator, "cell 0 2 6 1,growx,aligny top");
		this.lblNom = new JLabel("Nom :");
		this.lblNom.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(this.lblNom, "cell 0 4");

		this.textFieldNom = new JTextField();
		this.textFieldNom.setHorizontalAlignment(SwingConstants.CENTER);
		this.textFieldNom.setFont(new Font("Arial", Font.PLAIN, 15));
		add(this.textFieldNom, "cell 1 4 4 1,grow");
		this.textFieldNom.setColumns(10);

		this.lblPrenom = new JLabel("Prenom :");
		this.lblPrenom.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(this.lblPrenom, "cell 0 5");

		this.textFieldPrenom = new JTextField();
		this.textFieldPrenom.setHorizontalAlignment(SwingConstants.CENTER);
		this.textFieldPrenom.setFont(new Font("Arial", Font.PLAIN, 15));
		add(this.textFieldPrenom, "cell 1 5 4 1,growx,aligny center");
		this.textFieldPrenom.setColumns(10);

		this.lblNumroDeTable = new JLabel("Numero de table :");
		this.lblNumroDeTable.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(this.lblNumroDeTable, "cell 0 3");

		this.textFieldNumTable = new JTextField();
		this.textFieldNumTable.setHorizontalAlignment(SwingConstants.CENTER);
		this.textFieldNumTable.setFont(new Font("Arial", Font.PLAIN, 15));
		add(this.textFieldNumTable, "cell 1 3 4 1,grow");
		this.textFieldNumTable.setColumns(10);
		
				lblSexe = new JLabel("Sexe :");
				this.lblSexe.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
				add(lblSexe, "cell 0 6");

		this.lblDateDeNaissace = new JLabel("Date de Naissace :");
		this.lblDateDeNaissace.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(this.lblDateDeNaissace, "cell 0 7");

		this.textFieldDateNaissance = new JXDatePicker();
		this.textFieldDateNaissance.getEditor().setHorizontalAlignment(SwingConstants.CENTER);
		this.textFieldDateNaissance.getEditor().setFont(new Font("Arial", Font.PLAIN, 15));
		this.textFieldDateNaissance.addActionListener(new TextFieldDateNaissanceActionListener());
		add(this.textFieldDateNaissance, "cell 1 7 4 1,grow");

		this.lblLieuDeNaissance = new JLabel("Lieu de naissance :");
		this.lblLieuDeNaissance.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(this.lblLieuDeNaissance, "cell 0 8");

		jcalendarbutton = new JCalendarButton();
		jcalendarbutton.setBounds(180, 251, 248, 19);

		this.textFieldLieuNaissance = new JTextField();
		this.textFieldLieuNaissance.setHorizontalAlignment(SwingConstants.CENTER);
		this.textFieldLieuNaissance.setFont(new Font("Arial", Font.PLAIN, 15));
		add(this.textFieldLieuNaissance, "cell 1 8 4 1,grow");
		this.textFieldLieuNaissance.setColumns(10);

		this.rdbtnM = new JRadioButton("M");
		this.rdbtnM.setSelected(true);
		this.buttonGroup.add(this.rdbtnM);
		add(this.rdbtnM, "cell 1 6,alignx right,aligny top");

		this.rdbtnF = new JRadioButton("F");
		this.buttonGroup.add(this.rdbtnF);
		add(this.rdbtnF, "cell 4 6,alignx left,aligny top");

		this.btnAnnuller = new JButton("Annuler");
		this.btnAnnuller.addActionListener(new BtnAnnullerActionListener());
		
				this.btnValider = new JButton("Suivant");
				this.btnValider.addActionListener(new BtnValiderActionListener());
				add(this.btnValider, "cell 1 10,grow");
		add(this.btnAnnuller, "cell 4 10,grow");

		this.lblIdentificationDunlve = new JLabel("INFORMATIONS PERSONNELLES (1/4)");
		this.lblIdentificationDunlve.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(this.lblIdentificationDunlve, "cell 1 1 4 1,alignx center,growy");
	}

	private class BtnValiderActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String strNumTable = textFieldNumTable.getText();
			int numTable = Integer.parseInt(strNumTable);
			String nom = textFieldNom.getText();
			String prenom = textFieldPrenom.getText();
			String lieuNaissance = textFieldLieuNaissance.getText();
			Date date = textFieldDateNaissance.getDate();
			Calendar dateNaissance = null;
			try {
				dateNaissance = Calendar.getInstance();
				dateNaissance.setTime(date);
			} catch (Exception e1) {
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
			((IdentificationFrame) parentframe).suivant();
		}
	}

	private class TextFieldDateNaissanceActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

		}
	}
	private class BtnAnnullerActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
//			parentframe.dispose();
		}
	}
}
