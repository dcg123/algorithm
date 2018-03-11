package 最大二分匹配.最小顶点覆盖;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by user on 2017/10/16.
 */
public class poj3041 {
    /**
     * 给一个N*N的矩阵，有些格子有障碍，要求我们消除这些障碍，问每次消除一行或一列的障碍，

     最少要几次。这里将每行x看成一个X结点，每列Y看成一个Y结点，障碍的坐标x,y看成X到Y的

     一条边，构建出图后，就变成了找最少的点，使得这些点与所有的边相邻，即最小点覆盖问题。
     */
    static int MAX=505;
    static boolean map[][]=new boolean[MAX][MAX];
    static int match[]=new int[MAX];
    static boolean vis[]=new boolean[MAX];
    static int n,k;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        k=scanner.nextInt();
        for (int i=0;i<MAX;i++){
            for (int j=0;j<MAX;j++){
                map[i][j]=false;
            }
        }
        for (int i=1;i<=k;i++){
            int x=scanner.nextInt();
            int y=scanner.nextInt();
            map[x][y]=true;
        }
        int ans=MaxMatch();
        System.out.println(ans);
    }

    private static int MaxMatch() {
        int ret=0;
        Arrays.fill(match,-1);
        for (int i=1;i<=n;i++){
            Arrays.fill(vis,false);
            if (dfs(i)){
                ret++;
            }
        }
        return ret;
    }

    private static boolean dfs(int u) {
        for (int i=1;i<=n;i++){
            if (map[u][i]&&!vis[i]){
                vis[i]=true;
                if (match[i]==-1||dfs(match[i])){
                    match[i]=u;
                    return true;
                }
            }
        }
        return false;
    }
}
