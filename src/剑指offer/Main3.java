package 剑指offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by user on 2017/11/29.
 */
public class Main3 {
    class ListNode{
        int val;
        ListNode next=null;
        public ListNode(int a){
            val=a;
        }
    }
    public static void main(String[] args) {
    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer>  list=new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        ListNode temp=listNode;
        while (temp!=null){
            stack.push(temp.val);
            temp=temp.next;
        }
        while (!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }
}
