package SetsAndMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] sizes = scan.nextLine().split("\\s+");
        int firstSetSize = Integer.parseInt(sizes[0]);
        int secondSetSize = Integer.parseInt(sizes[1]);
        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();
        fillTheSet(firstSetSize, firstSet, scan);
        fillTheSet(secondSetSize, secondSet, scan);
        firstSet.retainAll(secondSet);
        firstSet.forEach(number -> System.out.print(number + " "));
    }

    private static void fillTheSet(int size, Set<Integer> set, Scanner scan) {
        for (int i = 0; i < size; i++) {
            set.add(Integer.parseInt(scan.nextLine()));
        }
    }
}
