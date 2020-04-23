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
        LocalDate theDate = aDate;
            if (theDate.getDayOfMonth() == 13 || theDate.getDayOfWeek() == DayOfWeek.FRIDAY) {
                    return theDate;
                } else{
                while (theDate.getDayOfMonth() != 13 || theDate.getDayOfWeek() != DayOfWeek.FRIDAY) {
                    theDate.minusDays(1);
                }
            }
            return theDate;
        }


    /**
     * Return the number of friday 13ths in a given year.
     * Simply count the friday 13ths starting from Jan 1st until Dec 31st in that given year.
     *
     * @param year
     * @return
     */
    public static int howManyFriday13ths(int year) {
        int numOfFriday13ths= 0;
        LocalDate theDate = LocalDate.of(year,1,13);
        for (int i=0; i < 12; i++) {
            if (theDate.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
                numOfFriday13ths++;
            }
            theDate = theDate.plusMonths(1);
        }
        return numOfFriday13ths;
    }
}
