package 图论.网络流.最小费用最大流;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by user on 2017/10/16.
 */
public class poj3068 {
    /**
     * 源点到第一个点建容量为2,花费为0的边，最后一个点到汇点建容量为2,花费为0的边，
     * 在每条边的起点和终点建一条容量为1，花费为边权的边，则该题转化成一道最小费用最大流问题，
     * 如果最大流是2则存在满足条件的最短路，输出其最小花费即为答案，
     * 如果最大流小于2则输出Not possible
     * @param args
     */
    static int INF=0x3f3f3f3f;
    class node{
        int to,cap,cost,rev;
        node(int _to, int _cap, int _cost, int _rev)
        {
            to = _to;
            cap = _cap;
            cost = _cost;
            rev = _rev;
        }
    }
    static poj3068 poj=new poj3068();
    static int V;
    static int dis[]=new int[10005],prevv[]=new int[10005],preve[]=new int[10005];
    static Vector<node> G[]=new Vector[10005];
    static void addedge(int from,int to,int cap,int cost){
        G[from].add(poj.new node(to,cap,cost,G[to].size()));
        G[to].add(poj.new node(from,0,-cost,G[from].size()-1));
    }
    static int min_cost_flow(int s,int t,int f){
        int i,d,v,ans,sign;
        ans=0;
        while(f>0){
            Arrays.fill(dis,INF);
            dis[s]=0;
            sign=1;
            while(sign==1){
                sign=0;
                for(v=0;v<V;v++){
                    if(dis[v]==INF)
                        continue;
                    for(i=0;i<G[v].size();i++){
                        node e=G[v].get(i);
                        if(e.cap>0&&dis[e.to]>dis[v]+e.cost){
                            dis[e.to]=dis[v]+e.cost;
                            prevv[e.to]=v;
                            preve[e.to]=i;
                            sign=1;
                        }
                    }
                }
            }                                       //沿费用最短路增广
            if(dis[t]==INF)
                return -1;
            d=f;
            for(v=t;v!=s;v=prevv[v])
                d=Math.min(d,G[prevv[v]].get(preve[v]).cap);     //找出当前流量
            f-=d;
            ans+=d*dis[t];
            for(v=t;v!=s;v=prevv[v]){
                node e=G[prevv[v]].get(preve[v]);
                e.cap-=d;
                G[v].get(e.rev).cap+=d;                 //加反向边
            }
        }
        return ans;
    }                                               //最小费用流模板

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n,m,i,j,u,v,w,ans,cas;
        cas=1;
        while(scanner.hasNext()){
            n=scanner.nextInt();
            m=scanner.nextInt();
            if (n==0&&m==0){
                break;
            }
            scanner.nextLine();
            for(i=0;i<=n+1;i++)
                G[i]=new Vector<node>();
            addedge(0,1,2,0);                       //源点与第一个点容量为2，费用为0
            addedge(n,n+1,2,0);                     //汇点与最后一个点容量也为2，费用为0
            while(m-->0){
                String str=scanner.nextLine();
                String a[]=str.split(" ");
                u=Integer.valueOf(a[0]);
                v=Integer.valueOf(a[1]);
                w=Integer.valueOf(a[2]);
                addedge(u+1,v+1,1,w);               //建容量为1，权值为边权的边
            }
            V=n+2;
            ans=min_cost_flow(0,V-1,2);
            if(ans==-1)
                System.out.printf("Instance #%d: Not possible\n",cas++);
            else
                System.out.printf("Instance #%d: %d\n",cas++,ans);
        }
    }

}
