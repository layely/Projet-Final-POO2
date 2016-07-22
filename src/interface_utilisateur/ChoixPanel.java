package interface_utilisateur;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import objet.Eleve;
import utilitaire.Outil;
import databaseDAOs.DAO_Eleve;
import databaseDAOs.DAO_Resultat;
import net.miginfocom.swing.MigLayout;

import java.awt.Font;

public class ChoixPanel extends JPanel {
	private ArrayList<JToggleButton> allButtonsChoix;

	
	protected JLabel lblChoix;
	protected JLabel lblChoix_1;
	protected JLabel lblChoix_2;
	protected JToggleButton buttonChoix1;
	protected JToggleButton buttonChoix2;
	protected JToggleButton buttonChoix3;
	protected JButton btnValider;
	protected JButton btnAnnuler;
	protected JLabel lblX;
	protected JToggleButton buttonChoix4;

	JPanel parentPanel;
	DAO_Eleve eleveDAO;
	DAO_Resultat resultatDAO;
	private JLabel lblChoix_3;
	
	
	/**
	 * Create the panel.
	 */
	public ChoixPanel(JPanel parent) {
		this.setBackground(Outil.CENTER_PANE_COLOR);
		parentPanel = parent;
		eleveDAO = new DAO_Eleve();
		resultatDAO = new DAO_Resultat();
		initialize();
	}

	private void initialize() {
		setLayout(new MigLayout("", "[grow,right][20px][190px,fill][][190px][grow]", "[40px][50px,fill][40px][30px][30px][30px][20px][30px][20px:40px:40px,grow][30px]"));
		
		this.lblChoix_3 = new JLabel("Choix (3/4)");
		this.lblChoix_3.setFont(new Font("Footlight MT Light", Font.PLAIN, 26));
		add(this.lblChoix_3, "cell 0 1 2097051 1,alignx center");

		this.lblChoix = new JLabel("Choix 1 :");
		this.lblChoix.setFont(new Font("Footlight MT Light", Font.PLAIN, 17));
		this.lblChoix.setHorizontalAlignment(SwingConstants.RIGHT);
		add(this.lblChoix, "cell 0 3,grow");

		this.lblChoix_1 = new JLabel("Choix 2 :");
		this.lblChoix_1.setFont(new Font("Footlight MT Light", Font.PLAIN, 17));
		this.lblChoix_1.setHorizontalAlignment(SwingConstants.RIGHT);
		add(this.lblChoix_1, "cell 0 4,grow");

		this.lblChoix_2 = new JLabel("Choix 3 :");
		this.lblChoix_2.setFont(new Font("Footlight MT Light", Font.PLAIN, 17));
		this.lblChoix_2.setHorizontalAlignment(SwingConstants.RIGHT);
		add(this.lblChoix_2, "cell 0 5,grow");

		this.buttonChoix1 = new JToggleButton();
		this.buttonChoix1.setFont(new Font("Footlight MT Light", Font.PLAIN, 17));
		this.buttonChoix1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_buttonChoix1_actionPerformed(e);
			}
		});
		this.buttonChoix1.setHorizontalAlignment(SwingConstants.CENTER);
		this.buttonChoix1.setBackground(new Color(0, 153, 255));
		this.buttonChoix1.setText("Série L");
		add(this.buttonChoix1, "cell 2 3 3 1");

		this.buttonChoix2 = new JToggleButton();
		this.buttonChoix2.setFont(new Font("Footlight MT Light", Font.PLAIN, 17));
		this.buttonChoix2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_buttonChoix2_actionPerformed(e);
			}
		});
		this.buttonChoix2.setHorizontalAlignment(SwingConstants.CENTER);
		this.buttonChoix2.setBackground(new Color(0, 153, 255));
		this.buttonChoix2.setText("Série S");
		add(this.buttonChoix2, "cell 2 4 3 1");

		this.buttonChoix3 = new JToggleButton();
		this.buttonChoix3.setFont(new Font("Footlight MT Light", Font.PLAIN, 17));
		this.buttonChoix3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_buttonChoix3_actionPerformed(e);
			}
		});
		this.buttonChoix3.setHorizontalAlignment(SwingConstants.CENTER);
		this.buttonChoix3.setBackground(new Color(0, 153, 255));
		this.buttonChoix3.setText("Série G");
		add(this.buttonChoix3, "cell 2 5 3 1");

		this.btnValider = new JButton("Suivant");
		this.btnValider.setFont(new Font("Footlight MT Light", Font.PLAIN, 17));
		this.btnValider.addActionListener(new BtnValiderActionListener());
		add(this.btnValider, "cell 2 9,alignx right,growy");

		this.btnAnnuler = new JButton("Precendent");
		this.btnAnnuler.setFont(new Font("Footlight MT Light", Font.PLAIN, 17));
		this.btnAnnuler.addActionListener(new BtnAnnulerActionListener());
		add(this.btnAnnuler, "cell 4 9,grow");

		this.lblX = new JLabel("Non choisie :\r\n");
		this.lblX.setFont(new Font("Footlight MT Light", Font.PLAIN, 17));
		add(this.lblX, "cell 0 7,alignx right,growy");

		this.buttonChoix4 = new JToggleButton();
		this.buttonChoix4.setFont(new Font("Footlight MT Light", Font.PLAIN, 17));
		this.buttonChoix4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_buttonChoix4_actionPerformed(e);
			}
		});
		this.buttonChoix4.setHorizontalAlignment(SwingConstants.CENTER);
		this.buttonChoix4.setBackground(new Color(0, 153, 255));
		this.buttonChoix4.setText("Série T");
		add(this.buttonChoix4, "cell 2 7 3 1");
		
		initAllButtonsChoixArray();
	}

	private class BtnValiderActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			String choix1 = buttonChoix1.getText().split(" ")[1];
			String choix2 = buttonChoix2.getText().split(" ")[1];
			String choix3 = buttonChoix3.getText().split(" ")[1];

			String choix = choix1 + choix2 + choix3;
			IdentificationPanel.dernierIdentifie.setChoix(choix);
			((IdentificationFrame) parentPanel).suivant();

