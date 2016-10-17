package Problem02.PythagoreanNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        int[] numbers = new int[count];
        for(int i = 0; i < count ;i++) {
            numbers[i] = Integer.parseInt(scanner.nextLine());
        }

        Arrays.sort(numbers);

        List<String> pyths = new ArrayList<>();
        for(int i = 0; i < count; i ++) {
            for(int j = i; j < count; j++) {
                for(int k = j; k < count; k++) {
                    if(numbers[i] * numbers[i]+
                            numbers[j] * numbers[j] ==
                            numbers[k] * numbers[k]) {
                        pyths.add(String.format("%1$d*%1$d + %2$d*%2$d = %3$d*%3$d", numbers[i], numbers[j], numbers[k]));
                    }
                }
            }
        }

        if(pyths.size() == 0) {
            System.out.println("No");
        } else {
            System.out.println(String.join("\n", pyths));
        }


    }
}
