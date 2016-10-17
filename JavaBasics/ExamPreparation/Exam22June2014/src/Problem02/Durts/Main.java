package Problem02.Durts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        hitTheTarget();
    }

    private static void hitTheTarget() {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\\s+");
        int xCenter = scanner.nextInt();
        int yCenter = scanner.nextInt();
        scanner.nextLine();
        int radius = scanner.nextInt();
        int maxDiag = radius / 2;
        scanner.nextLine();
        int countPairs = scanner.nextInt();
        scanner.nextLine();

        int[] xCoord = new int[countPairs];
        int[] yCoord = new int[countPairs];
        List<String> results = new ArrayList<>();
        for(int i = 0; i < countPairs; i++) {
            xCoord[i] = scanner.nextInt();
            yCoord[i] = scanner.nextInt();
            if((Math.abs(xCoord[i] - xCenter) <= maxDiag && Math.abs(yCoord[i] - yCenter) <= radius) ||
                    (Math.abs(yCoord[i] - yCenter) <= maxDiag && Math.abs(xCoord[i] - xCenter) <= radius)) {
                results.add("yes");
            } else {
                results.add("no");
            }
        }

        System.out.println(String.join("\n", results));
    }

}
