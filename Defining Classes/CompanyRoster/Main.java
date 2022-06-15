package DefiningClasses.CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, List<Employee>> departments = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];
            Employee employee = null;
            if (input.length == 6) {
                String email = input[4];
                int age = Integer.parseInt(input[5]);
                employee = new Employee(name, salary, position, department, email, age);
            } else if (input.length == 5) {
                String fifthToken = input[4];
                if (fifthToken.contains("@")) {
                    String email = fifthToken;
                    employee = new Employee(name, salary, position, department, email);
                } else {
                    int age = Integer.parseInt(fifthToken);
                    employee = new Employee(name, salary, position, department, age);
                }
            } else if (input.length == 4) {
                employee = new Employee(name, salary, position, department);
            }
            if (!departments.containsKey(department)) {
                departments.put(department, new ArrayList<>());
                departments.get(department).add(employee);
            } else {
                departments.get(department).add(employee);
            }
        }

        String maxAverageSalaryDepartment = departments.entrySet()
                .stream()
                .max(Comparator.comparingDouble(entry -> getAverageSalary(entry.getValue())))
                .get()
                .getKey();

        System.out.printf("Highest Average Salary: %s%n", maxAverageSalaryDepartment);
        List<Employee> employeeList = departments.get(maxAverageSalaryDepartment);
        employeeList.sort(Comparator.comparingDouble(Employee::getSalary));
        Collections.reverse(employeeList);
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }


    public static double getAverageSalary(List<Employee> employees) {
        double sumOfSalaries = 0;
        for (Employee employee : employees) {
            sumOfSalaries += employee.getSalary();
        }
        return sumOfSalaries / employees.size();
    }
}
