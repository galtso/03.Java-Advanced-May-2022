package FunctionalProgramming;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.*;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, Integer> people = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] peopleList = scan.nextLine().split(", ");
            String name = peopleList[0];
            int age = Integer.parseInt(peopleList[1]);
            people.put(name, age);
        }
        String condition = scan.nextLine();
        int ageLimit = Integer.parseInt(scan.nextLine());
        String printFormat = scan.nextLine();

        BiPredicate<Integer, Integer> ageFilter;
        if (condition.equals("younger")) {
            ageFilter = (personAge, age) -> personAge <= age;
        } else {
            ageFilter = (personAge, age) -> personAge >= age;
        }

        Consumer<Map.Entry<String, Integer>> printer;
        if (printFormat.equals("name")) {
            printer = person -> System.out.println(person.getKey());
        } else if (printFormat.equals("age")) {
            printer = person -> System.out.println(person.getValue());
        } else {
            printer = person -> System.out.printf("%s - %d%n", person.getKey(), person.getValue());
        }

        people.entrySet().stream()
                .filter(person -> ageFilter.test(person.getValue(), ageLimit))
                .forEach(printer);

    }
}
