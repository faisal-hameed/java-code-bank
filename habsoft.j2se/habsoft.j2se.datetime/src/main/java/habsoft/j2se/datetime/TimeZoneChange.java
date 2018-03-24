package habsoft.j2se.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class TimeZoneChange {
    public static void main(String[] args) {
        ZoneId zoneId = ZoneId.of("GMT+3");

        Date cd = new Date(118, 01, 3);
        // System.out.println(cd);
        LocalDateTime ldt = LocalDateTime.ofInstant(cd.toInstant(), ZoneId.systemDefault());
        System.out.println("Local DT : " + ldt);

        LocalDate ld = LocalDate.now();
        System.out.println("local date : " + ld);

        ZonedDateTime startDate = ld.atStartOfDay().atZone(zoneId);
        System.out.println("Start Date : " + startDate);

        ZonedDateTime endDate = ld.atStartOfDay().plusDays(1).minusSeconds(1).atZone(zoneId);
        System.out.println("End Date : " + endDate);

        ZonedDateTime zdt = ZonedDateTime.now(zoneId);
        System.out.println("Karachi time : " + zdt);

    }
}
