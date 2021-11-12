package lecture5;

import lecture5.Interfaces.CanEat;
import lecture5.Interfaces.CanSwim;

public class Platypus implements CanSwim, CanEat {
    private String name;
    private String type;

    public Platypus(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    @Override
    public void canSwim() {

    }

    @Override
    public void canEat() {
    }

    @Override
    public String toString() {
        return "Platypus{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
