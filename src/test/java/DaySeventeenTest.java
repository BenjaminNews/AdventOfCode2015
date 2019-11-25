import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DaySeventeenTest {

    private static final String input = "20\n" +
                                        "15\n" +
                                        "10\n" +
                                        "5\n"  +
                                        "5";

    DaySeventeen daySeventeen = new DaySeventeen();
    @Test
    public void givenInput_withTargetCountOf_25_returns_4() {
        assertEquals(4, daySeventeen.partOne(input, 25));
    }

    @Test
    public void givenInput_withTargetCountOf_25_returns_3() {
        assertEquals(3, daySeventeen.partTwo(input, 25));
    }
}