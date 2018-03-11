package 图论.最短路.二分最短路;

/**
 * Created by user on 2017/10/13.
 */
public class hdu1839 {
    /**
     * 题目：给m条管道，每条管道有可运输的最大容量和消耗的时间c,t
     现在有东西要从1运输到n,必须在时间T内完成，求符合条件的可运输的最大容量
     分析：对于所给的m条管道的最大容量，进行排序，然后二分容量求从1到n的最短时间即可
     */
//    #include<cstdio>
//#include<vector>
//#include<cstring>
//#include<queue>
//#include<map>
//#include<algorithm>
//    using namespace std;
//
//const int maxn = 10001;
//const int INF = 0x7FFFFFFF;
//    struct aaa { int u, v, cc, tt; }node[500005];
//    vector<aaa>ljb[maxn];
//    int c[500005], dist[maxn], flag[maxn];
//    int n, m, t;
//
//    void spfa(int xianzhi)
//    {
//        int iii;
//        queue<int>Q;
//        memset(flag, 0, sizeof(flag));
//        for (iii = 0; iii<=n; iii++) dist[iii] = INF;
//        dist[1] = 0; Q.push(1); flag[1] = 1;
//        while (!Q.empty())
//        {
//            int h = Q.front(); Q.pop(); flag[h] = 0;
//            for (iii = 0; iii<ljb[h].size(); iii++)
//            {
//                aaa u = ljb[h][iii];
//                if (u.cc >= xianzhi)
//                {
//                    if (u.u == h)
//                    {
//                        if (dist[u.u] + u.tt <= dist[u.v])
//                        {
//                            dist[u.v] = dist[u.u] + u.tt;
//                            if (flag[u.v] == 0)
//                            {
//                                Q.push(u.v);
//                                flag[u.v] = 1;
//                            }
//                        }
//                    }
//                    else if (u.v == h)
//                    {
//                        if (dist[u.v] + u.tt <= dist[u.u])
//                        {
//                            dist[u.u] = dist[u.v] + u.tt;
//                            if (flag[u.u] == 0)
//                            {
//                                Q.push(u.u);
//                                flag[u.u] = 1;
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//    int main()
//    {
//        int X;
//        scanf("%d", &X);
//        while (X--)
//        {
//            int i, j, u, v, tt;
//            scanf("%d%d%d", &n, &m, &t);
//            for (i = 0; i <= n; i++) ljb[i].clear();
//            for (i = 0; i <= m; i++) node[i].tt = INF;
//            for (i = 0; i < m; i++)
//            {
//                scanf("%d%d%d%d", &u, &v, &c[i], &tt);
//                node[i].u = u; node[i].v = v;
//                node[i].cc = c[i]; node[i].tt = tt;
//                ljb[v].push_back(node[i]); ljb[u].push_back(node[i]);
//            }
//            sort(c, c + m);
//            int anss = -1, xx, dd, zz;
//            xx = 0; dd = m - 1; zz = (xx + dd) / 2;
//            while (1)
//            {
//                spfa(c[zz]);
//                if (dist[n] <= t) { anss = zz; xx = zz + 1; zz = (xx + dd) / 2; }
//                else { dd = zz; zz = (xx + dd) / 2; }
//                if (xx >= dd) break;
//            }
//            printf("%d\n", c[anss]);
//        }
//        return 0;
//    }
}
