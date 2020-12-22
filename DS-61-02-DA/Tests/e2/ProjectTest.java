package e2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {

    Team Project = new Team("Project");
    Team team1 = new Team("team 1");
    Team team2 = new Team("team 2");
    Team team3 = new Team("team 3");
    Team team4 = new Team("team 4");

    Worker w1 = new Worker("w1",1f,1f);
    Worker w2 = new Worker("w2",2f,2f);
    Worker w4 = new Worker("w4",4f,4f);
    Worker w8 = new Worker("w8",8f,8f);
    Worker w16 = new Worker("w16",16f,16f);
    Worker w32 = new Worker("w32",32f,32f);

    @Test
    void workerInfoTest(){
        Project pro = new Project("Poroyecto");

        pro.add(w1);
        assertEquals("Worker w1: 1.0 hours, 1.0 €",pro.workerInfo(pro,w1));

        pro.add(team1);
        team1.add(w2);
        assertEquals("Worker w2: 2.0 hours, 2.0 €",pro.workerInfo(pro,w2));
        assertEquals("Worker w2: 2.0 hours, 2.0 €",pro.workerInfo(team1,w2));

        assertThrows(IllegalArgumentException.class, () -> pro.workerInfo(pro,w4));
    }

    @Test
    void coworkerList(){
        Project pro = new Project("Proyecto");
        pro.add(w1); pro.add(team1); pro.add(team3);

        team1.add(team2); team1.add(w2); team1.add(w4);
        team2.add(w8); team2.add(w16); team3.add(w32);

        System.out.print(pro.projectInfo(pro));

        assertEquals("[ w1, w4, w2, w16, w8, w32, ]\n",pro.coworkerList(pro));
        assertEquals("[ w4, w2, w16, w8, ]\n",pro.coworkerList(team1));
        assertEquals("[ w16, w8, ]\n",pro.coworkerList(team2));
    }

    @Test
    void projectInfoTest(){
        Project pro = new Project("Proyecto");
        pro.add(w1); pro.add(team1); pro.add(team3);

        team1.add(team2); team1.add(w2); team1.add(w4);
        team2.add(w8); team2.add(w16); team3.add(w32);

        assertEquals("""
                Proyecto: 63.0 hours, 63.0 €
                \tWorker w1: 1.0 hours, 1.0 €
                \tteam 1: 30.0 hours, 30.0 €
                \t\tWorker w4: 4.0 hours, 4.0 €
                \t\tWorker w2: 2.0 hours, 2.0 €
                \t\tteam 2: 24.0 hours, 24.0 €
                \t\t\tWorker w16: 16.0 hours, 16.0 €
                \t\t\tWorker w8: 8.0 hours, 8.0 €
                \tteam 3: 32.0 hours, 32.0 €
                \t\tWorker w32: 32.0 hours, 32.0 €
                """,pro.projectInfo(pro));
    }

}
