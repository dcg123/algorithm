package bfs;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by user on 2017/10/3.
 */
public class Main42 {
    static int p,q;
    static int a[][]=new int[1000+10][1000+10];
    static int pd[]=new int[1000+10];
    static boolean vis[]=new boolean[1000+10];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while (t-->0){
            p=scanner.nextInt();
            q=scanner.nextInt();
            init();
            Arrays.fill(pd,0);
            for (int i=0;i<q;i++){
                int u=scanner.nextInt();
                int v=scanner.nextInt();
                a[u][v]=1;
                a[v][u]=1;
                pd[u]++;
                pd[v]++;
            }
            //判断是否是连通图
            Arrays.fill(vis,false);
            dfs(1);
            boolean flag=true;
            for (int i=1;i<=p;i++){
                if (!vis[i]){
                    flag=false;
                    break;
                }
            }
            int sum=0;
            for (int i=1;i<=p;i++){
                if (pd[i]%2==1){
                    sum++;
                }
            }
            if(sum!=0&&sum!=2){
                flag = false;
            }
            if(flag)
                System.out.println("Yes");
            else System.out.println("No");
        }
    }

    private static void dfs(int s) {
        vis[s]=true;
        for (int i=0;i<=p;i++){
            if (i!=s&&a[s][i]==1&&!vis[i]){
                dfs(i);
            }
        }
    }

    private static void init() {
        for (int i=0;i<1000+10;i++){
            for (int j=0;j<1000+10;j++){
                a[i][j]=0;
            }
        }
    }
}
