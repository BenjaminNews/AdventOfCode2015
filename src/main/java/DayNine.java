import com.google.common.collect.Collections2;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DayNine {

    private Map<String, City> cities = new HashMap<>();
    private Collection<List<String>> combination;
    private int shortestDistance = Integer.MAX_VALUE;
    private int longestRoute = Integer.MIN_VALUE;

    public void setup(String input) {
        for(String journey : input.split("\n")) {
            String[] values = journey.split(" ");
            if(!cities.containsKey(values[0]))
                cities.put(values[0], new City());
            if(!cities.containsKey(values[2]))
                cities.put(values[2], new City());
            cities.get(values[0]).connections.put(values[2], Integer.parseInt(values[4]));
            cities.get(values[2]).connections.put(values[0], Integer.parseInt(values[4]));
        }
        combination = Collections2.permutations(new ArrayList<String>(cities.keySet()));
    }

    public void getRouteLengths() {
        for(List<String> route : combination) {
            int currentDistance = 0;
            for(int i = 0; i + 1 < route.size(); i++)
                currentDistance += cities.get(route.get(i)).getConnectionDistance(route.get(i + 1));
            if(currentDistance < shortestDistance)
                shortestDistance = currentDistance;
            if(currentDistance > longestRoute)
                longestRoute = currentDistance;
        }
    }

    public static void main(String... args) {
        DayNine dayNine = new DayNine();
        dayNine.setup(input);
        dayNine.getRouteLengths();
        System.out.printf("Part One: %d%n", dayNine.getShortestDistance());
        System.out.printf("Part Two: %d%n", dayNine.getLongestDistance());

    }

    public int getShortestDistance() {
        return shortestDistance;
    }

    public int getLongestDistance() {
        return longestRoute;
    }

    private class City {

        private Map<String, Integer> connections = new HashMap<String, Integer>();

        private int getConnectionDistance(String connection) {
            return connections.get(connection);
        }
    }

    private static final String input = "Tristram to AlphaCentauri = 34\n" +
                                        "Tristram to Snowdin = 100\n" +
                                        "Tristram to Tambi = 63\n" +
                                        "Tristram to Faerun = 108\n" +
                                        "Tristram to Norrath = 111\n" +
                                        "Tristram to Straylight = 89\n" +
                                        "Tristram to Arbre = 132\n" +
                                        "AlphaCentauri to Snowdin = 4\n" +
                                        "AlphaCentauri to Tambi = 79\n" +
                                        "AlphaCentauri to Faerun = 44\n" +
                                        "AlphaCentauri to Norrath = 147\n" +
                                        "AlphaCentauri to Straylight = 133\n" +
                                        "AlphaCentauri to Arbre = 74\n" +
                                        "Snowdin to Tambi = 105\n" +
                                        "Snowdin to Faerun = 95\n" +
                                        "Snowdin to Norrath = 48\n" +
                                        "Snowdin to Straylight = 88\n" +
                                        "Snowdin to Arbre = 7\n" +
                                        "Tambi to Faerun = 68\n" +
                                        "Tambi to Norrath = 134\n" +
                                        "Tambi to Straylight = 107\n" +
                                        "Tambi to Arbre = 40\n" +
                                        "Faerun to Norrath = 11\n" +
                                        "Faerun to Straylight = 66\n" +
                                        "Faerun to Arbre = 144\n" +
                                        "Norrath to Straylight = 115\n" +
                                        "Norrath to Arbre = 135\n" +
                                        "Straylight to Arbre = 127";
}
