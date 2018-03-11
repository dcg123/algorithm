package 图论.最短路.双tsp;

/**
 * Created by user on 2017/10/13.
 */
public class hdu2224 {
//    *
//    题意：平面上n个点，确定一条连接各点的最短闭合旅程且每个点仅用一次。
// 这个解的一般形式为NP的（在多项式时间内可以求出）
//    建议通过只考虑双调旅程(bitonictour)来简化问题,这种旅程即为从最左点开始，
// 严格地从左到右直至最右点，然后严格地从右到左直至出发点。每个点都要走一次，
// 且每个点只能走一次，求最短路径；
//    相当于一个人从一个点出发分两条不同的路线走，不过一个走在前面一个在后面走。
//    设dp[i][j]代表起始点到i的距离+起始点到j的距离，中间没有交叉点，且没有遗漏点(dp[i][j]=dp[j][i])；
//    当i<j-1的时候，dp[i][j]是从dp[i][j-1]传递过去的，即dp[i][j]=dp[i][j-1]+dis[j-1][j];
//    当i=j-1的时候，dp[i][j]是由dp[i][k]+dis[k][j]得到的，即dp[i][j]=min(dp[i][j],dp[i][k]+dis[k][j]);
//*/
//        #include<stdio.h>
//#include<stdlib.h>
//#include<math.h>
//#include<string.h>
//#define inf 0x3fffffff
//            #define N  300
//    struct node {
//        int x,y;
//    }f[N];
//    int cmp(const void *a,const void *b) {
//        return (*(struct node *)a).x-(*(struct node *)b).x;
//    }
//    double dp[N][N],dis[N][N];
//    double L(int x,int y) {
//        return sqrt(1.0*(f[x].x-f[y].x)*(f[x].x-f[y].x)+1.0*(f[x].y-f[y].y)*(f[x].y-f[y].y));
//    }
//    double Min(double a,double b) {
//        return a>b?b:a;
//    }
//    int main() {
//        int n,i,j,k;
//        while(scanf("%d",&n)!=EOF) {
//            for(i=1;i<=n;i++)
//                scanf("%d%d",&f[i].x,&f[i].y);
//            qsort(f+1,n,sizeof(f[0]),cmp);
//            memset(dp,0,sizeof(dp));
//            for(i=1;i<n;i++)
//                for(j=i+1;j<=n;j++)
//                    dis[i][j]=dis[j][i]=L(i,j);
//            dp[2][1]=dis[2][1];
//            for(i=2;i<n;i++) {
//                dp[i+1][i]=inf;
//                for(j=1;j<=i-1;j++) {
//                    dp[i+1][j]=dp[i][j]+dis[i][i+1];
//                    dp[i+1][i]=Min(dp[i+1][i],dp[i][j]+dis[j][i+1]);
//                }
//            }
//            //printf("%.2f\n",dp[n][n-1]);
//            dp[n][n]=dp[n][n-1]+dis[n-1][n];
//            printf("%.2f\n",dp[n][n]);
//        }
//        return 0;}

}
