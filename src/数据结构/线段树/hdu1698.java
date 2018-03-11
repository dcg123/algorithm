package 数据结构.线段树;

/**
 * Created by user on 2017/10/11.
 */
public class hdu1698 {
    //线段树建树，修改，求最值。。
    /**
     * #include<cstdio>
     #include<algorithm>
     #define LL(x) x<<1
     #define RR(x) x<<1|1
     using namespace std;
     const int maxn=2e5+7;
     const int INF=-1e9+7;
     int a[maxn<<2];
     void build(int now,int l,int r)
     {
     if(l==r)
     {
     scanf("%d",&a[now]);
     return ;
     }
     int mid=(l+r)>>1;
     build(LL(now),l,mid);
     build(RR(now),mid+1,r);
     a[now]=max(a[LL(now)],a[RR(now)]);
     }
     void update(int now,int l,int r,int p,int val)
     {
     int mid=(l+r)>>1;
     if(l==r)    a[now]=val;
     else
     {
     if(p<=mid) update(LL(now),l,mid,p,val);
     else update(RR(now),mid+1,r,p,val);
     a[now]=max(a[LL(now)],a[RR(now)]);
     }
     }
     int query(int now,int l,int r,int ql,int qr)
     {
     int mid=(l+r)>>1,res=INF;
     if(ql<=l&&qr>=r) return a[now];
     if(ql<=mid) res=max(res,query(LL(now),l,mid,ql,qr));
     if(qr>mid) res=max(res,query(RR(now),mid+1,r,ql,qr));
     return res;
     }
     int main()
     {
     int n,m,l,r;
     char option[3];
     while(~scanf("%d%d",&n,&m))
     {
     build(1,1,n);
     for(int i=0;i<m;i++)
     {
     scanf("%s",option);
     if(option[0]=='Q')
     {
     scanf("%d%d",&l,&r);
     printf("%d\n",query(1,1,n,l,r));
     }
     else if(option[0]=='U')
     {
     scanf("%d%d",&l,&r);
     update(1,1,n,l,r);
     }
     }
     }
     return 0;
     }

     */
}
