package LCA;

/**
 * Created by user on 2017/10/18.
 */
public class LCA修改点权值排序 {
    /**
     * hdu3078
     * LCA + 修改点权值 + 排序：每个点有初始的权值，
     * 一边查询一边伴随着修改某些点的权值，查询是从a到b路径中第k大的权值是多少。
     * 不需要太多的技巧，修改操作就直接修改，
     * 查询操作先求LCA，然后从a走到b保存下所有的权值，排序，然后直接输出即可
     */
//    #include<iostream>
//#include<cstdio>
//#include<cstring>
//#include<vector>
//#include<cmath>
//#include<queue>
//#include<stack>
//#include<map>
//#include<set>
//#include<algorithm>
//    using namespace std;
//const int maxn=80010;
//    int pre[maxn],E[maxn*2],dep[maxn*2],pos[maxn],vis[maxn];
//    int d[maxn*2][30],val[maxn],num,path[maxn];
//    int N,Q;
//    vector<int> g[maxn];
//
//    void init()
//    {
//        for(int i=0;i<=N;i++)g[i].clear();
//        num=0;
//        memset(pos,-1,sizeof(pos));
//        memset(vis,0,sizeof(vis));
//    }
//
//    void dfs(int u,int depth)
//    {
//        E[++num]=u,dep[num]=depth;
//        if(pos[u]==-1)pos[u]=num;
//        vis[u]=1;
//        int len=g[u].size();
//        for(int i=0;i<len;i++)
//        {
//            int v=g[u][i];
//            if(vis[v])continue;
//            pre[v]=u;
//            dfs(v,depth+1);
//            E[++num]=u,dep[num]=depth;
//        }
//    }
//
//    void initRMQ(int n)
//    {
//        for(int i=0;i<=n;i++)d[i][0]=i;
//        for(int j=1;(1<<j)<=n;j++)
//            for(int i=1;i+(1<<j)<=n;i++)
//            {
//                int x=d[i][j-1],y=d[i+(1<<(j-1))][j-1];
//                if(dep[x]<dep[y])d[i][j]=x;
//                else d[i][j]=y;
//            }
//    }
//
//    int LCA(int u,int v)
//    {
//        int x=pos[u],y=pos[v];
//        if(x>y)swap(x,y);
//        int k=0;
//        while((1<<(k+1))<=y-x+1)k++;
//        int a=d[x][k],b=d[y-(1<<k)+1][k];
//        if(dep[a]<dep[b])return E[a];
//        else return E[b];
//    }
//
//    void solve(int k,int u,int v)
//    {
//        int fa=LCA(u,v);
//        int cnt=0;
//        while(u!=fa){path[cnt++]=val[u];u=pre[u];}
//        while(v!=fa){path[cnt++]=val[v];v=pre[v];}
//        path[cnt++]=val[fa];
//        sort(path,path+cnt,greater<int>());
//        if(cnt<k)printf("invalid request!\n");
//        else printf("%d\n",path[k-1]);
//    }
//
//    int main()
//    {
//        while(scanf("%d%d",&N,&Q)!=EOF)
//        {
//            for(int i=1;i<=N;i++)scanf("%d",&val[i]);
//            init();
//            for(int i=1;i<N;i++)
//            {
//                int u,v;
//                scanf("%d%d",&u,&v);
//                g[u].push_back(v);
//                g[v].push_back(u);
//            }
//            dfs(1,1);
//            initRMQ(num);
//            while(Q--)
//            {
//                int k,a,b;
//                scanf("%d%d%d",&k,&a,&b);
//                if(!k)val[a]=b;
//                else solve(k,a,b);
//            }
//        }
//        return 0;
//    }

}
