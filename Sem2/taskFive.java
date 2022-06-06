import java.lang.reflect.Array;
import java.util.Arrays;

import javax.swing.border.EmptyBorder;

public class TaskFive
{
    public static void main(String[] args) {
        String example = "2?? + ?1 = 250";
        example = example.replaceAll("\\+ ", "");
        example = example.replaceAll("\\= ", "");
        int counter = (example.split("\\?")).length - 1;
        int[] nums = new int[counter];

        generated(nums, 0, 10, example.split(" "));
    }

    public static void generated(int[] array, int index, int K, String[] primer)
    {
        if (index == array.length)
        {
            String result = new String(); // собираем результат 
            String sumElement= new String(); // собираем слагаемые
            int temp = 0; // вычисляем сумму слагаемых для сравнения с истинным
            
            for (int i = 0; i < primer.length - 1; i ++)
            {
                sumElement = primer[i];
                for (int j = i; j < primer[i].length(); j++)
                {
                    sumElement = sumElement.replaceFirst("\\?", String.valueOf(array[i+j]));
                }
                 
                temp +=Integer.parseInt(sumElement);
                result += Integer.parseInt(sumElement);
                if(i % 2 == 0) result += " + ";
            }
            result += " = " + temp;
            if ( temp == Integer.parseInt(primer[primer.length - 1])) System.out.println(result);
            return;
        }
        for (int i = 0; i < 10; i ++)
        {
            array[index] = i;
            generated(array, index + 1, 10, primer);
        }
    }

}