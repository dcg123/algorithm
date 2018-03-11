package 连通图.并查集tra;

/**
 * Created by user on 2017/10/14.
 */
public class poj3694 {
    /**
     * 题意：一个网络管理员管理一个网络，
     * 网络中的电脑直接或间接的相连接，管理员有Q次操作
     * ，每次向网络中建立一条新边，向管理员报告桥的个数。

     思路：先将网络中的桥求出来，在求的过程中进行并查集缩点，
     在询问的时候，进行最朴素的LCA查找最近公共祖先，
     在求的过程中判断节点与父节点是不是在同一个集合中，
     如果不在同一个集合，说明是桥，则这个桥将不存在，
     将两个集合合并。
     */
//    #include <cstdio>
//#include <cstring>
//#include <cstdlib>
//#include <cmath>
//#include <queue>
//#include <algorithm>
//
//    using namespace std;
//
//const int INF = 0x3f3f3f3f;
//
//const int Max = 110000;
//
//    typedef struct Node
//    {
//        int v;
//
//        int next;
//    }Line;
//
//    Line Li[Max*4];
//
//    int Head[Max],top;
//
//    int dfn[Max],low[Max],vis[Max];
//
//    int pre[Max],fa[Max];
//
//    int num;
//
//    int n,m,Q;
//
//    void AddEdge(int u,int v)
//    {
//        Li[top].v = v; Li[top].next = Head[u];
//
//        Head[u] = top++;
//    }
//
//    int Find(int x)
//    {
//        return pre[x]==-1?x:pre[x]=Find(pre[x]);
//    }
//
//
//    void Union(int x,int y)
//    {
//        int Fx = Find(x);
//
//        int Fy = Find(y);
//
//        if(Fx!=Fy)
//        {
//            pre[Fx]=Fy;
//        }
//    }
//
//    void dfs(int fat,int u,int dep)
//    {
//        dfn[u]=low[u]=dep;
//
//        fa[u]=fat;
//
//        vis[u]  =  1;
//
//        for(int i=Head[u];i!=-1;i=Li[i].next)
//        {
//            if(Li[i].v!=fat&&vis[Li[i].v]==1)
//            {
//                low[u] = min(low[u],dfn[Li[i].v]);
//            }
//            if(vis[Li[i].v]==0)
//            {
//                dfs(u,Li[i].v,dep+1);
//
//                low[u] = min(low[u],low[Li[i].v]);
//
//                if(low[Li[i].v]<=dfn[u])//并查集缩点
//                {
//                    Union(Li[i].v,u);
//                }
//                else
//                {
//                    num++;
//                }
//            }
//        }
//        vis[u]=2;
//    }
//
//    void Judge(int u)
//    {
//        int x=Find(u);
//
//        int y=Find(fa[u]);
//
//        if(x!=y)//同一集合，则集合合并
//        {
//            num--;
//            pre[x]=y;
//        }
//    }
//
//    void LCA(int u,int v)//找公共祖先
//    {
//        while(dfn[u]>dfn[v])
//        {
//            Judge(u);
//
//            u=fa[u];
//        }
//        while(dfn[v]>dfn[u])
//        {
//            Judge(v);
//            v=fa[v];
//        }
//
//        while(u!=v)
//        {
//            Judge(u);
//            Judge(v);
//            u = fa[u];
//            v = fa[v];
//        }
//    }
//    int main()
//    {
//
//        int z=1;
//        while(~scanf("%d %d",&n,&m)&&(n+m))
//        {
//            top = 0;
//
//            memset(Head,-1,sizeof(Head));
//
//            int u,v;
//
//            for(int i=0;i<m;i++)
//            {
//                scanf("%d %d",&u,&v);
//
//                AddEdge(u,v);
//
//                AddEdge(v,u);
//            }
//
//            num = 0 ;
//
//            memset(vis,0,sizeof(vis));
//
//            memset(pre,-1,sizeof(pre));
//
//            dfs(0,1,1);
//
//            scanf("%d",&Q);
//
//            printf("Case %d:\n",z++);
//
//            while(Q--)
//            {
//                scanf("%d %d",&u,&v);
//
//                if(Find(u)!=Find(v))
//                {
//                    LCA(u,v);
//                }
//
//                printf("%d\n",num);
//            }
//
//            printf("\n");
//        }
//
//        return 0;
//    }
}
