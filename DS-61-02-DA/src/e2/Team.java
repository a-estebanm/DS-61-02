package e2;

import java.util.ArrayList;
import java.util.List;

public class Team extends ProjectElem {
    public Team(String Id) { super(Id); }

    private List<ProjectElem> elems = new ArrayList<>();

    public void add(ProjectElem elem) { elems.add(elem); }
    public ProjectElem getElement(int i){ return elems.get(i);}
    public void remove(ProjectElem elem) { elems.remove(elem); }

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
