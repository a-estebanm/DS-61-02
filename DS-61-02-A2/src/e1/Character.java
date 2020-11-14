package e1;

public abstract class Character {

    private int health;
    private int armor;
    private final String name;
    protected Dice dice;

    public Character(int health, int armor, String name, Dice dice){
        this.health=health;
        this.armor=armor;
        this.name = name;
        this.dice = dice;
    }

    public int getArmor(Character c2) {
        if(c2.getClass().getSimpleName().equals("Orc")) return armor*=0.9;
        return armor; }

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

    public abstract int force(Character c2);
}
