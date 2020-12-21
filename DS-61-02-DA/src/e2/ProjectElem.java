package e2;

public abstract class ProjectElem {
    private String id;
    /*
    private float cost;
    private float time;


    public void setCost(float Cost) { this.cost = Cost; }
    public float getCost() { return cost; }

    public void setTime(float Time) { this.time = Time; }
    public float getTime() { return time; }

    public ProjectElem() { }
    */

    public ProjectElem(String Id) {this.id = Id;}

    public abstract float time();
    public abstract float cost();

    public void setId(String Id) { this.id = Id; }
    public String getId() { return id; }
}