package Problem04.LogsAggregator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        registerLogs();
    }

    private static void registerLogs() {
        Scanner scanner = new Scanner(System.in);
        int countLines = Integer.parseInt(scanner.nextLine());
        TreeMap<String, TreeMap<String, Integer>> logs = new TreeMap<>();
        for(int i = 1; i <= countLines; i++) {
            String[] params = scanner.nextLine().trim().split("\\s+");
            String user = params[1];
            String ip = params[0];
            int duration = Integer.parseInt(params[2]);
            logs.putIfAbsent(user, new TreeMap<>());
            logs.get(user).putIfAbsent(ip, 0);
            int summmarizedDuration = logs.get(user).get(ip);
            logs.get(user).put(ip, summmarizedDuration + duration);
        }

        printLogs(logs);
    }

    private static void printLogs(TreeMap<String, TreeMap<String, Integer>> logs) {
        for(String user : logs.keySet()) {
            List<String> ipDuration = new ArrayList<>();
            int duration = 0;
            for(int value : logs.get(user).values()) {
                duration += value;
            }

            System.out.println(user + ": " + duration + " [" + String.join(", ", logs.get(user).keySet()) + "]");
        }
    }
}
