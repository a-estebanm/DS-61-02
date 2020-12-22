package e2;

import java.util.ArrayList;
import java.util.List;

public class Team extends ProjectElem {
    public Team(String Id) { super(Id); }

    private List<ProjectElem> elems = new ArrayList<>();

    public void add(ProjectElem elem) {
        if(elem instanceof Team)
            elems.add(elem); //last pos
        else elems.add(0,elem);
    }
    public ProjectElem getElement(int i){ return elems.get(i);}
    public void remove(ProjectElem elem) { elems.remove(elem); }



    public boolean exists(String Id, boolean b){
        for(ProjectElem elem : elems)
            if(elem instanceof Team){
                return b||((Team) elem).exists(Id,b);
            } else if (elem.getId().equals(Id)) { return true; }
        return b;
    }


    public String teamStr(int i, StringBuilder tInfo){
        tInfo.append( this.str() ).append("\n");
        for(ProjectElem elem : elems) {
            for(int x=0; x<i; x++) tInfo.append("\t");
            if(elem instanceof Team){
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
        float time = 0;
        for(ProjectElem elem : elems)
                time += elem.time();
        return time;
    }


    @Override
    public float cost() {
        float cost = 0;
        for(ProjectElem elem : elems)
            cost += elem.cost();
        return cost;
    }
}
