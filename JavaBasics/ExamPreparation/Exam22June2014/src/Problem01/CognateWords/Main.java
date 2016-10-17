package Problem01.CognateWords;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        findCognateWords();
    }

    private static void findCognateWords() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String wordPattern = "[a-zA-Z]+";
        Pattern pattern = Pattern.compile(wordPattern);
        Matcher match = pattern.matcher(input);
        List<String> words = new ArrayList<>();
        while(match.find()) {
            words.add(match.group());
        }

        String[] strings = words.toArray(new String[0]);
        int length = strings.length;
        LinkedHashSet<String> cognateWords  = new LinkedHashSet<>();
        for(int i = 0; i < length - 1 ; i ++) {
            for(int j = i + 1; j < length; j++) {
                String concatenated = strings[i] + strings[j];
                String reverseConcatenated = strings[j] + strings[i];
                for(int k = 0; k < length ; k++) {
                    if(concatenated.equals(strings[k])) {
                        cognateWords.add(String.format("%s|%s=%s", strings[i], strings[j], strings[k]));
                        continue;
                    }

                    if(reverseConcatenated.equals(strings[k])) {
                        cognateWords.add(String.format("%s|%s = %s", strings[j], strings[i], strings[k]));
                        continue;
                    }
                }
            }
        }

        if(cognateWords.size() == 0) {
            System.out.println("No");
        } else {
            System.out.println(String.join("\n", cognateWords));
        }
    }
}
