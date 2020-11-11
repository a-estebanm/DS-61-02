package e1;

public abstract class Character {

    private int health;
    private int armor;
    private final String name;
    Dice dice;

    public Character(int health, int armor, String name, Dice dice){
        this.health=health;
        this.armor=armor;
        this.name = name;
        this.dice = dice;
    }

    public int getArmor() {
        return armor;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public void setArmor(int armor) { //NECESSARY?
        this.armor = armor;
    }

    public void setHealth(int health) {
        this.health = health;
    }

  /*  public void setDice(Dice dice) {
        this.dice = dice;
    }*/

    public abstract int force();
}
