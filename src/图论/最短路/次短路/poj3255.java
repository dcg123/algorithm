package 图论.最短路.次短路;

/**
 * Created by user on 2017/10/17.
 */
public class poj3255 {
    /**
     * 某街区有R条道路，N个路口，道路可以双向通过，问1路口到N路口的次短距离同一条路可以走多次
     用最短路做法Dijkstra算法，dist[]记录最短路，dist2[]记录次短路
     */
//    #include <iostream>
//#include <vector>
//#include <queue>
//#include <string.h>
//#include <stdio.h>
//#include <algorithm>
//    using namespace std;
//const int maxn=5005;
//const int inf=1e9;
//    int N,R;
//    struct edge
//    {
//        int to,cost;
//    };
//    typedef pair<int ,int> P ;///first 是从1到second的最短路 second 是路口标号
//    vector<edge>G[maxn];///邻接表
//    int dist[maxn];///最短路
//    int dist2[maxn];///次短路
//    void solve()
//    {
//        priority_queue<P ,vector<P>,greater<P> >que;
//        fill(dist,dist+N,inf);
//        fill(dist2,dist2+N,inf);
//        dist[0]=0;
//        //dist2[0]=0;
//        que.push(P(0,0));
//        while(!que.empty())
//        {
//            P p=que.top();///优先队列 ，用.top
//            que.pop();
//            int v=p.second ,d=p.first;
//            if(dist2[v]<d)continue;
//            for(int i=0; i<G[v].size(); i++)
//            {
//                edge e=G[v][i];
//                int d2=d+e.cost;
//                if(dist[e.to]>d2)
//                {
//                    swap(dist[e.to],d2);
//                    que.push(P(dist[e.to],e.to));
//                }
//                if(dist2[e.to]>d2&&dist[e.to]<d2)
//                {
//                    dist2[e.to]=d2;
//                    que.push(P(dist2[e.to],e.to));
//                }
//            }
//        }
//        printf("%d\n",dist2[N-1]);
//    }
//    int main()
//    {
//        int from;
//        while(cin>>N>>R)
//        {
//            edge now;
//            for(int i=0;i<R;i++)
//            {
//                cin>>from>>now.to>>now.cost;
//                from--;
//                now.to--;///标号从  0-N-1！！
//                G[from].push_back(now);
//                swap(now.to,from);
//                G[from].push_back(now);
//            }
//            solve();
//        }
//        return 0;
//    }

}
