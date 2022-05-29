import java.util.function.DoubleToIntFunction;
import java.util.function.IntToDoubleFunction;

public class allswap {
    public static void main(String[] args) {
        allswap( 4, 4);
    }   

    public static void allswap(int N, int K)
    {
        int temp = (int) Math.pow(K,N);
        for (int i = 0; i < Math.pow(K,N); i++)
        {   
            for (int j = 0; j < N; j++)
            {
                temp /= K;
                System.out.print((i / temp ) % K + ""); 
            }
            temp = (int) Math.pow(K,N);
            System.out.print(" ");
        }

    }
}
