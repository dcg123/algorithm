package 最大二分匹配.有向图最小路径覆盖;

/**
 * Created by user on 2017/10/19.
 */
public class poj3216 {
    /**
     *  首先说一下题意，Q个区域，M个任务，每个区域任务可能有多个，
     *  然后给你个到各地所需时间的矩阵，每个任务都有开始和持续时间，问最少需要多少工人？ 每个工人只能同时执行一个任务。
     通过题意，我的瞬间反应就是先把点拆开再说，因为每个区域可能有多个任务，所以把每个任务都当做一点处理，之后就需要考虑一件事情，一个工人在Qi区域做完之后是不是应该去一个离他最近且正好有任务的地方Qj，那么他从Qi到Qj是不是应该走最近的路线？ 下一步就出来了，求出所有区域之间的最短距离，用floyd一键搞定。然后就可以建图（有向的）了，把能衔接起来的任务统统连上，按照上一个任务的开始时间+持续时间+到下一点的时间<=下一点的开始时间来连边（不用换区域的到下一点的时间为零），
     那么此时的问题就变成了多少个工人能把图走完？  即最小路径覆盖，直接匈牙利算法搞定。
     */
//    #include<cstdio>
//#include<cstring>
//#include<iostream>
//#include<vector>
//#define maxn 500
//            #define inf 0xfffffff
//    using namespace std;
//
//    struct edge
//    {
//        int pos,realpos,start,need;
//    }rela[maxn];
//    vector<int> q[maxn];
//    int mize[maxn][maxn],point[maxn];
//    int vis[maxn],link[maxn];
//    int n,m,sum;
//    void init()
//    {
//        for(int i=0;i<=maxn;i++)
//            q[i].clear();
//        memset(rela,0,sizeof(rela));
//        memset(mize,0,sizeof(mize));
//        memset(point,0,sizeof(point));
//        for(int a=1;a<=n;a++)
//            for(int b=1;b<=n;b++)
//            {
//                scanf("%d",&mize[a][b]);
//                if(mize[a][b]==-1) mize[a][b]=inf;
//            }
//
//        for(int c=1;c<=m;c++)
//        {
//            scanf("%d %d %d",&rela[c].pos,&rela[c].start,&rela[c].need);
//            int p=0;
//            for(int d=1;d<c;d++)
//            {
//                if(rela[d].pos==rela[c].pos) p++;
//            }
//            rela[c].realpos=rela[c].pos+n*p;
//            point[rela[c].realpos]=1;
//            if(sum<rela[c].realpos) sum=rela[c].realpos;
//        }
//    }
//    void floyd()
//    {
//        for(int i=1;i<=n;i++)
//        {
//            for(int j=1;j<=n;j++)
//            {
//                for(int k=1;k<=n;k++)
//                {
//                    mize[j][k]=mize[j][k]<mize[i][k]+mize[j][i]?mize[j][k]:mize[i][k]+mize[j][i];
//                }
//            }
//        }
//
//
//    }
//    void set_map()
//    {
//        for(int i=1;i<=m;i++)
//        {
//            int realpos=rela[i].realpos,pos=rela[i].pos,time=rela[i].need+rela[i].start;
//            for(int j=1;j<=m;j++)
//            {
//                if(j==i) continue;
//                int a=rela[j].realpos,b=rela[j].pos,t=rela[j].start;
//                //       if(mize[pos][b]==-1||mize[b][pos]==-1) continue;
//                if(time+mize[pos][b]<=t)     // 矩阵式对称的  怎么写都无所谓
//                {
//                    q[realpos].push_back(a);
//                    //     q[a].push_back(realpos);
//                }
//            }
//        }
// /*   for(int i=1;i<=8;i++)
//    {
//        if(q[i].size()==0) continue;
//        cout<<i<<": "<<endl;
//        for(int j=0;j<q[i].size();j++)
//        {
//            cout<<q[i][j]<<" ";
//        }
//        cout<<endl;
//    }*/
//    }
//    int dfs(int x)
//    {
//        for(int i=0;i<q[x].size();i++)
//        {
//            int y=q[x][i];
//            if(!vis[y])
//            {
//                vis[y] = true;
//                if(link[y]== -1||dfs(link[y]))
//                {
//                    link[y] = x;
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//    void solve()
//    {
//        int s=0;
//        memset(link,-1,sizeof(link));
//        for(int i=1;i<=sum;i++)
//        {
//            if(point[i]==0) continue;
//            memset(vis,0,sizeof(vis));
//            if(dfs(i)) s++;
//        }
//        printf("%d\n",m-s);
//    }
//    int main()
//    {
//        while(scanf("%d%d",&n,&m)!=EOF)
//        {
//            if(n==0&&m==0) break;
//            sum=0;
//            init();
//            floyd();
//            set_map();
//            solve();
//        }
//        return 0;
//    }
}
