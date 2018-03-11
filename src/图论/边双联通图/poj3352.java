package 图论.边双联通图;

/**
 * Created by user on 2017/10/19.
 */
public class poj3352 {
    /**
     * 题目大意:有n个旅游景点 r条路线，每条路线双向链接两个景区
     由于每条线路都有可能被施工，并且保证每次施工只对一条线路进行。
     问至少需要添加几条边，能保证不论那条边在修建时，城市始终还是连通的

     分析因为需要修路 但是要保证图是联通的 如果是只是求吧图边为强联通图的话
     修路的时候会因路被占用无法保证联通
     所以求边联通  边联通是任意两点之间有两条不同的路联通
     */
//    #include <iostream>
//#include <cstdio>
//#include <cstring>
//#include <vector>
//#include <algorithm>
//
//    using namespace std;
//
//const int MAXN = 5005;
//
//    vector<int> g[MAXN];
//    int pre[MAXN], low[MAXN], dg[MAXN], dfs_clock;
//    bool vis[MAXN], map[MAXN][MAXN];
//    int n, r;
//
//    void tarjan(int u, int fa) {
//        pre[u] = low[u] = ++dfs_clock;
//        vis[u] = 1;
//        for (int i = 0; i < g[u].size(); i++) {
//            int v = g[u][i];
//            if (v == fa) continue;
//            if (!pre[v]) {
//                tarjan(v, u);
//                low[u] = min(low[u], low[v]);
//            }
//            else if (vis[v]) {
//                low[u] = min(low[u], pre[v]);
//            }
//        }
//    }
//
//    void find_ebc() {
//        memset(pre, 0, sizeof(pre));
//        memset(low, 0, sizeof(low));
//        memset(vis, 0, sizeof(vis));
//        dfs_clock = 0;
//        for (int i = 1; i <= n; i++)
//            if (!pre[i])
//                tarjan(i, -1);
//    }
//
//    int main() {
//        while (scanf("%d%d", &n, &r) != EOF) {
//            for (int i = 1; i <= n; i++)
//                g[i].clear();
//            memset(map, 0, sizeof(map));
//            int u, v;
//            for (int i = 0; i < r; i++) {
//                scanf("%d%d", &u, &v);
//                if (!map[u][v]) {
//                    g[u].push_back(v);
//                    g[v].push_back(u);
//                    map[u][v] = map[v][u] = 1;
//                }
//            }
//
//            find_ebc();
//            memset(dg, 0, sizeof(dg));
//            for (int u = 1; u <= n; u++) {
//                for (int i = 0; i < g[u].size(); i++) {
//                    int v = g[u][i];
//                    if (low[u] != low[v])
//                        dg[low[u]]++;
//                }
//            }
//
//            int cnt = 0;
//            for (int i = 1; i <= n; i++)
//                if (dg[i] == 1)
//                    cnt++;
//            printf("%d\n", (cnt + 1) / 2);
//        }
//        return 0;
//    }
}
