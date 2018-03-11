package 最大二分匹配.最大独立子集;

/**
 * Created by user on 2017/10/12.
 */
public class hdu1068 {
    /**
     * 题意：有n个人，一些人认识另外一些人，选取一个集合，
     * 使得集合里的每个人都互相不认识，求该集合中人的最大个数。

     题解：这题就是求最大独立集，
     但是这并不是两个集合，而是一个集合，所以求出最大匹配后需要/2，然后代公式：最大独立集=N-最大匹配。
     */

    /**
     *#include <stdio.h>
     #include <string.h>

     #define maxn 1010

     int n, B[maxn];
     bool vis[maxn];
     int head[maxn], id;
     struct Node {
     int v, next;
     } E[maxn * maxn];

     void addEdge(int u, int v) {
     E[id].v = v; E[id].next = head[u];
     head[u] = id++;
     }

     void getMap() {
     int i, u, k, v; id = 0;
     memset(head, -1, sizeof(int) * n);
     memset(B, -1, sizeof(int) * n);
     for(u = 0; u < n; ++u) {
     scanf("%*d: (%d)", &k);
     while(k--) {
     scanf("%d", &v);
     addEdge(u, v);
     }
     }
     }

     int findPath(int x) {
     int i, v;
     for(i = head[x]; i != -1; i = E[i].next) {
     if(!vis[v = E[i].v]) {
     vis[v] = 1;
     if(B[v] == -1 || findPath(B[v])) {
     B[v] = x; return 1;
     }
     }
     }
     return 0;
     }

     int MaxMatch() {
     int ans = 0, i;
     for(i = 0; i < n; ++i) {
     memset(vis, 0, sizeof(bool) * n);
     ans += findPath(i);
     }
     return ans;
     }

     void solve() {
     printf("%d\n", n - (MaxMatch() >> 1));
     }

     int main() {
     //freopen("stdin.txt", "r", stdin);
     while(scanf("%d", &n) == 1) {
     getMap();
     solve();
     }
     return 0;
     }
     */
}
