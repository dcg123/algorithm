package 单向链表;

import java.util.Scanner;

/**
 * Created by user on 2017/11/28.
 */
public class Linked {

    class Node{
        public Object value=null;
        private Node next=null;
    }
    private Node header = null;//头结点
    //初始化
    void initLinked(){
        header=new Node();
        header.value=null;
        header.next=null;
    }

    //增加节点
    void addLinked(Node newNode){
        Node e=new Node();
        e.value=newNode.value;
        if (header.next==null){
            header.next=e;
        }else {
            Node temp=header;
            while (temp.next!=null){
                temp=temp.next;
            }
            temp.next=e;
        }
    }
    //删除节点
    void deletNode(Node deleteNode){
        Node temp=header;
        while (temp.next!=null){
            if (temp.next.value.equals(deleteNode.value)){
                temp.next=temp.next.next;
            }else {
                temp=temp.next;
            }
        }
    }

    //获取节点
    Node getNode(int i){
        if (i<=0||i>size()){
            System.out.println("输入位置有误");
            return null;
        }
        else {
            Node element = new Node();
            int count=0;
            Node temp=header;
            while (temp.next!=null){
                count++;
                if (count==i){
                    element.value=temp.next.value;
                }
                temp=temp.next;
            }
            return element;
        }
    }

    private int size() {
        Node temp=header;
        int count=0;
        while (temp.next!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }

    //查看节点是否存在
    boolean isContain(int isNode){
        Node temp=header;
        while (temp.next!=null){
            if (temp.next.value.equals(isNode)){
                return true;
            }
            temp=temp.next;
        }
        return false;
    }
    void print(){
        System.out.println("输出链表");
        Node temp=header;
        while (temp.next!=null){
            temp=temp.next;
            System.out.print(temp.value+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Linked linked=new Linked();
        linked.initLinked();
        System.out.println("输入链表数据");
        for (int i=0;i<4;i++){
            Node node=linked.new Node();
            node.value=scanner.nextInt();
            linked.addLinked(node);
        }
        System.out.println("打印链表");
        linked.print();
        System.out.println("链表长度"+linked.size());
        System.out.println("第1个元素值为："+linked.getNode(1).value);
        System.out.println("第2个元素值为："+linked.getNode(2).value);
        System.out.println("第3个元素值为："+linked.getNode(3).value);
        System.out.println(linked.isContain(2));
        System.out.println(linked.isContain(5));

    }
}

