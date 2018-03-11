package 最大二分匹配.最小顶点覆盖;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by user on 2017/10/12.
 */
public class hdu1498 {
    /**
     * 1 /*HDU1498
     2 题目大意:
     3 给出N*N（100以内）的矩阵，矩阵上填气球的标号（1--50），给定 K
     4 问，哪些编号的气球是不能一次在K次以内拿完的。每次拿取的过程是：选择一行或者一列，再在其中选一个气球，其余的下一次不能再选。
     5
     6 思考：
     7 变种的棋盘问题。
     8 但是要枚举气球编号(分类讨论).
     9 这样，就是找到最大的匹配，即最多能放置互不在同一行或一列的气球。
     10 这个匹配数小于等于K，则气球能全部被拿完。
     11 复杂度为：O(50*200*200)
     12 */

    static int n,k;
    static int map[][]=new int[101][101];
    static int link[]=new int[101];
    static int ans[]=new int[101];
    static boolean color[]=new boolean[101];
    static boolean vis[]=new boolean[101];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int totle;
        while (scanner.hasNext()){
            n=scanner.nextInt();
            k=scanner.nextInt();
            if (n+k==0){
                break;
            }
            Arrays.fill(color,false);
            for (int i=0;i<101;i++){
                for (int j=0;j<101;j++){
                    map[i][j]=0;
                }
            }
            for (int i=0;i<n;i++){
                for (int j=0;j<n;j++){
                    map[i][j]=scanner.nextInt();
                    color[map[i][j]]=true;
                }
            }
            totle=0;
            for (int i=1;i<=50;i++){
                if (color[i]){
                    if (km(i)>k){
                        ans[totle++]=i;
                    }
                }
            }
            if(totle==0){
                System.out.println("-1");
                continue;
            }
            Arrays.sort(ans,0,totle);

            for (int i=0;i<totle;i++){
                System.out.println(ans[i]);
            }
        }
    }

    private static int km(int co) {
        Arrays.fill(link,-1);
        int ans=0;
        for (int i=0;i<n;i++){
            Arrays.fill(vis,false);
            if (dfs(i,co)){
                ans++;
            }
        }
        return ans;
    }

    private static boolean dfs(int i, int co) {
        for (int j=0;j<n;j++){
            if (!vis[j]&&map[i][j]==co){
                vis[j]=true;
                if (link[j]==-1||dfs(link[j],co)){
                    link[j]=i;
                    return true;
                }
            }
        }
        return false;
    }
}
