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
    public static LocalDate findPreviousFriday13th(LocalDate aDate)
    {
        LocalDate returnDate;

        if (aDate.getDayOfWeek().getValue() == 5 && aDate.getDayOfMonth() == 13)
        {
            returnDate = aDate;
        }
        else
        {
            returnDate = findPreviousFriday13th(aDate.minusDays(1));
        }

        return(returnDate);
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
        int Friday13ths = 0;

        LocalDate aDate = LocalDate.of(year,1,13);
        String dayOfTheWeek = aDate.getDayOfWeek().name();
        for(int i=0; i < 12; i++)
        {
            if(dayOfTheWeek.contentEquals("FRIDAY"))
            {
                Friday13ths++;
            }

            aDate = aDate.plusMonths(1);

            dayOfTheWeek = aDate.getDayOfWeek().name();

        }

        return Friday13ths;
    }

}
