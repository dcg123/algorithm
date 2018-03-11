package 图论.网络流.最小割;

/**
 * Created by user on 2017/10/16.
 */
public class poj3469 {
    /**
     * 最小割，图中所有的割中，边权值和最小的割为最小割。
     * 题意：给你n个模块，每个模块在A核花费为ai,
     * 在B核跑花费为bi,然后由m个任务（ai,bi,wi），
     * 表示如果ai,bi不在同一个核上跑，额外的花费为wi，
     * 求最小的花费。
     一开始想的时候以为是费用流，但想着想着觉得，这么大的数据量绝对不可能是费用流。
     最后发现它是一个最小割模型。实际上就是要将网络里的模块划分成s-t两个点集，
     然后我们合适的构造一下边就可以使得对应的最小割就是我们的答案，构造的方法是这样的：
     当模块属于A集的时候，花费为ai，所以就从向t连一条ai的边，而当模块属于B集的时候，
     花费为bi，所以就由s连一条向bi的边。然后对于每个任务，当ai,bi不同的时候花费为mi，
     所以就由ai,bi连两条容量为wi的边，跑一下最大流就可以得出对应的最小花费了
     */
//    #include<iostream>
//#include<algorithm>
//#include<cstdio>
//#include<cstring>
//#include<vector>
//#include<queue>
//    using namespace std;
//const int MAX=200010;
//const int INF=1<<30;
//    struct edge{int to,cap,rev;};
//    vector<edge> G[MAX];
//    int level[MAX];
//    int iter[MAX];
//    void add(int from,int to,int cap)
//    {
//        G[from].push_back((edge){to,cap,G[to].size()});
//        G[to].push_back((edge){from,0,G[from].size()-1});
//    }
//    void bfs(int s)
//    {
//        memset(level,-1,sizeof(level));
//        queue<int> que;
//        level[s]=0;
//        que.push(s);
//        while(!que.empty())
//        {
//            int v=que.front();
//            que.pop();
//            for(int i=0;i<G[v].size();i++)
//            {
//                edge &e=G[v][i];
//                if(e.cap>0&& level[e.to]<0)
//                {
//                    level[e.to]=level[v]+1;
//                    que.push(e.to);
//                }
//            }
//        }
//    }
//    int dfs(int v,int t,int f)
//    {
//        if(v==t) return f;
//        for(int &i=iter[v];i<G[v].size();i++)
//        {
//            edge &e=G[v][i];
//            if(e.cap>0&&level[v]<level[e.to])
//            {
//                int d=dfs(e.to,t,min(f,e.cap));
//                if(d>0)
//                {
//                    e.cap-=d;
//                    G[e.to][e.rev].cap+=d;
//                    return d;
//                }
//            }
//        }
//        return 0;
//    }
//    int max_flow(int s,int t)
//    {
//        int flow=0;
//        for(;;)
//        {
//            bfs(s);
//            if(level[t]<0) return flow;
//            memset(iter,0,sizeof(iter));
//            int f;
//            while((f=dfs(s,t,INF))>0)
//                flow+=f;
//        }
//    }
//const int MAXV=20010;
//    int N,M;
//    int A[MAXV],B[MAXV];
//    int a[MAX],b[MAX],w[MAX];
//    void solve()
//    {
//        int s=N,t=s+1;
//        for(int i=0;i<N;i++)
//        {
//            add(i,t,A[i]);
//            add(s,i,B[i]);
//        }
//        for(int i=0;i<M;i++)
//        {
//            add(a[i]-1,b[i]-1,w[i]);
//            add(b[i]-1,a[i]-1,w[i]);
//        }
//        cout<<max_flow(s,t)<<endl;
//    }
//    int main()
//    {
//        cin>>N>>M;
//        for(int i=0;i<N;i++)
//        {
//            scanf("%d%d",&A[i],&B[i]);
//        }
//        for(int i=0;i<M;i++)
//        {
//            scanf("%d%d%d",&a[i],&b[i],&w[i]);
//        }
//        solve();
//        return 0;
//    }

}
