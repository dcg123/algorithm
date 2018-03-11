package 最大二分匹配.有向图最小路径覆盖;

/**
 * Created by user on 2017/10/19.
 */
public class poj1422 {
    /**
     * 题意：一个地图上有n个小镇，以及连接着其中两个小镇的有向边，
     * 而且这些边无法形成回路。现在选择一些小镇空降士兵（1个小镇最多1个士兵），
     * 士兵能沿着边走到尽头，问最少空降几个士兵，能遍历完所有的小镇。
     思路：匈牙利算法求最小路径覆盖：在一个有向图中，路径覆盖就是在图中找一些路径，
     使之覆盖了图中的所有顶点，且任何一个顶点有且只有一条路径与之关联；（
     如果把这些路径中的每条路径从它的起始点走到它的终点，那么恰好可以经过图中的每个顶点一次且仅一次）；
     解决此类问题可以建立一个二分图模型。把所有顶点i拆成两个：Ｘ结点集中的i和Y结点集中的i',
     如果有边i->j，则在二分图中引入边i->j'，设二分图最大匹配为m,则结果就是n-m
     */
//    using namespace std;
//const int maxn=125;
//    int map[maxn][maxn],visit[maxn],match[maxn];
//    int n;
//    bool dfs(int v)
//    {
//        int i;
//        for(i=1;i<=n;i++)
//        {
//            if(map[v][i]&&!visit[i])
//            {
//                visit[i]=1;
//                if(match[i]==-1||dfs(match[i]))
//                {
//                    match[i]=v;
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    int hungry()
//    {
//        int i,ans=0;
//        memset(match,-1,sizeof(match));
//        for(i=1;i<=n;i++)
//        {
//            memset(visit,0,sizeof(visit));
//            if(dfs(i)) ans++;
//        }
//        return ans;
//    }
//
//
//    int main()
//    {
//        int i,t,j,a,b,ans,m;
//        scanf("%d",&t);
//        while(t--)
//        {
//            scanf("%d%d",&n,&m);
//            memset(map,0,sizeof(map));
//            for(i=0;i<m;i++)
//            {
//                scanf("%d%d",&a,&b);
//                map[a][b]=1;
//            }
//            ans=n-hungry();
//            printf("%d%\n",ans);
//        }
//        return 0;
//    }
}
