import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

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
        LocalDate tempDate = aDate;
        for (int i = tempDate.getDayOfMonth(); i > 0; i--){
             if (tempDate.getDayOfMonth() == 13) {
                 if (tempDate.getDayOfWeek() == DayOfWeek.FRIDAY) {
                     System.out.println("The most recent Friday the 13th was: " + aDate);
                     return aDate;
                 }
             }
             else{
                 tempDate.minusDays(1);
             }
        }
        return findPreviousFriday13th(aDate.minusDays(1));
    }

    /**
     * Return the number of friday 13ths in a given year.
     * Simply count the friday 13ths starting from Jan 1st until Dec 31st in that given year.
     *
     * @param year
     * @return
     */
    public static int howManyFriday13ths(int year) {
        int num = 0;
        for(int i = 1; i <=12; i++){
            LocalDate theDate = LocalDate.of(year, i, 13);
            if (theDate.getDayOfWeek() == DayOfWeek.FRIDAY){
                num++;
            }
        }
        return num;
    }

}
