package habsoft.j2se.datetime;

import java.time.Clock;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Java8TimeTest {
	public static void main(String[] args) {
		
		// Current Time
		LocalTime clt = LocalTime.now();
		System.out.println("Current Local Time : "+clt);
		
		// Different Clock
		Clock utcClock = Clock.tickMinutes(ZoneId.systemDefault());
		LocalTime clockTime = LocalTime.now(utcClock);
		System.out.println("UTC clock time without seconds : "+clockTime);
		
		// Time from string
		String time = "02:05:30.500 AM";
		String pattern = "hh:mm:ss.SSS a" ;
		
		LocalTime tt = LocalTime.parse(time, DateTimeFormatter.ofPattern(pattern));
		System.out.println("Time from string : "+tt);
		
	}
}
