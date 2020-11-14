package e1;

import java.util.Random;

public abstract class Heroes extends Character {


    public Heroes(int health, int armor, String name, Dice dice) {
        super(health, armor, name, dice);
    }

    @Override

    public int force(Character c2){
        return dice.forceH();
    }


}

