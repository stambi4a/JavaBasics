package Problem04.Nuts;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        listCompanyNuts();
    }

    private static void listCompanyNuts() {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, LinkedHashMap<String, Integer>> nuts = new TreeMap<>();
        int count = Integer.parseInt(scanner.nextLine());
        int index = 1;
        while(index <= count) {
            String[] params = scanner.nextLine().split("\\s+");
            String company = params[0];
            String nutType = params[1];
            int amount = Integer.parseInt(params[2].substring(0, params[2].length() - 2));

            nuts.putIfAbsent(company, new LinkedHashMap<>());
            nuts.get(company).putIfAbsent(nutType, 0);
            int productSpent = nuts.get(company).get(nutType);
            nuts.get(company).put(nutType, productSpent + amount);
            index++;
        }

        printResults(nuts);
    }

    private static void printResults(TreeMap<String, LinkedHashMap<String, Integer>> nuts) {
        for(String company : nuts.keySet()) {
            System.out.print(company + ": ");
            List<String> companyNuts = new ArrayList<>();
            nuts.get(company).
                    forEach((nutType, amount) -> companyNuts.add(nutType + "-" + amount +"kg"));
            System.out.println(String.join(", ", companyNuts));
        }
    }
}
