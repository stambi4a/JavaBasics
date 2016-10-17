package Problem01.VideoDurations;

import java.util.Scanner;

public class Main {
    private static final int MINUTES_IN_HOUR = 60;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hours = 0;
        int minutes = 0;
        while(true) {
            String input = scanner.nextLine();
            if(input.equals("End")) {
                break;
            }

            String[]params  = input.trim().split(":");
            int hs = Integer.parseInt(params[0]);
            int ms = Integer.parseInt(params[1]);
            hours += hs;
            minutes += ms;
        }

        hours += minutes / MINUTES_IN_HOUR;
        minutes = minutes % MINUTES_IN_HOUR;
        System.out.printf("%d:%02d", hours, minutes);
    }
}
