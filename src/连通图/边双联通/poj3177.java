package 连通图.边双联通;

/**
 * Created by user on 2017/10/14.
 */
public class poj3177 {
    /**
     * 题意：就是加入最少的边使之成双联通图
     一个有桥的联通图要变成双联通图的化，先把双联通子图缩点处理，使之成为树（无环）
     找出树的叶子节点（入度为1）加边的数为(leaf+1)/2;

     为了保护放牧环境，避免牲畜过度啃咬同一个地方的草皮，
     牧场主决定利用不断迁移牲畜进行喂养的方法去保护牧草。然而牲畜在迁移过程中也会啃食路上的牧草，
     所以如果每次迁移都用同一条道路，那么该条道路同样会被啃咬过度而遭受破坏。

     现在牧场主拥有F个农场，已知这些农场至少有一条路径连接起来（不一定是直接相连），
     但从某些农场去另外一些农场，至少有一条路可通行。为了保护道路上的牧草，
     农场主希望再建造若干条道路，使得每次迁移牲畜时，至少有2种迁移途径，避免重复走上次迁移的道路。
     已知当前有的R条道路，问农场主至少要新建造几条道路，才能满足要求？

     无向图变为双联通分量（不存在割点和桥）（两个点中有两天不重复路径）
     */
//    #include <iostream>
//#include <cstdlib>
//#include <cstdio>
//#include <algorithm>
//#include <vector>
//#include <queue>
//#include <cmath>
//#include <stack>
//#include <cstring>
//    usingnamespace std;
//#define INF 0xfffffff
//            #define maxn 10025
//            #define min(a,b) (a<b?a:b)
//    int m, n, Time, cnt, top;
//    int dfn[maxn], block[maxn], low[maxn], Father[maxn], Stack[maxn];
//    vector<int> G[maxn];
//    void init()
//    {
//        memset(dfn, 0, sizeof(dfn));
//        memset(low, 0, sizeof(low));
//        memset(block, 0, sizeof(block));
//        memset(Father, 0, sizeof(Father));
//        top = Time = cnt = 0;
//
//        for(int i=0; i<=n; i++)
//            G[i].clear();
//    }
//    void Tarjan(int u,int fa)
//    {
//        dfn[u] = low[u] = ++Time;
//        Father[u] = fa;
//        Stack[top++] = u;
//        int len = G[u].size(), v, k = 0;
//
//        for(int i=0; i<len; i++)
//        {
//            v = G[u][i];
//            if(v == fa && !k)
//            {
//                k ++;
//                continue;
//            }
//
//            if(!low[v])
//            {
//                Tarjan(v, u);
//                low[u] = min(low[u], low[v]);
//            }
//            else
//                low[u] = min(low[u], dfn[v]);
//        }
//
//        if(dfn[u] == low[u])
//        {
//            do
//            {
//                v = Stack[--top];
//                block[v] = cnt;
//            }while(u != v);
//            cnt ++;
//        }
//    }
//
//    void solve()
//    {
//        int i, degree[maxn] = {0}, ans = 0;
//        for(i=1; i<=n; i++)
//        {
//            if( !low[i] )
//                Tarjan(i, i);
//        }
//
//        for(i=1; i<=n; i++)
//        {
//            int v = Father[i];
//            if(block[i] != block[v])
//            {
//                degree[block[i] ] ++;
//                degree[block[v] ] ++;
//            }
//        }
//
//        for(i=0; i<cnt; i++)
//        {
//            if(degree[i] == 1)
//                ans ++;
//        }
//        printf("%d\n", (ans+1)/2 );
//    }
//
//
//    int main()
//    {
//        while(scanf("%d %d",&n, &m) != EOF)
//        {
//            init();
//            while(m --)
//            {
//                int a, b;
//                scanf("%d %d",&a, &b);
//                G[a].push_back(b);
//                G[b].push_back(a);
//            }
//            solve();
//        }
//        return0;
//    }

}
