package FunctionalProgramming;

import java.sql.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Integer[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).toArray(Integer[]::new);

        Comparator<Integer> comparator = (e1, e2) -> {
            if (e1 % 2 == 0 && e2 % 2 != 0) {
                return -1;
            } else if (e1 % 2 != 0 && e2 % 2 == 0) {
                return 1;
            } else {
                return e1.compareTo(e2);
            }
        };
        Arrays.sort(numbers, comparator);
        Arrays.stream(numbers).forEach(number -> System.out.print(number + " "));
    }
}
