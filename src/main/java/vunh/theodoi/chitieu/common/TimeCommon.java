package vunh.theodoi.chitieu.common;

import org.apache.logging.log4j.util.Strings;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;

public class TimeCommon {
    private static final DateTimeFormatter FORMATTER_yyyyMMdd = DateTimeFormatter.ofPattern("yyyyMMdd");
    public static LocalDate getLocalDate(String date) {
        try {
            return LocalDate.parse(date, FORMATTER_yyyyMMdd);
        } catch (DateTimeParseException e) {
            throw new DateTimeParseException("Invalid date:", date, 0);
        }
    }

    public static boolean formatYYYY_MM_DD(String date) {
        if (Strings.isEmpty(date))
            return false;

        try {
            LocalDate.parse(date, FORMATTER_yyyyMMdd);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

    public static String formatMonth(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("yyyyMM"));
    }
}
