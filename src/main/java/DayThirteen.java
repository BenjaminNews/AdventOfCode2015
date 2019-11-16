import com.google.common.collect.Collections2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DayThirteen {

    private Map<String, Person> people = new HashMap<>();

    private Collection<List<String>> combinations;

    public void setup(String input) {
        for (String connection : input.split("\n")) {
            String[] values = connection.split(" ");
            if(!people.containsKey(values[0]))
                people.put(values[0], new Person());
            int updatevalue = connection.contains("gain") ? Integer.parseInt(values[3]) : Integer.parseInt(values[3]) * -1;
            people.get(values[0]).connections.put(values[values.length - 1].replace(".", ""), updatevalue);
        }
        combinations = Collections2.permutations(new ArrayList<String>(people.keySet()));
    }

    public int partOne() {
        int highestScore = Integer.MIN_VALUE;
        for(List<String> arrangement : combinations) {
            int currentScore = 0;
            for(int i = 0; i < arrangement.size(); i++) {
                if(i == 0)
                    currentScore += buildSeatingScore(arrangement, currentScore, i, 1, arrangement.size() - 1);
                else if (i == arrangement.size() - 1)
                    currentScore += buildSeatingScore(arrangement, currentScore, i, i - 1, 0);
                else
                    currentScore += buildSeatingScore(arrangement, currentScore, i, i - 1, i + 1);
            }
            if(currentScore > highestScore)
                highestScore = currentScore;
        }
        return highestScore;
    }

    private int buildSeatingScore(List<String> arrangement, int currentScore, int currentPerson, int personToTheRight, int personToTheLeft) {
        Person current = people.get(arrangement.get(currentPerson));
        String right = arrangement.get(personToTheRight);
        String left = arrangement.get(personToTheLeft);
        return current.getConnectionDistance(right) + current.connections.get(left);
    }

    class Person {
        private Map<String, Integer> connections = new HashMap<String, Integer>();
        private int getConnectionDistance(String connection) {
            return connections.get(connection);
        }
    }

    public static void main(String[] args) {
        DayThirteen dayThirteen = new DayThirteen();
        dayThirteen.setup(input);
        System.out.printf("Part One: %d%n", dayThirteen.partOne());
        dayThirteen.setup(inputTwo);
        System.out.printf("Part Two: %d%n", dayThirteen.partOne());
    }

    private static final String input = "Alice would lose 2 happiness units by sitting next to Bob.\n" +
                                        "Alice would lose 62 happiness units by sitting next to Carol.\n" +
                                        "Alice would gain 65 happiness units by sitting next to David.\n" +
                                        "Alice would gain 21 happiness units by sitting next to Eric.\n" +
                                        "Alice would lose 81 happiness units by sitting next to Frank.\n" +
                                        "Alice would lose 4 happiness units by sitting next to George.\n" +
                                        "Alice would lose 80 happiness units by sitting next to Mallory.\n" +
                                        "Bob would gain 93 happiness units by sitting next to Alice.\n" +
                                        "Bob would gain 19 happiness units by sitting next to Carol.\n" +
                                        "Bob would gain 5 happiness units by sitting next to David.\n" +
                                        "Bob would gain 49 happiness units by sitting next to Eric.\n" +
                                        "Bob would gain 68 happiness units by sitting next to Frank.\n" +
                                        "Bob would gain 23 happiness units by sitting next to George.\n" +
                                        "Bob would gain 29 happiness units by sitting next to Mallory.\n" +
                                        "Carol would lose 54 happiness units by sitting next to Alice.\n" +
                                        "Carol would lose 70 happiness units by sitting next to Bob.\n" +
                                        "Carol would lose 37 happiness units by sitting next to David.\n" +
                                        "Carol would lose 46 happiness units by sitting next to Eric.\n" +
                                        "Carol would gain 33 happiness units by sitting next to Frank.\n" +
                                        "Carol would lose 35 happiness units by sitting next to George.\n" +
                                        "Carol would gain 10 happiness units by sitting next to Mallory.\n" +
                                        "David would gain 43 happiness units by sitting next to Alice.\n" +
                                        "David would lose 96 happiness units by sitting next to Bob.\n" +
                                        "David would lose 53 happiness units by sitting next to Carol.\n" +
                                        "David would lose 30 happiness units by sitting next to Eric.\n" +
                                        "David would lose 12 happiness units by sitting next to Frank.\n" +
                                        "David would gain 75 happiness units by sitting next to George.\n" +
                                        "David would lose 20 happiness units by sitting next to Mallory.\n" +
                                        "Eric would gain 8 happiness units by sitting next to Alice.\n" +
                                        "Eric would lose 89 happiness units by sitting next to Bob.\n" +
                                        "Eric would lose 69 happiness units by sitting next to Carol.\n" +
                                        "Eric would lose 34 happiness units by sitting next to David.\n" +
                                        "Eric would gain 95 happiness units by sitting next to Frank.\n" +
                                        "Eric would gain 34 happiness units by sitting next to George.\n" +
                                        "Eric would lose 99 happiness units by sitting next to Mallory.\n" +
                                        "Frank would lose 97 happiness units by sitting next to Alice.\n" +
                                        "Frank would gain 6 happiness units by sitting next to Bob.\n" +
                                        "Frank would lose 9 happiness units by sitting next to Carol.\n" +
                                        "Frank would gain 56 happiness units by sitting next to David.\n" +
                                        "Frank would lose 17 happiness units by sitting next to Eric.\n" +
                                        "Frank would gain 18 happiness units by sitting next to George.\n" +
                                        "Frank would lose 56 happiness units by sitting next to Mallory.\n" +
                                        "George would gain 45 happiness units by sitting next to Alice.\n" +
                                        "George would gain 76 happiness units by sitting next to Bob.\n" +
                                        "George would gain 63 happiness units by sitting next to Carol.\n" +
                                        "George would gain 54 happiness units by sitting next to David.\n" +
                                        "George would gain 54 happiness units by sitting next to Eric.\n" +
                                        "George would gain 30 happiness units by sitting next to Frank.\n" +
                                        "George would gain 7 happiness units by sitting next to Mallory.\n" +
                                        "Mallory would gain 31 happiness units by sitting next to Alice.\n" +
                                        "Mallory would lose 32 happiness units by sitting next to Bob.\n" +
                                        "Mallory would gain 95 happiness units by sitting next to Carol.\n" +
                                        "Mallory would gain 91 happiness units by sitting next to David.\n" +
                                        "Mallory would lose 66 happiness units by sitting next to Eric.\n" +
                                        "Mallory would lose 75 happiness units by sitting next to Frank.\n" +
                                        "Mallory would lose 99 happiness units by sitting next to George.";

    private static final String inputTwo =  "Alice would lose 2 happiness units by sitting next to Bob.\n" +
                                            "Alice would lose 62 happiness units by sitting next to Carol.\n" +
                                            "Alice would gain 65 happiness units by sitting next to David.\n" +
                                            "Alice would gain 21 happiness units by sitting next to Eric.\n" +
                                            "Alice would lose 81 happiness units by sitting next to Frank.\n" +
                                            "Alice would lose 4 happiness units by sitting next to George.\n" +
                                            "Alice would lose 80 happiness units by sitting next to Mallory.\n" +
                                            "Alice would lose 0 happiness units by sitting next to Ben.\n" +
                                            "Bob would gain 93 happiness units by sitting next to Alice.\n" +
                                            "Bob would gain 19 happiness units by sitting next to Carol.\n" +
                                            "Bob would gain 5 happiness units by sitting next to David.\n" +
                                            "Bob would gain 49 happiness units by sitting next to Eric.\n" +
                                            "Bob would gain 68 happiness units by sitting next to Frank.\n" +
                                            "Bob would gain 23 happiness units by sitting next to George.\n" +
                                            "Bob would gain 29 happiness units by sitting next to Mallory.\n" +
                                            "Bob would gain 0 happiness units by sitting next to Ben.\n" +
                                            "Carol would lose 54 happiness units by sitting next to Alice.\n" +
                                            "Carol would lose 70 happiness units by sitting next to Bob.\n" +
                                            "Carol would lose 37 happiness units by sitting next to David.\n" +
                                            "Carol would lose 46 happiness units by sitting next to Eric.\n" +
                                            "Carol would gain 33 happiness units by sitting next to Frank.\n" +
                                            "Carol would lose 35 happiness units by sitting next to George.\n" +
                                            "Carol would gain 10 happiness units by sitting next to Mallory.\n" +
                                            "Carol would gain 0 happiness units by sitting next to Ben.\n" +
                                            "David would gain 43 happiness units by sitting next to Alice.\n" +
                                            "David would lose 96 happiness units by sitting next to Bob.\n" +
                                            "David would lose 53 happiness units by sitting next to Carol.\n" +
                                            "David would lose 30 happiness units by sitting next to Eric.\n" +
                                            "David would lose 12 happiness units by sitting next to Frank.\n" +
                                            "David would gain 75 happiness units by sitting next to George.\n" +
                                            "David would lose 20 happiness units by sitting next to Mallory.\n" +
                                            "David would lose 0 happiness units by sitting next to Ben.\n" +
                                            "Eric would gain 8 happiness units by sitting next to Alice.\n" +
                                            "Eric would lose 89 happiness units by sitting next to Bob.\n" +
                                            "Eric would lose 69 happiness units by sitting next to Carol.\n" +
                                            "Eric would lose 34 happiness units by sitting next to David.\n" +
                                            "Eric would gain 95 happiness units by sitting next to Frank.\n" +
                                            "Eric would gain 34 happiness units by sitting next to George.\n" +
                                            "Eric would lose 99 happiness units by sitting next to Mallory.\n" +
                                            "Eric would lose 0 happiness units by sitting next to Ben.\n" +
                                            "Frank would lose 97 happiness units by sitting next to Alice.\n" +
                                            "Frank would gain 6 happiness units by sitting next to Bob.\n" +
                                            "Frank would lose 9 happiness units by sitting next to Carol.\n" +
                                            "Frank would gain 56 happiness units by sitting next to David.\n" +
                                            "Frank would lose 17 happiness units by sitting next to Eric.\n" +
                                            "Frank would gain 18 happiness units by sitting next to George.\n" +
                                            "Frank would lose 56 happiness units by sitting next to Mallory.\n" +
                                            "Frank would lose 0 happiness units by sitting next to Ben.\n" +
                                            "George would gain 45 happiness units by sitting next to Alice.\n" +
                                            "George would gain 76 happiness units by sitting next to Bob.\n" +
                                            "George would gain 63 happiness units by sitting next to Carol.\n" +
                                            "George would gain 54 happiness units by sitting next to David.\n" +
                                            "George would gain 54 happiness units by sitting next to Eric.\n" +
                                            "George would gain 30 happiness units by sitting next to Frank.\n" +
                                            "George would gain 7 happiness units by sitting next to Mallory.\n" +
                                            "George would gain 7 happiness units by sitting next to Ben.\n" +
                                            "Mallory would gain 31 happiness units by sitting next to Alice.\n" +
                                            "Mallory would lose 32 happiness units by sitting next to Bob.\n" +
                                            "Mallory would gain 95 happiness units by sitting next to Carol.\n" +
                                            "Mallory would gain 91 happiness units by sitting next to David.\n" +
                                            "Mallory would lose 66 happiness units by sitting next to Eric.\n" +
                                            "Mallory would lose 75 happiness units by sitting next to Frank.\n" +
                                            "Mallory would lose 99 happiness units by sitting next to George.\n" +
                                            "Mallory would lose 0 happiness units by sitting next to Ben.\n" +
                                            "Ben would lose 0 happiness units by sitting next to Alice.\n" +
                                            "Ben would lose 0 happiness units by sitting next to Bob.\n" +
                                            "Ben would lose 0 happiness units by sitting next to Carol.\n" +
                                            "Ben would lose 0 happiness units by sitting next to David.\n" +
                                            "Ben would lose 0 happiness units by sitting next to Eric.\n" +
                                            "Ben would lose 0 happiness units by sitting next to Frank.\n" +
                                            "Ben would lose 0 happiness units by sitting next to George.\n" +
                                            "Ben would lose 0 happiness units by sitting next to Mallory.";
    ;
//    Alice
//            Bob
//    Carol
//            David
//    Eric
//            Frank
//    George
//            Mallory
}
