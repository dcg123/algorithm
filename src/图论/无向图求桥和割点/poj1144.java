package 图论.无向图求桥和割点;

import java.util.Scanner;

/**
 * Created by user on 2017/9/25.
 */
public class poj1144 {
    static int V=1000;
    static int edge[][]=new int[V][V];//邻接矩形
    static int bridge[][]=new int[V][V];//表示u->v是否是一个桥
    static int cut[]=new int[V];//表示节点v是否是割点
    static int dnf[]=new int[V];
    static int low[]=new int[V];
    static int vis[]=new int[V];
    static int n;
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            n=scanner.nextInt();
            if(n==0){
                break;
            }
            scanner.nextLine();
            init();
            while (true){
                String str=scanner.nextLine();
                String a[]=str.split(" ");
                if (Integer.valueOf(a[0])==0){
                    break;
                }
                else {
                    int from=Integer.valueOf(a[0]);
                    for (int i=1;i<a.length;i++){
                        int to=Integer.valueOf(a[i]);
                        edge[from-1][to-1]=1;
                        edge[to-1][from-1]=1;
                    }
                }
            }
            for(int i=1;i<=n;i++){
                if (vis[i]==0){
                    cnt_bridge(i,-1,0,n);
                }
            }

            int ans=0;
            for (int i=0;i<n;i++){
                if (cut[i]==1){
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }

    private static void init() {
        for (int i=0;i<V;i++){
            dnf[i]=0;
            low[i]=0;
            vis[i]=0;
            cut[i]=0;
            for (int j=0;j<V;j++){
                edge[i][j]=0;
                bridge[i][j]=0;
            }
        }
    }

    private static void cnt_bridge(int cur, int father, int dep, int n) {
        vis[cur]=1;
        dnf[cur]=low[cur]=dep;
        int children=0;
        for (int i=0;i<n;i++){
            if (edge[cur][i]==1){
                if (i!=father&&vis[i]==1){
                    if (dnf[i]<low[cur]){
                        low[cur]=dnf[i];
                    }
                }
            }
            if (vis[i]==0){
                cnt_bridge(i,cur,dep+1,n);
                children++;
                if (low[i]<low[cur]){
                    low[cur]=low[i];
                }
                if ((father==-1&&children>1)||(father!=-1&&low[i]>=dnf[cur])){
                    cut[cur]=1;
                }
                if (low[i]>dnf[cur]){
                    bridge[cur][i]=bridge[i][cur]=1;
                }
            }
        }
        vis[cur]=2;
    }
}
