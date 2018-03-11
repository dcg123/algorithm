package 线段树.区间更新单点查询;

/**
 * Created by user on 2017/10/20.
 */
public class hdu3974 {
    /**
     * 题意： 给定一棵树，50000个节点，50000个操作，
     * C x表示查询x节点的值，T x y表示更新x节点及其子节点的值为y。。
     */
//    #include <string.h>
//#include <stdio.h>
//#include <algorithm>
//#include <cmath>
//#include <vector>
//#include <map>
//#include <iostream>
//    using namespace std;
//
//const int N=100010;
//    struct node
//    {
//        int l, r, mid;
//        int value, lazy, parent;
//    } tr[N*4];
//    int n, m, up, l[N], r[N], first[N], edge[N], next[N], f[N];
//    int value;
//
//    void add(int x, int y)
//    {
//        f[x] = y;
//        edge[up] = x;
//        next[up] = first[y];
//        first[y] = up++;
//    }
//    int findset(int i)
//    {
//        while(f[i]!=i)
//            i = f[i];
//        return i;
//    }
//    void dfs(int p)
//    {
//        int i;
//        i = first[p];
//        l[p] = up;
//        while(i!=-1)
//        {
//            dfs(edge[i]);
//            i = next[i];
//        }
//        r[p] = up++;
//    }
//    void build(int l, int r, int p)
//    {
//        tr[p].l = l;
//        tr[p].r = r;
//        tr[p].value = -1;
//        tr[p].lazy = -1;
//        tr[p].parent = -1;
//        tr[p].mid = (l+r)>>1;
//        if(l==r)
//            return;
//        build(l, tr[p].mid, p*2);
//        build(tr[p].mid+1, r, p*2+1);
//    }
//    void down(int p)
//    {
//        if(tr[p].lazy!=-1)
//        {
//            tr[p*2].value = tr[p].lazy;
//            tr[p*2].lazy = tr[p].lazy;
//            tr[p*2].parent = tr[p].lazy;
//            tr[p*2+1].value = tr[p].lazy;
//            tr[p*2+1].lazy = tr[p].lazy;
//            tr[p*2+1].parent = tr[p].lazy;
//            tr[p].lazy = -1;
//        }
//    }
//    void update(int l, int r, int p)
//    {
//        if(l==tr[p].l && r==tr[p].r)
//        {
//            tr[p].value = value;
//            tr[p].lazy = value;
//            return ;
//        }
//        down(p);
//        if(r<=tr[p].mid)
//            update(l, r, p*2);
//        else if(l>tr[p].mid)
//            update(l, r, p*2+1);
//        else
//        {
//            update(l, tr[p].mid, p*2);
//            update(tr[p].mid+1, r, p*2+1);
//        }
//    }
//    int query(int l, int r, int p)
//    {
//        if(l==tr[p].l && r==tr[p].r)
//            return tr[p].value;
//        down(p);
//        if(r<=tr[p].mid)
//            return query(l, r, p*2);
//        else if(l>tr[p].mid)
//            return query(l, r, p*2+1);
//        else
//        {
//            return tr[p*2].parent;
//        }
//    }
//    int main()
//    {
//        char s[20];
//        int i, j, x, y, cas, cas1, root;
//
//        scanf("%d", &cas);
//        cas1 = 1;
//        while(cas--)
//        {
//            scanf("%d", &n);
//            for(i=1; i<=n; i++)
//            {
//                first[i] = -1;
//                f[i] = i;
//            }
//
//            up = 1;
//            for(i=1; i<n; i++)
//            {
//                scanf("%d %d", &x, &y);
//                add(x, y);
//            }
//
//            root = findset(1);
//            up = 1;
//            dfs(root);
//            up--;
//            //for(i=1; i<=5; i++)
//            //	printf("i=%d...%d %d...\n", i, l[i],  r[i]);
//
//            build(1, up, 1);
//            printf("Case #%d:\n", cas1++);
//            scanf("%d", &m);
//            while(m--)
//            {
//                scanf("%s", s);
//                if(s[0]=='C')
//                {
//                    scanf("%d", &x);
//                    printf("%d\n", query(r[x], r[x], 1));
//                }
//                else
//                {
//                    scanf("%d %d", &x, &value);
//                    update(l[x], r[x], 1);
//                }
//            }
//        }
//        return 0;
//    }
}
