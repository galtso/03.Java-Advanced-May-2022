package _06_Defining_Classes._02_Defining_Classes_Exersices._02_Company_Roster;

import java.util.List;

public class Department {
    private String name;
    private double salary;
    private int count;

    public Department(String name, double salary, int count) {
        this.name = name;
        this.salary = salary;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
