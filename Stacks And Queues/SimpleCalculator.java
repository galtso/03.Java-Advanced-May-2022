package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        ArrayDeque<String> stack = new ArrayDeque<>();
        Collections.addAll(stack, input);
        while (stack.size() > 1) {
            int firstNumber = Integer.parseInt(stack.poll());
            String operator = stack.poll();
            int secondNumber = Integer.parseInt(stack.poll());
            if (operator.equals("+")) {
                stack.push(String.valueOf(firstNumber + secondNumber));
            } else {
                stack.push(String.valueOf(firstNumber - secondNumber));
            }
        }
        System.out.println(stack.peek());
    }
}
