package SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Map<String, Double>> foodShops = new TreeMap<>();
        String input = scan.nextLine();
        while (!input.equals("Revision")) {
            String[] info = input.split(", ");
            String shop = info[0];
            String product = info[1];
            double price = Double.parseDouble(info[2]);
            foodShops.putIfAbsent(shop, new LinkedHashMap<>());
            foodShops.get(shop).put(product, price);
            input = scan.nextLine();
        }
        foodShops.forEach((key, value) -> {
            System.out.printf("%s->%n", key);
            value.forEach((k, v) -> System.out.printf("Product: %s, Price: %.1f%n", k, v));
        });

        //"{shop}->
        //Product: {product}, Price: {price}"
    }
}
