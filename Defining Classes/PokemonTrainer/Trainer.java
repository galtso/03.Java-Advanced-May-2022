package DefiningClasses.PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int numberOfBadges;
    private List<Pokemon> pokemonCollection;

    public Trainer(String name, int numberOfBadges, List<Pokemon> pokemonCollection) {
        this.name = name;
        this.numberOfBadges = numberOfBadges;
        this.pokemonCollection = pokemonCollection;

    }

    public List<Pokemon> getPokemonCollection() {
        return pokemonCollection;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public boolean hasElement(String element) {
        for (Pokemon pokemon : pokemonCollection) {
            if (pokemon.getElement().equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void increaseBadge() {
        this.numberOfBadges++;
    }

    public void takeDamage() {
        pokemonCollection.removeIf(Pokemon::isDead);
    }

    @Override
    //"{TrainerName} {Badges} {NumberOfPokemon}
    public String toString() {
        return String.format("%s %d %d", name, numberOfBadges, pokemonCollection.size());
    }
}
