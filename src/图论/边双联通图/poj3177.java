package 图论.边双联通图;

/**
 * Created by user on 2017/10/19.
 */
public class poj3177 {
    /**
     * 题意：有n个牧场，Bessie 要从一个牧场到另一个牧场，要求至少要有2条独立的路可以走。
     * 现已有m条路，求至少要新建多少条路，使得任何两个牧场之间至少有两条独立的路。
     * 两条独立的路是指：没有公共边的路，但可以经过同一个中间顶点。
     * 先求出边双连通分量（low[i]值相同的点属于同一个边双连通分量.)，
     * 然后把边双连通分量缩点，得到一个无向连通图，
     * 那么这时最少加几条边才能构成边双连通图呢？有个结论：对于一棵无向树,我们要使得其变成边双连通图,
     * 需要添加的边数 == (树中度数为1的点的个数+1)/2，所以就相当于求一下叶子结点的数目。
     */
//    typedef long long ll;
//const int N=5009;
//    int pre[N],low[N],bccno[N],dfs_clock,bcc_cnt;
//    vector<int>g[N];
//    stack<int>S;
//    void dfs(int u,int fa) {
//        low[u]=pre[u]=++dfs_clock;
//        S.push(u);
//        for(int i=0; i<g[u].size(); i++) {
//            int v=g[u][i];
//            if(v==fa)continue;
//            if(!pre[v]) {
//                dfs(v,u);
//            }
//            low[u]=min(low[u],low[v]);
//        }
//        if(pre[u]==low[u]) {
//            ++bcc_cnt;
//            int tmp;
//            do {
//                tmp=S.top();
//                S.pop();
//                bccno[tmp]=bcc_cnt;
//            } while(u!=tmp);
//        }
//    }
//    void find_edge_bcc(int n) {
//        dfs_clock=bcc_cnt=0;
//        memset(pre,0,sizeof(pre));
//        memset(low,0,sizeof(low));
//
//        for(int i=0; i<n; i++)
//            if(!pre[i])dfs(i,-1);
//    }
//    int in[N];
//    int a[N][N];
//    int main() {
//        //freopen("f.txt","r",stdin);
//        int n,m;
//        scanf("%d%d",&n,&m);
//        for(int i=0; i<=n; i++)g[i].clear();
//        for(int i=1; i<=m; i++) {
//            int u,v;
//            scanf("%d%d",&u,&v);
//            u--;
//            v--;
//            if(a[u][v])continue;
//            a[u][v]=a[v][u]=1;
//            g[u].push_back(v);
//            g[v].push_back(u);
//        }
//        find_edge_bcc(n);
//        memset(in,0,sizeof(in));
//        for(int i=0; i<n; i++)
//            for(int j=0; j<g[i].size(); j++) {
//                int v=g[i][j];
//                if(bccno[i]!=bccno[v])in[bccno[v]]++;
//            }
//        int ans=0;
//        for(int i=1; i<=n; i++)
//            if(in[i]==1)ans++;
//        printf("%d\n",(ans+1)/2);
//        return 0;
//    }


}
