import javax.swing.UIManager;

import interface_utilisateur.SplashScreen;


public class Main {

	public static void main(String[] args) {
		try {
			UIManager
					.setLookAndFeel("de.muntjak.tinylookandfeel.TinyLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		// Throw a nice little title page up on the screen first
				SplashScreen splash = new SplashScreen(5000);
				// Normally, we'd call splash.showSplash() and get on with the program.
				// But, since this is only a test...
				splash.showSplashAndExit();
	}
}
