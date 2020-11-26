package e3;

import java.util.ArrayList;
import java.util.List;

public class Gunslinger {

    private int loads;
    private final List <GunslingerAction> rivalActions; //Final??
    private int rivalLoads;
    private Behavior behavior;

    Gunslinger(Behavior behavior){
        loads=0;
        rivalLoads=0;
        rivalActions = new ArrayList<>();
        this.behavior=behavior;
    }

    public GunslingerAction action(){
        return behavior.action(this);
    }

    public int getLoads(){
        return loads;
    }

    public void rivalAction(GunslingerAction action){
        if (action==GunslingerAction.RELOAD) rivalLoads++;
        if (action==GunslingerAction.SHOOT) rivalLoads--;
        rivalActions.add(action);
    }

    public List<GunslingerAction> getRivalActions(){
        return rivalActions;
    }

    public int getRivalLoads(){
        return rivalLoads;
    }

    public void setBehavior(Behavior behavior){
        this.behavior=behavior;
    }

    public void reload(){
        loads++;
    }
}
