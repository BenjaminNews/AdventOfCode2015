import java.io.IOException;
import java.util.Arrays;

public class DaySeventeen {

    private int totalLiquid;
    private int goodCombinaisons;
    private int minNbContainersUsed = Integer.MAX_VALUE;

    public int partOne(String input, int targetFluid) {
        String[] entries = input.split("\n");
        totalLiquid = targetFluid;
        goodCombinaisons = 0;

        int[] containers = new int[entries.length];
        for (int i = 0; i < entries.length; i++) {
            containers[i] = Integer.parseInt(entries[i]);
        }
        calculateContent(containers, 0);
        return goodCombinaisons;
    }

    public int partTwo(String input, int targetFluid) {
        String[] entries = input.split("\n");
        goodCombinaisons = 0;

        int[] containers = new int[entries.length];
        for (int i = 0; i < entries.length; i++) {
            containers[i] = Integer.parseInt(entries[i]);
        }
        calculateContentWithMinimumUse(containers, 0, 0);
        return goodCombinaisons;
    }

    private void calculateContent(int[] remainingContainers, Integer total) {
        if (remainingContainers.length == 0) {
            if (total == totalLiquid) {
                goodCombinaisons++;
            }
        } else {
            for (int i : new int[]{0, 1}) {
                calculateContent(Arrays.copyOfRange(remainingContainers, 1, remainingContainers.length), total + (remainingContainers[0] * i));
            }
        }
    }

    private void calculateContentWithMinimumUse(int[] remainingContainers, Integer total, int containersUsed) {
        if (remainingContainers.length == 0) {
            if (total == totalLiquid) {
                if (containersUsed < minNbContainersUsed) {
                    minNbContainersUsed = containersUsed;
                    goodCombinaisons = 1;
                } else if (containersUsed == minNbContainersUsed) {
                    goodCombinaisons++;
                }
            }
        } else {
            for (int i : new int[]{0, 1}) {
                calculateContentWithMinimumUse(
                        Arrays.copyOfRange(remainingContainers, 1, remainingContainers.length),
                        total + (remainingContainers[0] * i),
                        containersUsed + i);
            }
        }
    }

    public static void main(String[] args) {
        DaySeventeen daySeventeen = new DaySeventeen();
        System.out.printf("Part one: %d", daySeventeen.partOne(input, 150));
        System.out.printf("%nPart two: %d", daySeventeen.partTwo(input, 150));
    }

    private static String input =   "33\n" +
                                    "14\n" +
                                    "18\n" +
                                    "20\n" +
                                    "45\n" +
                                    "35\n" +
                                    "16\n" +
                                    "35\n" +
                                    "1\n" +
                                    "13\n" +
                                    "18\n" +
                                    "13\n" +
                                    "50\n" +
                                    "44\n" +
                                    "48\n" +
                                    "6\n" +
                                    "24\n" +
                                    "41\n" +
                                    "30\n" +
                                    "42";
}
