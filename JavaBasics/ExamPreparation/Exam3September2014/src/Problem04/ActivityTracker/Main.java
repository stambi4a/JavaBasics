package Problem04.ActivityTracker;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        int index = 1;
        TreeMap<Integer, TreeMap<String, Integer>> activities = new TreeMap<>();
        while(index <= count) {
            String input = scanner.nextLine();

            String[] params = input.split("[\\s+\\/]");
            int month = Integer.parseInt(params[1]);
            String user = params[3];
            Integer distance = Integer.parseInt(params[4]);
            index++;
            activities.putIfAbsent(month, new TreeMap<>());
            activities.get(month).putIfAbsent(user, 0);
            Integer previousActivity = activities.get(month).get(user);
            activities.get(month).put(user, previousActivity + distance);
        }

        for(Integer month : activities.keySet()) {
            List<String> resultsByDistance = new ArrayList<>();
            for(Map.Entry<String, Integer> userAndDistance: activities.get(month).entrySet()) {
                resultsByDistance.add(userAndDistance.getKey() +"(" + userAndDistance.getValue() + ")");
            }

            System.out.println(month + ": " + String.join(", ", resultsByDistance));
        }
    }
}
