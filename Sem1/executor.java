import javax.swing.border.EmptyBorder;

public class executor {
    public static void main(String[] args) {
        System.out.println(executorGo(20.0,2.0,1.0,2.0));
    }

    // Функция при котором начальное значение меньше конечного
    private static String executorGoNegative(Double start, Double result, Double sumStep, Double multStep)
    {
        if (start + sumStep > start && start * multStep > start ) return "Unreal"; // Условие выхода
        String logDo = "";
        String stepLogDo = "";
        Boolean flagMult = true;
        double temp = 0;
        while (start > result)
        {
            temp = start;
            if (start * multStep < start // Каждый шаг уменьшает значение
            && flagMult // В тупиквый раз было не умножение
            && start * multStep >= result) // пока значение больше или равно конечному
            {
                start *= multStep;
                stepLogDo = temp + "*" + multStep + " ";
            }
            else
            {
                start += sumStep;
                stepLogDo = temp + "+" + sumStep + " ";
                flagMult = true;
            }

            logDo += stepLogDo;
            if (start < result)
            {
                if(!(logDo.contains("*"))) //Условие, когда ни одна комбинация не подходит
                {
                    logDo = "Unreal";
                    break;
                }
                else //Условие, когда надо подняться вверх по иерархии
                {
                    start -= sumStep;
                    start /= multStep;
                    flagMult = false;
                    logDo = logDo.substring(0,logDo.length() - stepLogDo.length() * 2 + 1);
                }
            }
        }
        return logDo;
    }
   
    // Функция при котором начальное значение больше конечного
    private static String executorGoPositive(Double start, Double result, Double sumStep, Double multStep)
    {
        if (start + sumStep < start && start * multStep < start ) return "Unreal"; // Условие выхода
        String logDo = "";
        String stepLogDo = "";
        Boolean flagMult = true;
        double temp = 0;
        while (start < result)
        {
            temp = start;
            if (start * multStep > start // Каждый шаг увеличивает значение
            && flagMult // В тупиквый раз было не умножение
            && start * multStep <= result) // пока значение меньше или равно конечному
            {
                start *= multStep;
                stepLogDo = temp + "*" + multStep + " ";
            }
            else
            {
                start += sumStep;
                stepLogDo = temp + "+" + sumStep + " ";
                flagMult = true;
            }

            logDo += stepLogDo;
            if (start > result)
            {
                if(!(logDo.contains("*"))) //Условие, когда ни одна комбинация не подходит
                {
                    logDo = "Unreal";
                    break;
                }
                else //Условие, когда надо подняться вверх по иерархии
                {
                    start -= sumStep;
                    start /= multStep;
                    flagMult = false;
                    logDo = logDo.substring(0,logDo.length() - stepLogDo.length() * 2 + 1);
                }
            }
        }
        return logDo;
    }

    // Функция распределения 
    static String executorGo(Double start, Double result, Double sumStep, Double multStep)
    {
        if (start < result) return executorGoPositive(start, result, sumStep, multStep);
        else return executorGoNegative(start, result, sumStep, multStep);
    }
}
