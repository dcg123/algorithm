package 线段树.查询区间最大值单点更新;

/**
 * Created by user on 2017/10/14.
 */
public class hdu1754 {
    /**
     * 第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩。
     接下来有M行。每一行有一个字符 C (只取'Q'或'U') ，和两个正整数A，B。
     当C为'Q'的时候，表示这是一条询问操作，它询问ID从A到B(包括A,B)的学生当中，成绩最高的是多少。
     当C为'U'的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。
     */
//    #include<iostream>
//#include<algorithm>
//#include<string>
//#include<cstdio>
//#include<cstring>
//#include<cmath>
//    using namespace std;
//    int MAX[4000001];
//    int max(int a,int b)
//    {
//        return a>b?a:b;
//    }
//    void PushUp(int rt)
//    {
//        MAX[rt]=max(MAX[rt<<1],MAX[(rt<<1)+1]);
//    }
//    void build(int l,int r,int rt)
//    {
//        if(l==r)
//        {
//            scanf("%d",&MAX[rt]);
//            return;
//        }
//        int m=(l+r)>>1;
//        build(l,m,rt<<1);
//        build(m+1,r,(rt<<1)+1);
//        PushUp(rt);
//    }
//    void update(int p,int q,int l,int r,int rt)
//    {
//        if(l==r)
//        {
//            MAX[rt]=q;
//            return;
//        }
//        int m=(l+r)>>1;
//        if(p<=m)
//            update(p,q,l,m,rt<<1);
//        else
//            update(p,q,m+1,r,(rt<<1)+1);
//        PushUp(rt);
//    }
//    int getmax(int L,int R,int l,int r,int rt)
//    {
//        if(L<=l&&r<=R)
//            return MAX[rt];
//        int m=(r+l)>>1;
//        int ret=0;
//        if(L<=m)
//            ret=max(ret,getmax(L,R,l,m,rt<<1));
//        if(R>m)
//            ret=max(ret,getmax(L,R,m+1,r,(rt<<1)+1));
//        return ret;
//    }
//    int main()
//    {
//        int n,m,a,b,i;
//        char c;
//        while(~scanf("%d %d",&n,&m))
//        {
//            build(1,n,1);
//            for(i=0;i<m;i++)
//            {
//                scanf("%*c%c%d %d",&c,&a,&b);
//                if(c=='Q')
//                    printf("%d\n",getmax(a,b,1,n,1));
//                else
//                    update(a,b,1,n,1);
//            }
//        }
//        return 0;
//    }
}


//#include<iostream>
//#include<cstdio>
//using namespace std;
//
//        const int MAXN = 2e5 + 111;
//
//        int maxVal[MAXN], a[MAXN];
//
//        int lowbit(int x)
//        {
//        return x & -x;
//        }
//
//        void init(int n)
//        {
//        for (int i = 1; i <= n; ++i)
//        {
//        scanf("%d", &a[i]);
//        maxVal[i] = a[i];
//        for (int j = 1; j < lowbit(i); j <<= 1)  // 与所有涉及到的子区间段最大值比较
//        {
//        maxVal[i] = max(maxVal[i], maxVal[i - j]);
//        }
//        }
//        }
//
//        int getMax(int l, int r)
//        {
//        int ret = a[r];
//        while (l != r)
//        {
//        for (r -= 1; r - lowbit(r) >= l; r -= lowbit(r)) // 1.判断是区间是否在查询范围内
//        {
//        ret = max(ret, maxVal[r]);
//        }
//        ret = max(ret, a[r]); // 2.如果不在查询范围内，则只能将第r个数加入判断
//        }
//        return ret;
//        }
//
//        void update(int x, int val, int n) // 单单改变父亲结点是不够的，因为无法确定这段区间中的最大值来自哪里，
//        {                                  // 所以还需要与子区间进行比较确定最大值
//        a[x] = val;
//        for (int i = x; i <= n; i += lowbit(i))
//        {
//        maxVal[i] = a[i];
//        for (int j = 1; j < lowbit(i); j <<= 1)
//        {
//        maxVal[i] = max(maxVal[i], maxVal[i - j]);
//        }
//        }
//        }
//
//
//        int main()
//        {
//        int n, m, a, b;
//        while (~scanf("%d%d", &n, &m))
//        {
//        init(n);
//        char op[2];
//        for (int i = 0; i < m; ++i)
//        {
//        scanf("%s%d%d", op, &a, &b);
//        if (op[0] == 'Q') printf("%d\n", getMax(a, b));
//        else update(a, b, n);
//        }
//        }
//        return 0;
//        }