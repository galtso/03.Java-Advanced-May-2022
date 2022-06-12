package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(", ");
        Function<String, Integer> parser = Integer::parseInt;
        List<Integer> numbers = Arrays.stream(input)
                .map(parser)
                .collect(Collectors.toList());

        System.out.println("Count = " + numbers.size());

        int sum = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .sum();
        System.out.printf("Sum = %d", sum);
    }
}
