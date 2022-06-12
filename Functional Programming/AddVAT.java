package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(", ");

        Function<String, Double> parser = Double::parseDouble;

        //Function<Double, Double> addVAT = e-> 1.2 * e;
        UnaryOperator<Double> addVat = e -> 1.2 * e;
        //Функция, която приема и връща един и същи тип аргумент <Double, Double>

        Consumer<Double> printer = e -> System.out.printf("%.2f%n", e);

        System.out.println("Prices with VAT:");
        Arrays.stream(input)
                .map(parser)
                .map(addVat)
                .forEach(printer);
    }
}
