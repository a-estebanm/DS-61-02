package e3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GunslingerTest {


    @Test
    void BehTest(){

        Gunslinger Rel_Oad = new Gunslinger( new ReloadForEvar() );

        assertEquals(0, Rel_Oad.getLoads());
        assertEquals("RELOAD",Rel_Oad.action().toString());
        assertEquals(1, Rel_Oad.getLoads());

        Rel_Oad.reload();
        assertEquals(2, Rel_Oad.getLoads());

        Rel_Oad.setBehavior(new Protect());
        assertEquals("PROTECT",Rel_Oad.action().toString());

        Rel_Oad.rivalAction(GunslingerAction.RELOAD);
        Rel_Oad.rivalAction(GunslingerAction.PROTECT);
        assertEquals("[RELOAD, PROTECT]",Rel_Oad.getRivalActions().toString());

        assertEquals(1,Rel_Oad.getRivalLoads());

    }

    @Test
    void DuelWins1Then2(){

        Gunfight wins1 = new Gunfight();
        wins1.duel(new Gunslinger(new Shoot()), new Gunslinger( new ReloadForEvar()));

        System.out.print("\n\n\n2nd match ---------------------------------\n\n");

        Gunfight wins2 = new Gunfight();
        wins2.duel(new Gunslinger( new ReloadForEvar() ), new Gunslinger(new Shoot()));

        System.out.print("\n\n\n3rd match ---------------------------------\n\n");

        Gunfight MG1 = new Gunfight();
        Gunslinger no = new Gunslinger(new RelMG());
        MG1.duel(no, new Gunslinger( new Protect()));

        System.out.print("\n\n\n4th match ---------------------------------\n\n");

        Gunfight bothShoot = new Gunfight();
        bothShoot.duel(new Gunslinger( new Shoot() ), new Gunslinger(new Shoot()));


        System.out.print("\n\n\n5th match ---------------------------------\n\n");

        Gunfight timeTie = new Gunfight();
        timeTie.duel(new Gunslinger( new ReloadForEvar() ), new Gunslinger(new Protect()));

    }

}
