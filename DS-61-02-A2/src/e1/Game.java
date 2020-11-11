package e1;

import java.util.ArrayList;

public class Game {

    ArrayList <Hero> heroes;
    ArrayList <Beast> beasts;

    public Game(ArrayList <Hero> heroes, ArrayList <Beast> beasts){
        this.beasts=beasts;
        this.heroes=heroes;
    }

    public void fight(Character c1, Character c2){
        int damage = c1.force();
        int armor = c2.getArmor();
        if (c1.getClass().getSimpleName().equals("Elf") && c2.getClass().getSimpleName().equals("Orc") ) damage+=10;
        if (c1.getClass().getSimpleName().equals("Hobbit") && c2.getClass().getSimpleName().equals("Goblin") ) damage-=5;
        if (c1.getClass().getSimpleName().equals("Orc")) armor *= 0.9;
        if(damage>armor) c2.setHealth(c2.getHealth() - (damage - armor));

    }

    public void kill(Character c2){

        if (c2.getHealth()<=0) System.out.print(c2.getClass().getSimpleName()+" "+c2.getName()+" dies!");



    }

    public static void main(String [] arg){

        Orc c1 = new Orc(0,12, "juan josé esteban gómez", new Dice());
        System.out.print(c1.dice.dice.nextInt(90));

       // c1.kill
    }

}
