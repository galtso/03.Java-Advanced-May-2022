package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long n = Long.parseLong(scan.nextLine());
        ArrayDeque<Long> stack = new ArrayDeque<>();
        ArrayDeque<Long> queue = new ArrayDeque<>();
        long firstFibonacciNumber = 1;
        long secondFibonacciNumber = 1;
        stack.push(firstFibonacciNumber);
        stack.push(secondFibonacciNumber);
        queue.offer(firstFibonacciNumber);
        queue.offer(secondFibonacciNumber);
        for (int i = 1; i < n; i++) {
            if (!queue.isEmpty()) {
                long nextFibonacciNumber = queue.poll() + queue.peek();
                queue.offer(nextFibonacciNumber);
                stack.push(nextFibonacciNumber);
            }
        }
        if (!stack.isEmpty()) {
            System.out.println(stack.peek());
        }
    }
}
