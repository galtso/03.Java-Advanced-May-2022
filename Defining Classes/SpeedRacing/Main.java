package DefiningClasses.SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, Car> carMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] carData = scan.nextLine().split("\\s+");
            String model = carData[0];
            double fuelAmount = Double.parseDouble(carData[1]);
            double consumption = Double.parseDouble(carData[2]);
            Car car = new Car(model, fuelAmount, consumption);
            carMap.put(model, car);
        }
        String input = scan.nextLine();
        while (!input.equals("End")) {
            String carModel = input.split("\\s+")[1];
            int kilometres = Integer.parseInt(input.split("\\s+")[2]);

            Car currentCar = carMap.get(carModel);
            if (!currentCar.hasEnoughFuel(kilometres)) {
                System.out.println("Insufficient fuel for the drive");
            } else {
                currentCar.drive(kilometres);
            }
            input = scan.nextLine();
        }
        carMap.values().stream().forEach(System.out::println);
    }
}
