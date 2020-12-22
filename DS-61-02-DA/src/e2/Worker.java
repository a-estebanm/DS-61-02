package e2;
//n
public class Worker extends ProjectElem {
    private float cost;
    private float time;

    public Worker(String Id, float Cost, float Time) {
        super(Id);
        cost = Cost;
        time = Time;
    }

    public void setCost(float Cost) { this.cost = Cost; }
    public float getCost() { return cost; }

    public void setTime(float Time) { this.time = Time; }
    public float getTime() { return time; }

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