package e1;

import java.util.ArrayList;

public class Game <T extends Character, V extends Character>{

    private ArrayList <T> list1;
    private ArrayList <V> list2;

    public void setList1(ArrayList<T> list1) {
        this.list1 = list1;
    }

    public void setList2(ArrayList<V> list2) {
        this.list2 = list2;
    }

    public ArrayList<T> getList1() {
        return list1;
    }

    public ArrayList<V> getList2() {
        return list2;
    }

    public Game(ArrayList <T> list1, ArrayList <V> list2){
        setList1(list1);
        setList2(list2);
    }
    public void checkLists(){ //CHECK MORE
        if(list1.isEmpty() || list2.isEmpty()) throw new IllegalArgumentException("Do not input an empty list"); //If one list is Empty there isn't a game to play
        Class<?> l1 = list1.get(0).getClass().getSuperclass(); //We avoid calling multiple times this methods by creating this class variables
        Class<?> l2 = list2.get(0).getClass().getSuperclass();
        if(l1==l2) throw new IllegalArgumentException("Don't input lists of the same class");
        for (T c: list1) if (c.getClass().getSuperclass() != l1) throw new IllegalArgumentException("Don't insert different classes in a list");
        for (V c : list2) if (c.getClass().getSuperclass() != l2) throw new IllegalArgumentException("Don't insert different classes in a list");
    }
    public void battle(){
        checkLists();
        int counter=1;
        T c1;
        V c2;
        while(!list1.isEmpty() && !list2.isEmpty()){
            System.out.print("Turn "+ counter++ +":\n");
            for(int i =0 ; i < Math.min(list1.size(),list2.size()); i++){
                c1 = list1.get(i);
                c2 = list2.get(i);
                System.out.print("Fight between "+ c1.getName()+" (Health = "+c1.getHealth()+") and "+c2.getName()+" (Health = "+c2.getHealth()+")\n");
                fight(c1,c2);
            }
        }
        if (list1.isEmpty()&&list2.isEmpty()){
            System.out.print("It's a tie!");
            return;
        }
        if(list1.isEmpty()){
            System.out.print(list2.get(0).getClass().getSuperclass().getSimpleName().toUpperCase()+" WIN!");
        }else System.out.print(list1.get(0).getClass().getSuperclass().getSimpleName().toUpperCase()+" WIN!");

    }

    public void fight(T c1, V c2){
        int damage = c1.force(c2);
        int armor = c2.getArmor(c1);
        int damage2 = c2.force(c1);
        int armor2 = c1.getArmor(c2);
        if(damage>armor) c2.setHealth(c2.getHealth() - (damage - armor));
        if(damage2>armor2) c1.setHealth(c1.getHealth() - (damage2 - armor2));
        kill(c1, c2);
    }

    public void kill( T c1, V c2) {
        if (c1.getHealth() <= 0){
            System.out.print(c1.getClass().getSimpleName() + " " + c1.getName() + " dies!\n");
            list1.remove(c1);
        }
        if (c2.getHealth() <= 0){
            System.out.print(c2.getClass().getSimpleName() + " " + c2.getName() + " dies!\n");
            list2.remove(c2);
        }
    }
}
