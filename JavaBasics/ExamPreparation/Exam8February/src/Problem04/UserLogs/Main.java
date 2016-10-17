package Problem04.UserLogs;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        createuserLog();
    }

    private static void createuserLog() {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, LinkedHashMap<String, Integer>> userLogs = new TreeMap<>();
        while(true) {
            String input = scanner.nextLine();
            if(input.equals("end")) {
                break;
            }

            addLog(input, userLogs);
        }

        printResult(userLogs);
    }

    private static void printResult(TreeMap<String, LinkedHashMap<String, Integer>> userLogs) {
        for(String user: userLogs.keySet()) {
            List<String> ipLogs = new ArrayList<>();
            System.out.println(user + ": ");
            userLogs.get(user).forEach((ipAddress, ipLogCount) -> ipLogs.add(ipAddress + " => " + ipLogCount));
            System.out.println(String.join(", ", ipLogs) + ".");
        }
    }


    private static void addLog(String input, TreeMap<String, LinkedHashMap<String, Integer>> userLogs) {
        String[] params = input.split("\\s+");
        String ipAddress = params[0].substring(3, params[0].length());
        String user = params[2].substring(5, params[2].length());
        userLogs.putIfAbsent(user, new LinkedHashMap<>());
        userLogs.get(user).putIfAbsent(ipAddress, 0);
        int ipLogCount = userLogs.get(user).get(ipAddress) + 1;
        userLogs.get(user).put(ipAddress, ipLogCount);
    }
}