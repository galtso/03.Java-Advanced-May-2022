package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;


public class MathPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] kids = scan.nextLine().split(" ");
        int toss = Integer.parseInt(scan.nextLine());
        ArrayDeque<String> children = new ArrayDeque<>();
        children.addAll(Arrays.asList(kids));

        int cycle = 1;
        while (children.size() > 1) {

            for (int i = 1; i < toss; i++) {
                children.add(children.poll());
            }
                if (isPrime(cycle)) {
                    System.out.println("Prime " + children.peek());

                } else {
                    System.out.printf("Removed %s%n", children.poll());
                }

            cycle++;
        }
        System.out.println("Last is " + children.peek());


    }

    private static boolean isPrime(int cycle) {
        if (cycle <= 1) {
            return false;
        }
        for (int i = 2; i < cycle; i++) {
            if (cycle % i == 0) {
                return false;
            }
        }
        return true;
    }
}