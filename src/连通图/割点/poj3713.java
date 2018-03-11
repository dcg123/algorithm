package 连通图.割点;

/**
 * Created by user on 2017/10/16.
 */
public class poj3713 {
    /**
     * 题目大意
     给你一幅点数为n，边数为m的无向图，
     问图上任意两点之间是否存在至少三条的路径，
     如果任意两点间都有三条或者以上的路径数那么输出'YES'，否则输出'NO'。
     解题思路
     考虑一下不可行的情况，
     就是存在两点间的路径条数<3情况，那么我们可以去枚举两个点a和b
     ，然后将其和相邻的边删除，然后判断联通块个数，
     如果块数大于1则存在路径条数<3的情况，否则不存在，
     因为如果a和b是一个路径条数<3的点对的路径上的点，如果将其破坏了，
     这两个点必然不会再联通，因为不可行的情况路径条数最多为2，
     因此只需要枚举两个点。
     当然直接这样做很显然是有可能超时的，这里我们可以先枚举点a，
     再用tarjan算法判断无向图是否存在割点，如果存在割点，
     那么就说明不可行，否则可行。
     */
//    #include<stdio.h>
//#include<string.h>
//#include<vector>
//    using namespace std;
//const int MAX = 1010;
//    vector<int> edge[MAX];
//    int low[MAX],dfn[MAX];
//    int vis[MAX];
//    int n,m,tdfn;
//    bool flag=0;
//    int root;
//    inline int min(int a,int b){return a<b?a:b;}
//    void dfs(int u,int fa)
//    {
//        vis[u]=1;
//        dfn[u]=low[u]=++tdfn;
//        int tol=0,i,v;
//        for(i=0;i<edge[u].size();i++)
//        {
//            v=edge[u][i];
//            if(vis[v]==2)  continue;
//            if(vis[v]==0)
//            {
//                dfs(v,u);tol++;
//                low[u]=min(low[u],low[v]);
//                if(u==root&&tol>1||u!=root&&low[v]>=dfn[u])
//                {
//                    flag=true;//存在割点
//                    return ;
//                }
//            }
//            else if(vis[v]==1&&v!=fa)
//                low[u]=min(low[u],dfn[v]);
//        }
//        return ;
//    }
//    int main()
//    {
//        while(scanf("%d%d",&n,&m),n||m)
//        {
//            flag=0;
//            int i,j,a,b;
//            for(i=0;i<=n;i++)
//                edge[i].clear();
//            for(i=1;i<=m;i++)
//            {
//                scanf("%d%d",&a,&b);
//                edge[a].push_back(b);
//                edge[b].push_back(a);
//            }
//            for(i=0;i<n;i++)
//            {
//                memset(vis,0,sizeof(vis));
//                memset(dfn,0,sizeof(dfn));
//                memset(low,0,sizeof(low));
//                vis[i]=2;//去掉一个点
//                root=0;tdfn=0;
//                if(i==0) root=1;
//                dfs(root,-1);
//                for(j=0;j<n;j++)
//                {
//                    if(vis[j]==0)
//                    {
//                        flag=1;
//                        break;
//                    }
//                }
//                if(flag==1) break;
//            }
//            if(flag) printf("NO\n");
//            else printf("YES\n");
//        }
//        return 0;
//    }
}
