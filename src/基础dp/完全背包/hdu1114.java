package 基础dp.完全背包;

import java.util.Scanner;

/**
 * Created by user on 2017/10/15.
 */
public class hdu1114 {
    static int N=10005;
    static int INF=0x3f3f3f3f;
    static int dp[]=new int[N];
    static int weight[]=new int[N];
    static int cost[]=new int[N];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while (t-->0){
            int emp=scanner.nextInt();
            int fill=scanner.nextInt();
            int n=scanner.nextInt();
            for (int i=1;i<=n;i++){
                weight[i]=scanner.nextInt();
                cost[i]=scanner.nextInt();
            }
            int v=fill-emp;
            dp[0]=0;
            for (int i=1;i<=v;i++){
                dp[i]=INF;
            }
            for (int i=1;i<=n;i++){
                for (int j=cost[i];j<=v;j++){
                    dp[j]=Math.min(dp[j],dp[j-cost[i]]+weight[i]);
                }
            }
            if (dp[v]==INF){
                System.out.println("This is impossible.");
            }else {
                System.out.println("The minimum amount of money in the piggy-bank is "+dp[v]+".");
            }
        }
    }
}
