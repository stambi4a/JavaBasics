package Problem01.DozenEggs;

import java.util.Scanner;

public class Main {
    private static final int EGGS_IN_A_DOZEN = 12;
    private static final int INPUT_LINES = 7;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int allEggs = 0;
        int index = 1;
        while(index <= INPUT_LINES) {
            String input = scanner.nextLine();

            String[] params = input.split("\\s+");
            int eggs = Integer.parseInt(params[0]);
            if(params[1].equals("dozens")) {
                eggs *= EGGS_IN_A_DOZEN;
            }

            allEggs += eggs;
            index++;
        }

        int dozens = allEggs / EGGS_IN_A_DOZEN;
        int eggs = allEggs % EGGS_IN_A_DOZEN;
        System.out.printf("%d dozens + %d eggs", dozens, eggs);
    }
}