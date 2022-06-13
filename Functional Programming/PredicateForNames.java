package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sizeRequired = Integer.parseInt(scan.nextLine());
        List<String> names = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());
        Predicate<String> filterPredicate = name -> name.length() <= sizeRequired;
        Consumer<String> printer = System.out::println;
        names.stream()
                .filter(filterPredicate)
                .forEach(printer);
    }
}
