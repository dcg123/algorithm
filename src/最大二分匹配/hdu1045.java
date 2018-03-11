package 最大二分匹配;

////hdu 1045  Fire Net
//
////这题意思是给出一张图，图中'X'表示wall,'.'表示空地,可以放置blockhouse
////同一条直线上只能有一个blockhouse，除非有wall隔开，问在给出的图中
////最多能放置多少个blockhouse
//
////二分匹配，别人都说水题，但我没看出它是二分图匹配
////看了别人的解题报告后还有点懵懵懂懂的
//
////这题是把原始图分别按行和列缩点
////建图：横竖分区。先看每一列，同一列相连的空地同时看成一个点，显然这
////样的区域不能够同时放两个点。这些点作为二分图的X部。同理在对所有的
////行用相同的方法缩点，作为Y部。
//
////连边的条件是两个区域有相交部分(即'.'的地方)。最后求最大匹配就是答案。
//
//
//#include <stdio.h>
//        #include <string.h>
//
//        #define N 8
//
//        int cnt_row, cnt_col;
//        int row[N][N], col[N][N], r[N], c[N];
//        char map[N][N];
//        bool path[N][N], vis[N];
//
//        int dfs(int rr)
//        {
//        for(int i = 0; i < cnt_col; ++i)
//        {   //rr到i有路径 且 i没遍历过
//        if(path[rr][i] && vis[i] == false)
//        {
//        vis[i] = true;
//        if(c[i] == -1 || dfs(c[i]))//若 i 还没匹配过或 跟i
//        {   //匹配的点找到另一个相匹配的点(则i 就可以跟rr匹配)
//        c[i] = rr;
//        r[rr] = i;
//        return 1;
//        }
//        }
//        }
//        return 0;
//        }
//
//        int maxmatch()
//        {
//        int ans = 0;
//        memset(r, -1, sizeof(r));
//        memset(c, -1, sizeof(c));
//        for(int i = 0; i < cnt_row; ++i)
//        {
//        if(r[i] == -1)
//        {
//        memset(vis, false, sizeof(vis));
//        ans += dfs(i);
//        }
//        }
//        return ans;
//        }
//
//        int main()
//        {
//        int n;
//        while(scanf("%d%*c", &n), n)
//        {
//        for(int i = 0; i < n; ++i)
//        {
//        for(int j = 0; j < n; ++j)
//        map[i][j] = getchar();
//        getchar();
//        }
//
//        memset(row, -1, sizeof(row));
//        memset(col, -1, sizeof(col));
//        cnt_row = cnt_col = 0;
//        for(int i = 0; i < n; ++i)
//        {
//        for(int j = 0; j < n; ++j)
//        {
//        if(map[i][j] == '.' && row[i][j] == -1)
//        {           //横向缩点
//        for(int k = j; map[i][k] == '.' && k < n; ++k)
//        row[i][k] = cnt_row;  //给相同的区域标记同一个数字
//        cnt_row++;
//        }
//
//
//        if(map[j][i] == '.' && col[j][i] == -1)
//        {           //纵向缩点
//        for(int k = j; map[k][i] == '.' && k < n; ++k)
//        col[k][i] = cnt_col;  //给相同的区域标记同一个数字
//        cnt_col++;
//        }
//        }
//        }
//
//        memset(path, false, sizeof(path));
//        for(int i = 0; i < n; ++i)
//        for(int j = 0; j < n; ++j)
//        if(map[i][j] == '.')    //连边,'.'的地方即为缩点后的 行和列的交点
//        path[ row[i][j] ][ col[i][j] ] = true;
//
//        printf("%d\n", maxmatch());  //二分图匹配
//        }
//        return 0;
//        }