public class Program {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        System.out.println(minStack.getMin());
        System.out.println(minStack.top()); 
        minStack.pop();
        System.out.println(minStack.getMin()); 
        
    }
}