package IntroductionToJavaCha13Pr3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(input);
        String stringPattern = "(<upcase>)([\\w\\s]+)(<\\/upcase>)";
        Pattern pattern = Pattern.compile(stringPattern);
        Matcher match = pattern.matcher(input);
        StringBuffer sb = new StringBuffer();
        while(match.find()) {
            String upReplace = match.group(2).toUpperCase();
            match.appendReplacement(sb, upReplace);
        }
        match.appendTail(sb);
        System.out.println(sb);
    }
}
