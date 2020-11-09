package e1;

public abstract class Character {

    private int health;
    private int armor;

    public Character(int health, int armor){
        this.health=health;
        this.armor=armor;
    }
    public abstract int force(int seed);
}
