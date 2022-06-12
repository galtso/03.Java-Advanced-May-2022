package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] names = scan.nextLine().split("\\s+");
        Consumer<String> printer = System.out::println;
        Arrays.stream(names)
                .forEach(printer);
    }
}
