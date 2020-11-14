package e1;

import java.util.Random;

public abstract class Beasts extends Character {


    public Beasts(int health, int armor, String name, Dice dice) {
        super(health, armor, name, dice);
    }

    @Override

    public int force(Character c2){
        return getDice().forceB();
    }

}