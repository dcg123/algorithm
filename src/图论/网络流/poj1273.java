package 图论.网络流;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by user on 2017/10/12.
 */
public class poj1273 {
    static int Max=210;
    static int map[][]=new int[Max][Max];
    static int n,m;
    static boolean vis[]=new boolean[Max];
    static int pre[]=new int[Max];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            n=scanner.nextInt();
            m=scanner.nextInt();
            if (n+m==0){
                break;
            }
            scanner.nextLine();
            for (int i=0;i<=n;i++){
                for (int j=0;j<=n;j++){
                    map[i][j]=0;
                }
            }
            for (int i=0;i<n;i++){
                String str=scanner.nextLine();
                String a[]=str.split(" ");
                int u=Integer.valueOf(a[0]);
                int v=Integer.valueOf(a[1]);
                int cost=Integer.valueOf(a[2]);
                map[u][v]+=cost;
            }
            int new_flow=0;
            int max_flow=0;
            do {
                new_flow=bfs_newflow(1,m);
                updata_flow(m,new_flow);
                max_flow+=new_flow;
            }while (new_flow!=0);
            System.out.println(max_flow);
        }
    }

    private static void updata_flow(int u, int flow) {
        while (pre[u]!=-1){
            map[pre[u]][u]-=flow;
            map[u][pre[u]]+=flow;
            u=pre[u];
        }
    }

    private static int bfs_newflow(int s, int t) {
        Arrays.fill(vis,false);
        Arrays.fill(pre,-1);
        Queue<Integer> queue=new LinkedList<Integer>();
        vis[s]=true;
        int min=999999;
        queue.offer(s);
        while (queue.size()!=0){
            int cur=queue.poll();
            if (cur==t){
                break;
            }
            for (int i=1;i<=m;i++){
                if (!vis[i]&&map[cur][i]!=0){
                    queue.offer(i);
                    vis[i]=true;
                    min=Math.min(min,map[cur][i]);
                    pre[i]=cur;
                }
            }
        }
        if (pre[t]==-1){
            return 0;
        }
        return min;
    }
}
