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
        while(true){
            if(aDate.getDayOfWeek()==DayOfWeek.FRIDAY){

                if(aDate.getDayOfMonth()==13){
                    return aDate;
                }else{
                    aDate = aDate.minusWeeks(1);
                }

            }else{
                aDate = aDate.minusDays(1);
            }
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
        int howMany = 0;
        LocalDate newDate = LocalDate.of(year,1,1);

        while(newDate.getYear()==year){
            if(newDate.getDayOfWeek()==DayOfWeek.FRIDAY){

                if(newDate.getDayOfMonth()==13){
                    howMany += 1;
                    newDate = newDate.plusWeeks(1);
                }else{
                    newDate = newDate.plusWeeks(1);
                }

            }else{
                newDate = newDate.plusDays(1);
            }
        }
        return howMany;
    }

}
