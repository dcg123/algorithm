package 图论.最短路;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by user on 2017/8/14.
 */
public class aoj2249 {
    /**
     * 修路：ACM之王要在全国改造交通网络，第一保证首都最短路，第二保证最低花费。
     * n个点，m条边，每条边有一个路和花费。求程到1点距离最小（最短路）的前提下，寻找花费最小的值。
     */
    static int INF=100000;
    static int MAX_N=10000;
    static int d[]=new int[MAX_N];
    static int vis[]=new int[MAX_N];
    static int cost[]=new int[MAX_N];
    static int n,m;
    class Node{
        int from,to,dis,c;
    }
    static aoj2249 aoj=new aoj2249();
    static Node node[];
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            n=scanner.nextInt();
            m=scanner.nextInt();
            if(n+m==0){
                break;
            }
            node=new Node[m];
            for(int i=0;i<m;i++){
                int from=scanner.nextInt(),to=scanner.nextInt(),dis=scanner.nextInt(),c=scanner.nextInt();
                node[i]=aoj.new Node();
                node[i].from=from;
                node[i].to=to;
                node[i].dis=dis;
                node[i].c=c;
            }
            spfa(1);
            System.out.println(cost[0]);
        }
    }

    private static void spfa(int start) {
        Arrays.fill(vis,0);
        Arrays.fill(d,INF);
        Arrays.fill(cost,INF);
        d[start]=0;
        cost[start]=0;
        Queue<Integer> queue=new LinkedList<Integer>();
        queue.offer(start);
        while (queue.size()!=0){
            int cur=queue.poll();
            vis[cur]=0;
            for(int i=0;i<node.length;i++){
                if(cur==node[i].from&&d[node[i].to]>(d[node[i].from]+node[i].dis)){
                    d[node[i].to]=d[node[i].from]+node[i].dis;
                    cost[node[i].to]=node[i].c;
                    if(vis[i]==0){
                        vis[i]=1;
                        queue.offer(node[i].to);
                    }
                }
                else if(d[node[i].to]==d[cur]+node[i].dis){
                    if(cost[node[i].to]>node[i].c){
                        cost[node[i].to]=node[i].c;
                    }
                }
            }
        }
        for(int i=1;i<=n;i++)
            cost[0]+=cost[i];
    }


}
