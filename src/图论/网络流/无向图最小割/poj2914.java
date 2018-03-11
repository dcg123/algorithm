package 图论.网络流.无向图最小割;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by user on 2017/10/12.
 */
public class poj2914 {
    /**
     * //就是最小割集，可以使用最小割 Stoer-Wagner 算法
     //题意就是要去掉一些边，使得可以分成两个集合，并且使得去掉的边的权值和为最小
     /*
     算法步骤：
     1. 设最小割cut=INF, 任选一个点s到集合A中, 定义W(A, p)为A中的所有点到A外一点p的权总和.

     2. 对刚才选定的s, 更新W(A,p)(该值递增).

     3. 选出A外一点p, 且W(A,p)最大的作为新的s, 若A!=G(V), 则继续2.

     4. 把最后进入A的两点记为s和t, 用W(A,t)更新cut.

     5. 新建顶点u, 边权w(u, v)=w(s, v)+w(t, v), 删除顶点s和t, 以及与它们相连的边.

     6. 若|V|!=1则继续1.

     */
    static int N = 501;
    static int MAXV = 0x3F3F3F3F;
    static int n,m,v[]=new int[N];//经过合并后的第i个节点v[i]
    static int mat[][]=new int[N][N];
    static int dis[]=new int[N];//dis[i]表示w(A,v[i])
    static boolean vis[]=new boolean[N];
    static int res;
    static  int min(int a, int b){
        return a < b ? a : b;
    }
    static int Stoer_Wagner(int n) {
        int i, j;
        int res = MAXV;
        for (i = 0; i < n; i++)
            v[i] = i;//初始化第i个结点就是i
        while (n > 1) {
            int maxp = 1,prev = 0;
            for (i = 1;i < n;i++){ //初始化到已圈集合的割大小,并找出最大距离的顶点
                dis[v[i]] = mat[v[0]][v[i]];
                if (dis[v[i]] > dis[v[maxp]])
                    maxp = i;
            }
            Arrays.fill(vis,false);
            vis[v[0]] = true;
            for (i = 1;i < n;i++) {
                if (i == n - 1){ //只剩最后一个没加入集合的点，更新最小割
                    res = min(res,dis[v[maxp]]);
                    for (j = 0; j < n; j++){ //合并最后一个点以及推出它的集合中的点
                        mat[v[prev]][v[j]] += mat[v[j]][v[maxp]];
                        mat[v[j]][v[prev]] = mat[v[prev]][v[j]];
                    }
                    v[maxp] = v[--n];//第maxp个节点去掉，第n个节点变成第maxp个
                }
                vis[v[maxp]] = true;
                prev = maxp;
                maxp = -1;
                for (j = 1;j < n;j++)
                    if (!vis[v[j]]){ //将上次求的maxp加入集合，合并与它相邻的边到割集
                        dis[v[j]] += mat[v[prev]][v[j]];
                        if (maxp == -1 || dis[v[maxp]] < dis[v[j]])
                            maxp = j;
                    }
            }
        }
        return res;
    }

    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()) {
            n=scanner.nextInt();
            m=scanner.nextInt();
            for (int i=0;i<N;i++){
                for (int j=0;j<N;j++){
                    mat[i][j]=0;
                }
            }
            int x,y,z;
            while (m-->0) {
                x=scanner.nextInt();
                y=scanner.nextInt();
                z=scanner.nextInt();
                mat[x][y] += z;
                mat[y][x] += z;
            }
           System.out. printf("%d\n",Stoer_Wagner(n));
        }

    }
}
