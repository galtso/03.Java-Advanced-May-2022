package ObjectsAndClasses._03_ObjectsAndClasses_More_Exercises._03_Car_Salesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Engine> engines = new ArrayList<>();
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] engineData = scan.nextLine().split(" ");
            String model = engineData[0];
            int power = Integer.parseInt(engineData[1]);
            String displacement = "n/a";
            String efficiency = "n/a";
            if (engineData.length == 4) {
                displacement = engineData[2];
                efficiency = engineData[3];
            }
            if (engineData.length == 3) {
                if (engineData[2].matches("[0-9]*")) {
                    displacement = engineData[2];
                } else {
                    efficiency = engineData[2];
                }
            }
            Engine engine = new Engine(model, power, displacement, efficiency);
            engines.add(engine);
        }
        int m = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < m; i++) {
            String[] carData = scan.nextLine().split(" ");
            String model = carData[0];
            String engine = carData[1];
            String weight = "n/a";
            String color = "n/a";
            if (carData.length == 4) {
                weight = carData[2];
                color = carData[3];
            }
            if (carData.length == 3) {
                if (carData[2].matches("[0-9]*")) {
                    weight = carData[2];
                } else {
                    color = carData[2];
                }
            }
            Engine engineForCar = new Engine(null, 0, null, null);
            for (Engine engine1 : engines) {
                if (engine1.getModel().equals(engine)) {
                    engineForCar = new Engine(engine1.getModel(), engine1.getPower(), engine1.getDisplacement(), engine1.getEfficiency());
                }
            }
            Car newCar = new Car(model, engineForCar, weight, color);
            cars.add(newCar);
        }

        for (Car car : cars) {
            System.out.println(car);
        }
    }
}
