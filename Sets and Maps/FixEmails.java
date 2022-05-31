package SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, String> users = new LinkedHashMap<>();
        String input = scan.nextLine();
        while (!input.equals("stop")) {
            String name = input;
            String email = scan.nextLine();
            if (!email.endsWith(".us") && !email.endsWith(".uk") && !email.endsWith(".com")) {
                users.put(name, email);
            }
            input = scan.nextLine();
        }
        if (!users.isEmpty()) {
            for (Map.Entry<String, String> entry : users.entrySet()) {
                System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
            }
        }
    }
}
