import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DayTenTest {

    @Test
    public void givenInputOf_1_afterOneRound_returns_11() {
        assertEquals(2, DayTen.performRounds("1", 1));
    }

    @Test
    public void givenInputOf_1_afterTwoRounds_returns_21() {
        assertEquals(2, DayTen.performRounds("1", 2));
    }

    @Test
    public void givenInputOf_1_afterThreeRounds_returns_1211() {
        assertEquals(4, DayTen.performRounds("1", 3));
    }

    @Test
    public void givenInputOf_1_afterFourRounds_returns_111221() {
        assertEquals(6, DayTen.performRounds("1", 4));
    }

    @Test
    public void givenInputOf_1_afterFiveRounds_returns_312211() {
        assertEquals(6, DayTen.performRounds("1", 5));
    }
}