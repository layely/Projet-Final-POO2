package interface_utilisateur;

import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;
import javax.swing.JPanel;

import utilitaire.Outil;

public class IdentificationFrame extends JPanel {

	/**
	 * Create the panel
	 */

	final String PAGE_IDENFTICATION = "identification";
	final String PAGE_RESULTAT = "resultat";
	final String PAGE_CHOIX = "choix";
	final String PAGE_INFO_ELEVE = "infoEleve";

	ArrayList<String> pages = new ArrayList<>(3);

	JPanel panelIdentif = new IdentificationPanel(this);
	JPanel panelResutat = new ResultatPanel(this);
	JPanel panelChoix = new ChoixPanel(this);
	JPanel panelInfoEleve = new InfoElevePanel(this);

	int currentPage = 0;

	public IdentificationFrame() {
		Collections.addAll(pages, PAGE_IDENFTICATION, PAGE_RESULTAT, PAGE_CHOIX);
		this.setBackground(Outil.CENTER_PANE_COLOR);
		initialize();
	}

	private void initialize() {
//		setTitle("Identification");
		setBounds(100, 100, 700, 400);
//		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new CardLayout());
		add(PAGE_IDENFTICATION, panelIdentif);
		add(PAGE_RESULTAT, panelResutat);
		add(PAGE_CHOIX, panelChoix);
		add(PAGE_INFO_ELEVE, panelInfoEleve);

	}

	public void suivant() {
		CardLayout layout = (CardLayout) this.getLayout();
		layout.next(this);
	}

	public void precedent() {
		CardLayout layout = (CardLayout) this.getLayout();
		layout.previous(this);
	}

	public static void main(String[] args) {
		new IdentificationFrame().setVisible(true);
	}
}