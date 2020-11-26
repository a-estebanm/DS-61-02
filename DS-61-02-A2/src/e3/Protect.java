package e3;

public class Protect implements Behavior{
    @Override
    public GunslingerAction action(Gunslinger g) {
        return GunslingerAction.PROTECT;
    }
}
