package e3;

public class Shoot implements Behavior{
    int i = 0;
    @Override
    public GunslingerAction action(Gunslinger g) {
        if (i++%2==0) return GunslingerAction.RELOAD;
        else return GunslingerAction.SHOOT;
    }
}
