package LCA;

/**
 * Created by user on 2017/10/18.
 */
public class 连通分量LCA {
    /**
     * poj3694
     * 连通分量+LCA
     * 一个网络管理员管理一个网络，网络中的电脑直接或间接的相连接，管理员有Q次操作，每次向网络中建立一条新边，向管理员报告桥的个数。

     思路：先将网络中的桥求出来，在求的过程中进行并查集缩点，在询问的时候，进行最朴素的LCA查找最近公共祖先，在求的过程中判断节点与父节点是不是在同一个集合中，
     如果不在同一个集合，说明是桥，则这个桥将不存在，将两个集合合并。
     */
//    #include<iostream>
//#include<string>
//#include<cstdio>
//#include
//#include<cmath>
//#include<cstring>
//#include<vector>
//    using namespace std;
//    vector<int>tu[100001];
//    int dfn[100001], low[100001], clj, jc, die[100001], bcj[100001], zouguo[100001],qiao[100001];
//    int zhao(int x)
//    {
//        return bcj[x] == -1 ? x : bcj[x] = zhao(bcj[x]);
//    }
//    void hebing(int a, int b)
//    {
//        int q = zhao(a), w = zhao(b);
//        if (q != w)bcj[q] = w;
//    }
//    void tarjan(int dian, int ba)
//    {
//        dfn[dian] = low[dian] =++clj;
//        die[dian] = ba;
//        for (int a = 0; a<tu[dian].size(); else="" if="" int="" void="" while="" x="" xx="zhao(die[u]);">dfn[w])
//        {
//            ceshi(q);
//            q = die[q];
//        }
//        while (dfn[q]<dfn[w]) cin="" int="" q="die[q]," u="0;" w="die[w];" while="">> n >> m)
//        {
//            if (n == 0 && m == 0)break;
//            clj = 0, jc = 0;
//            memset(dfn, 0, sizeof(dfn));
//            memset(zouguo, 0, sizeof(zouguo));
//            memset(low, 0, sizeof(low));
//            //memset(die, 0, sizeof(die));
//            memset(bcj, -1, sizeof(bcj));
//            for (int a = 1; a <= n; a++)tu[a].clear();
//            int q, w;
//            for (int a = 1; a <= m; a++)
//            {
//                scanf("%d%d", &q, &w);
//                tu[q].push_back(w);
//                tu[w].push_back(q);
//            }
//            tarjan(1, 0);
//            //cout << jc << endl;
//            cin >> k;
//            printf("Case %d:\n", ++u);
//            for (int a = 1; a <= k; a++)
//            {
//                scanf("%d%d", &q, &w);
//                if (zhao(q) != zhao(w))lca(q, w);
//                printf("%d\n", jc);
//            }
//            cout << endl;
//        }
//        return 0;
}
