package 数据结构.Lca;

import java.util.Scanner;

/**
 * Created by user on 2017/10/11.
 */
public class hdu2586 {
    /**
     * /********
     hdu2586
     2015.11.25
     46MS 4308K 3383 B C++

#include <iostream>
#include <stdio.h>
#include <algorithm>
#include <string.h>
    using namespace std;

const int maxn=40005;//顶点数
const int maxq=205;//最多查询次数，根据题目而定，本题中其实每组数据只有一个查询.

    //并查集
    int f[maxn];//根节点
    int find(int x)
    {
        if(f[x]==-1)
            return x;
        return f[x]=find(f[x]);
    }
    void unite(int u,int v)
    {
        int x=find(u);
        int y=find(v);
        if(x!=y)
            f[x]=y;
    }
//并查集结束

    bool vis[maxn];//节点是否访问
    int ancestor[maxn];//节点i的祖先
    struct Edge
    {
        int to,next,len;
    }edge[maxn*2];
    int head[maxn],tot;
    void addedge(int u,int v,int length)//邻接表头插法加边
    {
        edge[tot].to=v;
        edge[tot].len=length;
        //  printf("%d  ",length);
        edge[tot].next=head[u];
        head[u]=tot++;
    }

    struct Query
    {
        int q,next;
        int index;//查询编号，也就是输入的顺序
    }query[maxq*2];
    int ans[maxn*2];//存储每次查询的结果,下表0~Q-1，其实应该开maxq大小的。
    int h[maxn],tt;
    int Q;//题目中需要查询的次数
    int dis[maxn];

    void addquery(int u,int v,int index)//邻接表头插法加询问
    {
        query[tt].q=v;
        query[tt].next=h[u];
        query[tt].index=index;
        h[u]=tt++;
        query[tt].q=u;//相当于两次查询，比如查询  3，5 和5，3结果是一样的，以3为头节点的邻接表中有5，以5为头节点的邻接表中有3
        query[tt].next=h[v];
        query[tt].index=index;
        h[v]=tt++;
    }

    void init()
    {
        tot=0;
        memset(head,-1,sizeof(head));
        tt=0;
        memset(h,-1,sizeof(h));
        memset(vis,0,sizeof(vis));
        memset(f,-1,sizeof(f));
        memset(ancestor,0,sizeof(ancestor));
        memset(dis,0,sizeof(dis));
    }

    void LCA(int u)
    {
        ancestor[u]=u;
        vis[u]=true;


        for(int i=head[u];i!=-1;i=edge[i].next)//和顶点u相关的顶点
        {
            int v=edge[i].to;

            // printf("%d    ",edge[i].len);
            if(vis[v])
                continue;
            //dis[v]+=edge[i].len;
            dis[v]=dis[u]+edge[i].len;
            LCA(v);

            unite(u,v);
            ancestor[find(u)]=u;//将u的左右孩子的祖先设为u
            //dis[find(u)]+=dis[u];

        }
        for(int i=h[u];i!=-1;i=query[i].next)//看输入的查询里面有没有和u节点相关的
        {
            int v=query[i].q;
            if(vis[v])
                ans[query[i].index]=ancestor[find(v)];
        }
    }
    bool flag[maxn];//用来确定根节点的

    int t;
    int n,u,v,len;

    int main()
    {
        int a,b,c;
        // freopen("cin.txt","r",stdin);
        // scanf("%d(%d):%d",&a,&b,&c);
        // cout<<a<<b<<c;
        scanf("%d",&t);
        while(t--)
        {
            scanf("%d%d",&n,&Q);
            init();
            memset(flag,0,sizeof(flag));
            for(int i=1;i<n;i++)
            {
                scanf("%d%d%d",&u,&v,&len);
                flag[v]=true;//有入度
                addedge(u,v,len);
                addedge(v,u,len);
            }
            for(int i=0;i<Q;i++)
            {
                scanf("%d%d",&u,&v);
                addquery(u,v,i);
            }
            int root;
            for(int i=1;i<=n;i++)
            {
                if(!flag[i])
                {
                    root=i;
                    //  printf("root=%d  ",root);
                    break;
                }
            }
            LCA(root);
            //  for(int i=1;i<=n;i++)printf("%d  ",dis[i]); printf("\n");
            for(int i=0;i<Q;i++)
            {
                len=dis[query[i<<1].q]+dis[query[i<<1|1].q]-dis[ans[i]]*2;
                printf("%d\n",len);
            }

        }
        return 0;
    }
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

    }
}
