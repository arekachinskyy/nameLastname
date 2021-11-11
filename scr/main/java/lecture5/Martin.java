package lecture5;

import lecture5.Interfaces.CanEat;
import lecture5.Interfaces.CanFly;

import java.util.Objects;

public class Martin extends Birds implements CanEat, CanFly {
    private String beak;

    public Martin(String name, String type, String beak) {
        super(name, type);
        this.beak = beak;
    }

    public String getBeak() {
        return beak;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Martin martin = (Martin) o;
        return Objects.equals(beak, martin.beak);
    }

    @Override
    public int hashCode() {
        return Objects.hash(beak);
    }

    public void setBeak(String beak) {
        this.beak = beak;
    }

    @Override
    public void fly() {

    }

    @Override
    public void iAm() {

    }

    @Override
    public void canEat() {

    }

    @Override
    public Double speed(CanFly canFly) {
        return null;
    }

    @Override
    public Double speed() {
        return null;
    }
}
