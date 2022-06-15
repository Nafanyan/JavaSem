public class Program{
    public static void main(String[] args) {
        ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
        parkingSystem.getInfo();
        System.out.println(parkingSystem.addCar(1));
        System.out.println(parkingSystem.addCar(1));
        parkingSystem.getInfo();
    }
}