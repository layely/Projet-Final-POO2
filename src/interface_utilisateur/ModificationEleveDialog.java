package interface_utilisateur;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import objet.Eleve;
import tablemodels.EleveModel;

public class ModificationEleveDialog extends JDialog {

	public static ModificationEleveDialog modificationEleveDialog = null;
	private EleveModel eleveModel = null;
	
	
	public ModificationEleveDialog(JFrame parent, Eleve eleve) {
		super(parent, true);
		modificationEleveDialog = this;
		int x = parent.getX();
		int y = parent.getY();
		this.setLocation(x, y);
		this.setLayout(new BorderLayout());
		this.add(new IdentificationFrame(eleve), BorderLayout.CENTER);
		this.pack();
	}

	public ModificationEleveDialog(JFrame parent, JPanel parentPanel,
			Eleve eleve, EleveModel eleveModel) {
		super(parent, true);
		modificationEleveDialog = this;
		this.eleveModel = eleveModel;
		this.setLayout(new BorderLayout());
		this.setTitle("Modification de l'élève :   " + eleve.getNumTable()
				+ " -- " + eleve.getPrenom() + " " + eleve.getNom());
		this.add(new IdentificationFrame(eleve), BorderLayout.CENTER);
		this.setBounds(parentPanel.getBounds());
		this.setLocationRelativeTo(parentPanel);
	}

	@Override
	public void dispose() {
		eleveModel.reload();
		super.dispose();
	}

}
