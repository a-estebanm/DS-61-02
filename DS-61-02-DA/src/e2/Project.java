package e2;
//n
public class Project {

    public static String workerInfo(Team team, Worker worker){
        if(team.exists(worker.getId(),false)) return worker.str();
        else throw new IllegalArgumentException("Worker does not belong to team");
    }

    public static String teamInfo(Team team){
        final StringBuilder tInfo = new StringBuilder();
        return team.teamStr(1,tInfo);
    }

    public static void main(String[] args) {
        Team team = new Team("Dead n*ggas team");
        Team team2 = new Team("Rich n*ggas team");

        Worker Billy_G = new Worker("Billy_G",1f,8f);
        Worker Tupac = new Worker("Tupac",2f,8.0f);
        Worker Paul_Walker = new Worker("Paul_Walker",4f,4.0f);

        Worker w11 = new Worker("w11",10f,8.0f);
        Worker w12 = new Worker("w12",10f,8.0f);
        team.add(Tupac);
        team2.add(Billy_G);
        team.add(team2);

        //team.add(Paul_Walker);
        //team2.add(w11);
        //team.add(w12);

        //System.out.println( team.str() );
        System.out.println( teamInfo(team) );
        System.out.println( team2.str() );
        System.out.println( workerInfo(team,Billy_G) );
        System.out.println( Billy_G.getId() );
        System.out.println( workerInfo(team2,Billy_G) );
        //System.out.println( workerInfo(team2,Tupac) );
    }
}
