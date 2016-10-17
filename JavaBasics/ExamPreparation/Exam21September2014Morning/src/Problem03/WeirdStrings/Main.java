package Problem03.WeirdStrings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        calculateSums();
    }

    private static void calculateSums(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().replaceAll("[\\\\\\/\\(\\)\\|]|\\s+", "");
        String stringPattern = "[a-zA-Z]+";
        Pattern pattern = Pattern.compile(stringPattern);
        Matcher match = pattern.matcher(input);
        List<String> words = new ArrayList<>();
        while(match.find()) {
            words.add(match.group());
        }

        String[] wordArray = words.toArray(new String[0]);
        int length = wordArray.length;
        int[] weights = new int[length];
        for(int i = 0; i < length; i++) {
            int sum = 0;
            int wordLength = wordArray[i].length();
            for(int j = 0; j < wordLength; j++) {
                String lowerCaseWord = wordArray[i].toLowerCase();
                sum += lowerCaseWord.charAt(j) - 'a' + 1;
            }

            weights[i] = sum;
        }

        String maxSumWords = null;
        int maxSum = 0;
        for(int i = 0; i < length - 1; i++) {
            int sum = weights[i] + weights[i + 1];
            if(sum >= maxSum) {
                maxSum = sum;
                maxSumWords = wordArray[i] + "\n" + wordArray[i + 1];
            }
        }

        System.out.println(maxSumWords);
    }
}
