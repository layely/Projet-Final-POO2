package utilitaire;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Outil {

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
}
