import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DayTwoTest {

    @Test
    public void given_2x3x4_returnTotalRequiredPaperSizeOf_58() {
        assertEquals(58, DayTwo.partOne("2x3x4"));
    }

    @Test
    public void given_1x1x10_returnTotalRequiredPaperSizeOf_43() {
        assertEquals(43, DayTwo.partOne("1x1x10"));
    }

    @Test
    public void givenInputs_2x3x4_and_1x1x10_returnTotalRequiredPaperSizeOf_101() {
        assertEquals(101, DayTwo.partOne("2x3x4\n1x1x10"));
    }

    @Test
    public void givenInputs_2x3x4__returnTotalRequiredRibbonSizeOf_34() {
        assertEquals(34, DayTwo.partTwo("2x3x4"));
    }

    @Test
    public void givenInputs_1x1x10__returnTotalRequiredRibbonSizeOf_14() {
        assertEquals(14, DayTwo.partTwo("1x1x10"));
    }

    @Test
    public void givenInputs_1x1x10_and_2x3x4__returnTotalRequiredRibbonSizeOf_48() {
        assertEquals(48, DayTwo.partTwo("1x1x10\n2x3x4"));
    }
}