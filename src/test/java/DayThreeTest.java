import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DayThreeTest {

    @Test
    public void givenInput_vistsUniqueHouseTotalOf_2() {
        assertEquals(2, DayThree.partOne(">"));
        assertEquals(2, DayThree.partOne("^v^v^v^v^v"));
    }

    @Test
    public void givenInput_vistsUniqueHouseTotalOf_4() {
        assertEquals(4, DayThree.partOne("^>v<"));
    }

    @Test
    public void givenInput_withRobotSanta_vistsUniqueHouseTotalOf_3() {
        assertEquals(3, DayThree.partTwo("^v"));
        assertEquals(3, DayThree.partTwo("^>v<"));
    }

    @Test
    public void givenInput_withRobotSanta_vistsUniqueHouseTotalOf_11() {
        assertEquals(11, DayThree.partTwo("^v^v^v^v^v"));
    }
}