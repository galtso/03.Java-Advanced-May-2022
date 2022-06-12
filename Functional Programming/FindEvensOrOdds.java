package FunctionalProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        int firstNumber = Integer.parseInt(input[0]);
        int lastNumber = Integer.parseInt(input[1]);
        String evenOrOdd = scan.nextLine();
        List<Integer> numbers = new ArrayList<>();
        for (int i = firstNumber; i <= lastNumber; i++) {
            numbers.add(i);
        }
        Predicate<Integer> checkForEvenOdd;
        if (evenOrOdd.equals("even")) {
            checkForEvenOdd = e -> e % 2 == 0;
        } else {
            checkForEvenOdd = e -> e % 2 != 0;
        }

        Consumer<Integer> printer = e -> System.out.print(e + " ");
        numbers.stream()
                .filter(checkForEvenOdd)
                .forEach(printer);
    }
}
