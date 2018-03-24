package habsoft.j2se.datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class OtherJava8Classes {
    public static void main(String[] args) {
        ZonedDateTime zdt = ZonedDateTime.now();
        System.out.println("Zoned D/T: " + zdt);

        OffsetDateTime odt = zdt.toOffsetDateTime();
        System.out.println("Offset D/T : " + odt);

        Instant ct = Instant.now();
        System.out.println("Current Time : " + ct);

        ZoneId id = ZoneId.of("UTC");
        System.out.println(id);

        Date dd = new Date();
        ZonedDateTime zdt2 = dd.toInstant().atZone(id);

        LocalDate ldt = zdt2.toLocalDate();
        LocalDateTime startDate = ldt.atStartOfDay();
        System.out.println("Start Date : " + startDate);

        LocalDateTime endDate = startDate.plusDays(1).minusNanos(1);
        System.out.println("End Date : " + endDate);

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            TimeZone tz = TimeZone.getTimeZone("UTC");

            sdf.setTimeZone(tz);
            Calendar cal = Calendar.getInstance();
            cal.setTimeZone(tz);
            cal.setTime(sdf.parse("2017-11-11 20:47:33"));
            System.out.println(cal.getTime());
            System.out.println(cal.getTimeZone().getID());
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // new Date().from(endDate.)

        // System.out.println(ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT));

    }
}
