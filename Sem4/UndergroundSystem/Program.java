import java.util.Arrays;
import java.util.Hashtable;

public class Program {
    public static void main(String[] args) {

        UndergroundSystem undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(10, "Leyton", 3);
        undergroundSystem.checkOut(10, "Paradise", 8); // Customer 10 "Leyton" -> "Paradise" in 8-3 = 5

        // return 5.00000, (5) / 1 = 5
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Paradise"));
        undergroundSystem.checkIn(5, "Leyton", 10);
        undergroundSystem.checkOut(5, "Paradise", 16); // Customer 5 "Leyton" -> "Paradise" in 16-10 = 6

        // return 5.50000, (5 + 6) / 2 = 5.5
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Paradise"));

        undergroundSystem.checkIn(2, "Leyton", 21);
        undergroundSystem.checkOut(2, "Paradise", 30); // Customer 2 "Leyton" -> "Paradise" in 30-21 = 9

        // return 6.66667, (5 + 6 + 9) / 3 = 6.66667
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Paradise"));

    }
}