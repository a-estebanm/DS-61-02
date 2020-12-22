package e2;

public class Project extends Team {

    Project(String Id) { super(Id); }

    public String workerInfo(Team team, Worker worker){
        if(team.exists(worker.getId(),false)) return worker.str();
        else throw new IllegalArgumentException("Worker does not belong to team");
    }

    public String projectInfo(Team team){
        final StringBuilder tInfo = new StringBuilder();
        return team.teamStr(1,tInfo);
    }

    public String coworkerList(Team team){
        return "[ " + team.coStr() + "]\n";
    }

}
