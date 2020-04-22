import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
        LocalDate currentDate = aDate;
        while (currentDate.getDayOfWeek() != DayOfWeek.FRIDAY || currentDate.getDayOfMonth() != 13){
            currentDate = currentDate.minusDays(1);
        }
        return currentDate;
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
        int frequency=0;
        LocalDate currentDate = LocalDate.of(year, 12, 31); //Last day of the year
        while ( true ){
            if (currentDate.getYear() != year){
                break;
            }else {
                if (currentDate.getDayOfWeek() == DayOfWeek.FRIDAY && currentDate.getDayOfMonth() == 13){
                    frequency +=1;
                }
                currentDate = currentDate.minusDays(1);
            }
        }
        return frequency;
    }

}
