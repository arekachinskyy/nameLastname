package lecture4.vehicles;

import lecture4.details.Engine;
import lecture4.professions.Driver;

public class Truck extends Car{
    private int carrying;

    public int getCarrying() {
        return carrying;
    }

    public void setCarrying(int carrying) {
        this.carrying = carrying;
    }

    public Truck(String brand, String type, int weight, Driver driver, Engine engine, int carrying) {
        super(brand, type, weight, driver, engine);
        this.carrying = carrying;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "carrying=" + carrying +
                '}';
    }
}
