package Problem02.ThreeLargestNumbers;

import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        TreeMap<BigDecimal, String> numbers = new TreeMap<>(new Comparator<BigDecimal>() {
            @Override
            public int compare(BigDecimal o1, BigDecimal o2) {
                if(o2.compareTo(o1) == 0) {
                    return 1;
                }

                return o2.compareTo(o1);
            }
        });
        for(int i = 1; i <= count; i++) {
            String input = scanner.nextLine();
            BigDecimal number = new BigDecimal(input);
            numbers.put(number, input);
        }

        int countNumbers = 1;
       for(Map.Entry<BigDecimal, String> number : numbers.entrySet()) {
           System.out.println(number.getValue());
           countNumbers++;
           if(countNumbers > 3) {
                break;
           }
       }
    }
}
