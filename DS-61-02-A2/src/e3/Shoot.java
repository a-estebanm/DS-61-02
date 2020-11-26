package e3;

public class Shoot implements Behavior{

    @Override
    public GunslingerAction action(Gunslinger g) {
        if (g.getLoads() <= 0){
            g.reload();
            return GunslingerAction.RELOAD;
        } else return GunslingerAction.SHOOT;
    }
}
