package lecture4;

import lecture4.details.*;
import lecture4.professions.Driver;
import lecture4.vehicles.Car.*;
import lecture4.vehicles.SportCar;
import lecture4.vehicles.Truck;

public class TestCar {
    public static void main(String[] args) {
        Driver driver = new Driver("Mike",20, 45,"Hohaliuk Mihail");
        Engine engine = new Engine(6000,"Motor Company");
        SportCar sportCar = new SportCar("Mazda", "sport car", 1000, 350,driver, engine);
        Truck truck = new Truck("KAMAZ","1200XB",1200,driver,engine,5000);

        System.out.println(sportCar);
        System.out.println(truck);
        sportCar.printInfo();
        truck.printInfo();
    }
}
