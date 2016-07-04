package habsoft.j2se.datetime;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;

public class OtherJava8Classes {
	public static void main(String[] args) {
		ZonedDateTime zdt = ZonedDateTime.now();
		System.out.println("Zoned D/T: " + zdt);

		OffsetDateTime odt = zdt.toOffsetDateTime();
		System.out.println("Offset D/T : " + odt);

		Instant ct = Instant.now();
		System.out.println("Current Time : " + ct);

	}
}
