package 图论.最短路;

/**
 * Created by user on 2017/10/13.
 */
public class hdu1595 {
    /**
     * 题意：从1到n点如果切掉一条路，那么在最坏情况下的最短路是多少？？
     *
     * 题解：这个题开始的时候没想请，去枚举每一条边，然后超时。
     * 后来发现如果被堵死的路不是最短路中的某条，
     * 那么求的最短路肯定就还会是原来的最短路，
     * 所以我们只要枚举最短路中的每段路，
     * 然后再求最短路就行了。
     */
//    #include <stdio.h>
//#include <math.h>
//#include <iostream>
//#include <algorithm>
//#include <string.h>
//#include <stdlib.h>
//#include <queue>
//    using namespace std;
//const int N = 1005;
//const int M = 50005;
//const int INF = 999999999;
//    /*struct Node{
//        int u,v;
//    }node[M];*/
//    int graph[N][N];
//    bool vis[N];
//    int low[N];
//    int pre[N];
//    int n,m;
//    int dijkstra(int s,bool flag){
//        for(int i=1;i<=n;i++){
//            if(flag){
//                pre[i] = s;
//            }
//            low[i] = graph[s][i];
//            vis[i] = false;
//        }
//        vis[s] = true;
//        for(int i=1;i<n;i++){
//            int Min = INF;
//            for(int j=1;j<=n;j++){
//                if(low[j]<Min&&!vis[j]){
//                    Min = low[j];
//                    s = j;
//                }
//            }
//            vis[s] = true;
//            for(int j=1;j<=n;j++){
//                if(low[j]>low[s]+graph[s][j]&&!vis[j]){
//                    low[j] = low[s]+graph[s][j];
//                    if(flag){
//                        pre[j] = s;
//                    }
//                }
//            }
//        }
//        return low[n];
//    }
//    int main()
//    {
//        while(scanf("%d%d",&n,&m)!=EOF){
//        for(int i=1;i<=n;i++){
//            for(int j=1;j<=n;j++){
//                if(i==j) graph[i][j] = 0;
//                else graph[i][j] = INF;
//            }
//        }
//        for(int i=0;i<m;i++){
//            int u,v,w;
//            scanf("%d%d%d",&u,&v,&w);
//            graph[u][v]=graph[v][u] = min(w,graph[u][v]);
//            //scanf("%d%d%d",&node[i].u,&node[i].v,&w);
//            //graph[node[i].u][node[i].v]=graph[node[i].v][node[i].u] = min(w,graph[node[i].u][node[i].v]);
//        }
//        int res = dijkstra(1,1);
//        int Max = -1;
//        /*for(int i=0;i<m;i++){ ///枚举每一段TLE
//            int temp = graph[node[i].u][node[i].v];
//            graph[node[i].u][node[i].v]=graph[node[i].v][node[i].u] = INF;
//            int cost = dijkstra(1);
//            Max = max(cost,Max);
//            graph[node[i].u][node[i].v]=graph[node[i].v][node[i].u] = temp;
//        }*/
//        int temp = n;
//        while(temp!=1){
//            int k = graph[temp][pre[temp]];
//            graph[pre[temp]][temp] = graph[temp][pre[temp]] = INF;
//            int cost = dijkstra(1,0);
//            Max = max(cost,Max);
//            graph[pre[temp]][temp] = graph[temp][pre[temp]] =k;
//            temp = pre[temp];
//        }
//        printf("%d\n",Max);
//    }
//    }
}
