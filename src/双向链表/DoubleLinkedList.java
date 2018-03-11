package 双向链表;

/**
 * Created by user on 2017/11/29.
 */
public class DoubleLinkedList {
    class Node{
        Object value;
        Node pre;
        Node next;

        public Node(Object v){
            value=v;
        }
    }

    private Node head=new Node(null);//头结点
    private int size;

    public void addFirst(Node newNode){

    }
}
