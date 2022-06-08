package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(", ");

        List<String> numbers = Arrays.stream(input)
                .map(Integer::parseInt)
                .filter(e -> e % 2 == 0)
                .map(Object::toString)
                .collect(Collectors.toList());
        System.out.print(String.join(", ", numbers));
        System.out.println();

        numbers = numbers.stream()
                .map(Integer::parseInt)
                .sorted(Integer::compareTo)
                .map(Objects::toString)
                .collect(Collectors.toList());
        System.out.print(String.join(", ", numbers));
    }
}
