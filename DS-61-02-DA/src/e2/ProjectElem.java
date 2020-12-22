package e2;

public abstract class ProjectElem {
    private final String id;

    public ProjectElem(String Id) {this.id = Id;}

    public abstract float time();
    public abstract float cost();
    public abstract String str();

    public String getId() { return id; }
}