package StacksAndQueues;

import java.util.ArrayDeque;

import java.util.Arrays;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] kids = scan.nextLine().split(" ");
        int toss = Integer.parseInt(scan.nextLine());
        ArrayDeque<String> children = new ArrayDeque<>();
        children.addAll(Arrays.asList(kids));

        while (children.size() != 1) {
            for (int i = 1; i < toss; i++) {
                children.add(children.poll());
            }
            System.out.printf("Removed %s%n", children.poll());
        }
        System.out.println("Last is " + children.peek());
    }
}
