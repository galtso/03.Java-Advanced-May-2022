package _06_Defining_Classes._02_Defining_Classes_Exersices._06_Pokemon_Trainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<Trainer> trainerList = new ArrayList<>();
        while (!input.equals("Tournament")) {
            String[] dataInfo = input.split(" ");
            String trainerName = dataInfo[0];
            String pokemonName = dataInfo[1];
            String element = dataInfo[2];
            int pokemonHealth = Integer.parseInt(dataInfo[3]);

            Pokemon pokemon = new Pokemon(pokemonName, element, pokemonHealth);

            Trainer duplicateTrainer = trainerList.stream().filter(t -> t.getName().equals(trainerName)).findFirst().orElse(null);
            if (duplicateTrainer == null) {
                Trainer newTrainer = new Trainer(trainerName, 0);
                newTrainer.getPokemons().add(pokemon);
                trainerList.add(newTrainer);
            } else {
                duplicateTrainer.getPokemons().add(pokemon);
                trainerList.set(trainerList.indexOf(duplicateTrainer), duplicateTrainer);
            }


            input = scan.nextLine();
        }
        String element = scan.nextLine();
        while (!element.equals("End")) {
            for (Trainer trainer : trainerList) {
                if (trainer.hasElement(element, trainer.getPokemons())) {
                    trainer.setBadges(trainer.getBadges() + 1);
                } else {
                    trainer.loseHealth(trainer.getPokemons());
                    trainer.deleteDeadPokemons(trainer.getPokemons());
                }
            }
            element = scan.nextLine();
        }
        trainerList
                .stream()
                .sorted(Comparator.comparing(Trainer::getBadges).reversed())
                .forEach(System.out::println);


    }
}
