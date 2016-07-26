/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interface_utilisateur;

//SplashScreen.java
//A simple application to show a title screen in the center of the screen
//for the amount of time given in the constructor.  This class includes
//a sample main() method to test the splash screen, but it's meant for use
//with other applications.
//

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javafx.scene.control.Spinner;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JWindow;

import org.jdesktop.swingx.JXImageView;

import databaseDAOs.DBConnection;
import utilitaire.Outil;

import javax.swing.JProgressBar;

import net.miginfocom.swing.MigLayout;

public class SplashScreen extends JWindow {
	private int duration;
	private JProgressBar progressBar;

	public SplashScreen(int d) {
		duration = d;
		// showSplash();
	}

	// A simple little method to show a title screen in the center
	// of the screen for the amount of time given in the constructor
	public void showSplash() {
		JPanel content = (JPanel) getContentPane();
		content.setBackground(Outil.CENTER_PANE_COLOR);
		this.setAlwaysOnTop(false);

		// Set the window's bounds, centering the window
		int width = 450;
		int height = 215;
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width - width) / 2;
		int y = (screen.height - height) / 2;
		setBounds(x, y, width, height);

		// Build the splash screen
		Image image = null;
		try {
			image = ImageIO.read(new File("icon1.jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JLabel copyrt = new JLabel(
				"Copyright 2016, A. LY & A. SOW & F. BA & Y. SY", JLabel.CENTER);
		copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 12));

		JLabel title = new JLabel("GESTIONNAIRE DES ORIENTATIONS POST-BFEM",
				JLabel.CENTER);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[450px]", "[grow,fill][::20px,fill]"));

		JXImageView imageView = new JXImageView();
		panel.add(imageView, "cell 0 0,grow");

		progressBar = new JProgressBar();
		this.progressBar.setMaximum(duration);
		progressBar.setBackground(Outil.CENTER_PANE_COLOR);
		progressBar.setForeground(Outil.CENTER_PANE_BLUE);
		panel.add(progressBar, "cell 0 1,growx");
		content.add(copyrt, BorderLayout.SOUTH);
		content.add(title, BorderLayout.NORTH);
		Color oraRed = new Color(156, 20, 20, 255);
		content.setBorder(BorderFactory.createLineBorder(
				new Color(0, 153, 255), 10));

		// Display it
		setVisible(true);
		// Wait a little while, maybe while loading resources

		Image scaledImage = image.getScaledInstance(imageView.getWidth(),
				imageView.getHeight(), Image.SCALE_SMOOTH);
		imageView.setImage(scaledImage);

		loadProgressBar(duration / 3);
	}

	private void loadProgressBar(final int i) {
		try {
			Thread.sleep(duration / 3);
		} catch (Exception e) {
		}
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				progressBar.setValue(progressBar.getValue() + i);
			}
		});
	}

	public void showSplashAndExit() {
		showSplash();
		if (DBConnection.getConnection() == null) {
			String message = "Impossible d'établir la connection\n avec la base de donnée.\n";
			message += "Vérifier si votre server est en ligne";
			JOptionPane.showMessageDialog(this, message,
					"Problème de connection", JOptionPane.WARNING_MESSAGE);
			System.exit(1);
		}
		loadProgressBar(duration / 2);
		loadProgressBar(duration - (duration / 2 + duration / 3));
		this.dispose();
		new LoginFrame().setVisible(true);
	}

	public static void main(String[] args) {
		// Throw a nice little title page up on the screen first
		SplashScreen splash = new SplashScreen(5000);
		// Normally, we'd call splash.showSplash() and get on with the program.
		// But, since this is only a test...
		splash.showSplashAndExit();
	}
}
