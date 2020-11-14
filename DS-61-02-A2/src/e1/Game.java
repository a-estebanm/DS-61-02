package e1;

import javax.lang.model.type.NullType;
import java.util.ArrayList;

public class Game <T extends Character, V extends Character>{

    ArrayList <T> list1;
    ArrayList <V> list2;


    public Game(ArrayList <T> list1, ArrayList <V> list2){

        this.list1=list1;
        this.list2=list2;
    }
    public void checkLists(ArrayList <T> list1, ArrayList <V> list2){ //CHECK MORE
        if(list1.isEmpty() || list2.isEmpty()) throw new IllegalArgumentException("Do not imput an empty list");
        for (T c : list1) if (c.getClass() != list1.get(0).getClass()) throw new IllegalArgumentException("Don't insert different classes in a list");
        for (V c : list2) if (c.getClass() != list2.get(0).getClass()) throw new IllegalArgumentException("Don't insert different classes in a list");
        if(list1.get(0).getClass()==list2.get(0).getClass() && !list1.get(0).getClass().getSimpleName().equals("Character")) throw new IllegalArgumentException("Don't imput lists of the same class");
    }
    public void battle(ArrayList <T> list1, ArrayList <V> list2){

        while(!list1.isEmpty() && !list2.isEmpty()){
            for(int i =0 ; i < Math.min(list1.size(),list2.size()); i++){
                fight(list1.get(i),list2.get(i), i);
            }

        }
        if (list1.isEmpty()&&list2.isEmpty()){
            System.out.print("It's a tie!");
            return;
        }
        if(list1.isEmpty()){
            System.out.print("");
            return;
        }

    }

    public void fight(T c1, V c2, int counter){
        int damage = c1.force(c2);
        int armor = c2.getArmor(c1);
        int damage2 = c2.force(c1);
        int armor2 = c1.getArmor(c2);
        if(damage>armor) c2.setHealth(c2.getHealth() - (damage - armor));
        if(damage2>armor2) c1.setHealth(c1.getHealth() - (damage2 - armor2));

    }


    public void kill( Character c2){

        if (c2.getHealth()<=0) System.out.print(c2.getClass().getSimpleName()+" "+c2.getName()+" dies!");



    }

    public static void main(String [] args){
        Dice dice = new Dice(15);
        Orc c1 = new Orc(0,12, "juan josé esteban gómez", dice);
        Elf c2 = new Elf(0,2, "juan josé asdaesteban gómez", dice);
       // System.out.print(c1.dice.dice.nextInt(90)+"\n");
        Game <Character,Beast> game = new Game<>(new ArrayList<>(), new ArrayList<>());
        game.list1.add(c2);
        game.list1.add(c1);

    }

}
