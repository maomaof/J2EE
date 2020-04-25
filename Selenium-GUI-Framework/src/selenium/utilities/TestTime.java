package selenium.utilities;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.DateFormat;

public class TestTime {
	
	public static Calendar calendar;
	public static Date now;
	public static String getCurrentTime()
	{	now = new Date();
		return DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.MEDIUM).format(now);
		
	}
	public static long gettimemillis()
	{	calendar = new GregorianCalendar();
		
		return calendar.getTimeInMillis();
	}
	public static String getTime()
	{
		now = new Date();
		return DateFormat.getTimeInstance(DateFormat.SHORT).format(now);
	}
	
	public static long getSeconds()
	{	calendar = new GregorianCalendar();
		
		return calendar.get(calendar.SECOND);
	}

}
