package SetsAndMaps;

import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, List<Double>> students = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] student = scan.nextLine().split("\\s+");
            String name = student[0];
            double grade = Double.parseDouble(student[1]);
            if (!students.containsKey(name)) {
                students.put(name, new ArrayList<>());
                students.get(name).add(grade);
            } else {
                students.get(name).add(grade);
            }
        }
        students.forEach((key, value) -> {                 //за всеки (key, value)
            System.out.printf("%s -> ", key);              // принтираме ключа
            value.forEach(grade -> System.out.printf("%.2f ", grade));     //за всяко value -> принтираме value
            double gradeSum = 0;
            for (Double aDouble : value) {          //пресмятаме общата оценка
                gradeSum += aDouble;
            }
            System.out.printf("(avg: %.2f)%n", gradeSum / value.size());  //принтираме средната оценка
        });
    }
}
