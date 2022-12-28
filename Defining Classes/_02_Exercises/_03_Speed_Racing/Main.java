package _06_Defining_Classes._02_Defining_Classes_Exersices._03_Speed_Racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] carInfo = scan.nextLine().split(" ");
            String model = carInfo[0];
            double fuelAmount = Double.parseDouble(carInfo[1]);
            double fuelPerKm = Double.parseDouble(carInfo[2]);
            Car car = new Car(model, fuelAmount, fuelPerKm);
            carList.add(car);
        }
        String input = scan.nextLine();
        while (!input.equals("End")) {
            String[] driveInfo = input.split(" ");
            String carModel = driveInfo[1];
            int distanceToDrive = Integer.parseInt(driveInfo[2]);
            for (Car car : carList) {
                if (car.getModel().equals(carModel)){
                    car.drive(distanceToDrive);
                }
            }
            input = scan.nextLine();
        }
        carList
                .forEach(System.out::println);
    }
}
