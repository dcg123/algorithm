package 贪心;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by user on 2017/8/11.
 */
public class poj3262 {
    /**
     * 有n个牛在FJ的花园乱吃。
     所以FJ要赶他们回牛棚。
     每个牛在被赶走之前每秒吃Di个花朵。赶它回去FJ要花的时间是Ti。在被赶走的过程中牛就不能乱吃了
     */
    static int n;
    static poj3262 poj=new poj3262();
    class Node{
        int t,d;
    }
    static Node node[];
    class cmp implements Comparator<Node>{
        @Override
        public int compare(Node o1, Node o2) {
//            if(o1.t==o2.t){
//                return o1.d<o2.d?1:-1;
//            }
//            return o1.t<o2.t?-1:1;
            return o1.t*o1.d<o2.t*o2.d?1:-1;
        }
    }
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        node=new Node[n];
        long sum=0;
        for(int i=0;i<n;i++){
            node[i]=poj.new Node();
            node[i].t=scanner.nextInt()*2;
            node[i].d=scanner.nextInt();
            sum+=node[i].d;
        }
        Arrays.sort(node,0,n,poj.new cmp());
        long ans=0;
        for(int i=0;i<n;i++){
            sum-=node[i].d;
            ans+=sum*node[i].t;
        }
        System.out.println(ans);
    }
}
