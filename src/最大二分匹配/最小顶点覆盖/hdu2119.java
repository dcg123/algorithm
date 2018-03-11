package 最大二分匹配.最小顶点覆盖;

/**
 * Created by user on 2017/10/12.
 */
public class hdu2119 {
    /**
     * 给你一个矩阵（只包含0或1），每次你可以选择一行或一列，并删除这一行或这一列中的所有'1'。

     您的任务是发出删除矩阵中所有“1”的最短时间。
     */
//    #include<cstdio>
//#include<cstring>
//#include<queue>
//#include<vector>
//#include<cmath>
//#include<iostream>
//#include<algorithm>
//    using namespace std;
//    vector<int>V[1000];
//    int link[1000],use[1000];
//    void init(int n)
//    {
//        int i;
//        for(i=0;i<=n;i++)
//            V[i].clear();
//    }
//    bool Dfs(int v)
//    {
//        int i,j,k;
//        for(i=0;i<V[v].size();i++)
//        {
//            k=V[v][i];
//            if(!use[k])
//            {
//                use[k]=1;
//                if(!link[k]||Dfs(link[k]))
//                {
//                    link[k]=v;
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//    int MaxMatch(int n)
//    {
//        int i,j,ans=0;
//        memset(link,0,sizeof(link));
//        for(i=1;i<=n;i++)
//        {
//            memset(use,0,sizeof(use));
//            if(Dfs(i))
//                ans++;
//        }
//        return ans;
//
//    }
//    int main()
//    {
//        int i,j,n,m,k,t;
//        while(scanf("%d",&n)&&n)
//        {
//            scanf("%d",&m);
//            init(n);
//            k=0;
//            for(i=1;i<=n;i++)
//                for(j=1;j<=m;j++)
//                {
//                    scanf("%d",&t);
//                    if(t)
//                    {
//                        k++;
//                        V[i].push_back(j);
//                    }
//                }
//            int ans=MaxMatch(n);
//            printf("%d\n",ans);
//        }
//    }
}
