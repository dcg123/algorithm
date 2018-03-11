package 基础dp.最长上升子序列;

import java.util.Scanner;

/**
 * Created by user on 2017/10/15.
 */
public class poj2533 {
    static int N=1000+10;
    static int dp[]=new int[N];
    static int a[]=new int[N];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        for (int i=1;i<=n;i++){
            a[i]=scanner.nextInt();
            dp[i]=1;
        }
        for (int i=1;i<=n;i++){
            for (int j=1;j<i;j++){
                if (a[j]<a[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int sum=0;
        for (int i=1;i<=n;i++){
            if (dp[i]>sum){
                sum=dp[i];
            }
        }
        System.out.println(sum);
    }
}
