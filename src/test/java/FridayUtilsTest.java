import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class FridayUtilsTest {

    @Test
    void findPreviousFriday13th_TheParameterIs13thFriday() {
        var today = LocalDate.of(2015, 3, 13);
        var actual = FridayUtils.findPreviousFriday13th(today);
        var expected = LocalDate.of(2015, 3, 13);
        assertEquals(expected, actual);
    }

    @Test
    void findPreviousFriday13th_BeforeToday() {
        var today = LocalDate.of(2020, 4, 22);
        var actual = FridayUtils.findPreviousFriday13th(today);
        var expected = LocalDate.of(2020, 3, 13);
        assertEquals(expected, actual);
    }

    @Test
    void findPreviousFriday13th_BeforeJan1st2000() {
        var date = LocalDate.of(2000, 1, 1);
        var actual = FridayUtils.findPreviousFriday13th(date);
        var expected = LocalDate.of(1999, 8, 13);
        assertEquals(expected, actual);
    }

    @Test
    void findPreviousFriday13th_AllDatesReturnedShouldBeFriday13th() {
        var random = new Random(System.nanoTime());
        for (int i = 0; i < 20; i++) {
            var randomDate = LocalDate.of(random.nextInt(2020), random.nextInt(12) + 1, random.nextInt(28) + 1);
            var actual = FridayUtils.findPreviousFriday13th(randomDate);
            assertEquals(13, actual.getDayOfMonth(), "Test for date: " + randomDate);
            assertEquals(DayOfWeek.FRIDAY, actual.getDayOfWeek());
        }
    }

    @Test
    void findPreviousFriday13th_OneMonthInBetween() {
        var date = LocalDate.of(2009, 3, 14);
        var actual = FridayUtils.findPreviousFriday13th(date);
        var expected = LocalDate.of(2009, 3, 13);
        assertEquals(expected, actual);
        var beforeExpected = FridayUtils.findPreviousFriday13th(expected.minusDays(1));
        assertEquals(expected.minusMonths(1), beforeExpected);
    }

    @Test
    void howManyFriday13ths_In2000() {
        var actual = FridayUtils.howManyFriday13ths(2000);
        assertEquals(1, actual);
    }

    @Test
    void howManyFriday13ths_InSomeOtherYears() {
        Map<Integer, Integer> data = new HashMap<>() {{
            put(2001, 2);
            put(2002, 2);
            put(2003, 1);
            put(2004, 2);
            put(2005, 1);
            put(2006, 2);
            put(2007, 2);
            put(2008, 1);
            put(2009, 3);
            put(2010, 1);
        }};
        for (var entry : data.entrySet()) {
            var actual = FridayUtils.howManyFriday13ths(entry.getKey());
            assertEquals(entry.getValue(), actual, "Test for year " + entry.getKey());
        }

    }
}