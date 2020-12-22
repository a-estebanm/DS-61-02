package e2;

public class Project {

    public static String workerInfo(Team team, Worker worker){

        if(team.exists(worker.getId())) return worker.str();
        else throw new IllegalArgumentException("Worker does not belong to team");
    }

    public static String teamInfo(Team team){
        int counter;
        final StringBuilder tInfo = new StringBuilder();
        team.teamStr(1,tInfo);
        return tInfo.toString();
    }



    public static void main(String[] args) {
        Team team = new Team("Dead n*ggas team");
        Team team2 = new Team("Rich n*ggas team");

        Worker Billy_G = new Worker("Billy_G",16f,8f);
        Worker Tupac = new Worker("Tupac",16.7f,8.0f);
        Worker Paul_Walker = new Worker("Paul_Walker",16.7f,8.0f);
        team.add(Tupac);
        team2.add(Billy_G);
        team.add(team2);
        team.add(Paul_Walker);
        //System.out.println( workerInfo(team,Tupac) );
        //System.out.println( workerInfo(team,Billy_G) );
        //System.out.println( Billy_G.getId() );

        System.out.println( teamInfo(team) );
        //System.out.println( team2.getElems() );

        //System.out.println( workerInfo(team,Paul_Walker) );
    }
}
