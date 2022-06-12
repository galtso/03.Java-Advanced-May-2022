package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> words = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());
        Predicate<String> checkForUppercase = e -> Character.isUpperCase(e.charAt(0));
        words = words.stream()
                .filter(checkForUppercase)
                .collect(Collectors.toList());

        System.out.println(words.size());

        Consumer<String> printer = System.out::println;
        words.stream()
                .forEach(printer);
    }
}
