package 基础dp;

/**
 * Created by user on 2017/10/17.
 */
public class hdu1284 {
    /**
     * 思路：只有3个硬币，范围是32768，可以一个一个枚举硬币，如果只放价值为1的硬币，从d[1]递推到d[n]；如果再加上价值为2的硬币，那么就从d[2]递推到d[n]；在加上价值为3的硬币，就从d[3]递推到d[n].递推公式是d[j] = d[j] + d[j-i]； d[j]表示j有几种只用1，2, 3这三个数字的拆分方法，i 就是硬币的价值
     */
//    #include<stdio.h>
//#include<math.h>
//#include<string.h>
//
//    int dp[32800];
//
//    int main()
//    {
//        int n,i,j;
//        memset(dp,0,sizeof(dp));
//        dp[0]=1;
//        for(i=1;i<=3;i++)
//        {
//            for(j=i;j<=32770;j++)
//            {
//                dp[j]+=dp[j-i];
//            }
//        }
//        while(scanf("%d",&n)==1)
//        {
//            printf("%d\n",dp[n]);
//        }
//        return 0;
//    }

}
