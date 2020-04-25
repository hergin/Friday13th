import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

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
        if(aDate.getDayOfMonth()>13){
            aDate = aDate.minusDays(aDate.getDayOfMonth() - 13);
        }else if (aDate.getDayOfMonth()<13){
            aDate = aDate.minusMonths(1);
            aDate = aDate.plusDays(13-aDate.getDayOfMonth());
        }else{
            //nothing to fix!
        }
        if (aDate.getDayOfWeek() == DayOfWeek.FRIDAY && aDate.getDayOfMonth() ==13){
            return (aDate);
        }
        while (aDate.getDayOfWeek() != DayOfWeek.FRIDAY){
            aDate = aDate.minusMonths(1);
        }
        return aDate;
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
        int num13ths = 0;
        LocalDate testDate = LocalDate.of(year, 12, 13);
        System.out.println(testDate.getMonthValue());
        for (int i = testDate.getMonthValue(); i>0; i--){
            if (testDate.getDayOfWeek() == DayOfWeek.FRIDAY){
                num13ths++;
            }
            testDate = testDate.minusMonths(1);
        }
        return num13ths;
    }

}
