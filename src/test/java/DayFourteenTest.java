import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class DayFourteenTest {

    private DayFourteen dayFourteen;

    private static final String input = "Comet can fly 14 km/s for 10 seconds, but then must rest for 127 seconds.\n" +
                                        "Dancer can fly 16 km/s for 11 seconds, but then must rest for 162 seconds";
    @Before
    public void setup() {
        dayFourteen = new DayFourteen();
        dayFourteen.setup(input);
    }

    @Test
    public void givenInput_after_1000_seconds_leadDistanceIs_1120() {
        assertEquals(1120, dayFourteen.partOne(1000));
    }

    @Test
    public void givenInput_after_1000_seconds_leadScoreIs_689() {
        assertEquals(689, dayFourteen.partTwo(1000));
    }
}