package e2;

import java.util.ArrayList;
import java.util.List;

public class Team extends ProjectElem {
    public Team(String Id) { super(Id); }

    private List<ProjectElem> elems = new ArrayList<>();

    public void add(ProjectElem elem) { elems.add(elem); }
    public ProjectElem getElement(int i){ return elems.get(i);}
    public void remove(ProjectElem elem) { elems.remove(elem); }

    private boolean b;


    public boolean exists(String Id){
        for(ProjectElem elem : elems)
            if(elem.getClass().getSimpleName().equals("Team")){
                ((Team) elem).exists(Id);
            } else if (elem.getId().equals(Id)) { b = true; }
        return b;
    }

    public String teamStr(int i, StringBuilder tInfo){
        tInfo.append( this.str() ).append("\n");
        for(ProjectElem elem : elems) {
            for(int x=0; x<i; x++) tInfo.append("\t");
            if(elem.getClass().getSimpleName().equals("Team")){
                //tInfo.append( elem.str() ).append("\n");
                ((Team) elem).teamStr(i+1,tInfo);
            } else {
                tInfo.append( elem.str() ).append("\n");
                elem.str();
            }

        }


        return tInfo.toString();
    }

    public String getElems(){
        return elems.toString();
    }

    @Override
    public String str() {
        return "Team " + this.getId() + ": " + this.time() + " hours, " + this.cost() + " €";
    }
    @Override
    public float time() {
        int time = 0;
        for(ProjectElem elem : elems)
            time += elem.time();
        return time;
    }
    @Override
    public float cost() {
        int cost = 0;
        for(ProjectElem elem : elems)
            cost += elem.cost();
        return cost;
    }
}
