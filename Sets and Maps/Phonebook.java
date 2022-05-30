package SetsAndMaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, String> phonebook = new HashMap<>();
        String input = scan.nextLine();
        while (!input.equals("search")) {
            String name = input.split("-")[0];
            String number = input.split("-")[1];
            phonebook.putIfAbsent(name, number);
            phonebook.put(phonebook.get(name), number);
            input = scan.nextLine();
        }
        String searching = scan.nextLine();
        while (!searching.equals("stop")) {
            if (phonebook.containsKey(searching)) {
                System.out.println(searching + " -> " + phonebook.get(searching));
            } else {
                System.out.printf("Contact %s does not exist.%n", searching);
            }
            searching = scan.nextLine();
        }
    }
}
