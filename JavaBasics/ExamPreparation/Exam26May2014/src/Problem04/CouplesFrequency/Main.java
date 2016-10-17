package Problem04.CouplesFrequency;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.
                asList(scanner.nextLine().split("\\s")).
                stream().
                mapToInt(Integer:: parseInt).
                toArray();
        int length = numbers.length;
        int couplesCount = length - 1;
        LinkedHashMap<String, Integer> couples = new LinkedHashMap<>();
        for(int i = 0; i < length - 1; i++){
            String couple = numbers[i] + " " + numbers[i + 1];
            couples.putIfAbsent(couple, 0);
            int coupleCount = couples.get(couple);
            couples.put(couple, coupleCount + 1);
        }


        for(Map.Entry<String, Integer> coupleWithFrequency : couples.entrySet()) {
            Double coupleFrequency = (coupleWithFrequency.getValue() / (double)couplesCount) * 100d;
            System.out.printf("%s -> %.2f%%", coupleWithFrequency.getKey(), coupleFrequency);
            System.out.println();
        }
    }
}
