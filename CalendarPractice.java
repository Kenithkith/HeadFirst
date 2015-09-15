import java.util.Calendar;
import java.util.Date;


public class CalendarPractice {

	public static void main(String[] args) {
		
		Date today = new Date();

		System.out.println(today);
		
		System.out.println("Today is " + String.format("%tA, %<tB %<td.", today));
		System.out.println();
		
		
		Calendar cal = Calendar.getInstance();
		
		// Set time to January 7, 2004 at 3:40pm.
		cal.set(2004, 0, 7, 15, 40);
		System.out.println("Set day and time is:  " + cal.getTime());
		
		// Convert this to a big ol' amount of milliseconds.
		long day1 = cal.getTimeInMillis();
		
		// Add an hours worth of milliseconds, then update the time.
		day1 += 1000 * 60 * 60;
		cal.setTimeInMillis(day1);
		System.out.println("New hour: " + cal.get(cal.HOUR_OF_DAY));
		
		// Add 35 days to the date, which should move us into February.
		cal.add(cal.DATE, 35);
		System.out.println("Added 35 days - new date: " + cal.getTime());
		
		// "Roll" 35 days onto this date.  This "rolls" the date ahead 35 days,
		//  but DOES NOT change the month!
		cal.roll(cal.DATE, 35);
		System.out.println("Rolled 35 days - new date: " + cal.getTime());
		
		// We're not incrementing here, just doing a "set" of the date.
		cal.set(cal.DATE, 1);
		System.out.println("Set to 1: " + cal.getTime());
	
	}
}
