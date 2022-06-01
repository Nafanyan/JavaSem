import java.util.function.DoubleToIntFunction;

public class TaskThree {
    public static void main(String[] args) {
        System.out.println(triangNum(3));
    }
    
    static public int triangNum(int num)
    {
        return (int) (num * 0.5 * (num + 1));
    }
}
