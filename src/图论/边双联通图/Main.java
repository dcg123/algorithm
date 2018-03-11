package 图论.边双联通图;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by user on 2017/10/14.
 */
public class Main {
    //边联通分量  在无向图中

    /**
     * 双连通与强连通，最大的差别，
     * 也是最本质的差别就是前者适用于无向图中，而后者适用于有向图。
     * 至于两者的概念是一样的，就是图中有a点、b点，从a点可到达b点，同时从b点可到达a点
     * 边-双连通分量是指在一个无向图中两点间至少有两条路径，
     * 且路径中的边不同。边-双连通分量中一定没有桥。
     *
     * 吧包含桥的无向图 变成边双联通图
     * @param args
     */
    static int N = 5010; // 3352只用1010即可
    class node{
        int v,w,id;
        node(){

        }
        node(int v,int w,int id){
            this.v=v;
            this.w=w;
            this.id=id;
        }
    }
    static int INF=999999999;
    static Vector<node>G[]=new Vector[N];
    static int dfn[]=new int[N];
    static int low[]=new int[N];
    static int dfs_num;
    static int ans ;
    static int n,m;
    static Main main=new Main();
    static void init(){
        Arrays.fill(dfn,0);
        Arrays.fill(low,0);
        for(int i=0;i<=n;i++) G[i]=new Vector<node>();
        dfs_num = 0;ans = INF;
    }

    static void dfs(int u,int fa){
        low[u] = dfn[u] = ++dfs_num;
        for(int i=0;i<G[u].size();i++){
            int v = G[u].get(i).v;
            int id = G[u].get(i).id;
            if(id == fa) continue;
            if(dfn[v]==0){
                dfs(v,id);//注意这里 第二个参数是 id
                low[u] =Math. min(low[u],low[v]);//用后代的low更新当前的
            }
            else
                low[u] = Math.min(low[u],dfn[v]);//利用后代v的反向边更新low
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int t;
        while(scanner.hasNext()){
            n=scanner.nextInt();
            m=scanner.nextInt();
            if (n==0||m==0){
                break;
            }
            int a,b,c;
            init();
            for(int i=1;i<=m;i++){
                a=scanner.nextInt();
                b=scanner.nextInt();
                G[a].add(main.new node(b,0,i));
                G[b].add(main.new node(a,0,i));
            }
            for(int i=1;i<=n;i++){
                if(dfn[i]==0)
                    dfs(i,0);
                //cout<<i<<endl;
            }
            int degree[]=new int[N];
            Arrays.fill(degree,0);
            for(int i=1;i<=n;i++){
                for(int j=0;j<G[i].size();j++){
                    int v = G[i].get(j).v;
                    if(low[i] != low[v]){
                        degree[low[v]]++; degree[low[i]]++;
                    }
                }
            }
            int l = 0;
            for(int i=1;i<=dfs_num;i++)
                if(degree[i] == 2)
                    l++;
            System.out.printf("%d\n",(l+1)/2);
        }
    }
}


