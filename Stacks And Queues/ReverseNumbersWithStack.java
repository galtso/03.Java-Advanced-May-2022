package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] numbers = scan.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (String number : numbers) {
            stack.push(number);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
