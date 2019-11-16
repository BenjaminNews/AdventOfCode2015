import java.util.ArrayList;
import java.util.List;

public class DayFourteen {

    private List<Reindeer> allReindeer = new ArrayList<Reindeer>();

    public void setup(String input) {
        for(String allReindeerValues : input.split("\n")) {
            String[] reindeerValues = allReindeerValues.split(" ");
            allReindeer.add(new Reindeer(Integer.parseInt(reindeerValues[3]), Integer.parseInt(reindeerValues[6]), Integer.parseInt(reindeerValues[13])));
        }
    }

    public int partOne(int flyCount) {
        for(int i = 0; i < flyCount; i++) {
            for(Reindeer reindeer : allReindeer) {
                reindeer.fly();
            }
        }
        int maximumDistanceTravelled = Integer.MIN_VALUE;
        for(Reindeer deer : allReindeer) {
            if (deer.distance > maximumDistanceTravelled) {
                maximumDistanceTravelled = deer.distance;
            }
        }
        return maximumDistanceTravelled;
    }

    public int partTwo(int flyCount) {
        for(int i = 0; i < flyCount; i++) {
            for(Reindeer reindeer : allReindeer) {
                reindeer.fly();
            }

            int furthestDistance = Integer.MIN_VALUE;
            for(Reindeer deer : allReindeer) {
                if (deer.distance > furthestDistance) {
                    furthestDistance = deer.distance;
                }
            }
            for(Reindeer reindeer : allReindeer) {
                if(reindeer.distance == furthestDistance) {
                    reindeer.score++;
                }
            }
        }
        int highestScore = Integer.MIN_VALUE;
        for(Reindeer reindeer : allReindeer) {
            if(reindeer.score > highestScore) {
                highestScore = reindeer.score;
            }
        }
        return highestScore;
    }

    public static void main(String[] args) {
        DayFourteen dayFourteen = new DayFourteen();
        dayFourteen.setup(input);
        System.out.printf("Part one: %d%n", dayFourteen.partOne(2503));
        dayFourteen = new DayFourteen();
        dayFourteen.setup(input);
        System.out.printf("Part two: %d", dayFourteen.partTwo(2503));
    }

    private class Reindeer {
        private final int speed;
        private final int flyTime;
        private final int restTime;
        int distance = 0;
        private boolean resting = false;
        private int flyTilRestCount = 0;
        private int coolDownCount = 0;
        int score = 0;

        Reindeer (int speed, int flyTime, int restTime) {
            this.speed = speed;
            this.flyTime = flyTime;
            this.restTime = restTime;
        }

        private void fly() {
            if(!resting) {
                distance += speed;
                flyTilRestCount++;
                if(flyTilRestCount == flyTime) {
                    resting = true;
                }
            } else {
                coolDownCount++;
                if(coolDownCount == restTime) {
                    coolDownCount = 0;
                    resting = false;
                    flyTilRestCount = 0;
                }
            }
        }
    }

    private static final String input = "Rudolph can fly 22 km/s for 8 seconds, but then must rest for 165 seconds.\n" +
                                        "Cupid can fly 8 km/s for 17 seconds, but then must rest for 114 seconds.\n" +
                                        "Prancer can fly 18 km/s for 6 seconds, but then must rest for 103 seconds.\n" +
                                        "Donner can fly 25 km/s for 6 seconds, but then must rest for 145 seconds.\n" +
                                        "Dasher can fly 11 km/s for 12 seconds, but then must rest for 125 seconds.\n" +
                                        "Comet can fly 21 km/s for 6 seconds, but then must rest for 121 seconds.\n" +
                                        "Blitzen can fly 18 km/s for 3 seconds, but then must rest for 50 seconds.\n" +
                                        "Vixen can fly 20 km/s for 4 seconds, but then must rest for 75 seconds.\n" +
                                        "Dancer can fly 7 km/s for 20 seconds, but then must rest for 119 seconds.";
}
