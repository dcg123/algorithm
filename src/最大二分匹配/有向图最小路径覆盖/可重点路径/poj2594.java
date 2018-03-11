package 最大二分匹配.有向图最小路径覆盖.可重点路径;

/**
 * Created by user on 2017/10/19.
 */
public class poj2594 {
    /**
     * 给你一个有向无环图，有n个点，m条有向边。
     一个机器人可以从任意点开始沿着边的方向走下去。对于每一个机器人：走过的点不能再走过。
     问你最少用几个机器人可以走完所有的n个点，不同的机器人可以走相同的点。

     解题报告：
     原始的最小路径覆盖的各个路径是不能有相同的点的，而这题却可以，所以建图需要改变。

     建图如下：
     每一个点i拆成两个点，i和i’
     如果i到j可达（和原始不同之处，用floyd求解即可），连接i和j’.
     点数减去最大匹配即可。
     */

//    #include<iostream>
//#include<vector>
//#include<cstring>
//#include<cstdio>
//    using namespace std;
//    int a, b, from, to, match[501], n, m;
//    bool g[501][501], vst[501];
//    vector<int> v[501];
//    bool find(int u)
//    {
//        for(int i = 0; i < v[u].size(); i++)
//            if (!vst[v[u][i]])
//            {
//                vst[v[u][i]] = 1;
//                if (match[v[u][i]] == -1 || find(match[v[u][i]]))
//                {
//                    match[v[u][i]] = u;
//                    return true;
//                }
//            }
//        return false;
//    }
//    int solve()
//    {
//        memset(match, -1, sizeof(int) * (n + 1));
//        int ans = 0;
//        for(int i = 1; i <= n; i++)
//        {
//            memset(vst, 0, sizeof(bool) * (n + 1));
//            ans += find(i);
//        }
//        return ans;
//    }
//    int main()
//    {
//        while(scanf("%d%d", &a, &b) && (a || b))
//        {
//            for(int i = 1; i <= a; i++)
//            {
//                v[i].clear();
//                for(int j = 1; j <= a; j++) g[i][j] = 0;
//            }
//            for(int i = 0; i < b; i++)
//            {
//                scanf("%d%d", &from, &to);
//                g[from][to] = 1;
//            }
//            for(int k = 1; k <= a; k++)
//                for(int i = 1; i <= a; i++)
//                    if (g[i][k])
//                        for(int j = 1; j <= a; j++)
//                            g[i][j] = (g[i][j] || (g[i][k] && g[k][j]));
//            for(int i = 1; i <= a; i++)
//                for(int j = 1; j <= a; j++)
//                    if (g[i][j])
//                        v[i].push_back(j);
//            n = m = a;
//            printf("%d\n", n - solve());
//        }
//        return 0;
//    }
}
