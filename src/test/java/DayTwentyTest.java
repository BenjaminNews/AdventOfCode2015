import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DayTwentyTest {

    @Test
    public void givenHouse_1_receives_10_presents() {
        assertEquals(1, DayTwenty.partOne(10));
    }

    @Test
    public void givenHouse_2_receives_30_presents() {
        assertEquals(2, DayTwenty.partOne(30));
    }

    @Test
    public void givenHouse_3_receives_40_presents() {
        assertEquals(3, DayTwenty.partOne(40));
    }

    @Test
    public void givenHouse_4_receives_70_presents() {
        assertEquals(4, DayTwenty.partOne(70));
    }

    @Test
    public void givenHouse_6_receives_120_presents() {
        assertEquals(6, DayTwenty.partOne(120));
    }

    @Test
    public void givenHouse_8_receives_150_presents() {
        assertEquals(8, DayTwenty.partOne(150));
    }
}