package Problem02.MirrorNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        findMirrorNumbers();
    }

    private static void findMirrorNumbers() {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        int[] numbers = Arrays.asList(scanner.nextLine().split("\\s+")).
                stream().mapToInt(Integer:: parseInt).toArray();
        List<String> mirrorNumbers = new ArrayList<>();
        for(int i = 0; i < count - 1; i++) {
            int firstNumber = numbers[i];
            for(int j = i + 1; j < count; j++) {
                if(checkIfMirrorNumbers(firstNumber, numbers[j])) {
                    mirrorNumbers.add(firstNumber + "<!>" + numbers[j]);
                }
            }
        }

        if(mirrorNumbers.size() == 0) {
            System.out.println("No");
        }
        System.out.println(String.join("\n", mirrorNumbers));
    }

    private static boolean checkIfMirrorNumbers(int first, int second) {
        int mirror = 0;
        mirror += (first%10) * 1000;
        first /= 10;
        mirror += (first%10) * 100;
        first /= 10;
        mirror += (first%10) * 10;
        first /= 10;
        mirror += first%10;

        return mirror == second;
    }
}