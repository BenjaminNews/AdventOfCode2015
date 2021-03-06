import java.util.ArrayList;
public class DaySixteen {

    private ArrayList<Aunt> aunts = new ArrayList<Aunt>();

    public void setup(String input) {
        for(String aunt : input.split("\n")) {
            String[] giftValues = aunt.replaceAll("Sue [0-9]{1,3}: ", "").split(", ");
            Aunt newAunt = new Aunt();
            for (String giftValue : giftValues) {
                if (giftValue.startsWith("cars:")) {
                    newAunt.cars = Integer.parseInt(giftValue.split(": ")[1].replace(",", ""));
                } else if (giftValue.startsWith("cats:")) {
                    newAunt.cats = Integer.parseInt(giftValue.split(": ")[1].replace(",", ""));
                } else if (giftValue.startsWith("samoyeds:")) {
                    newAunt.samoyeds = Integer.parseInt(giftValue.split(": ")[1].replace(",", ""));
                } else if (giftValue.startsWith("pomeranians:")) {
                    newAunt.pomeranians = Integer.parseInt(giftValue.split(": ")[1].replace(",", ""));
                } else if (giftValue.startsWith("akitas:")) {
                    newAunt.akitas = Integer.parseInt(giftValue.split(": ")[1].replace(",", ""));
                } else if (giftValue.startsWith("vizslas:")) {
                    newAunt.vizslas = Integer.parseInt(giftValue.split(": ")[1].replace(",", ""));
                } else if (giftValue.startsWith("goldfish:")) {
                    newAunt.goldfish = Integer.parseInt(giftValue.split(": ")[1].replace(",", ""));
                } else if (giftValue.startsWith("trees:")) {
                    newAunt.trees = Integer.parseInt(giftValue.split(": ")[1].replace(",", ""));
                } else if (giftValue.startsWith("perfumes:")) {
                    newAunt.perfumes = Integer.parseInt(giftValue.split(": ")[1].replace(",", ""));
                }
            }
            aunts.add(newAunt);
        }
    }

    public int partOne(int children, int cats, int samoyeds, int pomeranians, int akitas, int vizslas, int goldfish, int trees, int cars, int perfumes) {
        for(int i = 0; i < aunts.size(); i++) {
            if(aunts.get(i).match(children, cats, samoyeds, pomeranians, akitas, vizslas, goldfish, trees, cars, perfumes)) {
                return ++i;
            }
        }
        return -1;
    }

