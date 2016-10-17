package Problem02.EnhancedBubbleSort;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] numbers = scan.nextLine().replace("[", "").replace("]", "").split(", ");
        ArrayList<Integer> numbersArr = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            numbersArr.add(Integer.parseInt(numbers[i]));
        }

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 1; j < numbers.length - i; j++) {
                if (numbersArr.get(j - 1) > numbersArr.get(j)) {
                    int old = numbersArr.get(j - 1);
                    numbersArr.set(j - 1, numbersArr.get(j));
                    numbersArr.set(j, old);
                }
            }
        }

        System.out.println(numbersArr);
    }
}
