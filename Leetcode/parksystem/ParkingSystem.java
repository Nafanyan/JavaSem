import java.util.HashMap;
import java.util.Map;

public class ParkingSystem {
    private int smallPark;
    private int mediumPark;
    private int bigPark;

    public ParkingSystem(int big, int medium, int small) {
        smallPark = small;
        mediumPark = medium;
        bigPark = big;
    }

    public boolean addCar(int carType) {
        if (carType == 1) return placeFree (bigPark--);
        if (carType == 2) return placeFree (mediumPark--);
        if (carType == 3) return placeFree (smallPark--);
        return false;
    }

    private boolean placeFree (int placeNum){
        return placeNum > 0;
    }
}