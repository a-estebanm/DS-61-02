package e3;

import java.util.List;

public class Gunslinger implements Behavior {

    private int loads;
    private List <GunslingerAction> rivalActions;
    private int rivalLoads;

    public GunslingerAction action(){

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

    }

    @Override
    public GunslingerAction action(Gunslinger g) {
        return null;
    }
}
