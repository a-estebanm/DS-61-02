package e1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Dice dice = new Dice(1);
    Orc c1 = new Orc(100,101, "OP orc", dice);
    Elf c2 = new Elf(100,30, "Elf1", dice);
    Hobbit c3 = new Hobbit(100,30, "Hobbit", dice);
    Human c4 = new Human(100,30, "Human", dice);
    Goblin c5 = new Goblin(100,30, "Goblin", dice);
    Elf c6 = new Elf(100,30, "Elf2", dice);
    @Test
    void checkListsTest(){

        Game <Character, Character> game = new Game<>(new ArrayList<>(), new ArrayList<>()); // both lists empty
        assertThrows( IllegalArgumentException.class, game::checkLists);


        Game <Character, Character> game2 = new Game<>(new ArrayList<>(), new ArrayList<>()); // one list empty
        game.getList2().add(c1);
        assertThrows(IllegalArgumentException.class, game2::checkLists);


        Game <Character, Character> game3 = new Game<>(new ArrayList<>(), new ArrayList<>()); // both lists are same class (heroes)
        game.getList1().add(c2);
        game.getList2().add(c3);
        assertThrows(IllegalArgumentException.class, game3::checkLists);


        Game <Character, Character> game4 = new Game<>(new ArrayList<>(), new ArrayList<>()); // different classes in a list
        game.getList1().add(c1);
        game.getList1().add(c2);
        game.getList1().add(c5);

        game.getList2().add(c6);
        game.getList2().add(c3);
        game.getList2().add(c4);
        assertThrows(IllegalArgumentException.class, game4::checkLists);
    }

    @Test
    void armor101(){
        Dice dice = new Dice();

        Orc c1 = new Orc(250,30, "cocky orc", dice);
        Elf c2 = new Elf(100,115, "immortal Elf", dice);

        Game <Character, Character> game = new Game<>(new ArrayList<>(), new ArrayList<>());
        game.getList1().add(c2);
        game.getList2().add(c1);
        game.battle();

        assertFalse(game.getList1().isEmpty());
        assertTrue(game.getList2().isEmpty());
    }

    @Test
    void health1000(){
        Dice dice = new Dice(1);
        Orc c1 = new Orc(10000,10, "orco OP", dice);
        Goblin c6 = new Goblin(100,30, "Goblin", dice);

        Game <Character, Character> game = new Game<>(new ArrayList<>(), new ArrayList<>());
        game.getList1().add(c2);
        game.getList1().add(c3);
        game.getList1().add(c4);
        game.getList2().add(c5);
        game.getList2().add(c1);
        game.getList2().add(c6);
        game.battle();

        assertFalse(game.getList2().isEmpty());
        assertTrue(game.getList1().isEmpty());
    }

    @Test
    void tie(){
        Orc c1 = new Orc(1,0, "common orc", dice);
        Human c2 = new Human(1,0, "normal human", dice);

        Game <Character, Character> game = new Game<>(new ArrayList<>(), new ArrayList<>());
        game.getList1().add(c2);
        game.getList2().add(c1);

        game.battle();
        assertTrue(game.getList2().isEmpty());
        assertTrue(game.getList1().isEmpty());
    }
}