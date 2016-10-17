package Problem01.OfficeStuff;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        listOfficeStuff();
    }

    private static void listOfficeStuff() {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, LinkedHashMap<String, Integer>> products = new TreeMap<>();
        int count = Integer.parseInt(scanner.nextLine());
        int index = 1;
        while(index <= count) {
            String[] params = scanner.nextLine().split("(\\s\\-\\s)");
            String company = params[0].substring(1, params[0].length());
            int amount = Integer.parseInt(params[1]);
            String product = params[2].substring(0, params[2].length() - 1);
            products.putIfAbsent(company, new LinkedHashMap<>());
            products.get(company).putIfAbsent(product, 0);
            int productSpent = products.get(company).get(product);
            products.get(company).put(product, productSpent + amount);
            index++;
        }

        printResults(products);
    }

    private static void printResults(TreeMap<String, LinkedHashMap<String, Integer>> products) {
        for(String company : products.keySet()) {
            System.out.print(company + ": ");
            List<String> companyProducts = new ArrayList<>();
            products.get(company).
                    forEach((product, amount) -> companyProducts.add(product + "-" + amount));
            System.out.println(String.join(", ", companyProducts));
        }
    }
}