package DefiningClasses.CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Engine> engineList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Engine engine;
            String[] engineInfo = scan.nextLine().split("\\s+");
            //"{Model} {Power} {Displacement} {Efficiency}
            String engineModel = engineInfo[0];
            String enginePower = engineInfo[1];
            String engineDisplacement = "n/a";
            String engineEfficiency = "n/a";
            if (engineInfo.length == 4) {
                engineDisplacement = engineInfo[2];
                engineEfficiency = engineInfo[3];

            } else if (engineInfo.length == 3) {
                if (engineInfo[2].matches("\\d+")) {
                    engineDisplacement = engineInfo[2];
                } else {
                    engineEfficiency = engineInfo[2];
                }
            }
            engine = new Engine(engineModel, enginePower, engineDisplacement, engineEfficiency);
            engineList.add(engine);
        }

        int m = Integer.parseInt(scan.nextLine());
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] carInfo = scan.nextLine().split("\\s+");
            //"{Model} {Engine} {Weight} {Color}
            String model = carInfo[0];
            String engine = carInfo[1];
            String weight = "n/a";
            String color = "n/a";
            if (carInfo.length == 4) {
                weight = carInfo[2];
                color = carInfo[3];
            } else if (carInfo.length == 3) {
                if (carInfo[2].matches("\\d+")) {
                    weight = carInfo[2];
                } else {
                    color = carInfo[2];
                }
            }
            Engine engineFromList = null;
            for (Engine engine1 : engineList) {
                if (engine1.getModel().equals(engine)) {
                    engineFromList = engine1;
                }
            }

            Car car = new Car(model, engineFromList, weight, color);
            System.out.println(car);
        }
    }
}
