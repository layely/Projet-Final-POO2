package utilitaire;

import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

public class Outil {

	public static final Color CENTER_PANE_COLOR = new Color(250, 240, 230);

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
}
