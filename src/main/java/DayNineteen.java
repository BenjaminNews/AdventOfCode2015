import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayNineteen {

    public static int partOne(String input, String replacements) {
        String[] replacementPairs = replacements.split("\n");
        List<String> uniqueMolecules = new ArrayList<String>();

        for(String replacementValue : replacementPairs) {
            Matcher m = Pattern.compile(replacementValue.split(" => ")[0]).matcher(input);
            while (m.find()) {
                String newMolecule = input.substring(0, m.start()) + replacementValue.split(" => ")[1] + input.substring(m.start() + replacementValue.split(" => ")[0].length());
                if(!uniqueMolecules.contains(newMolecule)) {
                    uniqueMolecules.add(newMolecule);
                }
            }
        }
        return uniqueMolecules.size();
    }

    public static void main(String[] args) {
        System.out.printf("Part one: %d", DayNineteen.partOne(input, replacementValues));
    }

    private static final String input = "CRnSiRnCaPTiMgYCaPTiRnFArSiThFArCaSiThSiThPBCaCaSiRnSiRnTiTiMgArPBCaPMgYPTiRnFArFArCaSiRnBPMgArPRnCaPTiRnFArCaSiThCaCaFArPBCaCaPTiTiRnFArCaSiRnSiAlYSiThRnFArArCaSiRnBFArCaCaSiRnSiThCaCaCaFYCaPTiBCaSiThCaSiThPMgArSiRnCaPBFYCaCaFArCaCaCaCaSiThCaSiRnPRnFArPBSiThPRnFArSiRnMgArCaFYFArCaSiRnSiAlArTiTiTiTiTiTiTiRnPMgArPTiTiTiBSiRnSiAlArTiTiRnPMgArCaFYBPBPTiRnSiRnMgArSiThCaFArCaSiThFArPRnFArCaSiRnTiBSiThSiRnSiAlYCaFArPRnFArSiThCaFArCaCaSiThCaCaCaSiRnPRnCaFArFYPMgArCaPBCaPBSiRnFYPBCaFArCaSiAl";

    private static final String replacementValues = "Al => ThF\n" +
                                                    "Al => ThRnFAr\n" +
                                                    "B => BCa\n" +
                                                    "B => TiB\n" +
                                                    "B => TiRnFAr\n" +
                                                    "Ca => CaCa\n" +
                                                    "Ca => PB\n" +
                                                    "Ca => PRnFAr\n" +
                                                    "Ca => SiRnFYFAr\n" +
                                                    "Ca => SiRnMgAr\n" +
                                                    "Ca => SiTh\n" +
                                                    "F => CaF\n" +
                                                    "F => PMg\n" +
                                                    "F => SiAl\n" +
                                                    "H => CRnAlAr\n" +
                                                    "H => CRnFYFYFAr\n" +
                                                    "H => CRnFYMgAr\n" +
                                                    "H => CRnMgYFAr\n" +
                                                    "H => HCa\n" +
                                                    "H => NRnFYFAr\n" +
                                                    "H => NRnMgAr\n" +
                                                    "H => NTh\n" +
                                                    "H => OB\n" +
                                                    "H => ORnFAr\n" +
                                                    "Mg => BF\n" +
                                                    "Mg => TiMg\n" +
                                                    "N => CRnFAr\n" +
                                                    "N => HSi\n" +
                                                    "O => CRnFYFAr\n" +
                                                    "O => CRnMgAr\n" +
                                                    "O => HP\n" +
                                                    "O => NRnFAr\n" +
                                                    "O => OTi\n" +
                                                    "P => CaP\n" +
                                                    "P => PTi\n" +
                                                    "P => SiRnFAr\n" +
                                                    "Si => CaSi\n" +
                                                    "Th => ThCa\n" +
                                                    "Ti => BP\n" +
                                                    "Ti => TiTi\n" +
                                                    "e => HF\n" +
                                                    "e => NAl\n" +
                                                    "e => OMg";
}
