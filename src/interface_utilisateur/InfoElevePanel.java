package interface_utilisateur;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import databaseDAOs.DAO_Eleve;
import databaseDAOs.DAO_Resultat;
import net.miginfocom.swing.MigLayout;
import objet.Eleve;
import utilitaire.Outil;

public class InfoElevePanel extends JPanel {

	private DAO_Resultat resultatDAO = new DAO_Resultat();
	private DAO_Eleve eleveDAO = new DAO_Eleve();
	private JPanel parent;
	private JLabel labelNumTable;
	private JLabel labelNom;
	private JLabel labelPrenom;
	private JLabel labelSexe;
	private JLabel labelDateNaiss;
	private JLabel labelLieuDeNaiss;
	private JLabel labelNoteFrancais;
	private JLabel labelNoteHistoGeo;
	private JLabel labelNoteSVT;
	private JLabel labelNotePC;
	private JLabel labelMoyGenerale;
	private JLabel labelBFEM;
	private JLabel labelChoix1;
	private JLabel labelChoix2;
	private JLabel labelChoix3;
	private Eleve eleve;
	private JLabel labelNoteMaths;

	/**
	 * Create the panel.
	 */

	public InfoElevePanel(final JPanel parent) {
		this.parent = parent;
		eleve = IdentificationPanel.dernierIdentifie;

		setLayout(new MigLayout("", "[510px,grow][grow]", "[266px,grow][grow]"));
		JPanel panelgauche = new JPanel(new MigLayout("", "", ""));

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Informations personnelles", TitledBorder.LEADING, TitledBorder.TOP,
				null, null));
		add(panelgauche, "cell 0 0,grow");
		panel.setLayout(new MigLayout("", "[150px][300px,shrinkprio 102]", "[][][][][][][][]"));

		panelgauche.add(panel, "cell 0 0,growx");

		JLabel lblNumeroDeTable = new JLabel("Numero de table : ");
		lblNumeroDeTable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNumeroDeTable, "cell 0 1");

		labelNumTable = new JLabel("New label");
		labelNumTable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(labelNumTable, "cell 1 1");

		JLabel lblNom = new JLabel("Nom :");
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNom, "cell 0 2");

		labelNom = new JLabel("New label");
		labelNom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(labelNom, "cell 1 2");

		JLabel lblPrenom = new JLabel("Prenom :");
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblPrenom, "cell 0 3");

		labelPrenom = new JLabel("Abdoulaye Oumar Mody");
		labelPrenom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(labelPrenom, "cell 1 3");

		JLabel lblSexe = new JLabel("Sexe :");
		lblSexe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblSexe, "cell 0 4");

		labelSexe = new JLabel("New label");
		labelSexe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(labelSexe, "cell 1 4");

		JLabel lblDateDeNaissance = new JLabel("Date de naissance :");
		lblDateDeNaissance.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblDateDeNaissance, "cell 0 5");

		labelDateNaiss = new JLabel("New label");
		labelDateNaiss.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(labelDateNaiss, "cell 1 5");

		JLabel lblLieuDeNaissance = new JLabel("Lieu de Naissance :");
		lblLieuDeNaissance.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblLieuDeNaissance, "cell 0 6");

		labelLieuDeNaiss = new JLabel("New label");
		labelLieuDeNaiss.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(labelLieuDeNaiss, "cell 1 6");

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "R\u00E9sultat Scolaire",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		add(panel_1, "cell 1 0,grow");
		panel_1.setLayout(new MigLayout("", "[][]", "[][][][][][][][][][][]"));

		JLabel lblFranais = new JLabel("Français :");
		lblFranais.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_1.add(lblFranais, "cell 0 0");

		labelNoteFrancais = new JLabel("Text here");
		labelNoteFrancais.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_1.add(labelNoteFrancais, "cell 1 0");

		JLabel lblMaths = new JLabel("Maths :");
		lblMaths.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_1.add(lblMaths, "cell 0 1");

		labelNoteMaths = new JLabel("Text here");
		labelNoteMaths.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_1.add(labelNoteMaths, "cell 1 1");

		JLabel lblHistogo = new JLabel("Histo-Géo :");
		lblHistogo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_1.add(lblHistogo, "cell 0 2");

		labelNoteHistoGeo = new JLabel("Text here");
		labelNoteHistoGeo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_1.add(labelNoteHistoGeo, "cell 1 2");

		JLabel lblSvt = new JLabel("SVT :\r\n");
		lblSvt.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_1.add(lblSvt, "cell 0 3");

		labelNoteSVT = new JLabel("Text here");
		labelNoteSVT.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_1.add(labelNoteSVT, "cell 1 3");

		JLabel lblPc = new JLabel("PC :");
		lblPc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_1.add(lblPc, "cell 0 4");

		labelNotePC = new JLabel("Text here");
		labelNotePC.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_1.add(labelNotePC, "cell 1 4");

		JLabel lblMoyenneGnrale = new JLabel("Moyenne Générale :");
		lblMoyenneGnrale.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_1.add(lblMoyenneGnrale, "cell 0 6");

		labelMoyGenerale = new JLabel("New label");
		labelMoyGenerale.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_1.add(labelMoyGenerale, "cell 0 7 2 1,pushx ,alignx center");

		JLabel lblBfem = new JLabel("BFEM :");
		lblBfem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_1.add(lblBfem, "cell 0 9");

		labelBFEM = new JLabel("Text here");
		labelBFEM.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_1.add(labelBFEM, "cell 0 10 2 1,alignx center");

		JPanel panelChoix = new JPanel();
		panelChoix.setBorder(new TitledBorder(null, "Choix", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelgauche.add(panelChoix, "cell 0 1,grow");
		panelChoix.setLayout(new MigLayout("", "[][][][][][][][]", "[][][]"));

		JLabel label = new JLabel("1 :");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelChoix.add(label, "cell 0 0");

		labelChoix1 = new JLabel("New label");
		labelChoix1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelChoix.add(labelChoix1, "cell 1 0");

		JLabel label_1 = new JLabel("2 :");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelChoix.add(label_1, "cell 3 0");

		labelChoix2 = new JLabel("New label");
		labelChoix2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelChoix.add(labelChoix2, "cell 4 0");

		JLabel label_2 = new JLabel("3 :");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelChoix.add(label_2, "cell 6 0");

		labelChoix3 = new JLabel("New label");
		labelChoix3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelChoix.add(labelChoix3, "cell 7 0");

		JPanel panel_2 = new JPanel();
		add(panel_2, "cell 0 1 2 1,alignx right,aligny bottom");
		panel_2.setLayout(new MigLayout("", "[100px:100px,fill][100px:100px,fill]", "[]"));

		JButton btnNewButton = new JButton("Valider");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eleveDAO.ajoutEleve(IdentificationPanel.dernierIdentifie);
				// TODO enregistrement du resultat aussi
				resultatDAO.ajoutResultat(IdentificationPanel.dernierIdentifie.getResultat(),
						IdentificationPanel.dernierIdentifie.getNumTable());
				showMessageDialog("Enregistrement effectué avec succès");
			}
		});
		panel_2.add(btnNewButton, "cell 0 0");

		JButton btnNewButton_1 = new JButton("Précedent");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((IdentificationFrame) parent).precedent();
			}
		});
		panel_2.add(btnNewButton_1, "cell 1 0");

	}

	protected void showMessageDialog(String message) {
		JOptionPane.showMessageDialog(parent, message);
	}

	public void updateLabelText() {
		eleve = IdentificationPanel.dernierIdentifie;
		if (eleve == null)
			return;
		labelNumTable.setText(String.valueOf(eleve.getNumTable()));
		labelNom.setText(eleve.getNom());
		labelPrenom.setText(eleve.getPrenom());
		labelSexe.setText(eleve.getSexToString());
		labelDateNaiss.setText(Outil.calendarToString(eleve.getDateNaissance()));
		labelLieuDeNaiss.setText(eleve.getLieuNaissance());
		labelNoteFrancais.setText(eleve.getResultat().getNoteFrancais().toString());
		labelNoteMaths.setText(eleve.getResultat().getNoteMaths().toString());
		labelNoteHistoGeo.setText(eleve.getResultat().getNoteHistoGeo().toString());
		labelNoteSVT.setText(eleve.getResultat().getNoteSVT().toString());
		labelNotePC.setText(eleve.getResultat().getNotePC().toString());
		labelMoyGenerale.setText(eleve.getResultat().getMoyenneGenerale().toString());
		labelBFEM.setText(eleve.getResultat().getBfemResutatString());
		labelChoix1.setText("Série " + eleve.getChoix1());
		labelChoix2.setText("Série " + eleve.getChoix2());
		labelChoix3.setText("Série " + eleve.getChoix3());
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		updateLabelText();
	}
}
