package e3;

public class ReloadForEvar implements Behavior{
    @Override
    public GunslingerAction action(Gunslinger g) {
        return GunslingerAction.RELOAD;
    }
}