package DefiningClasses.OpinionPoll;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, Integer> people = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            Person person = new Person(name, age);
            people.put(person.getName(), person.getAge());
        }
        people.entrySet().stream()
                .filter(e -> e.getValue() > 30)
                .forEach(person -> System.out.printf("%s - %d%n", person.getKey(), person.getValue()));
    }
}
