package 基础dp.坐标dp;

/**
 * Created by user on 2017/10/17.
 */
public class hdu1208 {
    /**
     * 起点在左上角，终点在右下角，而每一次走的步伐树只能等于该点的数值，值得注意的是0为死胡同。
     */
//    #include <stdio.h>
//#include <string.h>
//#include <algorithm>
//    using namespace std;
//
//    int n,i,j,k;
//    __int64 dp[40][40];
//    int map[40][40];
//    char s[40];
//
//    int main()
//    {
//        while(~scanf("%d",&n),n+1)
//        {
//            for(i = 0; i<n; i++)
//            {
//                scanf("%s",s);
//                for(j = 0; j<n; j++)
//                {
//                    map[i][j] = s[j]-'0';
//                }
//            }
//            memset(dp,0,sizeof(dp));
//            dp[0][0] = 1;
//            for(i = 0; i<n; i++)
//            {
//                for(j = 0; j<n; j++)
//                {
//                    if(!map[i][j] || !dp[i][j])
//                        continue;
//                    if(i+map[i][j]<n)//不越界
//                        dp[i+map[i][j]][j]+=dp[i][j];
//                    if(j+map[i][j]<n)
//                        dp[i][j+map[i][j]]+=dp[i][j];
//                }
//            }
//            printf("%I64d\n",dp[n-1][n-1]);
//        }
//        return 0;
//    }

}
