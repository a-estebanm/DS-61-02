package e1;

public class Hobbit extends Hero {
    public Hobbit(int health, int armor, String name, Dice dice) {
        super(health, armor, name, dice);
    }

    @Override
    public int force(Character c2) {
        if (c2.getClass().getSimpleName().equals("Goblin")) return (super.force(c2) - 5);
        return super.force(c2);
    }
}