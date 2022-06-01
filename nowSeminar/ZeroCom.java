import java.lang.reflect.Array;
import java.util.Arrays;

public class ZeroCom {
    public static void main(String[] args) {
        int N = 3;
        int K = 2;
        int[] nums = new int[N];
        generated(nums, 0, K);
    }

    public static void generated(int[] array, int index, int K)
    {
        if (index == array.length)
        {
            System.out.println(Arrays.toString((array)));
            return;
        }
        for (int i = 0; i < K; i ++)
        {
            array[index] = i;
            generated(array, index + 1, K);
        }
    }


    
}
