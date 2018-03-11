package 图论.最短路.次短路条数;

/**
 * Created by user on 2017/10/13.
 */
public class hdu1688 {
    /**
     * 体操作是：
     如果当前为最短路，则判断最短路+其连接的点v是否可更新点v的最短路径：
     如果小于原最短路径长度，则更新最短路并将之前的最短路更新至次短路，并相应地更新最短路和次短路的记录路径条数数组。
     如果等于原最短路径长度，则更新最短路的路径条数数组。
     如果大于原最短路径长度，则再判断是否可更新次短路，如果能，那么就更新次短路并相应地更新记录次短路的路径条数数组。
     如果当前为次短路，则肯定更新不了最短路(所以让它尝试更新也不会发生错误)，则判断次短路+其连接的点v是否可更新点v的次短路径：
     如果小于原次短路径长度，则更新次短路，并相应地更新次短路的记录路径条数数组。如果等于原最短路径长度，则更新次短路的路径条数数组。

     */
//    #include<stdio.h>
//#include<queue>
//#include<vector>
//    using namespace std;
//const int N = 1005;
//const int inf = 1e9;
//    struct EDG
//    {
//        int v,d;
//    };
//    struct node
//    {
//        int v,c;
//    };
//
//    vector<EDG>mapt[N];
//    int spfa(int sp,int ep,int n)
//    {
//        int inq[N][2]={0},dis[N][3],num[N][2];
//        queue<node>q; //队列里面的节点都是需要更新的
//        node pre,now;
//
//        for(int i=1;i<=n;i++)
//        {
//            dis[i][0]=dis[i][1]=inf;
//            dis[i][2]=inf; //只是用于标记当前（i,0）组合点己更新过的值
//            num[i][0]=num[i][1]=0;
//        }
//        now.v=sp; now.c=0; dis[sp][0]=0; num[sp][0]=1; q.push(now);
//
//        while(!q.empty())
//        {
//            pre=q.front(); q.pop();
//            inq[pre.v][pre.c]=0;
//
//            if(pre.c==0) //为下次被替换到次小值时，是否需要再一次根据当前值更新作判断依居
//                dis[pre.v][2]=dis[pre.v][0];
//
//            int k=mapt[pre.v].size();
//            for(int i=0;i<k;i++)
//            {
//                now.v=mapt[pre.v][i].v;
//
//                if(dis[now.v][0]>=dis[pre.v][pre.c]+mapt[pre.v][i].d)
//                {
//                    if(dis[now.v][0]>dis[pre.v][pre.c]+mapt[pre.v][i].d)
//                    {
//                        dis[now.v][1]=dis[now.v][0];
//                        num[now.v][1]=num[now.v][0];
//                        //当最小被替换成次小时，如果这个值没有更新过，就一定要放入队列
//                        now.c=1;
//                        if(inq[now.v][now.c]==0&&dis[now.v][now.c]!=dis[now.v][2])
//                            q.push(now),inq[now.v][now.c]=1;
//
//                        dis[now.v][0]=dis[pre.v][pre.c]+mapt[pre.v][i].d;
//                        num[now.v][0]=num[pre.v][pre.c];
//                    }
//                    else num[now.v][0]+=num[pre.v][pre.c];
//
//                    now.c=0;
//                    if(inq[now.v][now.c]==0)
//                        q.push(now),inq[now.v][now.c]=1;
//                }
//                else if(dis[now.v][1]>=dis[pre.v][pre.c]+mapt[pre.v][i].d)
//                {
//                    if(dis[now.v][1]>dis[pre.v][pre.c]+mapt[pre.v][i].d)
//                    {
//                        dis[now.v][1]=dis[pre.v][pre.c]+mapt[pre.v][i].d;
//                        num[now.v][1]=num[pre.v][pre.c];
//                    }
//                    else num[now.v][1]+=num[pre.v][pre.c];
//                    now.c=1;
//                    if(inq[now.v][now.c]==0)
//                        q.push(now),inq[now.v][now.c]=1;
//                }
//            }
//        }
//
//        if(dis[ep][1]==dis[ep][0]+1)
//            num[ep][0]+=num[ep][1];
//        return num[ep][0];
//    }
//    int main()
//    {
//        int t,n,m,a;
//        EDG ss;
//        scanf("%d",&t);
//        while(t--)
//        {
//            scanf("%d%d",&n,&m);
//            for(int i=1;i<=n;i++)
//                mapt[i].clear();
//            while(m--)
//            {
//                scanf("%d%d%d",&a,&ss.v,&ss.d);
//                mapt[a].push_back(ss);
//            }
//            int sp,ep;
//            scanf("%d%d",&sp,&ep);
//
//            printf("%d\n",spfa(sp,ep,n));
//        }
//    }
}
