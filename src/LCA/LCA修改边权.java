package LCA;

/**
 * Created by user on 2017/10/18.
 */
public class LCA修改边权 {
    /**
     * poj2763
     * LCA + 修改边权：一边查询两点间的距离，一边修改某些边权。
     * 对于修改了某些边的边权，就要从此开始遍历下面的子孙后代更改他们的dir值（点到根的距离）。
     * 也不需要太多技巧，直接按题意实现即可，
     * 不过时间比较糟糕，用线段树或树状数组可以对修改操作进行优化，时间提升很多
     */
//#include <cstdio>
//#include <cmath>
//#include <cstring>
//#include <algorithm>
//
//    using namespace std;
//
//const int maxn = 2e5+100;
//
//    int N,Q,S;
////vector <int> G[maxn];
//
//    struct edge{
//        int to,next,w;
//    }e[2*maxn];
//
//    int head[2*maxn],tot;
//    void add_edge(int u,int v,int w)
//    {
//        e[tot].to = v;
//        e[tot].w = w;
//        e[tot].next = head[u];
//        head[u] = tot++;
//
//        e[tot].to = u;
//        e[tot].w = w;
//        e[tot].next = head[v];
//        head[v] = tot++;
//    }
//
//    int in[maxn],out[maxn],P[2*maxn],fa[maxn][30],dep[maxn],dis[maxn],cnt;
//    void dfs(int u,int _fa,int _dep,int _dis)
//    {
//        in[u] = ++cnt;
//        P[cnt] = u;
//        fa[u][0] = _fa;
//        dis[u] = _dis;
//        dep[u] = _dep;
//        for(int i=head[u];~i;i=e[i].next)
//        {
//            int v = e[i].to;
//            if(v == _fa) continue;
//            dfs(v,u,_dep+1,_dis+e[i].w);
//        }
//        out[u] = ++cnt;
//    }
//    void debug()
//    {
//        printf("in:\t");for(int i=1;i<=N;i++) printf("%d ",in[i]);puts("");
//        printf("out:\t");for(int i=1;i<=N;i++) printf("%d ",out[i]);puts("");
//        printf("p:\t");for(int i=1;i<=cnt;i++) printf("%d ",P[i]);puts("");
//        printf("dis:\t");for(int i=1;i<=N;i++) printf("%d ",dis[i]);puts("");
//        printf("dep:\t");for(int i=1;i<=N;i++) printf("%d ",dep[i]);puts("");
//        printf("edge:");for(int i=0;i<tot;i++) printf("\tto:%d w:%d\n",e[i].to,e[i].w);
//    }
//
//    int initLCA()
//    {
//        int m = (int)log(N)/log(2)+1;
//        for(int k=0;k<m;k++)
//        {
//            for(int v=1;v<=N;v++)
//            {
//                if(fa[v][k] < 0) {fa[v][k+1] = -1;continue;}
//                else fa[v][k+1] = fa[fa[v][k]][k];
//            }
//        }
//    }
//
//    int LCA(int u,int v)
//    {
//        int m = (int)log(N)/log(2)+1;
//        if(dep[v] > dep[u]) swap(u,v);
//        for(int k=0;k<m;k++)
//        {
//            if((dep[u]-dep[v])>>k & 1 )
//                u = fa[u][k];
//        }
//        if(u == v) return u;
//        for(int k=m-1;k>=0;k--)
//        {
//            if(fa[u][k] != fa[v][k])
//            {
//                u = fa[u][k];
//                v = fa[v][k];
//            }
//        }
//        return fa[u][0];
//    }
//
//    int c[2*maxn];
//    int lowbit(int x) {return x&-x;}
//
//    void init()
//    {
//        memset(head,-1,sizeof head);
//        memset(fa,-1,sizeof fa);
//        memset(c,0,sizeof c);
//        memset(in,0,sizeof in);
//        memset(out,0,sizeof out);
//        tot = 0;
//        cnt = 0;
//    }
//
//    void add(int x,int d)
//    {
//        while(x)
//        {
//            c[x] += d;
//            x -= lowbit(x);
//        }
//    }
//    void add_seg(int l,int r,int d)
//    {
//        add(r,d);
//        add(l-1,-d);
//    }
//    int sum(int x)
//    {
//        int res = 0;
//        //printf("u:%d ",P[x]);
//        while(x <= cnt)
//        {
//            res += c[x];
//            x += lowbit(x);
//        }
//        //printf("res:%d\n",res);
//        return res;
//    }
//    int dist(int x)
//    {
//        if(x == -1) return 0;
//        return sum(in[x]) + dis[x];
//    }
//    int main()
//    {
//        //freopen("input.txt","r",stdin);
//        while(~scanf("%d%d%d",&N,&Q,&S))
//        {
//            init();
//            for(int i=0,u,v,w;i<N-1;i++)
//            {
//                scanf("%d%d%d",&u,&v,&w);
//                add_edge(u,v,w);
//            }
//            dfs(1,-1,1,0);
//            //debug();
//            initLCA();
//            for(int i=0;i<tot;i+=2)
//            {
//                if(dep[e[i].to] < dep[e[i+1].to]) swap(e[i].to,e[i+1].to);
//            }
//            int op;
//            for(int i=0,a,b,c;i<Q;i++)
//            {
//                scanf("%d",&op);
//                if(op == 0)
//                {
//                    scanf("%d",&a);
//                    int lca = LCA(S,a);
//                    //printf("lca:%d\n",lca);
//
//                    printf("%d\n",dist(S)+dist(a)-2*(dist(lca)));
//                    S = a;
//                }else
//                {
//                    scanf("%d%d",&a,&b);
//                    a--;
//                    int u = e[a*2].to;
//                    int dw = b - (dist(u) - dist(fa[u][0]));
//                    //printf("dw:%d u:%d\n",dw,u);
//                    add_seg(in[u],out[u],dw);
//                }
//            }
//        }
//    }
}
