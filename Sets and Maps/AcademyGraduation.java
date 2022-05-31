package SetsAndMaps;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        Map<String, Double[]> students = new TreeMap<>();
        for (int i = 0; i < number; i++) {
            String name = scan.nextLine();
            String[] gradeLine = scan.nextLine().split("\\s+");
            Double[] grades = new Double[gradeLine.length];
            for (int j = 0; j < grades.length; j++) {
                grades[j] = Double.parseDouble(gradeLine[j]);
            }
            students.put(name, grades);
        }
        students.forEach((key, value) -> {
            System.out.printf("%s is graduated with ", key);
            double sumGrade = 0;
            for (Double aDouble : value) {
                sumGrade += aDouble;
            }
            System.out.printf("%s%n", sumGrade / value.length);

        });
    }
}
