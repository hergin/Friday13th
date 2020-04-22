import java.time.DayOfWeek;
import java.time.LocalDate;

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
        if (aDate.getDayOfWeek().getValue() == 5 && aDate.getDayOfMonth() == 13) {
            return aDate;
        } else {
            LocalDate backOneDay = aDate.minusDays(1);
            return findPreviousFriday13th(backOneDay);
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
        LocalDate currentDate = LocalDate.of(year, 1,1);
        LocalDate lastDate = LocalDate.of(year, 12, 31);

        while (currentDate.isBefore(lastDate)) {
            if (currentDate.getDayOfWeek().getValue() == 5 && currentDate.getDayOfMonth() == 13) {
                total++;
            }
            currentDate = currentDate.plusDays(1);
        }
        return total;
    }

}
