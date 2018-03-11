package bfs.优先队列打印路径;

/**
 * Created by user on 2017/10/17.
 */
public class hdu1242 {
    /**
     * 题意：X代表卫兵，a代表终点，r代表起始点，.代表路，#代表墙
     路花费一秒，x花费两秒
     问到达终点的最少时间
     思路：BFS+优先队列的果题
     */

//#include <stdio.h>
//#include <string.h>
//#include <queue>
//    using namespace std;
//
//    struct node
//    {
//        int x,y,step;
//        friend bool operator<(node n1,node n2)
//        {
//            return n2.step<n1.step;
//        }
//    };
//
//    int n,m,vis[205][205];
//    char map[205][205];
//    int x1,x2,y1,y2;
//    int to[4][2] = {1,0,-1,0,0,1,0,-1};
//
//    int check(int x,int y)
//    {
//        if(x<0 || y<0 || x>=n || y>=m || !vis[x][y] || map[x][y] == '#')
//            return 1;
//        return 0;
//    }
//
//    int bfs()
//    {
//        int i;
//        priority_queue<node> Q;
//        node a,next;
//        a.x = x1;
//        a.y = y1;
//        a.step = 0;
//        Q.push(a);
//        vis[x1][y1] = 0;
//        while(!Q.empty())
//        {
//            a = Q.top();
//            Q.pop();
//            if(a.x == x2 && a.y == y2)
//                return a.step;
//            for(i = 0; i<4; i++)
//            {
//                next = a;
//                next.x+=to[i][0];
//                next.y+=to[i][1];
//                if(check(next.x,next.y))//判断
//                    continue;
//                next.step++;
//                if(map[next.x][next.y] == 'x')//卫兵处多花费了一秒
//                    next.step++;
//                if(vis[next.x][next.y]>=next.step)//存入最小时间
//                {
//                    vis[next.x][next.y] = next.step;
//                    Q.push(next);
//                }
//            }
//        }
//        return 0;
//    }
//
//    int main()
//    {
//        int i,j;
//        while(~scanf("%d%d",&n,&m))
//        {
//            for(i = 0; i<n; i++)
//            {
//                scanf("%s",map[i]);
//                for(j = 0; map[i][j]; j++)
//                {
//                    if(map[i][j] == 'r')
//                    {
//                        x1 = i;
//                        y1 = j;
//                    }
//                    else if(map[i][j] == 'a')
//                    {
//                        x2 = i;
//                        y2 = j;
//                    }
//                }
//            }
//            memset(vis,1,sizeof(vis));
//            int ans = 0;
//            ans = bfs();
//            if(ans)
//                printf("%d\n",ans);
//            else
//                printf("Poor ANGEL has to stay in the prison all his life.\n");
//        }
//
//        return 0;
//    }


}
