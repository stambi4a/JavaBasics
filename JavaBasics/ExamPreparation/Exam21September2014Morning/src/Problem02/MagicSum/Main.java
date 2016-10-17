package Problem02.MagicSum;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int divider = Integer.parseInt(scanner.nextLine());
        List<String> lines = new ArrayList<>();
        while(true) {
            String line = scanner.nextLine();
            if(line.equals("End")) {
                break;
            }

            lines.add(line);
        }

        int[] numbers = lines.stream().mapToInt(Integer::parseInt).toArray();
        int numbersCount = numbers.length;
        String numbersMax  = null;
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < numbersCount - 2; i++) {
            for(int j = i + 1; j < numbersCount - 1; j++) {
                int sum = 0;
                for(int k = j + 1; k < numbersCount; k++) {
                    sum = numbers[i] + numbers[j] + numbers[k];
                    if(sum % divider == 0 && sum > maxSum) {
                        maxSum = sum;
                        numbersMax = String.format("(%d + %d + %d) %% %d = 0", numbers[i], numbers[j], numbers[k], divider);
                    }
                }
            }
        }

        if(numbersMax != null) {
            System.out.println(numbersMax);
        } else {
            System.out.println("No");
        }
    }
}
