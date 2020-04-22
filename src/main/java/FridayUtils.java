import java.text.SimpleDateFormat;
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
        // TODO
       if (aDate.getDayOfWeek().getValue() == 5 && aDate.getDayOfMonth() == 13){
           return aDate;
       }else {
          LocalDate minusDay = aDate.minusDays(1);
          return findPreviousFriday13th(minusDay);
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
        // TODO
        int counter = 0;
        LocalDate localDate = LocalDate.of(year,12,31);
        while (true){
            if (localDate.getDayOfWeek() == DayOfWeek.FRIDAY && localDate.getDayOfMonth() == 13){
            counter += 1;
        }
        else{
            if (localDate.getYear() != year){
                break;
            }
            }
        localDate = localDate.minusDays(1);
        }

        return counter;
    }

}
