package 图论.最大生成树;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by user on 2017/10/12.
 */
public class hdu3367 {
    /**
     *  给出一个图，要求出最大的pseudoforest， 所谓pseudoforest就是指这个图的一个子图，
     *  这个子图的每个连通分量中最多只能有一个环，
     *  而且这个子图的所有权值之和最大。这个就是所谓的伪森林
     *
     *  过程类似与kruskal求最小生成树，千万不要直接求最大生成树，一
     *  开始时我想到的方法是用kruskal算法求出这个图的最大生成树，
     *  然后给这一棵数再加上一条最大的边，构成一个环。 但是WA得快吐血了。

     正确的做法和求最大生成树很类似，但是有一点改变，
     因为每个连通分量允许有一个回环， 所以，我们可以在进行合并两颗树时，
     要判断这两颗树是否有回环，如果两个树都有回环，那么明显不可以合并这两颗树，
     如果只有一棵树有回环，那么可以合并，然后标上记号。如果两个都没有回环，那么就直接合并了。
     如果有两个点是属于同一棵树上的，那么判断这棵树上是否已有回环，
     如果没有的话，那么允许有一个回环，可以链接这两点，再标上记号。
     */
    class Node{
        int x,y,p;
    }
    static Node node[]=new Node[100005];
    static hdu3367 hdu=new hdu3367();
    static int pre[]=new int[100005];
    static int sum;
    static int cycle[]=new int[10005];//标记树是否存在环
    static int n,m;
    class cmp implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o1.p<o2.p?1:-1;
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            n=scanner.nextInt();
            m=scanner.nextInt();
            if (n+m==0){
                break;
            }
            for (int i=0;i<m;i++){
                node[i]=hdu.new Node();
                node[i].x=scanner.nextInt();
                node[i].y=scanner.nextInt();
                node[i].p=scanner.nextInt();
            }
            kruskal();
            System.out.println(sum);
        }
    }

    private static void kruskal() {
        int a,b,k=0;
        sum=0;
        for (int i=0;i<=n;i++){
            pre[i]=i;
            cycle[i]=0;
        }
        Arrays.sort(node,0,m,hdu.new cmp());
        for (int i=0;i<m;i++){
            a=find(node[i].x);
            b=find(node[i].y);
            if (a!=b&&(cycle[a]!=1||cycle[b]!=1)){//如果两个树都有环 不能合并
                sum+=node[i].p;
                pre[a]=b;
                if (cycle[a]==1){//合并过后 如何a树存在环 因为是合并所以b树叶存在环
                    cycle[b]=cycle[a];
                }
            }else if (cycle[a]==0){
                sum+=node[i].p;
                cycle[a]=1;
            }
        }
    }

    private static int find(int x) {
        int r=x;
        while (r!=pre[r]){
            r=pre[r];
        }
        return r;
    }
}
