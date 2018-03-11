package 基础dp;

/**
 * Created by user on 2017/10/15.
 */
public class poj3666 {
//    /***********************************
//     DP题都做了十几条了，这个转移方程还是
//     没写出来，感觉自己真的好弱啊。。。
//
//     对于前i个数，我们需要关心的有两个值
//     1.把它变成单调序列需要的土，越少越好
//     2.第i个数的大小，越小越好
//
//     于是dp[i][j]表示考虑前i个数，第i个数
//     是j时，至少需要的土
//
//     第i个数是j时最少需要的土，就等于j和
//     a[i]差的绝对值+ 第i-1个数小于等于j时
//     至少需要土的最小值
//
//     即转移方程为：
//     dp[i][j]=abs(j-a[i])+min(dp[i-1][k])
//     k <= j
//
//     到这里问题就基本解决了。但是因为a[i]
//     的范围太大了，这样枚举k时就会TLE。这
//     里需要离散化优化
//
//     搞一个数组b，将a中的元素复制进去，然
//     后排序。
//     对于每个ij转移时，只要检查b中小于j的
//     元素就可以了
//
//     或者可以进一步省去遍历过程
//     对于dp[i-1][j]，维护一个最小值
//     每次直接加最小值就可以了
//     ***********************************/
//#include<cstdio>
//#include<iostream>
//#include<algorithm>
//
//    using namespace std;
//
//const int maxn = 2010;
//    long long inf = 2147483646;
//    long long dp [maxn][maxn];
//    int a [maxn], b [maxn];
//    int n;
//
//    int main ()
//    {
//        scanf("%d", &n);
//        for(int i= 1; i<= n; i++){
//            scanf("%d", a+i);
//            b[i] = a[i];
//        }
//        sort(b+1, b+n+1);
//
//        for(int i= 1; i<= n; i++){
//		long long m = dp[i-1][1];
//
//            for(int j= 1; j<= n; j++){
//                m = min(m, dp[i-1][j]);
//                dp[i][j] = abs(a[i] - b[j]) + m;
//            }
//        }
//
//	long long ans = inf;
//        for(int i= 1; i<= n; i++)
//            ans = min(ans, dp[n][i]);
//
//        printf("%lld\n", ans);
//
//        return 0;
//    }

}
