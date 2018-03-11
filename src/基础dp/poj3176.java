package 基础dp;
        import java.util.Arrays;
        import java.util.Scanner;

/**
 * Created by user on 2017/8/11.
 */
public class poj3176 {
    /**
     * 题目大意：

     　　　　输入一个n层的三角形，第i层有i个数，求从第1层到第n层的所有路线中，权值之和最大的路线。

     　　　　规定：第i层的某个数只能连线走到第i+1层中与它位置相邻的两个数中的一个。

     解题思路：

     　　　　动态规划。

     　　　　dp[i][j]=max(dp[i-1][j],dp[i-1][j-1]+data[i][j]

     　　　　因为dp数组的值只与上一行有关，用滚动数组优化了一下。（直接开成一维的了。。。）
     */
    static int MAX_N=100+5;
    static int map[][]=new int[MAX_N][MAX_N];
    static int n;
    static int dp[][]=new int[MAX_N][MAX_N];
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        for(int i=1;i<=n;i++){
            for (int j=1;j<=i;j++){
                map[i][j]=scanner.nextInt();
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                dp[i][j]=map[i][j]+Math.max(dp[i-1][j],dp[i-1][j-1]);
            }
        }
        int ans=dp[n][1];
        for(int i=1;i<=n;i++){
            if(ans<dp[n][i]){
                ans=dp[n][i];
            }
        }
        System.out.println(ans);
    }
}
