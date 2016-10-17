package Problem01.StuckNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        scanner.nextLine();
        int[] numbers = new int[count];
        for(int i = 0; i < count; i++) {
            numbers[i] = scanner.nextInt();
        }

        scanner.nextLine();

        List<String> stuckNumbers = new ArrayList<>();
        if(count < 4) {
            System.out.println("No");
            return;
        }

        for(int i = 0; i < count - 1; i ++) {
            for(int j = i + 1; j < count; j++) {
                String firstNumber = numbers[i] + "" + numbers[j];
                String firstStuckNumber = numbers[i] + "|" + numbers[j];
                String secondNumber = numbers[j] + "" + numbers[i];
                String secondStuckNumber = numbers[j] + "|" + numbers[i];
                for(int l = i + 1; l < count - 1; l++) {
                    if(l == j) {
                        continue;
                    }
                    for(int k = l + 1; k < count; k++) {
                        if(k == j) {
                            continue;
                        }

                        String thirdStuckNumber = numbers[k] + "|" + numbers[l];
                        String thirdNumber = numbers[k] + "" + numbers[l];
                        String fourthStuckNumber = numbers[l] + "|" + numbers[k];
                        String fourthNumber = numbers[l] + "" + numbers[k];
                        if(firstNumber.equals(thirdNumber)) {
                            stuckNumbers.add(firstStuckNumber +
                                    "==" +
                                    thirdStuckNumber +
                                    "\n" +
                                    thirdStuckNumber +
                                    "==" +
                                    firstStuckNumber);
                        }

                        if(secondNumber.equals(thirdNumber)) {
                            stuckNumbers.add(secondStuckNumber +
                                    "==" +
                                    thirdStuckNumber +
                                    "\n" +
                                    thirdStuckNumber +
                                    "==" +
                                    secondStuckNumber);
                        }

                        if(secondNumber.equals(fourthNumber)) {
                            stuckNumbers.add(secondStuckNumber +
                                    "==" +
                                    fourthStuckNumber +
                                    "\n" +
                                    fourthStuckNumber +
                                    "==" +
                                    secondStuckNumber);
                        }

                        if(firstNumber.equals(fourthNumber)) {
                            stuckNumbers.add(firstStuckNumber +
                                    "==" +
                                    fourthStuckNumber +
                                    "\n" +
                                    fourthStuckNumber +
                                    "==" +
                                    firstStuckNumber);
                        }
                    }
                }
            }
        }

        if(stuckNumbers.size() == 0) {
            System.out.println("No");
        } else {
            System.out.println(String.join("\n", stuckNumbers));
        }
    }
}