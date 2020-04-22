import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FridayUtils {

    /**
     * Find the date of the last Friday the 13th before the given parameter.
     * Go back one by one to find that.
     * If the given parameter is a 13th Friday, return it.
     *
     * @param aDate
     * @return
     */
    public static LocalDate findPreviousFriday13th(LocalDate aDate) {
        if (aDate.getDayOfWeek().getValue() == 5 && aDate.getDayOfMonth() == 13){
            return aDate;
        }
        else{
            LocalDate back = aDate.minusDays(1);
            return findPreviousFriday13th(back);
        }
    }
    /**
     * Return the number of friday 13ths in a given year.
     * Simply count the friday 13ths starting from Jan 1st until Dec 31st in that given year.
     *
     * @param year
     * @return
     */
    public static int howManyFriday13ths(int year) {
        int total = 0;
        LocalDate current = LocalDate.of(year, 1,1);
        LocalDate lastDate = LocalDate.of(year, 12, 31);

        while (current.isBefore(lastDate)) {
            if (current.getDayOfWeek().getValue() == 5 && current.getDayOfMonth() == 13) {
                total++;
            }
            current = current.plusDays(1);
        }
        return total;
    }

}
