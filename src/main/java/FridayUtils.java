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
        int dayNum = aDate.getDayOfMonth();
        String dayName = aDate.getDayOfWeek().name();

        if(dayNum == 13 && dayName.contentEquals("FRIDAY")){
            return aDate;
        }
        else {
            if (dayNum>13){
                int diff = dayNum - 13;
                aDate = aDate.minusDays(diff);
                dayName = aDate.getDayOfWeek().name();
                if (dayName.contentEquals("FRIDAY")){
                    return aDate;
                }
            }
            if (dayNum<13){
                int diff = 13 - dayNum;
                aDate = aDate.plusDays(diff);
            }
        }
        boolean looking = true;
        while (looking){
            aDate = aDate.minusMonths(1);
            dayName = aDate.getDayOfWeek().name();
            if (dayName.contentEquals("FRIDAY")){
                looking = false;
            }
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
        int count = 0;
        LocalDate aDate = LocalDate.of(year,1,13);
        String dayName = aDate.getDayOfWeek().name();
        for(int i=0;i<12;i++){
            if(dayName.contentEquals("FRIDAY")){
                count++;
            }
            aDate = aDate.plusMonths(1);
            dayName = aDate.getDayOfWeek().name();
        }
        return count;
    }

}
