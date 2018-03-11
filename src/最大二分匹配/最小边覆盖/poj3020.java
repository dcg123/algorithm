package 最大二分匹配.最小边覆盖;

/**
 * Created by user on 2017/10/19.
 */
public class poj3020 {
    /**
     * 大意就是说给你一张图，用‘*‘来表示城市，然后城市要覆盖4G什么东西，每个城市覆盖上之后可以向上下左右四个方向延伸，可以多覆盖一个，然后让我们求一个最小的基站数。
     也就是说每两个城市之间（相邻的城市）连接在一起，
     剩下的不能连接的单独算一个。如果我们把这些城市等效成一个一个得点，每相邻城市之间加上一条边，
     呢么我们最后求一个最大匹配就是能够最多的匹配的城市的个数，
     */
//    #include <iostream>
//#include <cstdio>
//#include <algorithm>
//#include <cmath>
//#include <queue>
//#include <vector>
//#include <cstring>
//#include <string>
//    using namespace std;
//const int MAXN=400+5;
//    int vis[MAXN],match[MAXN];
//    char tu[45][15];
//    int p[45][15];
//    int n,m;
//    vector<int>head[MAXN];
//
//    int dfs(int u)
//    {
//        int i;
//        int l=head[u].size();
//        for(i=0; i<l; ++i)
//        {
//            int v=head[u][i];
//            if(!vis[v])
//            {
//                vis[v]=1;
//                if(match[v]==-1||dfs(match[v]))
//                {
//                    match[v]=u;
//                    return 1;
//                }
//            }
//        }
//        return 0;
//    }
//
//    int main()
//    {
//        int t;
//        int i,j;
//        scanf("%d",&t);
//        while(t--)
//        {
//            int cnt=0;
//            scanf("%d%d",&n,&m);
//            for(i=0; i<n; ++i)
//            {
//                scanf("%s",tu[i]);
//                for(j=0; j<m; ++j)
//                {
//                    if(tu[i][j]=='*')
//                    {
//                        head[cnt].clear();//用容器就要记得清0
//                        p[i][j]=cnt++;
//                    }
//                }
//            }
//            memset(match,-1,sizeof(match));
//            for(i=0; i<n; ++i)
//                for(j=0; j<m; ++j)
//                {
//                    if(tu[i][j]=='*')//如果这是个城市，那么延伸4个方向，如果存在城市就加一条边
//                    {
//                        if(i-1>=0&&tu[i-1][j]=='*')head[p[i][j]].push_back(p[i-1][j]);
//                        if(j-1>=0&&tu[i][j-1]=='*')head[p[i][j]].push_back(p[i][j-1]);
//                        if(i+1<n&&tu[i+1][j]=='*')head[p[i][j]].push_back(p[i+1][j]);
//                        if(j+1<m&&tu[i][j+1]=='*')head[p[i][j]].push_back(p[i][j+1]);
//                    }
//                }
//            int sum=0;
//            for(i=0; i<cnt; ++i)
//            {
//                memset(vis,0,sizeof(vis));
//                if(dfs(i))sum++;
//            }
//            printf("%d\n",cnt-sum/2);
//        }
//        return 0;
//    }

}
