package 剑指offer;

/**
 * Created by user on 2017/11/29.
 */
public class Main14 {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int a){
            val=a;
        }
    }
    public static void main(String[] args) {

    }
    public ListNode FindKthToTail(ListNode head,int k) {
        int count=size(head);
        int sum=0;
        int num=count-k+1;
        ListNode temp=head;
        ListNode listNode=null;
        while (temp!=null){
            sum++;
            if (sum==num){
                listNode=temp;
                break;
            }
            temp=temp.next;
        }
        return listNode;
    }

    private int size(ListNode head) {
        int count=0;
        while (head!=null){
            count++;
            head=head.next;
        }
        return count;
    }
}
