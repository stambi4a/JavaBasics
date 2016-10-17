package Problem03.InsertionSort;

/*import org.apache.commons.lang3.time.StopWatch;*/

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        /*StopWatch stopWatchOne = new StopWatch();
        stopWatchOne.start();*/
        String line = scan.nextLine();
        /*String input = line.substring(1, line.length() - 2);*/
        String[] numbers = line.split(", ");
        ArrayList<Integer> numbersArr = new ArrayList<>();
        for (int i = 1; i < numbers.length - 1; i++) {
            numbersArr.add(Integer.parseInt(numbers[i]));
        }

       /* stopWatchOne.stop();
        long timeOne = stopWatchOne.getTime();
        System.out.println(timeOne/1000.0);

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();*/

        for (int i = 1; i < numbers.length; i++) {
            int j = i;
            int element = numbersArr.remove(j);
            while(j > 0 && element < numbersArr.get(j - 1)) {
                j--;
            }

            numbersArr.add(j, element);
        }
/*
        stopWatch.stop();
        long time = stopWatch.getTime();
        System.out.println(time/1000.0);*/

        System.out.println(numbersArr);
    }
}
