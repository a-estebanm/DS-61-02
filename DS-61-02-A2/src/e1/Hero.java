package e1;

import java.util.Random;

public class Hero extends Character {


    public Hero(int health, int armor, String name) {
        super(health, armor, name);
    }

    @Override
    public int force(int seed) {
        Random dice = new Random(seed);
        return dice.nextInt(100);
    }
    public int force(){

        Random dice = new Random();
        return dice.nextInt(100);
    }

}

