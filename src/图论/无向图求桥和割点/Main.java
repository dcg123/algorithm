package 图论.无向图求桥和割点;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by user on 2017/10/13.
 */
public class Main {
    //割点条件 cur是跟 并且有大于一个的儿子 cur不是跟 cur的一个儿子 low[v]>=dfn[cur]
    //桥的条件 dfn[u]<low[v]
    static int N = 110;
    static Vector<Integer> G[]=new Vector[N];//存储无向图信息
    static int dnf[]=new int[N];//存储节点的访问次序
    static int low[]=new int[N];//存储每个节点回到的最长开始祖先
    static boolean iscut[]=new boolean[N];//标记改点是否访问过
    static int dfs_num,conut;
    static boolean cnt[]=new boolean[N];//保存割点
    class Edge{
        int x,y;
    }
    static Edge edge[]=new Edge[N];
    static Main main=new Main();
    static void init(){
        Arrays.fill(dnf,0);
        Arrays.fill(low,0);
        Arrays.fill(iscut,false);
        Arrays.fill(cnt,false);
        for(int i=0;i<N;i++)G[i]=new Vector<Integer>();
        dfs_num = 0;
        conut=0;
    }
    static void dfs(int u,int fa){
        low[u] = dnf[u] = ++dfs_num;
        int child = 0;
        for(int i=0;i<G[u].size();i++){
            int v = G[u].get(i);
            if(dnf[v]==0){//没有访问过该点 递归遍历
                child++;
                dfs(v,u);
                low[u] = Math.min(low[u],low[v]);//用后代的low更新当前的
                if(low[v] >= dnf[u])//判断是否是割点
                    cnt[u]=true;
                if(low[v] > dnf[u])//判断是否是桥
                {
                    edge[conut]=main.new Edge();
                    edge[conut].x=u;
                    edge[conut].y=v;
                    conut++;
                }
            /* if(low[v] > pre[u])
                iscutbridge = 1;
            */
            }
            else if( v != fa)//该点已经访问过
                low[u] = Math.min(low[u],dnf[v]);//利用后代v的反向边更新low
        }
        if(fa< 0 && child == 1) cnt[u] = false;//就一个后代（共两个节点）
    }
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        int t;
        while(scanner.hasNext()){
            t=scanner.nextInt();
            if (t==0){
                break;
            }
            init();
            int n;
            scanner.nextLine();
            while (true){
                String str=scanner.nextLine();
                String a[]=str.split(" ");
                if (Integer.valueOf(a[0])==0){
                    break;
                }
                else {
                    int l=Integer.valueOf(a[0]);
                    for (int i=1;i<a.length;i++){
                        int r=Integer.valueOf(a[i]);
                        G[l].add(r);
                        G[r].add(l);
                    }
                }
            }

            for(int i=1;i<=t;i++){
                if(dnf[i]==0)
                    dfs(i,-1);
            }
            int ans = 0;
            for(int i=1;i<=t;i++){
                if(cnt[i])
                    ans++;
            }
            for (int i=0;i<conut;i++){
                System.out.println(edge[i].x+" "+edge[i].y);
            }
            System.out.printf("%d\n",ans);
        }
    }
}
