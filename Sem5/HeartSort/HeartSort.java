
import java.util.Arrays;
import java.util.Stack;

public class HeartSort {
    public static Stack<Integer> result = new Stack<>();

    public static void main(String[] args) {
        int[] array = { 5, 12, 3, 42, 8, 11, 6, 10, 17};
        System.out.println(Arrays.toString(array));
        heartSort(array);
        System.out.println(result);
    }

    public static void heartSort(int[] source) {
        if (source.length < 1) {
            return;
        }

        int leftIndex = 0;
        int rightIndex = 0;
        int bufferIndex = 0;
        for (int i = source.length / 2; i > 0; i--) {
            leftIndex = 2 * i - 1;
            rightIndex = 2 * i;
            bufferIndex = leftIndex / 2;

            if (source[bufferIndex] > source[leftIndex]) {
                swapArrElements(source, bufferIndex, leftIndex);
            }
            if (rightIndex != source.length && source[bufferIndex] > source[rightIndex]) {
                swapArrElements(source, bufferIndex, rightIndex);
            }
        }
        result.add(source[0]);
        
        heartSort(Arrays.copyOfRange(source, 1, source.length));
    }

    private static int[] swapArrElements(int[] source, int oneI, int twoI) {
        int temp = source[twoI];
        source[twoI] = source[oneI];
        source[oneI] = temp;
        return source;
    }
}
