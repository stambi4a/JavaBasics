package Problem03.PossibleTriangles;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        findTriangles();
    }

    private static void findTriangles() {
        Scanner scanner = new Scanner(System.in);
        List<String> triangles = new ArrayList<>();
        while(true) {
            String input = scanner.nextLine();
            if(input.equals("End")) {
                break;
            }

            double[] sides = Arrays.asList(input.split("\\s+")).
                    stream().
                    mapToDouble(Double::parseDouble).toArray();
            if(sides[0] + sides[1] > sides[2] &&
                    sides[1] + sides[2] > sides[0] &&
                    sides[2] + sides[0] > sides[1]) {
                Arrays.sort(sides);
                triangles.add(String.format(Locale.ENGLISH, "%.2f+%.2f>%.2f", sides[0], sides[1], sides[2]));
            }
        }

        if(triangles.size() == 0) {
            System.out.println("No");
        } else {
            System.out.println(String.join("\n", triangles));
        }
    }
}
