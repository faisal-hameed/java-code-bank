package habsoft.j2se.datetime;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Java8DateTest {
    public static void main(String[] args) {

        // Print current Date
        LocalDate cd = LocalDate.now();
        System.out.println("Current Date : " + cd);

        // Yesterday date
        System.out.println(cd.plusDays(-1));

        // Date from values
        LocalDate dob = LocalDate.of(1990, 1, 1);
        System.out.println("My DOB : " + dob);

        // Day
        System.out.println(dob.getDayOfWeek());

        // Date from String
        String date = "2016-07-01";
        DateTimeFormatter fm = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate pd = LocalDate.parse(date, fm);
        System.out.println("Parsed date : " + pd);

        // GMT date
        LocalDate gmt = LocalDate.now(ZoneId.of("GMT+0"));
        System.out.println("GMT date : " + gmt);

        // Date after 3 months
        LocalDate d3m = LocalDate.now().plus(3, ChronoUnit.MONTHS);
        System.out.println("Date after 3 months : " + d3m);

        Period d = Period.between(gmt, dob);
        System.out.println("My age till today : " + d);

    }

}
