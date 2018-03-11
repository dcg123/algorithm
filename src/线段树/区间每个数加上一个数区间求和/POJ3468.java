package 线段树.区间每个数加上一个数区间求和;

/**
 * Created by user on 2017/10/20.
 */
public class POJ3468 {

    /**
     * 树状数组
     *
     * 给你N个数，Q个操作，操作有两种，‘Q a b ’是询问a~b这段数的和，‘C a b c’是把a~b这段数都加上c。
     */
//    #include <iostream>
//#include <cstdio>
//#include <cstdlib>
//#include <cstring>
//#include <string>
//#include <queue>
//#include <algorithm>
//#include <map>
//#include <cmath>
//#include <iomanip>
//#define INF 99999999
//    typedef long long LL;
//    using namespace std;
//
//const int MAX=100000+10;
//    LL n,q;
//    LL sum[MAX],c1[MAX],c2[MAX];
//
//    LL lowbit(LL x){
//        return x&(-x);
//    }
//
//    void Update(LL x,LL d,LL *c){
//        while(x<=n){
//            c[x]+=d;
//            x+=lowbit(x);
//        }
//    }
//
//    LL Query(LL x,LL *c){
//        LL sum=0;
//        while(x>0){
//            sum+=c[x];
//            x-=lowbit(x);
//        }
//        return sum;
//    }
//
//    int main(){
//        char op[3];
//        LL x,y,d;
//        while(~scanf("%lld%lld",&n,&q)){
//            memset(c1,0,sizeof c1);
//            memset(c2,0,sizeof c2);
//            for(int i=1;i<=n;++i)scanf("%lld",sum+i),sum[i]+=sum[i-1];
//            for(int i=0;i<q;++i){
//                scanf("%s",op);
//                if(op[0] == 'C'){//ans[x]+=d,ans[y+1]-=d
//                    scanf("%lld%lld%lld",&x,&y,&d);
//                    Update(x,d,c1);
//                    Update(y+1,-d,c1);
//                    Update(x,x*d,c2);
//                    Update(y+1,-(y+1)*d,c2);
//                }else{
//                    scanf("%lld%lld",&x,&y);
//                    printf("%lld\n",sum[y]-sum[x-1]+Query(y,c1)*(y+1)-Query(x-1,c1)*x-Query(y,c2)+Query(x-1,c2));
//                }
//            }
//        }
//        return 0;
//    }

    //线段树
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
//            #define MAXN 100010
//
//    struct node
//    {
//        int l,r;
//        ll s,add;//add为每次加的数
//    }t[MAXN<<2];
//    int hh[MAXN];
//    int n,q;
//    ll ans;
//
//    void build(int l, int r, int i)
//    {
//        t[i].l = l;
//        t[i].r = r;
//        t[i].add = 0;
//        if(l == r) return ;
//        int mid = (l+r)>>1;
//        build(l, mid, i<<1);
//        build(mid+1, r, i<<1|1);
//        t[i].s = t[i<<1].s+t[i<<1|1].s;
//    }
//
//    void update(int l, int r, int add, int i)
//    {
//        if(t[i].l>r || t[i].r<l) return ;
//        if(t[i].l>=l && t[i].r<=r)
//        {
//            t[i].s += (t[i].r-t[i].l+1)*add;
//            t[i].add += add;
//            return ;
//        }
//        if(t[i].add)
//        {
//            t[i<<1].s += (t[i<<1].r-t[i<<1].l+1)*t[i].add;
//            t[i<<1].add += t[i].add;
//            t[i<<1|1].s += (t[i<<1|1].r-t[i<<1|1].l+1)*t[i].add;
//            t[i<<1|1].add += t[i].add;
//            t[i].add = 0;
//        }
//        update(l, r, add, i<<1);
//        update(l, r, add, i<<1|1);
//        t[i].s = t[i<<1].s+t[i<<1|1].s;
//    }
//
//    void query(int l, int r, int i)
//    {
//        if(t[i].l>r || t[i].r<l) return ;
//        if(t[i].l>=l && t[i].r<=r)
//        {
//            ans += t[i].s;
//            return ;
//        }
//        if(t[i].add)
//        {
//            t[i<<1].s += (t[i<<1].r-t[i<<1].l+1)*t[i].add;
//            t[i<<1].add += t[i].add;
//            t[i<<1|1].s += (t[i<<1|1].r-t[i<<1|1].l+1)*t[i].add;
//            t[i<<1|1].add += t[i].add;
//            t[i].add = 0;
//        }
//        query(l, r, i<<1);
//        query(l, r, i<<1|1);
//        t[i].s = t[i<<1].s+t[i<<1|1].s;
//    }
//
//    int main()
//    {
//        int a,b,c;
//        ll k;
//        char ch;
//        while(scanf("%d%d",&n,&q)==2)
//        {
//            for(int i=1; i<=n; i++)
//                scanf("%d",&hh[i]);
//            build(1, n, 1);
//            for(int i=1; i<=n; i++)
//                update(i, i, hh[i], 1);
//            while(q--)
//            {
//                getchar();
//                scanf("%c",&ch);
//                if(ch == 'C')
//                {
//                    scanf("%d%d%d",&a,&b,&c);
//                    update(a, b, c, 1);
//                }
//                if(ch == 'Q')
//                {
//                    ans = 0;
//                    scanf("%d%d",&a,&b);
//                    query(a, b, 1);
//                    printf("%lld\n",ans);
//                }
//            }
//        }
//        return 0;
//    }

}
