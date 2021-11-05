package lecture4.vehicles;

import lecture4.details.Engine;
import lecture4.professions.Driver;

public class SportCar extends Car{
    private int speed;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {

        this.speed = speed;
    }

    public SportCar(String brand, String type, int weight, int speed, Driver driver, Engine engine) {
        super(brand, type, weight, driver, engine);
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "SportCar{" +
                "speed=" + speed +
                '}';
    }
}
