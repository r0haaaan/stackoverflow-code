package in.rohaan;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
 * Code for https://stackoverflow.com/questions/66226463
 */
public class IntDateToDate {
    public static void main(String[] args) throws ParseException {
        String date1 = "22092021";
        String date2 = "03122021";

        Date d1 = getDate(date1);
        Date d2 = getDate(date2);

        if (d1.compareTo(d2) < 0) {
            System.out.println("d1 is older than d2");
        } else if (d1.compareTo(d2) > 0) {
            System.out.println("d2 is older than d1");
        } else {
            System.out.println("both are equal");
        }
        System.out.println("d1.compareTo(d2) " + d1.compareTo(d2));
        System.out.println("d2.compareTo(d1) " + d2.compareTo(d1));

        Calendar c1 = toCalendar(d1);
        System.out.printf("%d %d %d\n", c1.get(Calendar.DAY_OF_MONTH), c1.get(Calendar.MONTH), c1.get(Calendar.YEAR));

        Calendar c2 = toCalendar(d2);
        System.out.printf("%d %d %d\n", c2.get(Calendar.DAY_OF_MONTH), c2.get(Calendar.MONTH), c2.get(Calendar.YEAR));
    }

    private static Date getDate(String dateStr) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyy");
        return simpleDateFormat.parse(dateStr);
    }

    private static Calendar toCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }
}
