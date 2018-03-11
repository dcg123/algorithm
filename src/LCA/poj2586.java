package LCA;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by user on 2017/10/13.
 */
public class poj2586 {
    /**
     * 题意：给一个无根树，有q个询问，每个询问两个点，问两点的距离。
     * 求出  lca = LCA(X,Y) , 然后  dir[x] + dir[y] - 2 * dir[lca]
     dir[u]表示点u到树根的距离
     */
    static int n,m;
    static int pre[]=new int[40000+10];
    static boolean vis[]=new boolean[40000+10];
    static int ance[]=new int[40000+10];
    class Node{
        int from,to,cost;
    }
    static int d[]=new int[40000+10];
    static poj2586 main1=new poj2586();
    static Vector<Node> vector[]=new Vector[40000+10];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while (t-->0){
            n=scanner.nextInt();
            m=scanner.nextInt();
            if(n==0&&m==0){
                break;
            }
            scanner.nextLine();
            Arrays.fill(vis,false);
            Arrays.fill(ance,0);
            Arrays.fill(d,0);
            for (int i=0;i<=n;i++){
                pre[i]=i;
                vector[i]=new Vector<Node>();
            }
            for (int k=0;k<n-1;k++){
                String str=scanner.nextLine();
                String a[]=str.split(" ");
                int from=Integer.valueOf(a[0]);
                int to=Integer.valueOf(a[1]);
                int cost=Integer.valueOf(a[2]);
                Node ss=main1.new Node();
                ss.from=from;
                ss.to=to;
                ss.cost=cost;
                vector[from].add(ss);
                Node sss=main1.new Node();
                sss.from=to;
                sss.to=from;
                sss.cost=cost;
                vector[to].add(sss);
            }
            lca(1);
            for (int i=0;i<m;i++){
                int x=scanner.nextInt();
                int y=scanner.nextInt();
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

    private static int find(int u) {
        int r=u;
        while (r!=pre[r]){
            r=pre[r];
        }
        return r;
    }
}
