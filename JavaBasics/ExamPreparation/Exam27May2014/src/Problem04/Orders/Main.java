package Problem04.Orders;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        listCompanyNuts();
    }

    private static void listCompanyNuts() {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, TreeMap<String, Integer>> fruits = new LinkedHashMap<>();
        int count = Integer.parseInt(scanner.nextLine());
        int index = 1;
        while(index <= count) {
            String[] params = scanner.nextLine().split("\\s+");
            String customer = params[0];
            String fruit = params[2];
            int amount = Integer.parseInt(params[1]);

            fruits.putIfAbsent(fruit, new TreeMap<>());
            fruits.get(fruit).putIfAbsent(customer, 0);
            int productSpent = fruits.get(fruit).get(customer);
            fruits.get(fruit).put(customer, productSpent + amount);
            index++;
        }

        printResults(fruits);
    }

    private static void printResults(LinkedHashMap<String, TreeMap<String, Integer>> fruits) {
        for(String fruit : fruits.keySet()) {
            System.out.print(fruit + ": ");
            List<String> companyNuts = new ArrayList<>();
            fruits.get(fruit).
                    forEach((customer, amount) -> companyNuts.add(customer + " " + amount));
            System.out.println(String.join(", ", companyNuts));
        }
    }
}


