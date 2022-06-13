package FunctionalProgramming;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> people = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());
        String input = scan.nextLine();
        while (!input.equals("Party!")) {
            String[] commandParts = input.split("\\s+");
            String command = commandParts[0];
            Predicate<String> predicate = getPredicate(commandParts);
            switch (command) {
                case "Double":
                    List<String> peopleToAdd = new ArrayList<>();
                    people.stream().filter(predicate).forEach(person -> peopleToAdd.add(person));
                    people.addAll(peopleToAdd);
                    break;
                case "Remove":
                    people.removeIf(predicate);
                    break;
            }
            input = scan.nextLine();
        }

        if (people.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            Collections.sort(people);
            System.out.println(String.join(", ", people) + " are going to the party!");
        }
    }

    private static Predicate<String> getPredicate(String[] commandParts) {
        Predicate<String> predicate = null;
        String nameFilter = commandParts[1];
        String criteriaFilter = commandParts[2];
        switch (nameFilter) {
            case "StartsWith":
                predicate = name -> name.startsWith(criteriaFilter);
                break;
            case "EndsWith":
                predicate = name -> name.endsWith(criteriaFilter);
                break;
            case "Length":
                predicate = name -> name.length() == Integer.parseInt(criteriaFilter);
                break;
        }
        return predicate;
    }
}
