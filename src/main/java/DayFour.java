import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DayFour {


    public static int partOne(String input, int numberOfZeros)  {
        String zeros = "";
        for(int i = 0; i < numberOfZeros; i++) {
            zeros += "0";
        }
        try {
            for(int i = 0; i < Integer.MAX_VALUE; i++) {
                MessageDigest md = java.security.MessageDigest.getInstance("MD5");
                byte[] array = md.digest((input + i).getBytes());
                StringBuilder sb = new StringBuilder();
                for (byte b : array)
                    sb.append(Integer.toHexString((b & 0xFF) | 0x100).substring(1, 3));
                if(sb.toString().startsWith(zeros))
                    return i;
            }
        } catch (NoSuchAlgorithmException ignored) {
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.printf("Part One: %d", DayFour.partOne(input, 5));
        System.out.printf("%nPart One: %d", DayFour.partOne(input, 6));
    }

    private static final String input = "ckczppom";

}
