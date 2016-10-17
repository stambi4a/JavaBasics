package IntroductionToJavaCha13Pro4;

import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] forbiddenWords = scanner.nextLine().split(",");
        for (String forbiddenWord : forbiddenWords) {
            String replacement = String.join("", Collections.nCopies(forbiddenWord.length(), "*"));
            input = input.replaceAll(forbiddenWord, replacement);
            /*String stringPattern = String.format("%s", forbiddenWord);
            Pattern pattern = Pattern.compile(stringPattern);
            Matcher match = pattern.matcher(input);
            StringBuffer sb = new StringBuffer();
            while(match.find()) {
                String upReplace = match.group(2).toUpperCase();
                match.appendReplacement(sb, upReplace);
            }*/
        }

        System.out.println(input);
    }
}
