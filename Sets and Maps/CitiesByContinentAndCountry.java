package SetsAndMaps;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Map<String, List<String>>> countries = new LinkedHashMap<>();
        int number = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < number; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String continent = input[0];
            String country = input[1];
            String city = input[2];
            countries.putIfAbsent(continent, new LinkedHashMap<>());
            countries.get(continent).putIfAbsent(country, new ArrayList<>());
            countries.get(continent).get(country).add(city);
        }
        countries.forEach((key, value) -> {
            System.out.println(key + ":");
            for (Map.Entry<String, List<String>> entry : value.entrySet()) {
                System.out.printf("%s -> ", entry.getKey());
                System.out.println(String.join(", ", entry.getValue()));
            }
        });
    }
}
