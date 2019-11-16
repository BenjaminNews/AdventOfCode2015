import java.util.Arrays;

public class DayTen {

    private static int[] lookSayValues = new int[5_103_798];

    private static String lookAndSay(String input) {
        int[] numbers = Arrays.stream(input.split("")).mapToInt(Integer::parseInt).toArray();
        int[] result = new int[Integer.MAX_VALUE / 10];
        int inserIndex = 0;
        for(int checkPoint = 0; checkPoint < numbers.length; checkPoint++) {
            int count = 1;
            for(int next = checkPoint + 1; next < numbers.length && numbers[next] == numbers[checkPoint]; next++) {
                count++;
            }
            result[inserIndex] =  count;
            result[inserIndex + 1] = numbers[checkPoint];
            inserIndex += 2;
            checkPoint += count - 1;
        }
        int firstZeroIndex = getFirstZeroIndex(result);
        String s = Arrays.toString(Arrays.copyOfRange(result, 0, firstZeroIndex)).replace("[", "").replace("]", "").replace(", ", "");
        return s;
    }

    private static int getFirstZeroIndex(int[] result) {
        for(int i = 0; i < result.length; i++) {
            if(result[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public static int partOne(String input, int count) {
        for(int i = 1; i <= count; i++) {
            input = lookAndSay(input);
            if(i % 10 == 0)
                System.out.println(i);
        }
        return input.length();
    }

    public static void main(String[] args) {
        System.out.printf("Part One: %s%n", DayTen.partOne("1113122113", 40));
        System.out.printf("Part One: %s", DayTen.partOne("1113122113", 50));

    }
}
