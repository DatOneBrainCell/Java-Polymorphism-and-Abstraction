public class AbstractFactory {
    public static void main(String[] args) {
        CarFactory carFact = new CarFactory();
        TruckFactory truckFact = new TruckFactory();
        
        System.out.println("Car Parts:");
        System.out.println("Engine: " + carFact.engine);
        System.out.println("Tyre: " + carFact.tyre);
        
        System.out.println();
        
        System.out.println("Truck Parts:");
        System.out.println("Engine: " + truckFact.engine);
        System.out.println("Tyre: " + truckFact.tyre);
    }
}
abstract class Factory {
    String engine;
    String tyre;
}
class CarFactory extends Factory {
    String engine = "W-Engine";
    String tyre = "Tube Tyre";
}
class TruckFactory extends Factory {
    String engine = "Diesel Engine";
    String tyre = "Tube Tyre";
}
