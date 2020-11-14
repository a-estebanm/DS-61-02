package e1;

public class Elf extends Hero {
    public Elf(int health, int armor, String name, Dice dice) {
        super(health, armor, name, dice);
    }

    @Override
    public int force(Character c2) {
        if (c2.getClass().getSimpleName().equals("Orc")) return (super.force(c2)+10);
        return super.force(c2);
    }
}
