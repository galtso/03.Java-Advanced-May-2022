package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        ArrayDeque<String> inputLine = new ArrayDeque<>();
        while (!input.equals("print")) {
            if (input.equals("cancel")) {
                if (inputLine.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.printf("Canceled %s%n", inputLine.poll());
                }
            } else {
                inputLine.add(input);
            }
            input = scan.nextLine();
        }
        for (String s : inputLine) {
            System.out.println(s);
        }
    }
}
