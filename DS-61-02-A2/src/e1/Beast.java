package e1;

import java.util.Random;

public class Beast extends Character {


    public Beast(int health, int armor, String name, Dice dice) {
        super(health, armor, name, dice);
    }

    @Override

    public int force(){
        return dice.forceB();
    }

}