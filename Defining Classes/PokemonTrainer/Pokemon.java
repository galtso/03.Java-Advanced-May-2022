package DefiningClasses.PokemonTrainer;

public class Pokemon {
    private String name;
    private String element;
    private int health;

    public Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    public String getElement() {
        return element;
    }

    public boolean isDead() {
        this.health -= 10;
        if (health <= 0) {
            return true;
        }
        return false;
    }
}
