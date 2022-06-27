import java.util.Arrays;
import java.util.LinkedList;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = { 10, 2, 3, 4, 9, 9, 100 };
        sortMerge(array);
        System.out.println(Arrays.toString(array));

    }

    public static void sortMerge(int[] source) {
        if (sortTrue(source)) {
            return;
        }

        LinkedList<Integer> firstHalf = new LinkedList<>();
        LinkedList<Integer> secondHalf = new LinkedList<>();
        shareFlag(source, firstHalf, secondHalf);

        for (int i = 0; i < source.length; i++) {
            if (firstHalf.isEmpty() || secondHalf.isEmpty()) {
                if (firstHalf.isEmpty()) {
                    source[i] = secondHalf.pollFirst();
                } else {
                    source[i] = firstHalf.pollFirst();
                }
            } else {
                if (firstHalf.peekFirst() < secondHalf.peekFirst()) {
                    source[i] = firstHalf.pollFirst();
                } else {
                    source[i] = secondHalf.pollFirst();
                }
            }

        }
        sortMerge(source);
    }

    private static Boolean sortTrue(int[] source) {
        for (int i = 0; i < source.length - 1; i++) {
            if (source[i] > source[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private static void shareFlag(int[] array, LinkedList<Integer> firtsArray, LinkedList<Integer> secondArray) {
        Boolean flag = true;
        firtsArray.addLast(array[0]);
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                flag = !flag;
            }
            if (flag) {
                firtsArray.addLast(array[i]);
            } else {
                secondArray.addLast(array[i]);
            }
        }
    }
}