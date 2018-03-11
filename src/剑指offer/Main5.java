package 剑指offer;

import java.util.Stack;

/**
 * Created by user on 2017/11/29.
 */
public class Main5 {
    public static void main(String[] args) {

    }
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        int result;
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.peek());
                stack1.pop();
            }
        }
        result = stack2.peek();
        stack2.pop();
        return result;
    }
}
