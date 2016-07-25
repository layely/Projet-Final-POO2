package utilitaire;

import interface_utilisateur.MainFrame;

import java.awt.Color;
import java.awt.EventQueue;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import objet.Ecole;
import objet.Inspection;
import databaseDAOs.DAO_Ecole;
import databaseDAOs.DAO_Inspection;

public class Outil {

	public static final Color CENTER_PANE_COLOR = new Color(250, 240, 230);
	public static final String PROFILE_ECOLE = "ECOLE";
	public static final String PROFILE_INSPECTION = "INSPECTION";
	
	private static String profileName;
	private static String profileType;
	
	public static Calendar stringToCalendar(String str) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(sdf.parse(str));
		return gc;
	}

	public static String calendarToString(Calendar c) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(c.getTime());
	}
	
	private static boolean showOptionDialog(JComponent parentComponent, String message, String title, int optionType, int messageType, 
			Icon icon, Object[] options, Object initialValue) {
		int value = JOptionPane.showOptionDialog(parentComponent, message, title, 
				optionType, messageType, icon, options, initialValue);
		System.out.println("value : " + value);
		if(value == 0) 
			return true;
		return false;
	}
	
	public static boolean showConfirmationDialog(JComponent parentComponent) {
		String[] options = {"OUI", "NON"};
		return showOptionDialog(parentComponent, "Voulez vouz confirmer", "Confirmation", JOptionPane.YES_NO_OPTION, 
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
	}

	public static boolean getConnection(String login, String pass) {
		ArrayList<Ecole> listEcoles = new DAO_Ecole().getAllEcole();
		for(Ecole ecole : listEcoles) {
			if(ecole.getNom().equals(login) && ecole.getMotDePasse().equals(pass)) {
				profileName = login;
				profileType = PROFILE_ECOLE;
				return true;
			}
		}
		
		ArrayList<Inspection> listInspections = new DAO_Inspection().getAllInspection();
		for(Inspection inspection : listInspections) {
			if(inspection.getNom().equals(login) && inspection.getMot().equals(pass)) {
				profileName = login;
				profileType = PROFILE_INSPECTION;
				return true;
			}
		}
		return false;
	}

	public static String getProfileName() {
		return profileName;
	}


	public static String getProfileType() {
		return profileType;
	}

	public static void openHome() {
		final JFrame home = new MainFrame();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//TODO
	}
	
}
