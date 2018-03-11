package 数据结构.优先队列;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by user on 2017/10/11.
 */
public class hdu1434 {
    static int n,m;
    class Node{
        int rp;
        String name;
    }
    static hdu1434 main1434=new hdu1434();
    static Comparator<Node> comparator=new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            if (o1.rp==o2.rp){
                return o1.name.compareTo(o2.name)<0?1:-1;
            }
            return o1.rp<o2.rp?-1:1;
        }
    };

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            n=scanner.nextInt();
            m=scanner.nextInt();
            int t=0;
            //优先队列
            Queue<Node> queue[]=new PriorityQueue[10000+10];
            for (int i=0;i<=n;i++){
                queue[i]=new PriorityQueue<Node>(10000+10,comparator);
            }
            for (int i=0;i<n;i++){
                int x=scanner.nextInt();
                scanner.nextLine();
                for (int j=0;j<x;j++){
                    Node node=main1434.new Node();
                    String str=scanner.nextLine();
                    String a[]=str.split(" ");
                    node.name=a[0];
                    node.rp=Integer.valueOf(a[1]);
                    queue[i].offer(node);
                }
            }
            while (m-->0){
                String str=scanner.nextLine();
                String a[]=str.split(" ");
                if (a[0].equals("GETOUT")){
                    int num=Integer.valueOf(a[1]);
                    Node temp=queue[num].peek();
                    if (queue[num].size()!=0){
                        System.out.println(temp.name);
                        queue[num].poll();
                    }
                }
                if (a[0].equals("GETON")){
                    int num=Integer.valueOf(a[1]);
                    String name=a[2];
                    int rp=Integer.valueOf(a[3]);
                    Node node =main1434.new Node();
                    node.rp=rp;
                    node.name=name;
                    queue[num].offer(node);
                }else if (a[0].equals("JOIN")){
                    int num1=Integer.valueOf(a[1]);
                    int num2=Integer.valueOf(a[2]);
                    while (queue[num2].size()!=0){
                        Node temp=queue[num2].poll();
                        queue[num1].offer(temp);
                    }
                }
            }
        }
    }
}
