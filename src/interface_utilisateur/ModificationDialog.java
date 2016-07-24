package interface_utilisateur;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import objet.Ecole;
import objet.Eleve;
import objet.Lycee;
import tablemodels.MyTableModel;

public class ModificationDialog extends JDialog {

	public static ModificationDialog modificationEleveDialog = null;
	private MyTableModel tableModel = null;

	// public ModificationDialog(JFrame parent, Eleve eleve) {
	// super(parent, true);
	// modificationEleveDialog = this;
	// int x = parent.getX();
	// int y = parent.getY();
	// this.setLocation(x, y);
	// this.setLayout(new BorderLayout());
	// this.add(new IdentificationFrame(eleve), BorderLayout.CENTER);
	// this.pack();
	// }


	public ModificationDialog(JFrame parent, JPanel parentPanel, Eleve eleve,
			MyTableModel model) {
		super(parent, true);
		initialize(parentPanel, model);
		this.setTitle("Modification de l'élève :   " + eleve.getNumTable()
				+ " -- " + eleve.getPrenom() + " " + eleve.getNom());
		this.add(new IdentificationFrame(eleve), BorderLayout.CENTER);
	}

	public ModificationDialog(JFrame parent, JPanel parentPanel, Ecole ecole,
			MyTableModel model) {
		super(parent, true);
		initialize(parentPanel, model);
		this.setTitle("Modification de l'école :   " + ecole.getNom());
		this.add(new AjouterEcolePanel(parent, ecole), BorderLayout.CENTER);
	}
	
	public ModificationDialog(JFrame parent, JPanel parentPanel, Lycee lycee,
			MyTableModel model) {
		super(parent, true);
		initialize(parentPanel, model);
		this.setTitle("Modification du lycée :   " + lycee.getNom());
		this.add(new AjoutLyceePanel(parent, lycee), BorderLayout.CENTER);
	}
	
	public void initialize(JPanel parentPanel, MyTableModel model) {
		modificationEleveDialog = this;
		this.tableModel = model;
		this.setLayout(new BorderLayout());
		this.setBounds(parentPanel.getBounds());
		this.setLocationRelativeTo(parentPanel);
	}

	@Override
	public void dispose() {
		tableModel.reload();
		super.dispose();
	}

}
