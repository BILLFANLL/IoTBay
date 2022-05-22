package uts.isd.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

	public static String getDateTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date d = new Date();
		String str = sdf.format(d); 
		return str;
	}
}
