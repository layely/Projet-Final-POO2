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
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

import org.jdesktop.swingx.JXImageView;

import utilitaire.Outil;

public class SplashScreen extends JWindow {
	private int duration;

	public SplashScreen(int d) {
		duration = d;
	}

	// A simple little method to show a title screen in the center
	// of the screen for the amount of time given in the constructor
	public void showSplash() {
		JPanel content = (JPanel) getContentPane();
		content.setBackground(Outil.CENTER_PANE_COLOR);

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

		JXImageView imageView = new JXImageView();
		JLabel copyrt = new JLabel("Copyright 2016, A. LY & A. SOW & F. BA & Y. SY",
				JLabel.CENTER);
		copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 12));
		
		JLabel title = new JLabel("GESTIONNAIRE DES ORIENTATIONS POST-BFEM",
				JLabel.CENTER);
		
		content.add(imageView, BorderLayout.CENTER);
		content.add(copyrt, BorderLayout.SOUTH);
		content.add(title, BorderLayout.NORTH);
		Color oraRed = new Color(156, 20, 20, 255);
		content.setBorder(BorderFactory.createLineBorder(
				new Color(0, 153, 255), 10));

		// Display it
		setVisible(true);

		Image scaledImage = image.getScaledInstance(imageView.getWidth(),
				imageView.getHeight(), Image.SCALE_SMOOTH);
		imageView.setImage(scaledImage);
		// Wait a little while, maybe while loading resources
		try {
			Thread.sleep(duration);
		} catch (Exception e) {
		}

		setVisible(false);
	}

	public void showSplashAndExit() {
		showSplash();
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
