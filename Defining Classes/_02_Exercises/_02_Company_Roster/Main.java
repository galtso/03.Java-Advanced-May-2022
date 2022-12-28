package _06_Defining_Classes._02_Defining_Classes_Exersices._02_Company_Roster;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Employee> employees = new ArrayList<>();
        List<Department> departments = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] employeeData = scan.nextLine().split(" ");
            String name = employeeData[0];
            double salary = Double.parseDouble(employeeData[1]);
            String position = employeeData[2];
            String department = employeeData[3];
            String email = "n/a";
            int age = -1;

            if (employeeData.length == 6) {
                email = employeeData[4];
                age = Integer.parseInt(employeeData[5]);
            }
            if (employeeData.length == 5) {
                if (employeeData[4].contains("@")) {
                    email = employeeData[4];
                } else {
                    age = Integer.parseInt(employeeData[4]);
                }
            }
            Employee employee = new Employee(name, salary, position, department, email, age);
            employees.add(employee);

            Department matchedDepartment = departments.stream().filter(d -> d.getName().equals(department)).findFirst().orElse(null);
            if (matchedDepartment == null) {
                Department departmentToAdd = new Department(department, salary, 1);
                departments.add(departmentToAdd);
            } else {
                matchedDepartment.setSalary(matchedDepartment.getSalary() + salary);
                matchedDepartment.setCount(matchedDepartment.getCount() + 1);
            }
        }
        double highAverageSalary = 0;
        String highAvgSalaryDepartment = "";

        for (Department department : departments) {
            double averageSalary = department.getSalary() / department.getCount();
            if (averageSalary > highAverageSalary){
                highAverageSalary = averageSalary;
                highAvgSalaryDepartment = department.getName();
            }
        }
        System.out.printf("Highest Average Salary: %s%n", highAvgSalaryDepartment);

        String finalHighAvgSalaryDepartment = highAvgSalaryDepartment;
        employees.stream()
                .filter(e->e.getDepartment().equals(finalHighAvgSalaryDepartment))
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .forEach(System.out::println);
    }
}
