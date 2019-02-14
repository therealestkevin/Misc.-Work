package test.test1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateTest {
	public static void main (String[]args) throws ParseException {
		String dateString = "Feb 11,2019 3:24:20 PM";
		String dateString2 = "Feb 11,2019 3:24:22 PM";
		DateFormat format = new SimpleDateFormat("MMM d,yyyy HH:mm:ss aa");
		Date date = format.parse(dateString);
		Date date2 = format.parse(dateString2);
		System.out.println(date);
		
	}
}
