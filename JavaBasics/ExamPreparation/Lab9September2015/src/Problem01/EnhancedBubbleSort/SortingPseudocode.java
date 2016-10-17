package Problem01.EnhancedBubbleSort;

/*import org.apache.commons.lang3.time.StopWatch;*/

import java.util.ArrayList;
import java.util.Scanner;


public class SortingPseudocode {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] numbers = scan.nextLine().replace("[", "").replace("]", "").split(", ");
        ArrayList<Integer> numbersArr = new ArrayList<>();

        for(int i = 0; i < numbers.length ; i++) {
            numbersArr.add(Integer.parseInt(numbers[i]));
        }

        /*StopWatch stopWatch = new StopWatch();
        stopWatch.start();*/
        for(int i = 0; i < numbers.length - 1; i++)
        {
            for(int j = 1; j < numbers.length - i; j++) {
                if(numbersArr.get(j - 1) > numbersArr.get(j)) {
                    int old = numbersArr.get(j - 1);
                    numbersArr.set(j - 1, numbersArr.get(j));
                    numbersArr.set(j, old);
                }
            }
        }

        /*stopWatch.stop();
        long time = stopWatch.getTime();*/


        System.out.println(numbersArr);
        /*System.out.println(time/1000.0);*/
    }
}