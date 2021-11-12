package lecture5;

public abstract class Birds {
    String name;
    String type;

    public Birds(String name, String type) {
        this.name = name;
        this.type = type;
    }
    public abstract void fly();
    public abstract void iAm();
}
