public class DayTwenty {

    public static int partOne(int wantedValue) {
        int[] houses = new int[1000000];
        for(int x = 1; x < houses.length; x++) {
            for(int y = x; y < houses.length; y += x) {
                houses[y] += x * 10;
            }
        }

        for(int x = 0; x < houses.length; x++) {
            if(houses[x] >= wantedValue) {
                return x;
            }
        }
        return -1;
    }

    public static int partTwo(int wantedValue) {
        int[] houses = new int[1000000];
        for(int x = 1; x < houses.length; x++) {
            int count = 0;
            for(int y = x; y < houses.length; y += x) {
                houses[y] += x * 11;
                if(++count == 50) {
                    break;
                }
            }
        }

        for(int x = 0; x < houses.length; x++) {
            if(houses[x] >= wantedValue) {
                return x;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(DayTwenty.partOne(36_000_000));
        System.out.println(DayTwenty.partTwo(36_000_000));
    }
}
