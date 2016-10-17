package Problem01.CountBeers;

import java.util.Scanner;

public class Main {
    private static final int BEERS_IN_A_STACK = 20;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int allBeers = 0;
        while(true) {
            String input = scanner.nextLine();
            if(input.equals("End")) {
                break;
            }
            String[] params = input.split("\\s+");
            int beers = Integer.parseInt(params[0]);
            if(params[1].equals("stacks")) {
                beers *= BEERS_IN_A_STACK;
            }

            allBeers += beers;
        }

        int stacks = allBeers / BEERS_IN_A_STACK;
        int beers = allBeers % BEERS_IN_A_STACK;
        System.out.printf("%d stacks + %d beers", stacks, beers);
    }
}
