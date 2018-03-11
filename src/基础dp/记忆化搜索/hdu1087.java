package 基础dp.记忆化搜索;

import java.util.Scanner;

/**
 * Created by user on 2017/10/15.
 */
public class hdu1087 {
    /**
     * 这是一道DP+搜索的题目，是很典型也是很好的题目。文章的大意是：
     * FatMouse在一个N*N方格上找吃的，每一个点（x，y）上有一些吃的，
     * FatMouse从（0,0）的位置出发去找吃的，并且每次最多走k步，
     * 在他走过的地方就可以吃掉吃的，保证吃的数量在0-100之间，
     * 而规定是他只能水平或者垂直走，而且每走一步，
     * 下一步的吃的数量是需要大于此刻所占的位置，
     * 问FatMouse最后最多可以吃多少吃的。那么因为他是可以在水平和垂直上面随便走的，
     * 所以这个DP就没有一定的方向性和子局面可以确定
     * ，所以只用DP是不好做出来的，这类采用DP+搜索的方法。
     */
    static int N=100+10;
    static int a[][]=new int[N][N];
    static int dp[][]=new int[N][N];
    static int n,k;
    static int to[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            n=scanner.nextInt();
            k=scanner.nextInt();
            if (n==-1&&k==-1){
                break;
            }
            for (int i=0;i<=n;i++){
                for (int j=0;j<=n;j++){
                    dp[i][j]=0;
                }
            }
            for (int i=0;i<n;i++){
                for (int j=0;j<n;j++){
                    a[i][j]=scanner.nextInt();
                }
            }
            int ans=dfs(0,0);
            System.out.println(ans);
        }
    }

    private static int dfs(int x, int y) {
        int max=0;
        if (dp[x][y]>0){
            return dp[x][y];
        }
        for (int i=0;i<4;i++){
            for (int j=1;j<=k;j++){
                int dx=x+to[i][0]*j;
                int dy=y+to[i][1]*j;
                if (dx>=0&&dx<n&&dy>=0&&dy<n&&a[dx][dy]>a[x][y]){
                    int temp=dfs(dx,dy);
                    if (max<temp){
                        max=temp;
                    }
                }
            }
        }
        dp[x][y]=max+a[x][y];
        return dp[x][y];
    }
}
