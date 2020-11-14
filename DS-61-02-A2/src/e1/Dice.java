package e1;

import java.util.Random;

public class Dice {

    Random dice;

    public Dice (){
        this.dice= new Random();
    }
    public Dice (int seed){
        this.dice = new Random(seed);
    }
    public int forceH(){
        return Math.max(dice.nextInt(100),dice.nextInt(100));
    }
    public int forceB(){
        return dice.nextInt(90);
    }
}
