package 图论.最短路;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by user on 2017/10/13.
 */
public class hdu1317 {
    /**
     * 题意：从第一个房间开始有100的初始能量。每经过一个房间加上此房间的能量值，
     * 如果能量为负或者到达终点则停止。问能不能到达终点。
     *
     * 先folyd跑一遍 看是否可以从第一个房间到第最后一个房间
     */
    static int n;
    static boolean map[][]=new boolean[105][105];
    static boolean reach[][]=new boolean[105][105];
    static boolean vis[]=new boolean[105];
    static int d[]=new int[105];
    static int num[]=new int[105];
    static int en[]=new int[105];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            n=scanner.nextInt();
            if (n==-1){
                break;
            }
            for (int i=1;i<=n;i++){
                en[i]=scanner.nextInt();
                int k=scanner.nextInt();
                for (int j=0;j<k;j++){
                    int u=scanner.nextInt();
                    map[i][u]=true;
                    reach[i][u]=true;
                }
            }
            floyd();
            if (!reach[1][n]) {
                System.out.println("hopeless");
                continue;
            }
            if (spfa(1)){
                System.out.println("winnable");
            }else {
                System.out.println("hopeless");
            }
        }
    }

    private static boolean spfa(int s) {
        Queue<Integer> queue=new LinkedList<Integer>();
        Arrays.fill(d,9999999);
        Arrays.fill(vis,false);
        Arrays.fill(num,0);
        num[s]++;
        d[s]=100;
        vis[s]=true;
        while (queue.size()!=0){
            int cur=queue.poll();
            if (num[cur]>=n){
                return reach[cur][n];
            }
            vis[cur]=false;
            for (int i=1;i<=n;i++){
                if (map[cur][i]&&d[i]<d[cur]+en[i]&&d[cur]+en[i]>0){//判断是否这条路径大于0
                    d[i]=d[cur]+en[i];
                    if (!vis[i]){
                        vis[i]=true;
                        queue.offer(i);
                    }
                }
            }
        }
        return d[n]>0;
    }

    private static void floyd() {
        for (int k=1;k<=n;k++){
            for (int i=1;i<=n;i++){
                for (int j=1;j<=n;j++){
                    if (reach[i][j]||(reach[i][k]&&reach[k][j])){
                        reach[i][j]=true;
                    }
                }
            }
        }
    }
}