    public int partTwo(int children, int cats, int samoyeds, int pomeranians, int akitas, int vizslas, int goldfish, int trees, int cars, int perfumes) {
        for(int i = 0; i < aunts.size(); i++) {
            if(aunts.get(i).matchPartTwo(children, cats, samoyeds, pomeranians, akitas, vizslas, goldfish, trees, cars, perfumes)) {
                return ++i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        DaySixteen adventOfCodeDaySixteen = new DaySixteen();
        adventOfCodeDaySixteen.setup(input);
        System.out.printf("Part one: %d%n", adventOfCodeDaySixteen.partOne(3, 7, 2, 3, 0, 0, 5, 3, 2, 1));
        System.out.printf("Part two: %d", adventOfCodeDaySixteen.partTwo(3, 7, 2, 3, 0, 0, 5, 3, 2, 1));
    }

    private class Aunt {
        private int children = -1;
        private int cats = -1;
        private int samoyeds = -1;
        private int pomeranians = -1;
        private int akitas = -1;
        private int vizslas = -1;
        private int goldfish = -1;
        private int trees = -1;
        private int cars = -1;
        private int perfumes = -1;

        public boolean match(int childrenCount, int catsCount, int samoyedsCount, int pomeraniansCount, int akitasCount, int vizslasCount, int goldfishCount, int treesCount, int carsCount, int perfumesCount) {
            int matchCount = 0;
            matchCount = getMatchCountForCorrectValues(catsCount, pomeraniansCount, treesCount, goldfishCount, childrenCount, samoyedsCount, cats, pomeranians, trees, goldfish, children, samoyeds);
            if (akitas == akitasCount && akitas != -1) {
                matchCount++;
            }
            if (vizslas == vizslasCount && vizslas != -1) {
                matchCount++;
            }

            if (cars == carsCount && cars != -1) {
                matchCount++;
            }
            if(perfumes == perfumesCount && perfumes != -1) {
                matchCount++;
            }
            return matchCount == 3;
        }

        public boolean matchPartTwo(int childrenCount, int catsCount, int samoyedsCount, int pomeraniansCount, int akitasCount, int vizslasCount, int goldfishCount, int treesCount, int carsCount, int perfumesCount) {
            int matchCount = getMatchCountForCorrectValues(childrenCount, samoyedsCount, akitasCount, vizslasCount, carsCount, perfumesCount, children, samoyeds, akitas, vizslas, cars, perfumes);;
            if (cats > catsCount && cats != -1) {
                matchCount++;
            }
            if (pomeranians < pomeraniansCount && pomeranians != -1) {
                matchCount++;
            }
            if (trees > treesCount && trees != -1) {
                matchCount++;
            }
            if (goldfish < goldfishCount && goldfish != -1) {
                matchCount++;
            }
            return matchCount == 3;
        }

        private int getMatchCountForCorrectValues(int childrenCount, int samoyedsCount, int akitasCount, int vizslasCount, int carsCount, int perfumesCount, int children, int samoyeds, int akitas, int vizslas, int cars, int perfumes) {
            int matchCount = 0;
            if (children == childrenCount && children != -1) {
                matchCount++;
            }
            if (samoyeds == samoyedsCount && samoyeds != -1) {
                matchCount++;
            }
            if (akitas == akitasCount && akitas != -1) {
                matchCount++;
            }
            if (vizslas == vizslasCount && vizslas != -1) {
                matchCount++;
            }
            if (cars == carsCount && cars != -1) {
                matchCount++;
            }
            if (perfumes == perfumesCount && perfumes != -1) {
                matchCount++;
            }
            return matchCount;
        }
    }

    private static final String input = "Sue 1: goldfish: 9, cars: 0, samoyeds: 9\n" +
            "Sue 2: perfumes: 5, trees: 8, goldfish: 8\n" +
            "Sue 3: pomeranians: 2, akitas: 1, trees: 5\n" +
            "Sue 4: goldfish: 10, akitas: 2, perfumes: 9\n" +
            "Sue 5: cars: 5, perfumes: 6, akitas: 9\n" +
            "Sue 6: goldfish: 10, cats: 9, cars: 8\n" +
            "Sue 7: trees: 2, samoyeds: 7, goldfish: 10\n" +
            "Sue 8: cars: 8, perfumes: 6, goldfish: 1\n" +
            "Sue 9: cats: 4, pomeranians: 0, trees: 0\n" +
            "Sue 10: trees: 2, children: 10, samoyeds: 10\n" +
            "Sue 11: akitas: 10, perfumes: 4, vizslas: 1\n" +
            "Sue 12: akitas: 1, trees: 0, goldfish: 3\n" +
            "Sue 13: perfumes: 6, goldfish: 10, cars: 8\n" +
            "Sue 14: cats: 8, akitas: 5, vizslas: 0\n" +
            "Sue 15: cars: 8, trees: 3, samoyeds: 5\n" +
            "Sue 16: vizslas: 6, cats: 6, pomeranians: 10\n" +
            "Sue 17: akitas: 6, cats: 2, perfumes: 9\n" +
            "Sue 18: children: 9, goldfish: 2, akitas: 10\n" +
            "Sue 19: trees: 3, perfumes: 0, goldfish: 6\n" +
            "Sue 20: vizslas: 3, akitas: 0, trees: 1\n" +
            "Sue 21: vizslas: 3, cars: 7, akitas: 3\n" +
            "Sue 22: perfumes: 7, children: 1, pomeranians: 7\n" +
            "Sue 23: trees: 10, cars: 9, akitas: 10\n" +
            "Sue 24: akitas: 5, goldfish: 6, vizslas: 6\n" +
            "Sue 25: samoyeds: 3, trees: 8, vizslas: 5\n" +
            "Sue 26: vizslas: 4, pomeranians: 2, trees: 1\n" +
            "Sue 27: cars: 9, goldfish: 2, trees: 4\n" +
            "Sue 28: vizslas: 6, goldfish: 10, perfumes: 7\n" +
            "Sue 29: vizslas: 6, pomeranians: 3, akitas: 6\n" +
            "Sue 30: trees: 0, samoyeds: 5, akitas: 9\n" +
            "Sue 31: vizslas: 1, perfumes: 0, trees: 6\n" +
            "Sue 32: cars: 7, vizslas: 1, children: 10\n" +
            "Sue 33: vizslas: 1, cars: 1, perfumes: 7\n" +
            "Sue 34: vizslas: 9, trees: 10, akitas: 9\n" +
            "Sue 35: akitas: 3, vizslas: 5, cars: 10\n" +
            "Sue 36: cats: 3, children: 9, samoyeds: 3\n" +
            "Sue 37: vizslas: 5, pomeranians: 7, cars: 6\n" +
            "Sue 38: cars: 10, akitas: 5, vizslas: 8\n" +
            "Sue 39: akitas: 5, trees: 9, children: 2\n" +
            "Sue 40: vizslas: 0, cats: 7, akitas: 0\n" +
            "Sue 41: cars: 9, trees: 10, perfumes: 8\n" +
            "Sue 42: akitas: 4, trees: 2, goldfish: 3\n" +
            "Sue 43: goldfish: 1, cats: 1, akitas: 8\n" +
            "Sue 44: goldfish: 8, akitas: 9, vizslas: 4\n" +
            "Sue 45: perfumes: 3, goldfish: 4, trees: 0\n" +
            "Sue 46: trees: 7, perfumes: 1, goldfish: 8\n" +
            "Sue 47: pomeranians: 10, cars: 7, trees: 2\n" +
            "Sue 48: trees: 2, akitas: 1, cars: 4\n" +
            "Sue 49: goldfish: 5, perfumes: 7, akitas: 8\n" +
            "Sue 50: akitas: 9, vizslas: 9, trees: 2\n" +
            "Sue 51: cars: 0, samoyeds: 0, vizslas: 8\n" +
            "Sue 52: trees: 0, perfumes: 6, pomeranians: 4\n" +
            "Sue 53: vizslas: 1, cats: 6, akitas: 3\n" +
            "Sue 54: samoyeds: 8, akitas: 1, vizslas: 4\n" +
            "Sue 55: goldfish: 10, perfumes: 2, pomeranians: 10\n" +
            "Sue 56: trees: 9, perfumes: 3, goldfish: 5\n" +
            "Sue 57: akitas: 3, perfumes: 0, cats: 2\n" +
            "Sue 58: perfumes: 4, vizslas: 4, cars: 8\n" +
            "Sue 59: goldfish: 7, children: 5, pomeranians: 8\n" +
            "Sue 60: cars: 1, trees: 1, perfumes: 10\n" +
            "Sue 61: trees: 4, samoyeds: 4, cars: 6\n" +
            "Sue 62: akitas: 10, trees: 2, vizslas: 6\n" +
            "Sue 63: goldfish: 3, perfumes: 7, vizslas: 10\n" +
            "Sue 64: pomeranians: 5, children: 10, cars: 0\n" +
            "Sue 65: vizslas: 10, cars: 8, perfumes: 3\n" +
            "Sue 66: children: 5, vizslas: 4, akitas: 10\n" +
            "Sue 67: children: 6, perfumes: 7, cars: 3\n" +
            "Sue 68: goldfish: 8, cars: 6, children: 1\n" +
            "Sue 69: vizslas: 5, perfumes: 3, cars: 9\n" +
            "Sue 70: goldfish: 0, cats: 6, perfumes: 0\n" +
            "Sue 71: trees: 2, samoyeds: 3, cars: 1\n" +
            "Sue 72: cats: 3, akitas: 8, vizslas: 7\n" +
            "Sue 73: akitas: 3, vizslas: 2, goldfish: 6\n" +
            "Sue 74: pomeranians: 10, samoyeds: 9, cats: 8\n" +
            "Sue 75: vizslas: 7, cars: 7, akitas: 10\n" +
            "Sue 76: children: 3, cats: 6, vizslas: 3\n" +
            "Sue 77: goldfish: 7, pomeranians: 10, trees: 0\n" +
            "Sue 78: vizslas: 9, children: 7, trees: 10\n" +
            "Sue 79: trees: 6, pomeranians: 8, samoyeds: 1\n" +
            "Sue 80: vizslas: 5, children: 6, pomeranians: 5\n" +
            "Sue 81: cars: 9, vizslas: 9, akitas: 9\n" +
            "Sue 82: vizslas: 3, cars: 8, akitas: 1\n" +
            "Sue 83: vizslas: 4, trees: 2, cats: 1\n" +
            "Sue 84: children: 3, akitas: 0, vizslas: 1\n" +
            "Sue 85: cats: 6, vizslas: 5, akitas: 2\n" +
            "Sue 86: cars: 3, akitas: 7, goldfish: 8\n" +
            "Sue 87: samoyeds: 8, vizslas: 3, goldfish: 8\n" +
            "Sue 88: vizslas: 4, children: 0, cats: 7\n" +
            "Sue 89: goldfish: 9, pomeranians: 10, samoyeds: 0\n" +
            "Sue 90: trees: 6, akitas: 3, cars: 7\n" +
            "Sue 91: samoyeds: 3, akitas: 7, perfumes: 10\n" +
            "Sue 92: cars: 7, pomeranians: 10, trees: 2\n" +
            "Sue 93: samoyeds: 1, children: 3, cars: 3\n" +
            "Sue 94: samoyeds: 8, akitas: 7, vizslas: 0\n" +
            "Sue 95: goldfish: 7, children: 2, cars: 6\n" +
            "Sue 96: cars: 3, perfumes: 9, akitas: 10\n" +
            "Sue 97: akitas: 9, cars: 10, vizslas: 10\n" +
            "Sue 98: trees: 4, goldfish: 8, pomeranians: 7\n" +
            "Sue 99: samoyeds: 6, pomeranians: 0, vizslas: 7\n" +
            "Sue 100: akitas: 7, perfumes: 8, vizslas: 3\n" +
            "Sue 101: cars: 5, perfumes: 1, trees: 0\n" +
            "Sue 102: akitas: 6, pomeranians: 10, trees: 0\n" +
            "Sue 103: trees: 3, perfumes: 5, cats: 9\n" +
            "Sue 104: goldfish: 10, perfumes: 8, akitas: 0\n" +
            "Sue 105: goldfish: 6, vizslas: 5, trees: 2\n" +
            "Sue 106: pomeranians: 9, samoyeds: 10, perfumes: 10\n" +
            "Sue 107: cars: 8, vizslas: 4, akitas: 2\n" +
            "Sue 108: cats: 0, goldfish: 7, trees: 0\n" +
            "Sue 109: cars: 3, pomeranians: 6, trees: 2\n" +
            "Sue 110: perfumes: 4, goldfish: 5, akitas: 10\n" +
            "Sue 111: cars: 3, perfumes: 4, pomeranians: 4\n" +
            "Sue 112: cats: 2, goldfish: 10, akitas: 0\n" +
            "Sue 113: cats: 10, children: 0, trees: 1\n" +
            "Sue 114: akitas: 10, vizslas: 3, goldfish: 0\n" +
            "Sue 115: samoyeds: 3, goldfish: 6, vizslas: 1\n" +
            "Sue 116: cars: 3, perfumes: 5, trees: 6\n" +
            "Sue 117: akitas: 9, samoyeds: 8, goldfish: 8\n" +
            "Sue 118: pomeranians: 5, perfumes: 10, trees: 1\n" +
            "Sue 119: goldfish: 6, perfumes: 3, children: 1\n" +
            "Sue 120: trees: 1, children: 3, pomeranians: 6\n" +
            "Sue 121: akitas: 7, cars: 10, vizslas: 9\n" +
            "Sue 122: trees: 4, akitas: 8, samoyeds: 10\n" +
            "Sue 123: cats: 4, cars: 8, vizslas: 9\n" +
            "Sue 124: cars: 10, children: 1, trees: 0\n" +
            "Sue 125: goldfish: 5, pomeranians: 5, trees: 2\n" +
            "Sue 126: goldfish: 1, vizslas: 8, akitas: 10\n" +
            "Sue 127: vizslas: 4, cars: 9, akitas: 1\n" +
            "Sue 128: goldfish: 8, perfumes: 3, cars: 9\n" +
            "Sue 129: goldfish: 9, pomeranians: 9, perfumes: 1\n" +
            "Sue 130: trees: 1, vizslas: 9, perfumes: 3\n" +
            "Sue 131: children: 6, trees: 8, vizslas: 8\n" +
            "Sue 132: cars: 1, vizslas: 3, children: 7\n" +
            "Sue 133: cars: 7, children: 1, perfumes: 6\n" +
            "Sue 134: trees: 8, vizslas: 3, samoyeds: 2\n" +
            "Sue 135: cats: 9, perfumes: 4, pomeranians: 7\n" +
            "Sue 136: perfumes: 0, akitas: 8, vizslas: 6\n" +
            "Sue 137: goldfish: 5, trees: 0, vizslas: 7\n" +
            "Sue 138: trees: 1, perfumes: 2, cars: 10\n" +
            "Sue 139: samoyeds: 8, goldfish: 8, trees: 0\n" +
            "Sue 140: vizslas: 10, perfumes: 9, goldfish: 0\n" +
            "Sue 141: perfumes: 7, cars: 9, cats: 5\n" +
            "Sue 142: trees: 2, samoyeds: 2, cars: 0\n" +
            "Sue 143: cars: 1, perfumes: 1, akitas: 1\n" +
            "Sue 144: vizslas: 9, cars: 7, pomeranians: 10\n" +
            "Sue 145: pomeranians: 2, samoyeds: 7, children: 7\n" +
            "Sue 146: vizslas: 6, cars: 9, goldfish: 7\n" +
            "Sue 147: trees: 2, vizslas: 1, cats: 9\n" +
            "Sue 148: perfumes: 9, trees: 4, pomeranians: 5\n" +
            "Sue 149: samoyeds: 8, children: 1, vizslas: 9\n" +
            "Sue 150: cats: 3, trees: 2, vizslas: 4\n" +
            "Sue 151: goldfish: 7, akitas: 10, trees: 3\n" +
            "Sue 152: perfumes: 4, vizslas: 7, cars: 4\n" +
            "Sue 153: pomeranians: 4, akitas: 0, vizslas: 3\n" +
            "Sue 154: samoyeds: 8, trees: 2, vizslas: 10\n" +
            "Sue 155: vizslas: 7, cats: 7, pomeranians: 5\n" +
            "Sue 156: goldfish: 10, pomeranians: 1, vizslas: 1\n" +
            "Sue 157: cars: 6, perfumes: 7, trees: 9\n" +
            "Sue 158: trees: 5, samoyeds: 9, goldfish: 3\n" +
            "Sue 159: pomeranians: 4, akitas: 6, vizslas: 8\n" +
            "Sue 160: goldfish: 7, children: 0, cats: 0\n" +
            "Sue 161: vizslas: 5, akitas: 0, samoyeds: 2\n" +
            "Sue 162: akitas: 4, children: 0, vizslas: 3\n" +
            "Sue 163: samoyeds: 2, perfumes: 0, goldfish: 9\n" +
            "Sue 164: cars: 9, vizslas: 8, akitas: 6\n" +
            "Sue 165: samoyeds: 9, vizslas: 9, perfumes: 5\n" +
            "Sue 166: cars: 5, pomeranians: 4, samoyeds: 8\n" +
            "Sue 167: cars: 10, perfumes: 3, samoyeds: 6\n" +
            "Sue 168: pomeranians: 8, goldfish: 9, trees: 9\n" +
            "Sue 169: vizslas: 7, akitas: 3, samoyeds: 4\n" +
            "Sue 170: cats: 2, goldfish: 0, vizslas: 4\n" +
            "Sue 171: perfumes: 3, goldfish: 10, cats: 3\n" +
            "Sue 172: goldfish: 7, akitas: 6, cars: 0\n" +
            "Sue 173: cars: 9, goldfish: 7, akitas: 5\n" +
            "Sue 174: goldfish: 6, cats: 0, vizslas: 8\n" +
            "Sue 175: perfumes: 7, cats: 10, cars: 10\n" +
            "Sue 176: samoyeds: 9, vizslas: 4, pomeranians: 10\n" +
            "Sue 177: perfumes: 0, trees: 0, cars: 10\n" +
            "Sue 178: vizslas: 6, children: 7, samoyeds: 1\n" +
            "Sue 179: vizslas: 8, children: 6, trees: 0\n" +
            "Sue 180: cars: 1, vizslas: 6, trees: 1\n" +
            "Sue 181: vizslas: 10, perfumes: 3, cars: 1\n" +
            "Sue 182: trees: 8, samoyeds: 9, cars: 7\n" +
            "Sue 183: cars: 6, vizslas: 2, perfumes: 7\n" +
            "Sue 184: trees: 5, samoyeds: 9, akitas: 0\n" +
            "Sue 185: cars: 8, goldfish: 8, trees: 4\n" +
            "Sue 186: samoyeds: 6, goldfish: 1, trees: 2\n" +
            "Sue 187: perfumes: 1, trees: 2, akitas: 7\n" +
            "Sue 188: samoyeds: 5, cars: 6, perfumes: 2\n" +
            "Sue 189: samoyeds: 8, goldfish: 3, perfumes: 5\n" +
            "Sue 190: akitas: 2, cats: 1, samoyeds: 1\n" +
            "Sue 191: trees: 5, akitas: 1, goldfish: 7\n" +
            "Sue 192: vizslas: 3, trees: 0, perfumes: 4\n" +
            "Sue 193: cars: 3, perfumes: 4, akitas: 3\n" +
            "Sue 194: perfumes: 4, vizslas: 8, children: 4\n" +
            "Sue 195: vizslas: 1, samoyeds: 3, cars: 6\n" +
            "Sue 196: cars: 5, perfumes: 6, vizslas: 2\n" +
            "Sue 197: vizslas: 8, akitas: 8, cats: 6\n" +
            "Sue 198: cars: 9, akitas: 2, pomeranians: 7\n" +
            "Sue 199: cats: 9, akitas: 6, cars: 10\n" +
            "Sue 200: vizslas: 10, pomeranians: 2, goldfish: 9\n" +
            "Sue 201: vizslas: 9, samoyeds: 4, akitas: 3\n" +
            "Sue 202: akitas: 5, cats: 2, vizslas: 0\n" +
            "Sue 203: perfumes: 1, children: 3, akitas: 10\n" +
            "Sue 204: trees: 4, vizslas: 7, akitas: 9\n" +
            "Sue 205: trees: 8, perfumes: 9, cars: 1\n" +
            "Sue 206: goldfish: 6, trees: 5, cars: 8\n" +
            "Sue 207: akitas: 3, vizslas: 8, trees: 8\n" +
            "Sue 208: vizslas: 4, perfumes: 7, akitas: 10\n" +
            "Sue 209: cars: 9, perfumes: 7, goldfish: 9\n" +
            "Sue 210: vizslas: 2, cats: 2, akitas: 10\n" +
            "Sue 211: akitas: 1, trees: 3, cars: 2\n" +
            "Sue 212: goldfish: 5, trees: 0, vizslas: 7\n" +
            "Sue 213: akitas: 3, perfumes: 1, vizslas: 5\n" +
            "Sue 214: perfumes: 3, pomeranians: 6, cars: 0\n" +
            "Sue 215: goldfish: 1, cats: 9, cars: 3\n" +
            "Sue 216: goldfish: 9, pomeranians: 6, samoyeds: 0\n" +
            "Sue 217: cars: 6, trees: 2, perfumes: 2\n" +
            "Sue 218: vizslas: 3, goldfish: 8, akitas: 5\n" +
            "Sue 219: cats: 9, perfumes: 7, cars: 5\n" +
            "Sue 220: pomeranians: 5, vizslas: 4, cats: 5\n" +
            "Sue 221: trees: 0, akitas: 7, goldfish: 10\n" +
            "Sue 222: akitas: 2, cars: 3, vizslas: 5\n" +
            "Sue 223: goldfish: 3, perfumes: 7, akitas: 4\n" +
            "Sue 224: samoyeds: 2, cars: 4, vizslas: 7\n" +
            "Sue 225: trees: 5, cars: 0, perfumes: 0\n" +
            "Sue 226: trees: 2, goldfish: 10, perfumes: 6\n" +
            "Sue 227: cars: 8, trees: 9, akitas: 6\n" +
            "Sue 228: goldfish: 10, trees: 10, perfumes: 0\n" +
            "Sue 229: children: 7, samoyeds: 4, goldfish: 6\n" +
            "Sue 230: vizslas: 9, perfumes: 1, children: 10\n" +
            "Sue 231: vizslas: 8, trees: 5, akitas: 9\n" +
            "Sue 232: akitas: 5, goldfish: 9, trees: 1\n" +
            "Sue 233: vizslas: 3, trees: 2, children: 9\n" +
            "Sue 234: samoyeds: 8, perfumes: 0, cats: 0\n" +
            "Sue 235: perfumes: 4, vizslas: 3, akitas: 5\n" +
            "Sue 236: pomeranians: 5, vizslas: 3, akitas: 9\n" +
            "Sue 237: cats: 1, trees: 7, vizslas: 5\n" +
            "Sue 238: children: 5, cats: 4, samoyeds: 5\n" +
            "Sue 239: trees: 3, akitas: 2, goldfish: 6\n" +
            "Sue 240: goldfish: 9, trees: 1, perfumes: 1\n" +
            "Sue 241: cars: 2, pomeranians: 1, samoyeds: 2\n" +
            "Sue 242: akitas: 2, trees: 3, cars: 4\n" +
            "Sue 243: vizslas: 6, akitas: 2, samoyeds: 7\n" +
            "Sue 244: trees: 0, perfumes: 5, cars: 7\n" +
            "Sue 245: goldfish: 10, perfumes: 5, vizslas: 8\n" +
            "Sue 246: akitas: 0, perfumes: 0, cars: 1\n" +
            "Sue 247: samoyeds: 8, goldfish: 0, cars: 6\n" +
            "Sue 248: perfumes: 0, children: 10, trees: 10\n" +
            "Sue 249: perfumes: 6, akitas: 5, cats: 5\n" +
            "Sue 250: vizslas: 7, akitas: 4, cats: 5\n" +
            "Sue 251: samoyeds: 4, akitas: 1, trees: 8\n" +
            "Sue 252: perfumes: 8, pomeranians: 5, cars: 1\n" +
            "Sue 253: akitas: 10, trees: 4, cats: 3\n" +
            "Sue 254: perfumes: 2, cats: 2, goldfish: 9\n" +
            "Sue 255: cars: 4, trees: 1, akitas: 4\n" +
            "Sue 256: samoyeds: 9, goldfish: 0, akitas: 9\n" +
            "Sue 257: vizslas: 9, perfumes: 2, goldfish: 2\n" +
            "Sue 258: perfumes: 1, cars: 9, samoyeds: 1\n" +
            "Sue 259: trees: 0, goldfish: 0, samoyeds: 3\n" +
            "Sue 260: perfumes: 7, cars: 1, goldfish: 0\n" +
            "Sue 261: cars: 0, trees: 5, goldfish: 6\n" +
            "Sue 262: akitas: 7, vizslas: 3, pomeranians: 5\n" +
            "Sue 263: trees: 1, vizslas: 3, goldfish: 3\n" +
            "Sue 264: akitas: 7, vizslas: 4, children: 0\n" +
            "Sue 265: samoyeds: 5, trees: 0, akitas: 4\n" +
            "Sue 266: perfumes: 9, goldfish: 9, cars: 8\n" +
            "Sue 267: cars: 7, perfumes: 10, pomeranians: 8\n" +
            "Sue 268: cars: 0, akitas: 7, perfumes: 4\n" +
            "Sue 269: pomeranians: 0, cars: 9, perfumes: 10\n" +
            "Sue 270: samoyeds: 10, perfumes: 10, cars: 9\n" +
            "Sue 271: akitas: 2, vizslas: 8, cats: 5\n" +
            "Sue 272: akitas: 3, children: 9, samoyeds: 10\n" +
            "Sue 273: perfumes: 2, cars: 10, goldfish: 8\n" +
            "Sue 274: cars: 3, children: 10, perfumes: 10\n" +
            "Sue 275: cats: 9, akitas: 5, trees: 0\n" +
            "Sue 276: akitas: 6, children: 2, vizslas: 1\n" +
            "Sue 277: pomeranians: 6, trees: 10, samoyeds: 3\n" +
            "Sue 278: cars: 7, perfumes: 10, trees: 1\n" +
            "Sue 279: cars: 6, pomeranians: 8, trees: 2\n" +
            "Sue 280: pomeranians: 9, cats: 0, perfumes: 7\n" +
            "Sue 281: vizslas: 10, goldfish: 9, pomeranians: 5\n" +
            "Sue 282: perfumes: 4, samoyeds: 7, cars: 9\n" +
            "Sue 283: cars: 9, vizslas: 6, trees: 5\n" +
            "Sue 284: cars: 7, trees: 1, vizslas: 4\n" +
            "Sue 285: samoyeds: 4, goldfish: 10, cats: 4\n" +
            "Sue 286: samoyeds: 0, akitas: 4, children: 5\n" +
            "Sue 287: trees: 1, perfumes: 3, goldfish: 10\n" +
            "Sue 288: pomeranians: 10, akitas: 3, cars: 2\n" +
            "Sue 289: trees: 7, pomeranians: 4, goldfish: 10\n" +
            "Sue 290: samoyeds: 10, perfumes: 0, cars: 9\n" +
            "Sue 291: akitas: 0, pomeranians: 7, vizslas: 4\n" +
            "Sue 292: cats: 2, vizslas: 8, goldfish: 5\n" +
            "Sue 293: vizslas: 6, pomeranians: 9, perfumes: 0\n" +
            "Sue 294: akitas: 6, cars: 7, vizslas: 5\n" +
            "Sue 295: goldfish: 0, akitas: 9, cats: 0\n" +
            "Sue 296: goldfish: 1, trees: 0, cars: 6\n" +
            "Sue 297: perfumes: 6, cats: 8, pomeranians: 6\n" +
            "Sue 298: cats: 0, goldfish: 6, perfumes: 2\n" +
            "Sue 299: cars: 4, akitas: 1, samoyeds: 10\n" +
            "Sue 300: goldfish: 9, samoyeds: 6, cats: 5\n" +
            "Sue 301: cars: 0, vizslas: 7, trees: 0\n" +
            "Sue 302: goldfish: 9, samoyeds: 1, children: 6\n" +
            "Sue 303: cars: 6, perfumes: 7, samoyeds: 8\n" +
            "Sue 304: trees: 8, goldfish: 9, children: 9\n" +
            "Sue 305: perfumes: 0, cars: 5, goldfish: 4\n" +
            "Sue 306: cats: 3, cars: 7, vizslas: 7\n" +
            "Sue 307: pomeranians: 4, perfumes: 6, cars: 2\n" +
            "Sue 308: cars: 9, akitas: 6, goldfish: 4\n" +
            "Sue 309: pomeranians: 2, vizslas: 10, goldfish: 10\n" +
            "Sue 310: children: 0, cats: 4, akitas: 7\n" +
            "Sue 311: children: 10, akitas: 8, vizslas: 2\n" +
            "Sue 312: children: 5, cars: 0, vizslas: 4\n" +
            "Sue 313: perfumes: 10, trees: 3, pomeranians: 9\n" +
            "Sue 314: samoyeds: 3, goldfish: 2, trees: 9\n" +
            "Sue 315: cars: 2, cats: 5, pomeranians: 10\n" +
            "Sue 316: cats: 6, pomeranians: 6, children: 9\n" +
            "Sue 317: cats: 2, vizslas: 3, perfumes: 1\n" +
            "Sue 318: akitas: 1, perfumes: 3, vizslas: 10\n" +
            "Sue 319: cars: 7, perfumes: 0, trees: 0\n" +
            "Sue 320: goldfish: 6, samoyeds: 6, pomeranians: 4\n" +
            "Sue 321: trees: 2, goldfish: 6, children: 0\n" +
            "Sue 322: goldfish: 0, trees: 2, akitas: 8\n" +
            "Sue 323: pomeranians: 2, samoyeds: 9, vizslas: 1\n" +
            "Sue 324: trees: 4, goldfish: 6, pomeranians: 6\n" +
            "Sue 325: trees: 2, pomeranians: 3, goldfish: 1\n" +
            "Sue 326: perfumes: 4, goldfish: 6, trees: 5\n" +
            "Sue 327: akitas: 3, cars: 8, cats: 2\n" +
            "Sue 328: cats: 6, vizslas: 0, akitas: 2\n" +
            "Sue 329: perfumes: 3, goldfish: 10, akitas: 3\n" +
            "Sue 330: goldfish: 3, vizslas: 1, akitas: 6\n" +
            "Sue 331: perfumes: 4, trees: 1, goldfish: 5\n" +
            "Sue 332: goldfish: 7, vizslas: 9, akitas: 1\n" +
            "Sue 333: children: 8, cars: 8, trees: 4\n" +
            "Sue 334: cars: 1, vizslas: 6, trees: 0\n" +
            "Sue 335: goldfish: 2, cars: 2, akitas: 1\n" +
            "Sue 336: goldfish: 5, akitas: 5, trees: 9\n" +
            "Sue 337: cars: 5, vizslas: 6, goldfish: 6\n" +
            "Sue 338: cats: 9, akitas: 3, goldfish: 9\n" +
            "Sue 339: akitas: 3, cats: 2, children: 7\n" +
            "Sue 340: goldfish: 0, pomeranians: 8, perfumes: 9\n" +
            "Sue 341: trees: 0, pomeranians: 1, goldfish: 5\n" +
            "Sue 342: goldfish: 10, trees: 3, vizslas: 4\n" +
            "Sue 343: cats: 3, samoyeds: 1, children: 6\n" +
            "Sue 344: perfumes: 3, children: 4, samoyeds: 2\n" +
            "Sue 345: children: 6, trees: 2, goldfish: 1\n" +
            "Sue 346: trees: 2, pomeranians: 3, goldfish: 5\n" +
            "Sue 347: akitas: 10, vizslas: 7, trees: 1\n" +
            "Sue 348: perfumes: 4, akitas: 2, vizslas: 7\n" +
            "Sue 349: perfumes: 8, goldfish: 3, vizslas: 5\n" +
            "Sue 350: trees: 4, pomeranians: 5, akitas: 10\n" +
            "Sue 351: perfumes: 5, cars: 9, trees: 0\n" +
            "Sue 352: akitas: 6, children: 8, trees: 10\n" +
            "Sue 353: samoyeds: 7, akitas: 6, vizslas: 4\n" +
            "Sue 354: children: 9, goldfish: 7, perfumes: 5\n" +
            "Sue 355: trees: 1, perfumes: 4, cars: 1\n" +
            "Sue 356: samoyeds: 1, perfumes: 4, pomeranians: 8\n" +
            "Sue 357: trees: 7, goldfish: 10, akitas: 0\n" +
            "Sue 358: akitas: 1, vizslas: 6, cars: 7\n" +
            "Sue 359: vizslas: 3, goldfish: 8, trees: 4\n" +
            "Sue 360: akitas: 10, vizslas: 2, trees: 3\n" +
            "Sue 361: samoyeds: 6, pomeranians: 1, perfumes: 0\n" +
            "Sue 362: samoyeds: 3, cars: 1, trees: 0\n" +
            "Sue 363: vizslas: 0, pomeranians: 9, akitas: 4\n" +
            "Sue 364: perfumes: 9, pomeranians: 8, vizslas: 9\n" +
            "Sue 365: vizslas: 7, cars: 4, perfumes: 10\n" +
            "Sue 366: cars: 0, samoyeds: 5, goldfish: 10\n" +
            "Sue 367: children: 4, vizslas: 5, akitas: 4\n" +
            "Sue 368: samoyeds: 9, perfumes: 4, vizslas: 6\n" +
            "Sue 369: perfumes: 5, cars: 4, samoyeds: 5\n" +
            "Sue 370: akitas: 3, vizslas: 2, perfumes: 1\n" +
            "Sue 371: cars: 8, cats: 7, children: 5\n" +
            "Sue 372: vizslas: 9, perfumes: 2, akitas: 10\n" +
            "Sue 373: trees: 10, pomeranians: 9, goldfish: 3\n" +
            "Sue 374: children: 4, cars: 10, perfumes: 2\n" +
            "Sue 375: children: 7, samoyeds: 5, cats: 0\n" +
            "Sue 376: akitas: 10, samoyeds: 5, vizslas: 5\n" +
            "Sue 377: goldfish: 8, trees: 3, perfumes: 3\n" +
            "Sue 378: goldfish: 10, vizslas: 0, perfumes: 2\n" +
            "Sue 379: trees: 1, vizslas: 7, pomeranians: 4\n" +
            "Sue 380: samoyeds: 8, vizslas: 3, trees: 2\n" +
            "Sue 381: goldfish: 2, perfumes: 5, samoyeds: 9\n" +
            "Sue 382: cats: 3, vizslas: 10, akitas: 5\n" +
            "Sue 383: cars: 7, goldfish: 5, akitas: 8\n" +
            "Sue 384: children: 6, goldfish: 10, trees: 1\n" +
            "Sue 385: cats: 2, akitas: 6, samoyeds: 7\n" +
            "Sue 386: cars: 10, children: 4, goldfish: 2\n" +
            "Sue 387: cats: 0, perfumes: 5, akitas: 9\n" +
            "Sue 388: pomeranians: 7, akitas: 0, samoyeds: 9\n" +
            "Sue 389: trees: 0, akitas: 9, vizslas: 8\n" +
            "Sue 390: cars: 0, trees: 10, perfumes: 9\n" +
            "Sue 391: cats: 9, goldfish: 10, perfumes: 10\n" +
            "Sue 392: cars: 3, vizslas: 6, cats: 3\n" +
            "Sue 393: vizslas: 10, perfumes: 4, goldfish: 5\n" +
            "Sue 394: perfumes: 4, akitas: 10, trees: 2\n" +
            "Sue 395: pomeranians: 5, cars: 4, perfumes: 3\n" +
            "Sue 396: pomeranians: 9, vizslas: 5, akitas: 2\n" +
            "Sue 397: cars: 10, goldfish: 8, trees: 2\n" +
            "Sue 398: perfumes: 7, children: 9, goldfish: 9\n" +
            "Sue 399: akitas: 6, cats: 2, goldfish: 7\n" +
            "Sue 400: goldfish: 9, perfumes: 0, cars: 2\n" +
            "Sue 401: children: 4, vizslas: 0, trees: 2\n" +
            "Sue 402: akitas: 4, cars: 8, pomeranians: 4\n" +
            "Sue 403: vizslas: 8, perfumes: 7, goldfish: 1\n" +
            "Sue 404: goldfish: 10, samoyeds: 7, vizslas: 3\n" +
            "Sue 405: akitas: 1, vizslas: 6, perfumes: 6\n" +
            "Sue 406: pomeranians: 8, goldfish: 6, cats: 3\n" +
            "Sue 407: goldfish: 2, vizslas: 4, akitas: 7\n" +
            "Sue 408: cars: 10, perfumes: 10, vizslas: 3\n" +
            "Sue 409: vizslas: 7, pomeranians: 4, perfumes: 4\n" +
            "Sue 410: goldfish: 4, vizslas: 7, trees: 5\n" +
            "Sue 411: cars: 8, trees: 0, goldfish: 4\n" +
            "Sue 412: cars: 8, perfumes: 5, vizslas: 4\n" +
            "Sue 413: vizslas: 3, akitas: 7, samoyeds: 6\n" +
            "Sue 414: trees: 0, perfumes: 6, cars: 10\n" +
            "Sue 415: pomeranians: 4, trees: 1, perfumes: 6\n" +
            "Sue 416: cars: 10, perfumes: 6, akitas: 2\n" +
            "Sue 417: perfumes: 6, samoyeds: 0, akitas: 0\n" +
            "Sue 418: children: 1, perfumes: 9, vizslas: 3\n" +
            "Sue 419: goldfish: 9, samoyeds: 3, perfumes: 8\n" +
            "Sue 420: goldfish: 4, cars: 10, vizslas: 7\n" +
            "Sue 421: samoyeds: 7, vizslas: 7, cats: 2\n" +
            "Sue 422: trees: 1, goldfish: 8, perfumes: 0\n" +
            "Sue 423: cars: 3, perfumes: 2, trees: 3\n" +
            "Sue 424: samoyeds: 6, vizslas: 0, akitas: 6\n" +
            "Sue 425: trees: 3, akitas: 7, goldfish: 1\n" +
            "Sue 426: cars: 9, trees: 1, perfumes: 0\n" +
            "Sue 427: pomeranians: 0, children: 5, perfumes: 8\n" +
            "Sue 428: cars: 0, perfumes: 6, children: 4\n" +
            "Sue 429: akitas: 7, pomeranians: 9, cats: 6\n" +
            "Sue 430: cats: 6, trees: 1, cars: 0\n" +
            "Sue 431: children: 8, akitas: 5, perfumes: 9\n" +
            "Sue 432: perfumes: 5, akitas: 10, trees: 9\n" +
            "Sue 433: akitas: 4, perfumes: 10, vizslas: 7\n" +
            "Sue 434: trees: 3, children: 10, samoyeds: 4\n" +
            "Sue 435: vizslas: 5, goldfish: 2, akitas: 2\n" +
            "Sue 436: samoyeds: 3, trees: 2, cars: 6\n" +
            "Sue 437: children: 9, akitas: 0, pomeranians: 3\n" +
            "Sue 438: perfumes: 10, akitas: 2, cars: 7\n" +
            "Sue 439: perfumes: 10, samoyeds: 6, akitas: 10\n" +
            "Sue 440: vizslas: 10, trees: 2, akitas: 8\n" +
            "Sue 441: perfumes: 8, akitas: 2, pomeranians: 7\n" +
            "Sue 442: cars: 8, trees: 3, goldfish: 6\n" +
            "Sue 443: cars: 1, goldfish: 5, vizslas: 5\n" +
            "Sue 444: vizslas: 2, akitas: 10, samoyeds: 4\n" +
            "Sue 445: vizslas: 2, akitas: 10, perfumes: 9\n" +
            "Sue 446: akitas: 3, vizslas: 8, goldfish: 1\n" +
            "Sue 447: vizslas: 7, pomeranians: 5, trees: 10\n" +
            "Sue 448: cats: 6, perfumes: 10, children: 6\n" +
            "Sue 449: trees: 2, cars: 5, goldfish: 8\n" +
            "Sue 450: trees: 0, goldfish: 6, samoyeds: 3\n" +
            "Sue 451: perfumes: 0, cars: 8, trees: 1\n" +
            "Sue 452: akitas: 4, trees: 8, perfumes: 9\n" +
            "Sue 453: goldfish: 1, perfumes: 7, akitas: 6\n" +
            "Sue 454: vizslas: 3, cars: 1, perfumes: 6\n" +
            "Sue 455: trees: 1, akitas: 7, goldfish: 10\n" +
            "Sue 456: samoyeds: 4, vizslas: 2, cars: 9\n" +
            "Sue 457: perfumes: 10, children: 1, trees: 8\n" +
            "Sue 458: perfumes: 0, vizslas: 9, cars: 8\n" +
            "Sue 459: cats: 0, children: 7, trees: 3\n" +
            "Sue 460: vizslas: 4, cats: 6, perfumes: 2\n" +
            "Sue 461: trees: 3, children: 5, cars: 8\n" +
            "Sue 462: goldfish: 7, vizslas: 7, children: 5\n" +
            "Sue 463: cars: 5, akitas: 3, goldfish: 5\n" +
            "Sue 464: vizslas: 0, pomeranians: 5, cars: 0\n" +
            "Sue 465: goldfish: 4, akitas: 0, cats: 5\n" +
            "Sue 466: cars: 5, trees: 1, goldfish: 6\n" +
            "Sue 467: perfumes: 10, trees: 8, cars: 1\n" +
            "Sue 468: perfumes: 4, akitas: 3, cars: 0\n" +
            "Sue 469: vizslas: 3, cars: 7, pomeranians: 1\n" +
            "Sue 470: perfumes: 1, vizslas: 7, akitas: 8\n" +
            "Sue 471: goldfish: 10, samoyeds: 10, pomeranians: 5\n" +
            "Sue 472: goldfish: 6, trees: 0, perfumes: 0\n" +
            "Sue 473: goldfish: 5, vizslas: 0, children: 5\n" +
            "Sue 474: cars: 3, vizslas: 7, perfumes: 10\n" +
            "Sue 475: vizslas: 5, trees: 9, goldfish: 8\n" +
            "Sue 476: akitas: 2, goldfish: 6, children: 7\n" +
            "Sue 477: samoyeds: 0, perfumes: 1, pomeranians: 5\n" +
            "Sue 478: trees: 2, goldfish: 9, vizslas: 0\n" +
            "Sue 479: perfumes: 1, cars: 6, goldfish: 9\n" +
            "Sue 480: pomeranians: 3, perfumes: 5, trees: 9\n" +
            "Sue 481: cats: 3, akitas: 0, vizslas: 8\n" +
            "Sue 482: pomeranians: 10, akitas: 8, trees: 5\n" +
            "Sue 483: goldfish: 6, akitas: 10, perfumes: 2\n" +
            "Sue 484: cats: 0, goldfish: 0, children: 9\n" +
            "Sue 485: children: 4, akitas: 10, vizslas: 8\n" +
            "Sue 486: vizslas: 3, goldfish: 9, children: 10\n" +
            "Sue 487: children: 8, cats: 6, vizslas: 10\n" +
            "Sue 488: cars: 7, akitas: 10, samoyeds: 5\n" +
            "Sue 489: vizslas: 9, akitas: 6, trees: 2\n" +
            "Sue 490: vizslas: 5, akitas: 1, children: 5\n" +
            "Sue 491: vizslas: 8, goldfish: 3, perfumes: 6\n" +
            "Sue 492: trees: 3, samoyeds: 1, pomeranians: 6\n" +
            "Sue 493: akitas: 1, vizslas: 5, cars: 8\n" +
            "Sue 494: akitas: 4, cars: 4, vizslas: 9\n" +
            "Sue 495: vizslas: 1, akitas: 2, cats: 2\n" +
            "Sue 496: trees: 7, vizslas: 5, akitas: 6\n" +
            "Sue 497: akitas: 8, trees: 2, perfumes: 6\n" +
            "Sue 498: akitas: 1, trees: 1, samoyeds: 4\n" +
            "Sue 499: cars: 0, akitas: 5, vizslas: 3\n" +
            "Sue 500: cats: 2, goldfish: 9, children: 8";
}
