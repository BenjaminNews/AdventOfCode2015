import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DayNineTest {

    @Test
    public void givenInput_shortestReturnedRouteOf_605() {
        String input =  "London to Dublin = 464\n" +
                        "London to Belfast = 518\n" +
                        "Dublin to Belfast = 141";
        DayNine dayNine = new DayNine();
        dayNine.setup(input);
        dayNine.getRouteLengths();
        assertEquals(605, dayNine.getShortestDistance());
    }

    @Test
    public void givenInput_longestReturnedRouteOf_982() {
        String input =  "London to Dublin = 464\n" +
                        "London to Belfast = 518\n" +
                        "Dublin to Belfast = 141";
        DayNine dayNine = new DayNine();
        dayNine.setup(input);
        dayNine.getRouteLengths();
        assertEquals(982, dayNine.getLongestDistance());
    }
}