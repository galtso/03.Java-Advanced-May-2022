package SetsAndMaps;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<Double, Integer> map = new LinkedHashMap<>();
        double[] input = Arrays.stream(scan.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        for (int i = 0; i < input.length; i++) {
            if (map.containsKey(input[i])) {
                map.put(input[i], map.get(input[i]) + 1);
            } else {
                map.put(input[i], 1);
            }
        }
        for (Map.Entry<Double, Integer> doubleIntegerEntry : map.entrySet()) {
            System.out.printf("%.1f -> %d%n", doubleIntegerEntry.getKey(), doubleIntegerEntry.getValue());
        }
    }
}
