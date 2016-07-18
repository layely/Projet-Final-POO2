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

import utilitaire.Outil;
import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import org.jdesktop.swingx.JXTitledSeparator;

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

	private JPanel parentPanel;
	private JXTitledSeparator titledSeparator;

	/**
	 * Create the panel.
	 */
	public ResultatPanel(JPanel parent) {
		parentPanel = parent;
		this.setBackground(Outil.CENTER_PANE_COLOR);
		initialize();
	}

	private void initialize() {
		setLayout(new MigLayout("", "[grow][20px:n][180px][70px][180px][grow]", "[50px:n][31px][50px,top][30px][30px][30px][30px][30px][][30px][30px][23px][20px:50px:100px,grow][30px]"));

		this.lblSaisieDeNotes = new JLabel("Résultat scolaire (2/4)");
		this.lblSaisieDeNotes.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblSaisieDeNotes.setFont(new Font("Footlight MT Light", Font.PLAIN, 26));
		add(this.lblSaisieDeNotes, "cell 0 1 2097051 1,grow");
		
		this.titledSeparator = new JXTitledSeparator();
		this.titledSeparator.setTitle("");
		add(this.titledSeparator, "cell 0 2 2097051 1,growx,aligny top");

		this.lblD = new JLabel("Moyenne Français :");
		this.lblD.setFont(new Font("Footlight MT Light", Font.PLAIN, 17));
		this.lblD.setHorizontalAlignment(SwingConstants.RIGHT);
		add(this.lblD, "cell 0 3,growx,aligny center");
		
				this.textFieldFrancais = new JTextField();
				this.textFieldFrancais.setHorizontalAlignment(SwingConstants.CENTER);
				this.textFieldFrancais.setFont(new Font("Footlight MT Light", Font.PLAIN, 17));
				add(this.textFieldFrancais, "cell 2 3 3 1,grow");
				this.textFieldFrancais.setColumns(10);

		this.lblD_1 = new JLabel("Moyenne Mathématiques :");
		this.lblD_1.setFont(new Font("Footlight MT Light", Font.PLAIN, 17));
		this.lblD_1.setHorizontalAlignment(SwingConstants.RIGHT);
		add(this.lblD_1, "cell 0 4,alignx right");
						
								this.textFieldMaths = new JTextField();
								this.textFieldMaths.setHorizontalAlignment(SwingConstants.CENTER);
								this.textFieldMaths.setFont(new Font("Footlight MT Light", Font.PLAIN, 17));
								add(this.textFieldMaths, "cell 2 4 3 1,grow");
								this.textFieldMaths.setColumns(10);
				
						this.textFieldHistGeo = new JTextField();
						this.textFieldHistGeo.setHorizontalAlignment(SwingConstants.CENTER);
						this.textFieldHistGeo.setFont(new Font("Footlight MT Light", Font.PLAIN, 17));
						add(this.textFieldHistGeo, "cell 2 5 3 1,grow");
						this.textFieldHistGeo.setColumns(10);
				
						this.textFieldSVT = new JTextField();
						this.textFieldSVT.setHorizontalAlignment(SwingConstants.CENTER);
						this.textFieldSVT.setFont(new Font("Footlight MT Light", Font.PLAIN, 17));
						add(this.textFieldSVT, "cell 2 6 3 1,grow");
						this.textFieldSVT.setColumns(10);
				
						this.textFieldPC = new JTextField();
						this.textFieldPC.setHorizontalAlignment(SwingConstants.CENTER);
						this.textFieldPC.setFont(new Font("Footlight MT Light", Font.PLAIN, 17));
						add(this.textFieldPC, "cell 2 7 3 1,grow");
						this.textFieldPC.setColumns(10);
						
								this.textFieldMoyGenerale = new JTextField();
								this.textFieldMoyGenerale.setHorizontalAlignment(SwingConstants.CENTER);
								this.textFieldMoyGenerale.setFont(new Font("Footlight MT Light", Font.PLAIN, 17));
								add(this.textFieldMoyGenerale, "cell 2 9 3 1,grow");
								this.textFieldMoyGenerale.setColumns(10);
				
						this.lblRsultatDuBfem = new JLabel("Résultat du BFEM :");
						this.lblRsultatDuBfem.setFont(new Font("Footlight MT Light", Font.PLAIN, 17));
						this.lblRsultatDuBfem.setHorizontalAlignment(SwingConstants.RIGHT);
						add(this.lblRsultatDuBfem, "cell 0 11,alignx right");
		
				this.rdbtnTour1 = new JRadioButton("1er tour");
				this.rdbtnTour1.setFont(new Font("Footlight MT Light", Font.PLAIN, 17));
				this.rdbtnTour1.setHorizontalAlignment(SwingConstants.CENTER);
				this.rdbtnTour1.setSelected(true);
				this.buttonGroup.add(this.rdbtnTour1);
				add(this.rdbtnTour1, "cell 2 11,growx,aligny top");
		
				this.rdbtnTour2 = new JRadioButton("2ème tour");
				this.rdbtnTour2.setFont(new Font("Footlight MT Light", Font.PLAIN, 17));
				this.rdbtnTour2.setHorizontalAlignment(SwingConstants.CENTER);
				this.buttonGroup.add(this.rdbtnTour2);
				add(this.rdbtnTour2, "cell 3 11,growx,aligny top");
		
				this.rdbtnEchec = new JRadioButton("Echec");
				this.rdbtnEchec.setFont(new Font("Footlight MT Light", Font.PLAIN, 17));
				this.rdbtnEchec.setHorizontalAlignment(SwingConstants.CENTER);
				this.buttonGroup.add(this.rdbtnEchec);
				add(this.rdbtnEchec, "cell 4 11,growx,aligny top");

		this.lblNewLabel = new JLabel("Moyenne générale :");
		this.lblNewLabel.setFont(new Font("Footlight MT Light", Font.PLAIN, 17));
		this.lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		add(this.lblNewLabel, "cell 0 9,alignx right");

		this.lblHistogo = new JLabel("Histo-Géo :\r\n");
		this.lblHistogo.setFont(new Font("Footlight MT Light", Font.PLAIN, 17));
		this.lblHistogo.setHorizontalAlignment(SwingConstants.RIGHT);
		add(this.lblHistogo, "cell 0 5,alignx right,aligny center");

		this.lblPc = new JLabel("Moyenne PC :");
		this.lblPc.setFont(new Font("Footlight MT Light", Font.PLAIN, 17));
		this.lblPc.setHorizontalAlignment(SwingConstants.RIGHT);
		add(this.lblPc, "cell 0 7,growx,aligny center");

		this.lblSvt = new JLabel("Moyenne SVT :");
		this.lblSvt.setFont(new Font("Footlight MT Light", Font.PLAIN, 17));
		this.lblSvt.setHorizontalAlignment(SwingConstants.RIGHT);
		add(this.lblSvt, "cell 0 6,growx,aligny center");
				
						this.btnPrcdent = new JButton("Précédent");
						this.btnPrcdent.setFont(new Font("Footlight MT Light", Font.PLAIN, 17));
						this.btnPrcdent.addActionListener(new BtnPrcdentActionListener());
						
								this.btnValider = new JButton("Suivant\r\n");
								this.btnValider.setFont(new Font("Footlight MT Light", Font.PLAIN, 17));
								this.btnValider.addActionListener(new BtnValiderActionListener());
								add(this.btnValider, "cell 2 13,grow");
						add(this.btnPrcdent, "cell 4 13,grow");
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
			((IdentificationFrame) parentPanel).suivant();
		}
	}
	private class BtnPrcdentActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			((IdentificationFrame) parentPanel).precedent();
		}
	}
}
