import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DayOneTest {

    @Test
    public void givenInputs_returnsEndFloorOf_0() {
        assertEquals(0, DayOne.partOne("(())"));
        assertEquals(0, DayOne.partOne("()()"));
    }

    @Test
    public void givenInputs_returnsEndFloorOf_3() {
        assertEquals(3, DayOne.partOne("((("));
        assertEquals(3, DayOne.partOne("(()(()("));
        assertEquals(3, DayOne.partOne("))((((("));
    }

    @Test
    public void givenInputs_returnsEndFloorOf_minusOne() {
        assertEquals(-1, DayOne.partOne("())"));
        assertEquals(-1, DayOne.partOne("))("));
    }

    @Test
    public void givenInputs_returnsEndFloorOf_minusThree() {
        assertEquals(-3, DayOne.partOne(")))"));
        assertEquals(-3, DayOne.partOne(")())())"));
    }

    @Test
    public void givenInput_entersBasementAtPosition_1() {
        assertEquals(1, DayOne.partTwo(")"));
    }

    @Test
    public void givenInput_entersBasementAtPosition_5() {
        assertEquals(5, DayOne.partTwo("()())"));
    }
}