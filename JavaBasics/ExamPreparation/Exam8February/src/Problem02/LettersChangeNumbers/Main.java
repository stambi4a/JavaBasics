package Problem02.LettersChangeNumbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        sumNumberBetweenLetters();
    }

    private static void sumNumberBetweenLetters() {
        Scanner scanner = new Scanner(System.in);
        String[] sequence = scanner.nextLine().split("\\s+");
        int length = sequence.length;
        Double sum = 0d;
        for(int i = 0; i < length; i++) {
            int stringLength = sequence[i].length();
            Double number = Double.parseDouble(sequence[i].substring(1, stringLength - 1));
            char firstChar = sequence[i].charAt(0);
            number = checkFirstChar(number, firstChar);
            char lastChar = sequence[i].charAt(stringLength - 1);
            number = checkLastChar(number, lastChar);
            sum += number;
        }

        System.out.printf("%.2f", sum);
    }

    private static Double checkLastChar(Double number, char ch) {
        if(ch >= 'a' && ch <= 'z') {
            return number + (ch - 'a' + 1);
        }

        return number - (ch - 'A' + 1);
    }

    private static Double checkFirstChar(Double number, char ch) {
        if(ch >= 'a' && ch <= 'z') {
            return number * (ch - 'a' + 1);
        }

        return number /(ch - 'A' + 1);
    }

}
