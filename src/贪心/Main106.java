package 贪心;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by user on 2017/10/2.
 */
public class Main106 {
    class Node{
        int v,w;

    }
    static int s,m;
    static Node node[]=new Node[12];
    class cmp implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o1.v<o2.v?1:-1;
        }
    }
    static Main106 main106=new Main106();
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while (t-->0){
            s=scanner.nextInt();
            m=scanner.nextInt();
            for (int i=0;i<s;i++){
                node[i]=main106.new Node();
                node[i].v=scanner.nextInt();
                node[i].w=scanner.nextInt();
            }
            Arrays.sort(node,0,s,main106.new cmp());
            int sum=0;
            for (int i=0;i<s;i++){
                if (m-node[i].w>0){
                    sum+=node[i].w*node[i].v;
                    m-=node[i].w;
                }else {
                    sum+=m*node[i].v;
                    break;
                }
            }
            System.out.println(sum);
        }
    }
}
