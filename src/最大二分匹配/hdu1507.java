package 最大二分匹配;

import java.util.Scanner;
import java.util.Vector;

/**
 * Created by user on 2017/10/12.
 */
public class hdu1507 {
    /**
     * //感觉比较不错的一道题，二分匹配的题目，很多时候是需要将题目中的信息提取出来然后找到可以匹配的两个集合，这两个集合需要满足的条件是，集合自身元素没有关联性，所以这道题目的两个集合可以设定为横纵坐标之和为奇数的集合和横纵坐标之和为偶数的集合，然后建图，一个点只能与之上下左右的点相连，所以只需考虑这四个方向就可以了。邻接表可能更高效一点，但是由于这道题只用存储上下左右四个位置，所以向量容器效率也还可以。有时候根据题目无法找到两个集合，这种题目一般考察的都是最小路径覆盖问题，但是必须保证整个图是有向图或者元素之间只有单向的关系。
     #include<stdio.h>
     #include<vector>
     using namespace std;
     #define M 10005
     vector<int> g[M];
     int match[M],v[M],map[M];
     int d[4][2]={-1,0,1,0,0,-1,0,1};
     int dfs(int k)
     {
     int i,t;
     for(i=0;i<g[k].size();i++)
     {
     t=g[k][i];
     if(v[t])continue;
     v[t]=1;
     if(match[t]==-1||dfs(match[t]))
     {
     match[t]=k;
     return 1;
     }
     }
     return 0;
     }
     int main()
     {
     int n,m,t,a,b,num,i,j,k;
     while(scanf("%d%d",&n,&m)!=-1,n!=0&&m!=0)
     {
     memset(map,0,sizeof(map));
     memset(g,0,sizeof(g));
     scanf("%d",&num);
     for(i=0;i<num;i++)
     {
     scanf("%d%d",&a,&b);
     map[(a-1)*m+b]=1;
     }
     int xx,yy;
     for(i=1;i<=n;i++)
     {
     for(j=1;j<=m;j++)
     {
     if(!map[(i-1)*m+j]&&((i+j)%2))
     {
     for(k=0;k<4;k++)
     {
     xx=i+d[k][0];
     yy=j+d[k][1];
     if(xx>=1&&xx<=n&&yy>=1&&yy<=m&&map[(xx-1)*m+yy]==0)
     g[(i-1)*m+j].push_back((xx-1)*m+yy);
     }
     }
     }
     }
     int ans=0;
     memset(match,-1,sizeof(match));
     for(i=1;i<=n*m;i++)
     {
     memset(v,0,sizeof(v));
     ans+=dfs(i);
     }
     int x1,y1,x2,y2;
     printf("%d\n",ans);
     for(i=1;i<=n*m;i++)
     {
     if(match[i]!=-1)
     {
     if(!(match[i]%m))
     {
     x1=match[i]/m;
     y1=m;
     }
     else {
     x1=match[i]/m+1;
     y1=match[i]%m;
     }
     if(!(i%m))
     {
     x2=i/m;
     y2=m;
     }
     else{
     x2=i/m+1;
     y2=i%m;
     }
     printf("(%d,%d)--(%d,%d)\n",x1,y1,x2,y2);
     }
     }
     printf("\n");
     }
     return 0;
     }
     */
}
