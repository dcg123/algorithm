package 图论.最短路;

/**
 * Created by user on 2017/10/17.
 */
public class spfa记录字典序最小的路径 {
    /**
     * 最短路入门经典题

     题意是输入n表示n个点从1到n标号，n=0结束程序

     然后给出n*n的邻接矩阵，g[i][j]=-1表示i->j没有通路

     然后有多个查询，输入u,v，输出u->v的最短路并且打印字典序最小的路径，查询以-1 -1结束
     */
//    #include<stdio.h>
//#include<string.h>
//#include<queue>
//    using namespace std;
//#define inf 0x3fffffff
//            #define N 1100
//    int a[N][N];
//    int b[N];
//    int n;
//    int pre[N],dis[N],vis[N];
//    void init()
//    {
//        memset(pre,-1,sizeof(pre));
//        memset(vis,0,sizeof(vis));
//    }
//    int Min(int v,int vv)
//    {
//        return v>vv?vv:v;
//    }
//    int len;
//    void dfs(int k,char s[])
//    {
//        if(k==-1)return ;
//        dfs(pre[k],s);
//        s[len++]=k+'0';
//        return ;
//    }
//    int cmp(int jnext,int now)
//    {
//        char sf[N],sn[N];
//        len=0;
//        dfs(jnext,sf);
//        sf[len]=0;
//        len=0;
//        dfs(now,sn);
//        sn[len++]=jnext+'0';
//        sn[len]=0;
//        if(strcmp(sf,sn)>0)
//            return  1;
//        return 0;
//    }
//    void spfa(int s,int t)
//    {
//        int i;
//        for(i=1; i<=n; i++)
//            dis[i]=inf;
//        dis[s]=0;
//        queue<int>q;
//        q.push(s);
//        while(!q.empty())
//        {
//            int cur=q.front();
//            q.pop();
//            vis[cur]=0;
//            for(i=1; i<=n; i++)
//            {
//                if(dis[cur]==inf)continue;
//                if(a[cur][i]<0||i==cur)continue;
//                if(dis[i]>dis[cur]+a[cur][i]+b[i])
//                {
//                    dis[i]=dis[cur]+a[cur][i]+b[i];
//                    pre[i]=cur;
//                    if(!vis[i])
//                    {
//                        vis[i]=1;
//                        q.push(i);
//                    }
//                }
//                else if(dis[i]==dis[cur]+a[cur][i]+b[i]&&cmp(i,cur))//同时要比较如果选cur那么字典序会不会变小
//                    pre[i]=cur;
//            }
//        }
//        return ;
//    }
//    void print(int t)
//    {
//        if(pre[t]==-1)
//        {
//            printf("%d",t);
//            return ;
//        }
//        print(pre[t]);
//        printf("-->%d",t);
//        return ;
//    }
//    int main()
//    {
//        int i,s,j,t;
//        while(scanf("%d",&n),n)
//        {
//            for(i=1; i<=n; i++)
//                for(j=1; j<=n; j++)
//                    scanf("%d",&a[i][j]);
//            for(i=1; i<=n; i++)
//                scanf("%d",&b[i]);
//            while(scanf("%d%d",&s,&t),s!=-1&&t!=-1)
//            {
//                int sb=b[s],st=b[t];//这里我认为不需要每次置0
//                b[s]=0;//，在下面输出dis[t]-b[t]就可以了，但是wa
//                b[t]=0;//
//                init();
//                spfa(s,t);
//                printf("From %d to %d :\n",s,t);
//                printf("Path: ");
//                print(t);
//                printf("\n");
//                printf("Total cost : %d\n\n",dis[t]);
//                b[s]=sb;//
//                b[t]=st;//
//            }
//        }
//        return 0;
//    }
}
