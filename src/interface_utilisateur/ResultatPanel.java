package interface_utilisateur;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import objet.Resultat;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class ResultatPanel extends JPanel {
	protected JLabel lblSaisieDeNotes;
	protected JLabel lblD;
	protected JTextField textFieldFrancais;
	protected JLabel lblD_1;
	protected JTextField textFieldMaths;
	protected JRadioButton rdbtnTour1;
	protected JRadioButton rdbtnTour2;
	protected JRadioButton rdbtnEchec;
	protected JButton btnValider;
	protected JButton btnPrcdent;
	protected JTextField textFieldMoyGenerale;
	protected JLabel lblNewLabel;
	protected JLabel lblRsultatDuBfem;
	protected JLabel lblHistogo;
	protected JTextField textFieldHistGeo;
	protected JTextField textFieldSVT;
	protected JLabel lblPc;
	protected JLabel lblSvt;
	protected JTextField textFieldPC;
	protected final ButtonGroup buttonGroup = new ButtonGroup();

	private JFrame parentframe;

	/**
	 * Create the panel.
	 */
	public ResultatPanel(JFrame parent) {
		parentframe = parent;
		initialize();
	}

	private void initialize() {
		setLayout(null);

		this.lblSaisieDeNotes = new JLabel("Résultat scolaire");
		this.lblSaisieDeNotes.setBounds(76, 26, 278, 31);
		add(this.lblSaisieDeNotes);

		this.lblD = new JLabel("Français");
		this.lblD.setBounds(39, 69, 83, 15);
		add(this.lblD);

		this.textFieldFrancais = new JTextField();
		this.textFieldFrancais.setBounds(183, 67, 114, 19);
		add(this.textFieldFrancais);
		this.textFieldFrancais.setColumns(10);

		this.lblD_1 = new JLabel("Mathématiques");
		this.lblD_1.setBounds(39, 95, 117, 15);
		add(this.lblD_1);

		this.textFieldMaths = new JTextField();
		this.textFieldMaths.setBounds(183, 93, 114, 19);
		add(this.textFieldMaths);
		this.textFieldMaths.setColumns(10);

		this.rdbtnTour1 = new JRadioButton("1er tour");
		this.rdbtnTour1.setSelected(true);
		this.buttonGroup.add(this.rdbtnTour1);
		this.rdbtnTour1.setBounds(45, 332, 94, 23);
		add(this.rdbtnTour1);

		this.rdbtnTour2 = new JRadioButton("2ème tour");
		this.buttonGroup.add(this.rdbtnTour2);
		this.rdbtnTour2.setBounds(145, 332, 108, 23);
		add(this.rdbtnTour2);

		this.rdbtnEchec = new JRadioButton("Echec");
		this.buttonGroup.add(this.rdbtnEchec);
		this.rdbtnEchec.setBounds(276, 332, 94, 23);
		add(this.rdbtnEchec);

		this.btnValider = new JButton("Valider");
		this.btnValider.addActionListener(new BtnValiderActionListener());
		this.btnValider.setBounds(251, 376, 117, 25);
		add(this.btnValider);

		this.btnPrcdent = new JButton("Précédent");
		this.btnPrcdent.addActionListener(new BtnPrcdentActionListener());
		this.btnPrcdent.setBounds(396, 376, 117, 25);
		add(this.btnPrcdent);

		this.textFieldMoyGenerale = new JTextField();
		this.textFieldMoyGenerale.setBounds(197, 258, 114, 19);
		add(this.textFieldMoyGenerale);
		this.textFieldMoyGenerale.setColumns(10);

		this.lblNewLabel = new JLabel("Moyenne générale");
		this.lblNewLabel.setBounds(42, 260, 137, 15);
		add(this.lblNewLabel);

		this.lblRsultatDuBfem = new JLabel("Résultat du BFEM");
		this.lblRsultatDuBfem.setBounds(53, 309, 150, 15);
		add(this.lblRsultatDuBfem);

		this.lblHistogo = new JLabel("Histo-Géo");
		this.lblHistogo.setBounds(39, 122, 70, 15);
		add(this.lblHistogo);

		this.textFieldHistGeo = new JTextField();
		this.textFieldHistGeo.setBounds(183, 124, 114, 19);
		add(this.textFieldHistGeo);
		this.textFieldHistGeo.setColumns(10);

		this.textFieldSVT = new JTextField();
		this.textFieldSVT.setBounds(183, 155, 114, 19);
		add(this.textFieldSVT);
		this.textFieldSVT.setColumns(10);

		this.lblPc = new JLabel("PC");
		this.lblPc.setBounds(39, 184, 70, 15);
		add(this.lblPc);

		this.lblSvt = new JLabel("SVT");
		this.lblSvt.setBounds(39, 157, 70, 15);
		add(this.lblSvt);

		this.textFieldPC = new JTextField();
		this.textFieldPC.setBounds(183, 186, 114, 19);
		add(this.textFieldPC);
		this.textFieldPC.setColumns(10);
	}

	private class BtnValiderActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String strNoteFr = textFieldFrancais.getText();
			double noteFr = Double.parseDouble(strNoteFr);
			String strNoteMaths = textFieldMaths.getText();
			double noteMaths = Double.parseDouble(strNoteMaths);
			String strNoteHistoGeo = textFieldHistGeo.getText();
			double noteHistoGeo = Double.parseDouble(strNoteHistoGeo);
			String strNoteSVT = textFieldSVT.getText();
			double noteSVT = Double.parseDouble(strNoteSVT);
			String strNotePC = textFieldPC.getText();
			double notePC = Double.parseDouble(strNotePC);
			String strMoyGenerale = textFieldMoyGenerale.getText();
			double moyGenerale = Double.parseDouble(strMoyGenerale);

			int passageExam = -1;
			if (rdbtnTour1.isSelected())
				passageExam = Resultat.TOUR_1;
			else if (rdbtnTour2.isSelected())
				passageExam = Resultat.TOUR_2;
			else
				passageExam = Resultat.ECHEC;

			Resultat resultat = new Resultat(noteMaths, noteFr, noteSVT, noteHistoGeo, notePC, moyGenerale,
					passageExam);
			IdentificationPanel.dernierIdentifie.setResultat(resultat);
			((IdentificationFrame) parentframe).suivant();
		}
	}
	private class BtnPrcdentActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			((IdentificationFrame) parentframe).precedent();
		}
	}
}
