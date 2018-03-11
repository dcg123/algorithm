package 数据结构.优先队列;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by user on 2017/10/11.
 */
public class hdu1059 {
    class Node{
        String name;
        int val;
        int priority;
        int num;
    }
    static hdu1059 hdu=new hdu1059();
    static Comparator<Node> comparator=new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            if (o1.priority!=o2.priority){
                return o1.priority<o2.priority?-1:1;
            }
            return o1.num<o2.num?-1:1;
        }
    };
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int k = 0;
        Queue<Node> queue=new PriorityQueue<Node>(10000,comparator);
        while (scanner.hasNextLine()){
            String str=scanner.nextLine();
            String a[]=str.split(" ");
            if (a[0].equals("GET")){
                if (queue.size()!=0){
                    Node cur=queue.poll();
                    System.out.println(cur.name+" "+cur.val);
                }else {
                    System.out.println("EMPTY QUEUE!");
                }
            }else {
                String msg=a[1];
                int val=Integer.valueOf(a[2]);
                int priority=Integer.valueOf(a[3]);
                Node ss=hdu.new Node();
                ss.name=msg;
                ss.val=val;
                ss.priority=priority;
                ss.num=k++;
                queue.offer(ss);
            }
        }
    }
}
