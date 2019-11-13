import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DayElevenTest {

    private DayEleven dayEleven;

    @Before
    public void setup() {
        this.dayEleven = new DayEleven();
    }

    @Test
    public void givenInput_abcdefgh_returnNextPasswordOf_abcdffaa() {
        assertEquals("abcdffaa", dayEleven.parttOne("abcdefgh"));
    }

    //ghijklmn
    @Test
    public void givenInput_ghijklmn_returnNextPasswordOf_ghjaabcc() {
        assertEquals("ghjaabcc", dayEleven.parttOne("ghijklmn"));
    }
}