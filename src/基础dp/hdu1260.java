package 基础dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by user on 2017/10/15.
 */
public class hdu1260 {
    static int N=2000+10;
    static int dp[]=new int[N];
    static int a[]=new int[N];
    static int b[]=new int[N/2+100];
    static int k;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int s=scanner.nextInt();
        while (s-->0){
            k=scanner.nextInt();
            for (int i=1;i<=k;i++){
                a[i]=scanner.nextInt();
            }
            for (int i=2;i<=k;i++){
                b[i]=scanner.nextInt();
            }
            Arrays.fill(dp,0);
            dp[1]=a[1];
            dp[2]=Math.min(a[2]+a[1],b[2]);
            for (int i=3;i<=k;i++){
                dp[i]=Math.min(dp[i-1]+a[i],dp[i-2]+b[i]);
            }
            int t=dp[k];
            t+=8*3600;
            t%=(24*3600);
            if(t/3600<12) System.out.printf("%02d:%02d:%02d am\n",t/3600,t%3600/60,t%3600%60);
            else {
                t-=12*3600;
                System.out.printf("%02d:%02d:%02d pm\n",t/3600,t%3600/60,t%3600%60);
            }
        }
    }
}
