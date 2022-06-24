import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class Solution{
    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/"));
    }
    public static String simplifyPath(String path) {
        String[] pathsArr = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String s:pathsArr){
            if(s.equals("")) continue;
            else if(s.equals(".")) continue;
            else if(s.equals("..")) 
                if(!stack.isEmpty()) stack.pop();
                else continue;
            else stack.add(s);
        }
        return "/"+String.join("/", stack);
    }
}