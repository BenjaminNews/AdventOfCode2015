import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DayFiveTest {

    @Test
    public void givenInputs_returnsNice() {
        assertEquals(1, DayFive.partOne("ugknbfddgicrmopn"));
        assertEquals(1, DayFive.partOne("aaa"));
    }

    @Test
    public void givenInputs_returnsNaughty() {
        assertEquals(0, DayFive.partOne("jchzalrnumimnmhp"));
        assertEquals(0, DayFive.partOne("haegwjzuvuyypxyu"));
        assertEquals(0, DayFive.partOne("dvszwmarrgswjxmb"));
    }

    @Test
    public void givenAllInputs_returnsScoreOf_2(){
        assertEquals(2, DayFive.partOne("ugknbfddgicrmopn\n" +
                                                        "aaa\n" +
                                                        "jchzalrnumimnmhp\n" +
                                                        "haegwjzuvuyypxyu\n" +
                                                        "dvszwmarrgswjxmb"));
    }

    @Test
    public void givenInputsForPartTwo_returnNice() {
        assertEquals(1, DayFive.partTwo("qjhvhtzxzqqjkmpb"));
        assertEquals(1, DayFive.partTwo("xxyxx"));
    }

    @Test
    public void givenInputForPartTwo_returnsNaughty() {
        assertEquals(0, DayFive.partTwo("uurcxstgmygtbstg"));
        assertEquals(0, DayFive.partTwo("ieodomkazucvgmuy"));
    }

    @Test
    public void givenAllInputsForPartTwo_returnsScoreOf_2() {
        assertEquals(2, DayFive.partTwo("qjhvhtzxzqqjkmpb\n" +
                                                        "xxyxx\n" +
                                                        "uurcxstgmygtbstg\n" +
                                                        "ieodomkazucvgmuy"));
    }
}