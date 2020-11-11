package e1;

import java.util.Random;

public class Hero extends Character {


    public Hero(int health, int armor, String name, Dice dice) {
        super(health, armor, name, dice);
    }

    @Override

    public int force(){
        return dice.forceH();
    }


}

