package Problem04.SelectionSort;

import java.util.ArrayList;
import java.util.Scanner;

//import org.apache.commons.lang.time.StopWatch;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] numbers = scan.nextLine().replace("[", "").replace("]", "").split(", ");
        ArrayList<Integer> numbersArr = new ArrayList<Integer>();

        for (int i = 0; i < numbers.length; i++) {
            numbersArr.add(Integer.parseInt(numbers[i]));
        }

//        StopWatch stopWatch = new StopWatch();
//        stopWatch.start();

        for(int i = 0; i < numbers.length - 1; i++) {
            int min = numbersArr.get(i);
            int index = i;
            for(int j = i + 1; j < numbers.length; j++) {
                if(min > numbersArr.get(j)) {
                    min = numbersArr.get(j);
                    index = j;
                }
            }

            if(index != i) {
                int old = numbersArr.get(i);
                numbersArr.set(i, min);
                numbersArr.set(index, old);
            }
        }

//        stopWatch.stop();
//        long time = stopWatch.getTime();

        System.out.println(numbersArr);
//        System.out.println(time/1000.0);
    }
}