package Problem03.SimpleExpression;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> params = new ArrayList<>();
        String argsPattern= "(\\d+\\.?\\d*)|\\+|\\-";
        Pattern pattern = Pattern.compile(argsPattern);
        Matcher match = pattern.matcher(input);
        while(match.find()) {
            params.add(match.group());
        }

        int length = params.size();
        BigDecimal sum = BigDecimal.valueOf(0);
        boolean subtract = false;
        for(int i = 0; i < length; i++) {
            if(params.get(i).equals("-")) {
                subtract = true;
            } else if(!params.get(i).equals("+")) {
                Double number = Double.parseDouble(params.get(i));
                if(subtract) {
                    sum = sum.subtract(BigDecimal.valueOf(number));
                    subtract = false;
                } else {
                    sum = sum.add(BigDecimal.valueOf(number));
                }
            }
        }

        System.out.println(sum);
    }
}
