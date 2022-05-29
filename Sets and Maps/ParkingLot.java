package SetsAndMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<String> carEntry = new LinkedHashSet<>();
        String input = scan.nextLine();
        while (!input.equals("END")) {
            String command = input.split(", ")[0];
            String licensePlate = input.split(", ")[1];
            if (command.equals("IN")) {
                carEntry.add(licensePlate);
            } else {
                carEntry.remove(licensePlate);
            }
            input = scan.nextLine();
        }
        if (!carEntry.isEmpty()) {
            for (String s : carEntry) {
                System.out.println(s);
            }
        } else {
            System.out.println("Parking Lot is Empty");
        }
    }
}
