package e1;

import java.util.ArrayList;

public class Game {

    ArrayList <Hero> heroes;
    ArrayList <Beast> beasts;

    public Game(ArrayList <Hero> heroes, ArrayList <Beast> beasts){
        this.beasts=beasts;
        this.heroes=heroes;
    }

    public void battle(Character c1, Character c2){
        int damage = c1.force();
        int armor = c2.getArmor();
        if (c1.getClass().getSimpleName().equals("Elf") && c2.getClass().getSimpleName().equals("Orc") ) damage+=10;
        if (c1.getClass().getSimpleName().equals("Hobbit") && c2.getClass().getSimpleName().equals("Goblin") ) damage-=5;
        if (c1.getClass().getSimpleName().equals("Orc")) armor *= 0.9;
        if(damage>armor) c2.setHealth(c2.getHealth() - (damage - armor));

    }
    public boolean isDead(Character c2){
        if (c2.getHealth()<0) c2.setHealth(0);
        return c2.getHealth()<=0;
    }

    public static void main(String [] arg){

        Orc c1 = new Orc(10,12, "juan josé esteban gómez");
        System.out.print(c1.getName());

    }

}
