package Problem03.Biggest3PrimeNumbers;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numberPattern = "\\-?\\d+";
        Pattern pattern = Pattern.compile(numberPattern);
        Matcher match = pattern.matcher(scanner.nextLine());
        List<String> matches = new ArrayList<>();
        while(match.find()) {
            matches.add(match.group());
        }

        int[] numbers = matches.stream().mapToInt(Integer::parseInt).toArray();
        int length = numbers.length;
        TreeSet<Integer> primeNumbers = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for(int i = 0; i < length; i++) {
            int number = numbers[i];
            if(number < 2) {
                continue;
            }
            if(number % 2 == 0 && number != 2) {
                continue;
            }

            int start = 3;
            int j = 0;
            int biggestPossibleDivider = (int)Math.sqrt(number);
            for(j = start; j <= biggestPossibleDivider; j = j + 2) {
                if(number % j == 0) {
                    break;
                }
            }

            if(j > biggestPossibleDivider) {
                primeNumbers.add(number);
            }
        }

        int sumFirstThreePrimes = 0;
        if(primeNumbers.size() >= 3) {
            int count = 1;
            for(Integer prime : primeNumbers) {
                sumFirstThreePrimes += prime;
                count++;
                if(count > 3) {
                    break;
                }
            }

            System.out.println(sumFirstThreePrimes);
        } else {
            System.out.println("No");
        }

    }

}
