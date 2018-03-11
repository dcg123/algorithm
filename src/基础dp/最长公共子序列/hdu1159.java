package 基础dp.最长公共子序列;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by user on 2017/10/15.
 */
public class hdu1159 {
//    #include <stdio.h>
//#include <string.h>
//#include <stdlib.h>
//#include <math.h>
//
//
//    char str1[1005],str2[1005];
//
//    int dp[1005][1005];
//
//    int max(int a,int b)
//    {
//        return a>=b?a:b;
//    }
//
//    int main()
//    {
//        str1[0]='#';//天那,为什么不加这个不行呢?
//        str2[0]='#';//以前也看到过,别人加这个东西,还以为不是那么重要的,但是这次不加会错,我就彻底悔悟了
//        while(scanf("%s%s",str1+1,str2+1)!=EOF)
//        {
//            int n=strlen(str1)-1;
//            int m=strlen(str2)-1;
//            for(int i=0;i<=n;i++)
//                dp[i][0]=0;
//            for(int j=0;j<=m;j++)
//                dp[0][j]=0;
//            int t=-1;
//            for(i=1;i<=n;i++)
//            {
//                for(j=1;j<=m;j++)
//                {
//                    if(str1[i]==str2[j])
//                        dp[i][j]=dp[i-1][j-1]+1;
//                    else
//                        dp[i][j]=max(dp[i-1][j],dp[i][j-1]);
//                    if(t<dp[i][j])
//                        t=dp[i][j];
//                }
//            }
//            printf("%d\n",t);
//        }
//        return 0;
//    }


}
