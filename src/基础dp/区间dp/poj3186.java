package 基础dp.区间dp;

/**
 * Created by user on 2017/10/15.
 */
public class poj3186 {
    /**
     * 题意：给出的一系列的数字，可以看成一个双向队列，每次只能从队首或者队尾出队，第n个出队就拿这个数乘以n，最后将和加起来，求最大和
     思路：由里向外逆推区间

     状态：
     d[i][j]表示第i个到第j个的最大值
     状态转移方程：
     d[i][j]=max(d[i+1][j]+a[i]*(n+i-j),d[i][j-1]+a[j]*(n+i-j))
     为了满足无后效性i逆序循环
     */

//    #include<stdio.h>
//#define max(a,b) ((a)>(b)?(a):(b))
//
//    int dp[2002][2002];
//    int main()
//    {
//        int n,i,j,a[2002];
//        scanf("%d",&n);
//        for(i=1;i<=n;i++)
//            scanf("%d",a+i);
//        for(i=n;i>0;i--)//关键：倒着循环
//            for(j=i;j<=n;j++)
//                dp[i][j]=max(dp[i+1][j]+a[i]*(n+i-j),dp[i][j-1]+a[j]*(n+i-j));
//        printf("%d/n",dp[1][n]);
//    }

}
