import java.util.Arrays;

public class Tower {
    public static void main(String[] args) {
        int numRings = 2;
        transferRings(numRings, "Source", "Result", "Buffer");
    }


    public static void transferRings( int numRings, String one, String two, String three){
        if (numRings == 0) return;
        transferRings(numRings - 1, one, three, two);
        System.out.println("ring " + numRings + " from " + one + " to " + two);
        transferRings(numRings - 1, three, two, one);

    } 

}
