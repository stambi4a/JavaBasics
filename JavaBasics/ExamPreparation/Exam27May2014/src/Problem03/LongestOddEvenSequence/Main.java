package Problem03.LongestOddEvenSequence;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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
        int maxSequenceLength = 1;
        for(int i = 0; i < length; i++) {
            int sequenceLength = 1;
            boolean isEven = Math.abs(numbers[i] % 2) == 0 || numbers[i] == 0;
            boolean isOdd = Math.abs(numbers[i] % 2) == 1 || numbers[i] == 0;
            while(i < length - 1) {
                /*if ((numbers[i + 1] == 0 ||
                        (numbers[i] == 0 && ((sequenceLength % 2 == 1 && numbers[i + 1] + numbers[i - sequenceLength + 1] || (Math.abs(numbers[i] + numbers[i + 1]) % 2 == 1))) {
                    sequenceLength++;
                    i++;
                }*/
                if(numbers[i + 1] == 0 ||
                        (isEven && sequenceLength % 2 == 1 && Math.abs(numbers[i + 1] % 2) == 1) ||
                        (isEven && sequenceLength % 2 == 0 && Math.abs(numbers[i + 1] % 2) == 0) ||
                        (isOdd && sequenceLength % 2 == 1 && Math.abs(numbers[i + 1] % 2) == 0) ||
                        (isOdd && sequenceLength % 2 == 0 && Math.abs(numbers[i + 1] % 2) == 1)) {
                    sequenceLength++;
                    i++;
                }
                else {
                    break;
                }
            }

            if(sequenceLength > maxSequenceLength) {
                maxSequenceLength = sequenceLength;
                if(i == length - 1) {
                    break;
                }

                if(sequenceLength >= 3 && numbers[i] == 0) {
                    i = i - 1;
                }
            }
        }

        System.out.println(maxSequenceLength);
    }
}
