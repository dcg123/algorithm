package 最大二分匹配.有向图最小路径覆盖;

/**
 * Created by user on 2017/10/19.
 */
public class poj2060 {
    /**
     * 题意：
     有n个任务，如果时间来得及干完某些任务后还可以接着干别的任务，
     给一个任务清单，问最少派出去多少人能完成所有任务。
     思路：
     比较简单的追小路径覆盖问题了，在DAG中找到最少的简单路径去覆盖所有点，
     结论等于n-最大匹配数，可以这样理解，最开始没有边任务都需要一个人，共n个，
     然后只要有一条边（干完A活来的及干B活那么连边AB）,就有可能减少一个人，
     当A-B A-C这样的时候只能节省其中的一条，匹配也是，
     只能把A匹配给一个，这样说是不是很容易理解为什么最小路径覆盖的结论是n-最大匹配数了吧。
     */
//    #include<iostream>
//#include<cstdio>
//#include<cstring>
//#include<cstdlib>
//#include<algorithm>
//#include<cmath>
//#include<queue>
//#include<stack>
//#include<ctime>
//    using namespace std;
//    int n,t;
//    struct node
//    {
//        int time,time2;
//        int x1,y1,x2,y2;
//    }a[501];
//    int f[501][501],match[501],vis[501],dfscnt;
//    int suan(int x1,int y1,int x2,int y2)
//    {
//        return abs(x2-x1)+abs(y2-y1);
//    }
//    bool dfs(int root)
//    {
//        int i;
//        for(i=1;i<=n;i++)
//        {
//            if(f[root][i])
//            {
//                if(vis[i]!=dfscnt)
//                {
//                    vis[i]=dfscnt;
//                    if(!match[i]||dfs(match[i]))
//                    {
//                        match[i]=root;
//                        return 1;
//                    }
//                }
//            }
//        }
//        return 0;
//    }
//    int main()
//    {
//        int i,j;
//        scanf("%d",&t);
//        while(t--)
//        {
//            memset(f,0,sizeof(f));
//            memset(match,0,sizeof(match));
//            memset(vis,0,sizeof(vis));
//            dfscnt=0;
//            scanf("%d",&n);
//            for(i=1;i<=n;i++)
//            {
//                int hour,minute;
//                scanf("%d:%d",&hour,&minute);
//                a[i].time=hour*60+minute;
//                scanf("%d%d%d%d",&a[i].x1,&a[i].y1,&a[i].x2,&a[i].y2);
//                a[i].time2=a[i].time+suan(a[i].x1,a[i].y1,a[i].x2,a[i].y2);
//            }
//            for(i=1;i<=n;i++)
//            {
//                for(j=i;j<=n;j++)
//                {
//                    if(a[i].time2+suan(a[i].x2,a[i].y2,a[j].x1,a[j].y1)<a[j].time)
//                        f[i][j]=1;
//                }
//            }
//            int ans=0;
//            for(i=1;i<=n;i++)
//            {
//                dfscnt++;
//                if(dfs(i))ans++;
//            }
//            printf("%d\n",n-ans);
//        }
//    }
}
