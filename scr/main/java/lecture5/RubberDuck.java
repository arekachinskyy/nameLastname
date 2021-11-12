package lecture5;

import lecture5.Interfaces.CanSwim;

import java.util.Objects;

public class RubberDuck extends Birds implements CanSwim {
    private String material;
    private String beak;

    public RubberDuck(String name, String type, String type1, String material, String beak) {
        super(name, type);
        this.material = material;
        this.beak = beak;
    }
    @Override
    public void fly() {
    }
    @Override
    public void iAm() {
        System.out.println("RubberDuck is a bird");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RubberDuck that = (RubberDuck) o;
        return Objects.equals(material, that.material) && Objects.equals(beak, that.beak);
    }

    @Override
    public int hashCode() {
        return Objects.hash(material, beak);
    }

    @Override
    public String toString() {
        return "RubberDuck{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", material='" + material + '\'' +
                ", beak='" + beak + '\'' +
                '}';
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getBeak() {
        return beak;
    }

    public void setBeak(String beak) {
        this.beak = beak;
    }

    @Override
    public void canSwim() {

    }
}
