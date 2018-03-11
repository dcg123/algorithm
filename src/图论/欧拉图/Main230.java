package 图论.欧拉图;

/**
 * Created by user on 2017/10/7.
 */
public class Main230 {
//    #include<cstdio>
//#include<cstring>
//#include<cstdlib>
//#include<queue>
//#include<algorithm>
//#define INF 999999999
//            #define MAX 1010
//            #define MAX_STATUS 1<<6
//    using namespace std;
//
//    struct EDGE
//    {
//        int v ,w;
//        int next;
//    }edges[MAX*13];
//
//    struct NODE
//    {
//        int x ,y;
//    };
//
//    int head[MAX] ,cnt;
//
//    int n ,m ,p;
//    int value[MAX];
//
//    int status;//表示0~n号节点都被选择时的状态+1
//    int dis[MAX][MAX_STATUS] ,situation[MAX] ,vis[MAX][MAX_STATUS] ,dp;
//    //dis[i][j]表示以i节点为根选择点集状态为j时的最小值；situation[i]表示i节点对应的状态；vis[i][j]表示i节点为点集j时是否在队列中
//    queue<NODE> q;
//
//    void init()
//    {
//        memset(head,-1,sizeof(head));
//        memset(vis,0,sizeof(vis));
//        memset(situation,0,sizeof(situation));
//        cnt = 0;
//        status = 1<<(n + 1);
//        for(int i = 0;i <= n + m;i++)
//        {
//            for(int j = 0;j <= status;j++)
//            {
//                dis[i][j] = INF;
//            }
//        }
//        for(int i = 0;i <= n;i++)
//        {
//            situation[i] = 1<<i;
//            dis[i][situation[i]] = 0;
//        }
//    }
//
//    void add_edges(int u ,int v ,int w)
//    {
//        edges[cnt].v = v;
//        edges[cnt].w = w;
//        edges[cnt].next = head[u];
//        head[u] = cnt;
//        cnt++;
//
//        edges[cnt].v = u;
//        edges[cnt].w = w;
//        edges[cnt].next = head[v];
//        head[v] = cnt;
//        cnt++;
//    }
//
//    void SPFA()
//    {
//        NODE temp ,newd;
//        while(!q.empty())
//        {
//            temp = q.front();
//            q.pop();
//            vis[temp.x][temp.y] = 0;
//            for(int i = head[temp.x];i!=-1;i = edges[i].next)
//            {
//                int v ,situ;
//                v = edges[i].v;
//                situ = temp.y | situation[v];
//                if(dis[temp.x][temp.y] + edges[i].w < dis[v][situ])
//                {
//                    dis[v][situ] = dis[temp.x][temp.y] + edges[i].w;
//                    if(situ==temp.y && !vis[v][situ])
//                    {
//                        newd.x = v;
//                        newd.y = situ;
//                        q.push(newd);
//                        vis[v][situ] = 1;
//                    }
//                }
//            }
//        }
//    }
//
//    void Steiner_Tree()
//    {
//        NODE  temp;
//        for(int i = 0;i < status;i++)
//        {
//            for(int j = 0;j <= n + m;j++)
//            {
//                for(int k = i;k;k = (k - 1) & i)
//                {
//                    dis[j][i] = min(dis[j][i],dis[j][k|situation[j]]+dis[j][(i-k)|situation[j]]);
//                }
//                if(dis[j][i]!=INF)
//                {
//                    temp.x = j;
//                    temp.y = i;
//                    q.push(temp);
//                    vis[j][i] = 1;
//                }
//            }
//            SPFA();
//        }
//    }
//
//    int DP()
//    {
//        dp = INF;
//        for(int j = 0;j <= n+m;j++)
//        {
//            dp = min(dp,dis[j][status-1]);
//        }
//        return dp;
//    }
//
//    int main()
//    {
//        int u ,v ,w;
//        while(~scanf("%d%d%d",&n,&m,&p))
//        {
//            init();
//            for(int i = 1;i <= m + n;i++)
//            {
//                scanf("%d",&value[i]);
//                add_edges(0,i,value[i]);
//            }
//            for(int i = 0;i < p;i++)
//            {
//                scanf("%d%d%d",&u,&v,&w);
//                add_edges(u,v,w);
//            }
//            Steiner_Tree();
//            printf("%d\n",DP());
//        }
//        return 0;
//    }
}
