

public class Program{
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(6);
        queue.push(7);
        queue.push(8);
        queue.push(9);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }

}