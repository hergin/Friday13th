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
        if(aDate.getDayOfWeek().equals(DayOfWeek.FRIDAY) && aDate.getDayOfMonth() == 13){
            return aDate;
        }
        var tempDate = aDate;
        if(tempDate.getDayOfMonth() > 13) {
            tempDate = tempDate.withDayOfMonth(13);
        } else {
            tempDate = tempDate.withDayOfMonth(13);
            tempDate = tempDate.minusMonths(1);
        }
        while(true) {
            var tempDayOfWeek = tempDate.getDayOfWeek();
            if(tempDayOfWeek == DayOfWeek.FRIDAY){
                return tempDate;
            }
            tempDate = tempDate.minusMonths(1);
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
        LocalDate yearDate = LocalDate.of(year, 1, 1);
        yearDate = yearDate.withDayOfMonth(13);
        int amountOfFriThe13th = 0;
        for (int i = 0; i < 12; i++) {
            if(yearDate.getDayOfWeek().equals(DayOfWeek.FRIDAY)){
                amountOfFriThe13th++;
            }
            yearDate = yearDate.plusMonths(1);
        }
        return amountOfFriThe13th;
    }

}
