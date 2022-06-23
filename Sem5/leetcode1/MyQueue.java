import java.util.Stack;

public class MyQueue {
    private Stack<Integer> mainStack = new Stack<Integer>();
    private Stack<Integer> tempStack = new Stack<Integer>();

    public MyQueue() {

    }

    public void push(int x) {

        while (!mainStack.isEmpty()) {
            tempStack.push(mainStack.pop());
        }
        tempStack.push(x);
        while (!tempStack.isEmpty()) {
            mainStack.push(tempStack.pop());
        }
    }

    public int pop() {
        return mainStack.pop();
    }

    public int peek() {
        return mainStack.peek();
    }

    public boolean empty() {
        return mainStack.isEmpty();
    }
}