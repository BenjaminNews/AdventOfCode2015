import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DayFourTest {

    @Test
    public void givenInput_abcdef_returns_609043() {
        assertEquals(609043, DayFour.partOne("abcdef"));
    }

    @Test
    public void givenInput_pqrstuv_returns_1048970() {
        assertEquals(1048970, DayFour.partOne("pqrstuv"));
    }
}