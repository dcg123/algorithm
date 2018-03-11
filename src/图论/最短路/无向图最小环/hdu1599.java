package 图论.最短路.无向图最小环;

/**
 * Created by user on 2017/10/13.
 */
public class hdu1599 {
//    #include <set>
//#include <map>
//#include <queue>
//#include <stdio.h>
//#include <stdlib.h>
//#include <string.h>
//#include <iostream>
//#include <algorithm>
//    using namespace std;
//const long long INF=0x3f3f3f3f3f3f;
//    long long n,m;
//    long long s[105][105],ss[105][105];
//    void floyd(){
//    long long i,j,k,ans;
//        ans=INF;
//        for(i=1;i<=n;i++){
//            for(j=1;j<=n;j++){
//                for(k=1;k<=n;k++){
//                    if(j!=i&&k!=i&&j!=k)
//                        ans=min(ans,s[j][k]+ss[j][i]+ss[i][k]);
//                }                                   //没更新前的s[j][k]一定是不经过i点的
//            }                                       //所以这时再加上i点，满足是至少三个点
//            for(j=1;j<=n;j++)                       //的环，求出最小值
//                for(k=1;k<=n;k++)
//                    s[j][k]=min(s[j][k],s[j][i]+s[i][k]);
//        }
//        if(ans==INF)
//            puts("It's impossible.");
//        else
//            printf("%I64d\n",ans);
//    }
//    int main(){
//    long long i,j,u,v,w;
//        while(scanf("%I64d%I64d",&n,&m)!=EOF){
//            for(i=1;i<=n;i++)
//                for(j=1;j<=n;j++)
//                    s[i][j]=ss[i][j]=INF;
//            for(i=0;i<m;i++){
//                scanf("%I64d%I64d%I64d",&u,&v,&w);
//                s[u][v]=min(s[u][v],w);
//                s[v][u]=s[u][v];
//                ss[u][v]=ss[v][u]=s[u][v];
//            }
//            floyd();
//        }
//        return 0;
//    }

}
