package 线段树.区间更新区间查询;

/**
 * Created by user on 2017/10/20.
 */
public class hdu1698 {
    /**
     * 题意：一段线段由n条小线段组成，每次操作把一个区间的小线
     * 段变成金银铜之一（金的价值为3，银为2，铜为1），
     * 最初可当做全为铜；最后求这条线段的总价值。
     */
    //树状数组

//    #include <iostream>
//#include <cstdio>
//#include <cstring>
//#include <stack>
//#include <queue>
//#include <map>
//#include <set>
//#include <vector>
//#include <cmath>
//#include <algorithm>
//    using namespace std;
//const double eps = 1e-6;
//const double pi = acos(-1.0);
//const int INF = 0x3f3f3f3f;
//const int MOD = 1000000007;
//#define ll long long
//#define CL(a,b) memset(a,b,sizeof(a))
//            #define MAXN 100000+10
//
//    struct node
//    {
//        int l,r,s;
//    }t[MAXN<<2];
//    int n,sum;
//
//    void build(int l, int r, int num)
//    {
//        t[num].l = l;
//        t[num].r = r;
//        t[num].s = 1;
//        if(l == r) return ;
//        int mid = (l+r)>>1;
//        build(l, mid, num<<1);
//        build(mid+1, r, num<<1|1);
//    }
//
//    void update(int l, int r, int m, int num)
//    {
//        if(t[num].s == m) return ;//如果是相同的，就不用改了
//        if(t[num].l == l && t[num].r == r)//
//        {
//            t[num].s = m;
//            return ;
//        }
//        if(t[num].s != -1)//该区间只有一种颜色
//        {
//            t[num<<1].s = t[num<<1|1].s = t[num].s;//把他的所有子节点变为父结点一样的颜色
//            t[num].s = -1;//由于该区域颜色与修改不同，所以该区域由纯色变为杂色
//        }
//        //父区间为杂色对所有子节点进行处理
//        int mid = (t[num].l+t[num].r)>>1;
//        if(l > mid)
//            update(l, r, m, num<<1|1);
//        else if(r <= mid)
//            update(l, r, m, num<<1);
//        else
//        {
//            update(l, mid, m, num<<1);
//            update(mid+1, r, m, num<<1|1);
//        }
//    }
//
//    int query(int num)
//    {
//        if(t[num].s != -1)//纯色直接找
//            return (t[num].r-t[num].l+1)*t[num].s;
//        else//不纯就找左右子树
//            return query(num<<1)+query(num<<1|1);
//    }
//
//    int main()
//    {
//        int x,y,z,T,k;
//        int cas = 1;
//        scanf("%d",&T);
//        while(T--)
//        {
//            scanf("%d%d",&n,&k);
//            build(1, n, 1);
//            while(k--)
//            {
//                scanf("%d%d%d",&x,&y,&z);
//                update(x, y, z, 1);
//            }
//            printf("Case %d: The total value of the hook is %d.\n",cas++,query(1));
//        }
//        return 0;
//    }

}