//			parentPanel.dispose();
		}
	}

	private class BtnAnnulerActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			((IdentificationFrame) parentPanel).precedent();
		}
	}
	
	protected void do_buttonChoix1_actionPerformed(ActionEvent e) {
		buttonChoixEvent((JToggleButton)e.getSource());
	}
	
	private void initAllButtonsChoixArray() {
		allButtonsChoix = new ArrayList<>();
		allButtonsChoix.add(buttonChoix1);
		allButtonsChoix.add(buttonChoix2);
		allButtonsChoix.add(buttonChoix3);
		allButtonsChoix.add(buttonChoix4);
	}
	
	private void disableAllButtonsChoix() {
		for(JToggleButton t : allButtonsChoix) {
			t.setSelected(false);
		}
	}
	
	private void buttonChoixEvent(JToggleButton e) {
		String textSource = null;
		for(JToggleButton t : allButtonsChoix) {
			if(t.isSelected() && t != e) {
				textSource = t.getText();
				t.setText(e.getText());
				e.setText(textSource);
				disableAllButtonsChoix();
			}
		}
		
	}
 	
	protected void do_buttonChoix2_actionPerformed(ActionEvent e) {
		buttonChoixEvent((JToggleButton)e.getSource());
	}
	protected void do_buttonChoix3_actionPerformed(ActionEvent e) {
		buttonChoixEvent((JToggleButton)e.getSource());
	}
	protected void do_buttonChoix4_actionPerformed(ActionEvent e) {
		buttonChoixEvent((JToggleButton)e.getSource());
	}

	public void loadEleve(Eleve eleve) {
		buttonChoix1.setText("Série " + eleve.getChoix1());
		buttonChoix2.setText("Série " + eleve.getChoix2());
		buttonChoix3.setText("Série " + eleve.getChoix3());
		
		buttonChoix4.setText("Série " + eleve.getNonChoisi());
	}
}
