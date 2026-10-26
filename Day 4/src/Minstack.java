import java.util.Stack;

public class Minstack {
    private Stack<Integer> stack;
    private Stack<Integer> minstack;
    public Minstack(){
        stack=new Stack<>();
        minstack=new Stack<>();
    }
    public void push(int value) {
        stack.push(value);
        if(minstack.isEmpty()){
            minstack.push(value);
        }
        else{
            minstack.push(Math.min(minstack.peek(),value));
        }
    }

    public void pop() {
        stack.pop();
        minstack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minstack.peek();
    }
}
