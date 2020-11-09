package e1;

import java.util.Random;

public class Beast extends Character {


    public Beast(int health, int armor) {
        super(health, armor);
    }

    @Override
    public int force(int seed) {
        Random dice = new Random(seed);
        return dice.nextInt(90);
    }

    public int force(){

        Random dice = new Random();
        return dice.nextInt(90);
    }

}