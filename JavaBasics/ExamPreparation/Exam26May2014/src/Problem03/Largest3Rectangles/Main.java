package Problem03.Largest3Rectangles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String rectanglePattern = "(\\d+)\\s*x\\s*(\\d+)";
        Pattern pattern = Pattern.compile(rectanglePattern);
        List<Integer> areas = new ArrayList<>();
        Matcher match = pattern.matcher(input);
        while(match.find()) {
            int firstSide = Integer.parseInt(match.group(1));
            int secondSide = Integer.parseInt(match.group(2));
            int area = firstSide * secondSide;
            areas.add(area);
        }

        int[] rectangleAreas = areas.stream().mapToInt(i->i).toArray();
        int length = rectangleAreas.length;
        int maxThreeRectanglesArea = 0;
        for(int i = 0; i < length - 2; i++) {
            int threeRectanglesArea = rectangleAreas[i] + rectangleAreas[i + 1] + rectangleAreas[i + 2];
            if(threeRectanglesArea > maxThreeRectanglesArea) {
                maxThreeRectanglesArea = threeRectanglesArea;
            }
        }

        System.out.println(maxThreeRectanglesArea);
    }
}
