package e3;

import java.util.ArrayList;
import java.util.List;

public class Gunslinger {

    private int loads; //protected??
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
        GunslingerAction action = behavior.action(this);
        if (action==GunslingerAction.RELOAD) loads++;
        if (action==GunslingerAction.SHOOT) if (loads==0) throw new IllegalArgumentException("You can't shoot with no bullets");
        else loads --;
        if (action==GunslingerAction.MACHINE_GUN) if (loads<5) throw new IllegalArgumentException("You don't have enough bullets");
        else loads-=5;
        return action;
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

}
