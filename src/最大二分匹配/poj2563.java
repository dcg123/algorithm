package 最大二分匹配;

/**
 * Created by user on 2017/10/19.
 */
public class poj2563 {
    /**
     * 题意：
     n只地鼠，m个洞，老鹰的到达地面的时间s，地鼠的移动速度v，求多少只地鼠会被老鹰吃了。
     思路：
     地鼠和洞看成两集合，建立二分图。只有当地鼠到洞的时间少于老鹰到地面的时间才连边。
     */
//    #include <cmath>
//#include <cstdio>
//#include <cstring>
//#include <iostream>
//
//    using namespace std;
//    int n,m,s,v,mmap[500][500],vis[500],pre[500];
//    struct point
//    {
//        double x,y;
//    }G[200],H[200];
//    double dis(point p1,point p2)
//    {
//        return  sqrt((p2.x-p1.x)*(p2.x-p1.x)+(p2.y-p1.y)*(p2.y-p1.y));
//    }
//    int dfs(int x)
//    {
//        for(int i=n+1;i<=n+m;i++){
//            if(!vis[i]&&mmap[x][i]){
//                vis[i]=1;
//                if(pre[i]==-1||dfs(pre[i])){
//                    pre[i]=x;
//                    return 1;
//                }
//            }
//        }
//        return 0;
//    }
//    int main()
//    {
//        //std::ios::sync_with_stdio(false);
//        int i,j,a,b,t;
//        while(~scanf("%d%d%d%d",&n,&m,&s,&v)){
//        memset(pre,-1,sizeof(pre));
//        memset(mmap,0,sizeof(mmap));
//        for(i=1;i<=n;i++){
//            scanf("%lf%lf",&G[i].x,&G[i].y);
//        }
//        for(i=1;i<=m;i++){
//            scanf("%lf%lf",&H[i].x,&H[i].y);
//        }
//        for(i=1;i<=n;i++){
//            for(j=1;j<=m;j++){
//                double d=dis(G[i],H[j]);
//                if(d/v<=(double)s){
//                    mmap[i][n+j]=1;
//                }
//            }
//        }
//        int ans=0;
//        for(i=1;i<=n;i++){
//            memset(vis,0,sizeof(vis));
//            ans+=dfs(i);
//        }
//        printf("%d\n",n-ans);
//    }
//        return 0;
//    }

}
