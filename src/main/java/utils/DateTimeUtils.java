package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;

public class DateTimeUtils {

    public static String getCurrentDate(String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String getCurrentDateMinusDays(long days) {
        LocalDate date;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        date = LocalDate.now().minusDays(days);
        return date.format(formatter);
    }

    public static String getCurrentDatePlusDays(long days) {
        LocalDate date;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        date = LocalDate.now().plusDays(days);
        return date.format(formatter);
    }

    public static String getCurrentDatePlusMonths(long months) {
        LocalDate date;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        date = LocalDate.now().plusMonths(months);
        return date.format(formatter);
    }

    public static String convertDateFormat(String date, String pattern)
    {

        DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern(pattern)
                .toFormatter();

        LocalDate parsedDate = LocalDate.parse(date, formatter);
        DateTimeFormatter formatterResult = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String newDate = parsedDate.format(formatterResult);

        return newDate;
    }
}
