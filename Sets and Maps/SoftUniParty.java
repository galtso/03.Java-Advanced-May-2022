package SetsAndMaps;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<String> vipList = new TreeSet<>();
        Set<String> regularList = new TreeSet<>();
        String input = scan.nextLine();
        while (!input.equals("PARTY")) {
            char firstChar = input.charAt(0);
            if (Character.isDigit(firstChar)) {
                vipList.add(input);
            } else {
                regularList.add(input);
            }
            input = scan.nextLine();
        }
        String output = scan.nextLine();
        while (!output.equals("END")) {
            if (vipList.contains(output)) {
                vipList.remove(output);
            } else {
                regularList.remove(output);
            }
            output = scan.nextLine();
        }
        System.out.println(vipList.size() + regularList.size());
        for (String vip : vipList) {
            System.out.println(vip);
        }
        for (String regular : regularList) {
            System.out.println(regular);
        }
    }
}
