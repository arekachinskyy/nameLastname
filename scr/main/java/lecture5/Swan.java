package lecture5;

import lecture5.Interfaces.CanEat;
import lecture5.Interfaces.CanFly;
import lecture5.Interfaces.CanSwim;

import java.util.Objects;

public class Swan extends Birds implements CanEat, CanSwim {
    public Swan(String name, String type) {
        super(name, type);
    }

    @Override
    public void fly() {

    }

    @Override
    public void iAm() {

    }

    @Override
    public String toString() {
        return "Swan{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public void canEat() {

    }

    @Override
    public void canSwim() {

    }
}
