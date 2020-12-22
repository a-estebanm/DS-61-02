package e2;

import java.util.ArrayList;
import java.util.List;

public class Team extends ProjectElem {


    private final List<ProjectElem> elems = new ArrayList<>();

    Team(String Id) { super(Id); }


    public void add(ProjectElem elem) {
        if(elem instanceof Team)
            elems.add(elem); //last pos
        else elems.add(0,elem);
    }

    public boolean exists(String Id, boolean b){
        for(ProjectElem elem : elems)
            if(elem instanceof Team){
                return b||((Team) elem).exists(Id,b);
            } else if (elem.getId().equals(Id)) { return true; }
        return b;
    }

    public String coStr() {
        final StringBuilder tInfo = new StringBuilder();
        for(ProjectElem elem : elems)
            if(elem instanceof Team){
                tInfo.append(((Team) elem).coStr());
            } else {
                tInfo.append( elem.getId() ).append(", ");
            }
        return tInfo.toString();
    }

    public String teamStr(int level, StringBuilder tInfo){
        tInfo.append( this.str() ).append("\n");
        for(ProjectElem elem : elems) {
            tInfo.append("\t".repeat(Math.max(0, level)));
            if(elem instanceof Team){
                ((Team) elem).teamStr(level+1,tInfo);
            } else {
                tInfo.append( elem.str() ).append("\n");
            }
        }
        return tInfo.toString();
    }

    @Override
    public String str() {
        return this.getId() + ": " + this.time() + " hours, " + this.cost() + " €";
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
