package LCA;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by user on 2017/10/18.
 */
public class poj1986 {
    /**
     * 题意：LCA模板题，输入n和m，表示n个点m条边，下面m行是边的信息，
     * 两端点和权，后面的那个字母无视掉，没用的。接着k，下面k个询问lca，输出即可

     有人说要考虑不连通的情况，我没考虑AC了，另外可能有u，u这样的询问，
     不过这不影响，照样是写模板，没有特判，一样能过
     */
    static int pre[]=new int[10000];
    static boolean vis[]=new boolean[10000];
    static int ance[]=new int[10000];
    class Node{
        int from,to,cost;
    }
    static Node node[]=new Node[40000];
    static poj1986 poj=new poj1986();
    static int n,m;
    static int d[]=new int[40000+10];
    static Vector<Node> vector[]=new Vector[40000+10];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            n=scanner.nextInt();
            m=scanner.nextInt();
            scanner.nextLine();
            Arrays.fill(vis,false);
            Arrays.fill(ance,0);
            Arrays.fill(d,0);
            for (int i=0;i<=n;i++){
                pre[i]=i;
                vector[i]=new Vector<Node>();
            }
            for (int i=0;i<m;i++){
                String str=scanner.nextLine();
                String a[]=str.split(" ");
                int from=Integer.valueOf(a[0]);
                int to=Integer.valueOf(a[1]);
                int cost=Integer.valueOf(a[2]);
                Node ss=poj.new Node();
                ss.from=from;
                ss.to=to;
                ss.cost=cost;
                vector[from].add(ss);
                Node sss=poj.new Node();
                sss.from=to;
                sss.to=from;
                sss.cost=cost;
                vector[to].add(sss);
            }
            lca(1);
            int k=scanner.nextInt();
            scanner.nextLine();
            while (k-->0){
                String str=scanner.nextLine();
                String a[]=str.split(" ");
                int x=Integer.valueOf(a[0]);
                int y=Integer.valueOf(a[1]);
                int ans=Math.abs(d[x]+d[y]-2*d[ance[y]]);
                System.out.println(ans);
            }
        }
    }

    private static void lca(int u) {
        pre[u]=u;
        ance[find(u)]=u;
        vis[u]=true;
        for (int i=0;i<vector[u].size();i++){
            int v=vector[u].get(i).to;
            if (!vis[v]){
                d[v]=d[u]+vector[u].get(i).cost;
                lca(v);
                Union1(u,v);
                ance[find(u)]=u;
            }
        }
    }

    private static void Union1(int u, int v) {
        int x=find(u);
        int y=find(v);
        pre[x]=pre[y];
    }
    private static int  find(int u) {
        int r=u;
        while (r!=pre[r]){
            r=pre[r];
        }
        return r;
    }
}
