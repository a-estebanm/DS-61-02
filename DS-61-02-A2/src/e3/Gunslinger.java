package e3;

import java.util.List;

public class Gunslinger {

    private int loads;
    private List <GunslingerAction> rivalActions;
    private int rivalLoads;
    private Behavior behavior;

    public GunslingerAction action(){
        return behavior.action(this);
    }

    public int getLoads(){
        return loads;
    }

    public void rivalAction(GunslingerAction action){
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
