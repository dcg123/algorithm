package 图论.最短路;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by user on 2017/8/14.
 */
public class poj1346 {
    /**
     * 意：一个长度为n的序列和它的m个子序列，每个子序列的和都有一个限制k，
     * gt代表大于k，lt代表小于k。 问你这样的序列是否存在。
     思路：大于k == 大于等于k+1, 小于k == 小于等于k-1。
     图可能是不连通的，所以需要建立虚拟源点并和所有顶点连边来保证图的连通，
     接下来就是判断是否存在负环就可以了。
     注意：图中有 0 到 n 共 n + 1 个点。
     */
    static int MAX_N=100+5;
    static int Maxn=9999999;
    static boolean vis[][]=new boolean[MAX_N][MAX_N];
    static int dis[][]=new int[MAX_N][MAX_N];
    static int n;

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int start=scanner.nextInt();
        int endd=scanner.nextInt();
        for(int i=1;i<=n;i++)
        {
            int js=scanner.nextInt();
            for(int j=1;j<=js;j++)
            {
                int v=scanner.nextInt();
                if(j!=1)dis[i][v]=1;
                else dis[i][v]=0;
                vis[i][v]=true;
            }
        }
        for(int i=1;i<=n;i++)
            for(int j=1;j<=n;j++)
            {
                if(!vis[i][j]&&i!=j)dis[i][j]=Maxn;
                if(i==j)dis[i][j]=0;
            }
        for(int k=1;k<=n;k++)
            for(int i=1;i<=n;i++)
                for(int j=1;j<=n;j++)
                    if(dis[i][j]>dis[i][k]+dis[k][j])
                        dis[i][j]=dis[i][k]+dis[k][j];
        if(dis[start][endd]!=Maxn){
            System.out.println(dis[start][endd]);
        }else{
            System.out.println("-1");
        }

    }
}
