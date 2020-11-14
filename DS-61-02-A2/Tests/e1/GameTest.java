package e1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class GameTest {
    Dice dice = new Dice(1);
    Orc c1 = new Orc(100,101, "OP orc", dice);
    Elf c2 = new Elf(100,30, "Elf1", dice);
    Elf c6 = new Elf(100,30, "Elf2", dice);
    Hobbit c3 = new Hobbit(100,30, "Hobbit", dice);
    Human c4 = new Human(100,30, "Human", dice);
    Goblin c5 = new Goblin(100,30, "Goblin", dice);

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

        Orc c1 = new Orc(100,101, "orco malo", dice);
        Elf c2 = new Elf(100,30, "Elfo amable", dice);

        Game <Character, Character> game = new Game<>(new ArrayList<>(), new ArrayList<>());
        game.getList1().add(c2);
        game.getList2().add(c1);
        game.battle();

        assertFalse(game.getList2().isEmpty());
        assertTrue(game.getList1().isEmpty());
    }

    @Test
    void health1000(){
        Dice dice = new Dice(1);
        Orc c1 = new Orc(10000,10, "orco malo", dice);
        Elf c2 = new Elf(100,30, "Elf1", dice);
        Elf c3 = new Elf(100,30, "Elf2", dice);
        Elf c4 = new Elf(100,30, "Elf3", dice);
        Hobbit c5 = new Hobbit(100,30, "Elf4", dice);

        Game <Character, Character> game = new Game<>(new ArrayList<>(), new ArrayList<>());
        game.getList1().add(c2);
        game.getList1().add(c3);
        game.getList1().add(c4);
        game.getList1().add(c5);
        game.getList2().add(c1);
        game.battle();

        assertFalse(game.getList2().isEmpty());
        assertTrue(game.getList1().isEmpty());
    }
}