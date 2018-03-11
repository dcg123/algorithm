package 动态规划;

import java.util.Scanner;

/**
 * Created by user on 2017/10/8.
 */
public class Main1204 {
    /**
     * dp[i][0]表示不用魔法到达的最少时间
     * dp[i][1]表示用魔法到达的最少时间
     * 因为施魔法不能连续
     * 所以
     * dp[i][1]=min(dp[i-1][0],dp[i-2][0]);
     * dp[i][0]=min(dp[i-1][0],dp[i-1][1])+h[i];
     * @param args
     */
    static int h[]=new int[10000+10];
    static int dp[][]=new int[10000+10][2];
    static int INF= 0x3f3f3f3f;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n;
        while (scanner.hasNext()){
            n=scanner.nextInt();
            for (int i=1;i<=n;i++) h[i]=scanner.nextInt();
            for (int i=0;i<10000+10;i++){
                for (int j=0;j<2;j++){
                    dp[i][j]=INF;
                }
            }
            dp[0][0]=dp[0][1]=0;
            for (int i=1;i<=n;i++)
            {
                dp[i][0]=Math.min(dp[i-1][0],dp[i-1][1])+h[i];
                dp[i][1]=Math.min(dp[i][1],dp[i-1][0]);
                if (i<=1) continue;
                dp[i][1]=Math.min(dp[i][1],dp[i-2][0]);
            }
            System.out.printf("%d\n",Math.min(dp[n][0],dp[n][1]));
        }
    }
}
