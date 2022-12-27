package _06_Defining_Classes._01_Defining_Classes_Lab._01_Car_Info;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] carData = scan.nextLine().split("\\s+");
            Car car = new Car();
            car.setBrand(carData[0]);
            car.setModel(carData[1]);
            car.setHorse_power(Integer.parseInt(carData[2]));
            cars.add(car);
        }
        cars.forEach(c -> System.out.println(c.carInfo()));
    }
}
