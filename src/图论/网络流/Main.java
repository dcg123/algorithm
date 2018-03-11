package 图论.网络流;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by user on 2017/10/12.
 */
public class Main {
    static boolean vis[]=new boolean[1000];
    static int map[][]=new int[1000][1000];
    static int pre[]=new int[1000];
    static  int n,m;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        m=scanner.nextInt();
        edmonds_karp(n,m);
    }

    private static void edmonds_karp(int s, int t) {
        int new_flow=0;
        int max_flow=0;
        do{
            new_flow=find_bfs(s,t);
            updata_residual_network(t,new_flow);
            max_flow+=new_flow;
        }while (new_flow!=0);
    }

    private static void updata_residual_network(int u, int flow) {
        while (pre[u]!=-1){
            map[pre[u]][u]-=flow;
            map[u][pre[u]]+=flow;
            u=pre[u];
        }
    }

    private static int find_bfs(int s, int t) {
        Arrays.fill(vis,false);
        Arrays.fill(pre,-1);
        vis[s]=true;
        int min=999999;
        Queue<Integer> queue=new LinkedList<Integer>();
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
                    min=min<map[cur][i]?min:map[cur][i];
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
