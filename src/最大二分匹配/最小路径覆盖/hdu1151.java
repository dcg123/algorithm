package 最大二分匹配.最小路径覆盖;

/**
 * Created by user on 2017/10/12.
 */
public class hdu1151 {
    /**
     * 题目的意思就是：
     一个=城镇中有n个路口和m条单项的路径，图是无环图，现在要派一些伞兵去这些成寿寺，要到达所有的路口；
     有一些或者没有伞兵可以不去那些路口，只要其他人能完成这么任务；
     每个在一个路口着陆了的伞兵可以沿着街去到其他路口；
     我们的任务就是求出去执行任务的伞兵最少可以使几个；

     这个问题是二分图的最小路径覆盖问题；
     而路径覆盖的定义就是：
     在有向图中找一些路径，使之覆盖了图中的所有顶点，就是任意一个顶点都跟那些路径中的某一条关联，且任何一个顶点
     有且只有一个与之关联；一个单独的顶点是一跳路径……最小路径覆盖就是最少的路径覆盖数。
     最小路径覆盖=图的顶点数-最大匹配数
     */
//    #include<cstdio>
//#include<string>
//#include<cstring>
//#include<cmath>
//#include<iostream>
//#include<algorithm>
//    using namespace std;
//    int map[121][121];
//    int link[121];
//    int vis[121];
//    int n,m;
//    int find(int k){
//        for(int i=1;i<=n;i++)
//            if(!vis[i]&&map[k][i]){
//                vis[i]=1;
//                if(link[i]==-1||find(link[i])){
//                    link[i]=k;
//                    return 1;
//                }
//            }
//        return 0;
//    }
//    int hug(){//最大匹配数
//        int ans=0;
//        memset(vis,0,sizeof(vis));
//        memset(link,-1,sizeof(link));
//        for(int i=1;i<=n;i++){
//            if(find(i))
//                ans++;
//        }
//        return ans;
//    }
//    int main(){
//        int u,v,t,ans;
//        scanf("%d",&t);
//        while(t--){
//            scanf("%d%d",&n,&m);
//            memset(map,0,sizeof(map));
//            for(int i=0;i<m;i++){
//                scanf("%d%d",&u,&v);
//                map[u][v]=1;
//            }
//            ans=n-hug();
//            printf("%d\n",ans);
//        }
//        return 0;
//    }

}
