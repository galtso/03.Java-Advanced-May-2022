package ObjectsAndClasses._03_ObjectsAndClasses_More_Exercises._02_Raw_Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] carData = scan.nextLine().split(" ");
            String model = carData[0];
            int speed = Integer.parseInt(carData[1]);
            int power = Integer.parseInt(carData[2]);
            int weight = Integer.parseInt(carData[3]);
            String type = carData[4];
            double t1pressure = Double.parseDouble(carData[5]);
            int t1age = Integer.parseInt(carData[6]);
            Tire tire1 = new Tire(t1pressure, t1age);
            double t2pressure = Double.parseDouble(carData[7]);
            int t2age = Integer.parseInt(carData[8]);
            Tire tire2 = new Tire(t2pressure, t2age);
            double t3pressure = Double.parseDouble(carData[9]);
            int t3age = Integer.parseInt(carData[10]);
            Tire tire3 = new Tire(t3pressure, t3age);
            double t4pressure = Double.parseDouble(carData[11]);
            int t4age = Integer.parseInt(carData[12]);
            Tire tire4 = new Tire(t4pressure, t4age);
            List<Tire> tireList = new ArrayList<>();
            Collections.addAll(tireList, tire1, tire2, tire3, tire4);
            Engine engine = new Engine(speed, power);
            Cargo cargo = new Cargo(weight, type);
            Car car = new Car(model, engine, cargo, tireList);
            carList.add(car);
        }
        String command = scan.nextLine();
        List<String> fragileCars = new ArrayList<>();
        if (command.equals("fragile")) {
            for (Car x : carList) {
                if (x.getCargo().getType().equals("fragile")){
                    for (Tire tire : x.getTires()) {
                        if (tire.getPressure() < 1){
                            fragileCars.add(x.getModel());
                            break;
                        }
                    }
                }
            }


        } else if (command.equals("flamable")) {
            for (Car car : carList) {
                if (car.getCargo().getType().equals(command) && car.getEngine().getPower() > 250){
                    fragileCars.add(car.getModel());
                }
            }
        }

        fragileCars.forEach(System.out::println);
    }
}
