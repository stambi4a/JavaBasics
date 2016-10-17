package Problem01.Enigma;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        solveEnigma();
    }

    private static void solveEnigma() {
        Scanner scanner = new Scanner(System.in);
        int countLines = Integer.parseInt(scanner.nextLine());
        int index = 1;
        List<String> messages = new ArrayList<>();
        while(index <= countLines) {
            String input = scanner.nextLine();
            messages.add(decryptMessage(input));

            index++;
        }

        System.out.println(String.join("\n", messages));
    }

    private static String decryptMessage(String input) {
        String line = input.replaceAll("[0-9\\s]", "");
        int add = line.length() / 2;
        int length = input.length();
        char[] charArray = new char[length];
        for(int i = 0; i < length; i++) {
            Character ch = input.charAt(i);
            charArray[i] = (char)(ch + (ch != ' ' && (ch < '0' || ch > '9') ? add : 0));
        }

        String message = new String(charArray);

        return message;
    }
}