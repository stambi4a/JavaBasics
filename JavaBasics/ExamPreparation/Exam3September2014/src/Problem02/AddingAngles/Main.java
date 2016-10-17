package Problem02.AddingAngles;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final int DEGREES_IN_CIRCLE = 360;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        int[] numbers = Arrays.asList(scanner.nextLine().split("\\s+")).stream().mapToInt(Integer:: parseInt).toArray();
        boolean exist = false;
        for(int i = 0; i < count - 2; i++) {
            for(int j = i + 1; j < count - 1; j++) {
                for(int k = j + 1; k < count; k++) {
                    int degrees = numbers[i] + numbers[j] + numbers[k];
                    if(degrees % DEGREES_IN_CIRCLE == 0) {
                        System.out.printf("%d + %d + %d = %d degrees", numbers[i], numbers[j], numbers[k], degrees);
                        exist = true;
                        System.out.println();
                    }
                }
            }
        }

        if(!exist) {
            System.out.println("No");
        }
    }
}
