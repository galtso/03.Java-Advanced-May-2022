package DefiningClasses.CarInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String brand = input[0];
            String model = input[1];
            int horsePower = Integer.parseInt(input[2]);
            Car car = new Car(brand, model, horsePower);
            carList.add(car);
        }
        for (Car car : carList) {
            System.out.println(car);
        }
    }
}
