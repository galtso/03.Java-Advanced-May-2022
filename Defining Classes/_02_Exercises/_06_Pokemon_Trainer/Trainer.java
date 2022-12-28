package _06_Defining_Classes._02_Defining_Classes_Exersices._06_Pokemon_Trainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int badges;
    private List<Pokemon> pokemons;

    public Trainer(String name, int badges) {
        this.name = name;
        this.badges = badges;
        this.pokemons = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBadges() {
        return badges;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public boolean hasElement(String element, List<Pokemon> list){
        for (Pokemon pokemon : list) {
            if (pokemon.getElement().equals(element)){
                return true;
            }
        }
        return false;
    }

    public void loseHealth(List<Pokemon> list){
        for (Pokemon pokemon : list) {
            pokemon.setHealth(pokemon.getHealth() - 10);
        }
    }

    public void deleteDeadPokemons(List<Pokemon> list){
        list.removeIf(pokemon -> pokemon.getHealth() <= 0);
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.badges, this.pokemons.size());
    }
}
