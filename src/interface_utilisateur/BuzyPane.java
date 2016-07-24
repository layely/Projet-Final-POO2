package interface_utilisateur;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import org.jdesktop.swingx.JXBusyLabel;

import utilitaire.Outil;

import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Component;

import javax.swing.DebugGraphics;

public class BuzyPane extends JPanel {
	private final JXBusyLabel bslblChargement = new JXBusyLabel();

	/**
	 * Create the panel.
	 */
	public BuzyPane() {

		initialize();
	}
	private void initialize() {
		this.setBackground(Outil.CENTER_PANE_COLOR);
		setLayout(new BorderLayout(0, 0));
		this.bslblChargement.setSize(new Dimension(60, 60));
		this.bslblChargement.setPreferredSize(new Dimension(60, 60));
		this.bslblChargement.setIconTextGap(5);
		this.bslblChargement.setVerticalTextPosition(SwingConstants.BOTTOM);
		this.bslblChargement.setText("Chargement");
		this.bslblChargement.setDelay(80);
		this.bslblChargement.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.bslblChargement.setForeground(new Color(51, 153, 204));
		this.bslblChargement.setHorizontalTextPosition(SwingConstants.CENTER);
		this.bslblChargement.setMinimumSize(new Dimension(60, 60));
		this.bslblChargement.setMaximumSize(new Dimension(60, 60));
		this.bslblChargement.setName("hello");
		this.bslblChargement.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.bslblChargement.setHorizontalAlignment(SwingConstants.CENTER);
		this.bslblChargement.setBusy(true);
		
		add(this.bslblChargement, BorderLayout.CENTER);
	}

}
