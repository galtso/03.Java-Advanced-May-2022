package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        ArrayDeque<String> stacks = new ArrayDeque<>();
        String currentUrl = "";
        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (stacks.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    stacks.pop();
                    currentUrl = stacks.peek();
                    System.out.println(currentUrl);
                }
            } else {
                currentUrl = input;
                stacks.push(currentUrl);
                System.out.println(currentUrl);
            }
            input = scan.nextLine();
        }
    }
}
