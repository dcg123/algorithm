package 双向链表;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by user on 2017/10/11.
 */
public class poj1511 {
    /**
     * 求源点到各个点的最短路+各个点到源点最短路的和
     */
    static int MAX_N=1000000+5;
    static int cost[];
    static int n;
    static boolean used[];
    static node[] edge,redge;
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while (t-->0){
            n=scanner.nextInt();
            edge=new node[n];
            cost=new int[n];
            redge=new node[n];
            used=new boolean[n];
            for (int i=0;i<n;i++){
                edge[i]=new node(-1,-1);
                redge[i]=new node(-1,-1);
            }
            int m=scanner.nextInt();
            for (int i=0;i<m;i++){
                int a=scanner.nextInt(),b=scanner.nextInt(),c=scanner.nextInt();
                insert(a,b,c);
            }
            long w=0;
            w+=spfa(0);
            w+=spfa(1);
            System.out.println(w);
        }
    }
    private static long spfa(int d) {
        node temp;
        for(int i=0;i< n;i++)
            cost[i]=2000000000;
        Queue< Integer> qu=new LinkedList< Integer>();
        qu.add(0);
        cost[0]=0;
        while(!qu.isEmpty())
        {
            int u=qu.poll();
            used[u]=false;
            if(d==0)temp=edge[u].next;
            else temp=redge[u].next;
            while(temp!=null)
            {
                if(cost[temp.v]>cost[u]+temp.w)
                {
                    cost[temp.v]=cost[u]+temp.w;
                    if(!used[temp.v])
                    {
                        qu.add(temp.v);
                        used[temp.v]=true;
                    }
                }
                temp=temp.next;
            }
        }
        long ans=0;
        for(int i=0;i< n;i++)
            ans+=cost[i];
        return ans;
    }
    private static void insert(int x, int y, int w) {
        x--;
        y--;
        node temp=new node(y,w);
        temp.next=edge[x].next;
        edge[x].next=temp;
        temp=new node(x,w);
        temp.next=redge[y].next;
        redge[y].next=temp;
    }
}
class node{
    int v,w;
    node next=null;
    public node(int vv,int ww){
        v=vv;
        w=ww;
    }
}