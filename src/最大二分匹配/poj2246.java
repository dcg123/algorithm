package 最大二分匹配;

/**
 * Created by user on 2017/10/19.
 */
public class poj2246 {
    /**
     * 给你一个n*m的棋盘，其中有k个洞，现在有1*2大小的纸片，纸片不能覆盖洞，并且每个格子最多只能被覆盖一次。问你除了洞口之外这个棋盘是否能被纸片填满。

     这个题目一眼很难看出是二分图匹配...

     可以根据i和j性质可以看出，i+j为奇数的上下相邻的i'和j'一定是偶数，
     那么一个1*2的纸片的i+j一定是一个奇数一个偶数。所以我是建立一个二分图两个集合，
     将i+j为奇数的点与上下左右相邻的点连在一起，当然点不是洞。
     最后就用匈牙利算法求最大匹配数，然后就简单了。
     */
//    #include <iostream>
//#include <cstdio>
//#include <cstring>
//#include <vector>
//    using namespace std;
//const int N = 35* 35;
//    vector <int> G[N];
//    int match[N] , tx[] = {-1 , 0 , 1 , 0} , ty[] = {0 , 1 , 0 , -1} , n , m;
//    bool vis[N] , map[35][35];
//
//    bool check(int x , int y) {
//        if(!map[x][y] && x >= 0 && y >= 0 && x < n && y < m)
//            return true;
//        return false;
//    }
//
//    bool dfs(int u) {
//        for(int i = 0 ; i < G[u].size() ; ++i) {
//            int v = G[u][i];
//            if(!vis[v]) {
//                vis[v] = true;
//                if(match[v] == -1 || dfs(match[v])) {
//                    match[v] = u;
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    int hungry() {
//        int res = 0;
//        for(int i = 0 ; i < n ; ++i) {
//            for(int j = 0 ; j < m ; ++j) {
//                if((i + j) % 2 && !map[i][j]) {
//                    memset(vis , false , sizeof(vis));
//                    if(dfs(i*m + j)) {
//                        res++;
//                    }
//                }
//            }
//        }
//        return res;
//    }
//
//    int main()
//    {
//        int k , u , v;
//        while(cin >> n >> m >> k) {
//            memset(map , false , sizeof(map));
//            memset(match , -1 , sizeof(match));
//            for(int i = 0 ; i < n * m ; ++i) {
//                G[i].clear();
//            }
//            for(int i = 0 ; i < k ; ++i) {
//                cin >> u >> v;
//                map[--v][--u] = true;
//            }
//            for(int i = 0 ; i < n ; ++i) {
//                for(int j = 0 ; j < m ; ++j) {
//                    if(!map[i][j] && (i + j) % 2) {
//                        for(int t = 0 ; t < 4 ; ++t) {
//                            int x = i + tx[t] , y = j + ty[t];
//                            if(check(x , y)) {
//                                G[i*m + j].push_back(x*m + y);
//                            }
//                        }
//                    }
//                }
//            }
//            printf("%s\n" , 2*hungry() == n*m-k ? "YES" : "NO");
//        }
//        return 0;
//    }
}
