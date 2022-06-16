package DefiningClasses.PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Pokemon pokemon;
        Trainer trainer;
        Map<String, Trainer> trainerMap = new LinkedHashMap<>();
        while (!input.equals("Tournament")) {
            //"{TrainerName} {PokemonName} {PokemonElement} {PokemonHealth}
            String trainerName = input.split("\\s+")[0];
            String pokemonName = input.split("\\s+")[1];
            String pokemonElement = input.split("\\s+")[2];
            int pokemonHealth = Integer.parseInt(input.split("\\s+")[3]);
            pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            trainerMap.putIfAbsent(trainerName, new Trainer(trainerName, 0, new ArrayList<>()));
            trainerMap.get(trainerName).getPokemonCollection().add(pokemon);
            input = scan.nextLine();
        }
        String element = scan.nextLine();
        while (!element.equals("End")) {
            switch (element) {
                case "Fire":
                    checkForElement(trainerMap, element);
                    break;
                case "Water":
                    checkForElement(trainerMap, element);
                    break;
                case "Electricity":
                    checkForElement(trainerMap, element);
                    break;
            }
            element = scan.nextLine();
        }

        trainerMap.entrySet().stream()
                .sorted((a, b) -> b.getValue().getNumberOfBadges() - a.getValue().getNumberOfBadges())
                .forEach(entry -> {
                    System.out.println(entry.getValue());
                });
    }

    private static void checkForElement(Map<String, Trainer> trainerMap, String element) {
        for (Map.Entry<String, Trainer> entry : trainerMap.entrySet()) {
            if (!entry.getValue().getPokemonCollection().isEmpty() && entry.getValue().hasElement(element)) {
                entry.getValue().increaseBadge();
            } else {
                entry.getValue().takeDamage();
            }
        }
    }


}
