package e3;

public class RelMG implements Behavior{
    @Override
    public GunslingerAction action(Gunslinger g) {
        if(g.getLoads()==5) return GunslingerAction.MACHINE_GUN;
        g.reload();
        return GunslingerAction.RELOAD;
    }
}