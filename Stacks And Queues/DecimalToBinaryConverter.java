package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int decimal = Integer.parseInt(scan.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        if (decimal == 0) {
            System.out.println(0);
            return;
        } else {
            while (decimal != 0) {
                stack.push(decimal % 2);
                decimal /= 2;
            }
        }
        for (Integer integer : stack) {
            System.out.print(integer);
        }
    }
}
