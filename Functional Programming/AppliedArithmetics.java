package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine()
                        .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String input = scan.nextLine();
        while (!input.equals("end")) {
            switch (input) {
                case "add":
                    numbers = numbers.stream()
                            .map(e -> e + 1)
                            .collect(Collectors.toList());
                    break;
                case "multiply":
                    numbers = numbers.stream()
                            .map(e -> e * 2)
                            .collect(Collectors.toList());
                    break;
                case "subtract":
                    numbers = numbers.stream()
                            .map(e -> e - 1)
                            .collect(Collectors.toList());
                    break;
                case "print":
                    numbers.stream().forEach(e -> System.out.print(e + " "));
                    System.out.println();
                    break;
                default:
                    System.out.println("No such command!");
            }
            input = scan.nextLine();
        }

    }
}
