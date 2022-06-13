package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine()
                        .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> minElementIndex = integerList -> {
            int minElement = integerList.stream().mapToInt(e -> e).min().getAsInt();
            return integerList.lastIndexOf(minElement);
        };
        System.out.println(minElementIndex.apply(numbers));
    }
}
