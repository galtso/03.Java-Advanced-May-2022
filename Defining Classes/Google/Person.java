package DefiningClasses.Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private Car car;
    private List<Children> child;
    private Company company;
    private List<Parents> parent;
    private List<Pokemon> pokemon;

    public Person() {
        this.child = new ArrayList<>();
        this.parent = new ArrayList<>();
        this.pokemon = new ArrayList<>();
    }

    public Person(Car car, List<Children> child, Company company, List<Parents> parent, List<Pokemon> pokemon) {
        this.car = car;
        this.child = child;
        this.company = company;
        this.parent = parent;
        this.pokemon = pokemon;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Pokemon> getPokemon() {
        return this.pokemon;
    }

    public List<Parents> getParents() {
        return this.parent;
    }

    public List<Children> getChild() {
        return this.child;
    }

    @Override
    public String toString() {
        //Company:
        //	{companyName} {companyDepartment} {salary}
        //	...
        //	Children:
        //	{childName} {childBirthday}
        //	{childName} {childBirthday}"
        StringBuilder b = new StringBuilder();
        b.append("Company:").append("\n");
        if (company != null) {
            b.append(company).append("\n");
        }
        b.append("Car:").append("\n");
        if (car != null) {
            b.append(car).append("\n");
        }
        b.append("Pokemon:").append("\n");
        for (Pokemon pokemon1 : pokemon) {
            b.append(pokemon1).append("\n");
        }
        b.append("Parents:").append("\n");
        for (Parents parents : parent) {
            b.append(parents).append("\n");
        }
        b.append("Children:").append("\n");
        for (Children children : child) {
            b.append(children).append("\n");
        }
        return b.toString();


    }
}
