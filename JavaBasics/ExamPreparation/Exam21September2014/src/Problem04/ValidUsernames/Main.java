package Problem04.ValidUsernames;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        calculateUserNames();
    }

    private static void calculateUserNames() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] possibleUserNames = input.split("[\\s\\/)(\\\\]+");
        List<String> usernames = new ArrayList<>();

        String usernamePattern = "(^[a-zA-Z][\\w0-9]{2,24})$";
        Pattern pattern = Pattern.compile(usernamePattern);
        int length = possibleUserNames.length;
        for(int i = 0; i < length; i++) {
            Matcher match = pattern.matcher(possibleUserNames[i]);
            if(match.find()) {
                usernames.add(possibleUserNames[i]);
            }
        }

        length = usernames.size();
        String firstUser = null;
        String secondUser = null;

        int maxSum = 0;
        for(int i = 0; i < length - 1; i++) {
            int sum = usernames.get(i).length() + usernames.get(i + 1).length();

            if(sum > maxSum) {
                maxSum = sum;
                firstUser = usernames.get(i);
                secondUser = usernames.get(i + 1);
            }
        }

        System.out.println(firstUser + "\n" + secondUser);



    }
}
