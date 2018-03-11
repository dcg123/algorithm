package 基础dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by user on 2017/10/15.
 */
public class hdu1087 {
    //求最大上升子端和
    static int dp[]=new int[1000+10];
    static int s[]=new int[1000+10];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n;
        while(scanner.hasNext()){
            n=scanner.nextInt();
            if (n==0){
                break;
            }
            for(int i=0;i<n;++i){
                s[i]=scanner.nextInt();
            }
            dp[0]=s[0];
            int Max=dp[0];
            for(int i=1;i<n;++i){
                int sum=s[i];
                for(int j=0;j<i;++j){
                    if(s[i]>s[j])sum=Math.max(sum,dp[j]+s[i]);
                }
                dp[i]=sum;
                Max=Math.max(Max,dp[i]);
            }
            System.out.println(Max);
        }
    }
}
