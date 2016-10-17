package Problem01.Timespan;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        calculateTimeSpan();
    }

    private static void calculateTimeSpan(){
        Scanner scanner = new Scanner(System.in);
        try {
            String endTimeInput = scanner.nextLine();
            String startTimeInput = scanner.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("HHHHHHH:mm:ss");
            Date startTime = sdf.parse(startTimeInput);
            Date endTime = sdf.parse(endTimeInput);
            long diffInSeconds = (endTime.getTime() - startTime.getTime()) / 1000;
            long hours = diffInSeconds / 3600;
            long minutes = (diffInSeconds - hours * 3600) / 60;
            long seconds = (diffInSeconds - hours * 3600 - minutes * 60);
            System.out.printf("%d:%02d:%02d", hours, minutes, seconds);
        }catch(ParseException pe) {
            System.out.println(pe.getMessage());
        }
    }
}