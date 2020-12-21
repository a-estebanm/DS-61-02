package e2;

public class Project {
    //private Team team = new Team("Dead n*ggas team");



    public static String workerInfo(Team team, String id){
        final StringBuilder worker = new StringBuilder();
        return worker.append("Worker ").append(id).append(": ").toString();
    }

    public static int Main(String[] args) {
        Team team = new Team("Dead n*ggas team");
        Worker Tupac = new Worker("Tupac",16.7f,8.0f);
        team.add(Tupac);
        System.out.println( workerInfo(team,"Tupac") );
        return 0;
    }
}
