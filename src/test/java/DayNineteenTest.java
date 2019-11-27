import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DayNineteenTest {

    @Test
    public void givenInput_HOH_withReplacement_H_HO_returns_2_distinctMolecules() {
        assertEquals(2, DayNineteen.partOne("HOH", "H => HO"));
    }

    @Test
    public void givenInput_HOH_withReplacement_H_OH_returns_2_distinctMolecules() {
        assertEquals(2, DayNineteen.partOne("HOH", "H => OH"));
    }

    @Test
    public void givenInput_HOH_withReplacement_O_HH_returns_1_distinctMolecules() {
        assertEquals(1, DayNineteen.partOne("HOH", "O => HH"));
    }

    @Test
    public void givenAllInputs_withStartingValueOF_HOH_4_distinctMolecules() {
        String replacementSet = "H => HO\n" +
                                "H => OH\n" +
                                "O => HH";
        assertEquals(4, DayNineteen.partOne("HOH", replacementSet));
    }
}