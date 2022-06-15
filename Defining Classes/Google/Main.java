package DefiningClasses.Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Person> peopleData = new HashMap<>();
        String information = scan.nextLine();
        while (!information.equals("End")) {
            //•	"{Name} company {companyName} {department} {salary}"
            //•	"{Name} pokemon {pokemonName} {pokemonType}"
            //•	"{Name} parents {parentName} {parentBirthday}"
            //•	"{Name} children {childName} {childBirthday}"
            //•	"{Name} car {carModel} {carSpeed}"
            String[] parameters = information.split("\\s+");
            String name = parameters[0];
            peopleData.putIfAbsent(name, new Person());
            String typeCommand = parameters[1];
            switch (typeCommand) {
                case "company":
                    String companyName = parameters[2];
                    String department = parameters[3];
                    double salary = Double.parseDouble(parameters[4]);
                    Company company = new Company(companyName, department, salary);
                    peopleData.get(name).setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = parameters[2];
                    String pokemonType = parameters[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    peopleData.get(name).getPokemon().add(pokemon);
                    break;
                case "parents":
                    String parentName = parameters[2];
                    String parentBirthday = parameters[3];
                    Parents parent = new Parents(parentName, parentBirthday);
                    peopleData.get(name).getParents().add(parent);
                    break;
                case "children":
                    String childName = parameters[2];
                    String childBirthday = parameters[3];
                    Children child = new Children(childName, childBirthday);
                    peopleData.get(name).getChild().add(child);
                    break;
                case "car":
                    String carModel = parameters[2];
                    int carSpeed = Integer.parseInt(parameters[3]);
                    Car car = new Car(carModel, carSpeed);
                    peopleData.get(name).setCar(car);
                    break;
            }
            information = scan.nextLine();
        }
        String searchedPerson = scan.nextLine();
        System.out.println(searchedPerson);
        Person personData = peopleData.get(searchedPerson);
        System.out.println(personData);
    }
}
