package e2;

public class Worker extends ProjectElem {
    private final float cost;
    private final float time;

    public Worker(String Id, float Cost, float Time) {
        super(Id);
        cost = Cost;
        time = Time;
    }

    @Override
    public String str() {
        return "Worker " + this.getId() + ": " + this.time() + " hours, " + this.cost() + " €";
    }

    @Override
    public float time(){ return time; }

    @Override
    public float cost(){
        return cost;
    }
}