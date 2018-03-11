package 线段树.区间合并;

/**
 * Created by user on 2017/10/20.
 */
public class hdu4553 {
    /**
     * 　　寒假来了，又到了小明和女神们约会的季节。
     　　小明虽为屌丝级码农，但非常活跃，女神们常常在小明网上的大段发言后热情回复“呵呵”，所以，小明的最爱就是和女神们约会。与此同时，也有很多基友找他开黑，由于数量实在过于巨大，怎么安排时间便成了小明的一大心事。
     　　我们已知小明一共有T的空闲时间，期间会有很多女神或者基友来找小明。
     　　作为一个操作系统曾经怒考71分的大神，小明想到了一个算法，即“首次适应算法”，根据操作系统课本的描述，就是找一段最靠前的符合要求的连续空间分配给每个请求，由此小明做出了一个决定：
     　　当一个基友来找小明时，小明就根据“首次适应算法”来找一段空闲的时间来和基友约好，如果找到，就说“X,let’s fly”（此处，X为开始时间），否则就说“fly with yourself”；
     　　当女神来找小明时，先使用一次“首次适应算法”，如果没有找到，小明就冒着木叽叽的风险无视所有屌丝基友的约定，再次使用“无视基友首次适应算法”，两次只要有一次找到，就说“X,don’t put my gezi”（此处，X为开始时间），否则就说“wait for me”
     　　当然，我们知道小明不是一个节操负无穷的人，如果和女神约会完，还有剩余时间，他还是会和原来约好的基友去dota的。（举个例子：小西（屌丝）和小明约好在1~5这个时间单位段内打dota，这时候，女神来和小明预约长度为3的时间段，那么最终就是1~3小明去和女神约会，搞定后在4~5和小西打dota）
     　　小明偶尔也会想要学习新知识，此时小明就会把某一个时间区间的所有已经预定的时间全部清空用来学习并且怒吼“I am the hope of chinese chengxuyuan!!”，不过小明一般都是三分钟热度，再有人来预定的话，小明就会按耐不住寂寞把学习新知识的时间分配出去。
     输入第一行为CASE，表示有CASE组测试数据；
     每组数据以两个整数T，N开始，T代表总共的时间，N表示预约请求的个数；
     接着的N行，每行表示一个女神或者基友的预约，“NS QT”代表一个女神来找小明约一段长为QT的时间，“DS QT”则代表一个屌丝的长为QT的请求，当然也有可能是小明想学知识了，“STUDY!! L R”代表清空L~R区间内的所有请求。

     [Technical Specification]
     1. 1 <= CASE <= 30
     2. 1 <= T, N <= 100000
     3. 1 <= QT <= 110000
     4. 1 <= L <= R <=T
     */

//    #include <stdio.h>
//#include <string.h>
//#include <algorithm>
//    using namespace std;
//
//const int L = 100000+10;
//
//    struct node
//    {
//        int d,n,s;
//        int ls,rs,ms;//屌丝标记
//        int nsl,nsr,nsm;//女神标记
//    } a[L<<2];
//
//    void diaosi(int l,int r,int i)
//    {
//        a[i].d = 1;
//        a[i].ls = a[i].rs = a[i].ms = 0;
//    }
//
//    void nvshen(int l,int r,int i)
//    {
//        a[i].n = 1;
//        a[i].d = 0;
//        a[i].ls = a[i].rs = a[i].ms = 0;
//        a[i].nsl = a[i].nsr = a[i].nsm = 0;
//    }
//
//    void xuexi(int l,int r,int i)
//    {
//        a[i].s = 1;
//        a[i].d = a[i].n = 0;
//        a[i].ls = a[i].rs = a[i].ms = r-l+1;
//        a[i].nsl = a[i].nsr = a[i].nsm = r-l+1;
//    }
//
//    void pushup(int l,int r,int i)
//    {
//        int mid = (l+r)>>1;
//        a[i].ms = max(a[2*i].ms,a[2*i+1].ms);
//        a[i].ms = max(a[i].ms,a[2*i].rs+a[2*i+1].ls);
//        a[i].ls = a[2*i].ls;
//        a[i].rs = a[2*i+1].rs;
//        if(a[2*i].ls == mid-l+1)
//            a[i].ls+=a[2*i+1].ls;
//        if(a[2*i+1].rs == r-mid)
//            a[i].rs+= a[2*i].rs;
//
//        a[i].nsm = max(a[2*i].nsm,a[2*i+1].nsm);
//        a[i].nsm = max(a[i].nsm,a[2*i].nsr+a[2*i+1].nsl);
//        a[i].nsl = a[2*i].nsl;
//        a[i].nsr = a[2*i+1].nsr;
//        if(a[2*i].nsl == mid-l+1)
//            a[i].nsl+=a[2*i+1].nsl;
//        if(a[2*i+1].nsr == r-mid)
//            a[i].nsr+= a[2*i].nsr;
//    }
//
//    void pushdown(int l,int r,int i)
//    {
//        int mid = (l+r)>>1;
//        if(a[i].s)
//        {
//            xuexi(l,mid,2*i);
//            xuexi(mid+1,r,2*i+1);
//            a[i].s = 0;
//        }
//        if(a[i].d)
//        {
//            diaosi(l,mid,2*i);
//            diaosi(mid+1,r,2*i+1);
//            a[i].d = 0;
//        }
//        if(a[i].n)
//        {
//            nvshen(l,mid,2*i);
//            nvshen(mid+1,r,2*i+1);
//            a[i].n = 0;
//        }
//    }
//
//    void study(int L,int R,int l,int r,int i)
//    {
//        if(L == l && R == r)
//        {
//            xuexi(l,r,i);
//            return ;
//        }
//        int mid  = (l+r)>>1;
//        pushdown(l,r,i);
//        if(R<=mid)
//            study(L,R,l,mid,2*i);
//        else if(L>mid)
//            study(L,R,mid+1,r,2*i+1);
//        else
//        {
//            study(L,mid,l,mid,2*i);
//            study(mid+1,R,mid+1,r,2*i+1);
//        }
//        pushup(l,r,i);
//    }
//
//
//    void insert(int flag,int L,int R,int l,int r,int i)
//    {
//        if(l == L && r == R)
//        {
//            if(!flag)
//                diaosi(l,r,i);
//            else
//                nvshen(l,r,i);
//            return ;
//        }
//        int mid  = (l+r)>>1;
//        pushdown(l,r,i);
//        if(R<=mid)
//            insert(flag,L,R,l,mid,2*i);
//        else if(L>mid)
//            insert(flag,L,R,mid+1,r,2*i+1);
//        else
//        {
//            insert(flag,L,mid,l,mid,2*i);
//            insert(flag,mid+1,R,mid+1,r,2*i+1);
//        }
//        pushup(l,r,i);
//    }
//
//    int query(int flag,int t,int l,int r,int i)
//    {
//        if(l==r)
//            return l;
//        int mid = (l+r)>>1;
//        pushdown(l,r,i);
//        if(!flag)
//        {
//            if(a[2*i].ms>=t)
//                return query(flag,t,l,mid,2*i);
//            else if(a[2*i].rs+a[2*i+1].ls>=t)
//                return mid-a[2*i].rs+1;
//            else
//                return query(flag,t,mid+1,r,2*i+1);
//        }
//        else
//        {
//            if(a[2*i].nsm>=t)
//                return query(flag,t,l,mid,2*i);
//            else if(a[2*i].nsr+a[2*i+1].nsl>=t)
//                return mid-a[2*i].nsr+1;
//            else
//                return query(flag,t,mid+1,r,2*i+1);
//        }
//    }
//
//
//    int main()
//    {
//        int t,i,x,y,ans,cas = 1,n,m;
//        char str[20];
//        scanf("%d",&t);
//        while(t--)
//        {
//            scanf("%d%d",&n,&m);
//            printf("Case %d:\n",cas++);
//            study(1,n,1,n,1);
//            while(m--)
//            {
//                scanf("%s",str);
//                if(str[0] == 'D')
//                {
//                    scanf("%d",&x);
//                    if(a[1].ms<x)//线段树最大的区间都小于给定的时间就不用找了
//                        printf("fly with yourself\n");
//                    else
//                    {
//                        ans = query(0,x,1,n,1);
//                        insert(0,ans,ans+x-1,1,n,1);
//                        printf("%d,let's fly\n",ans);
//                    }
//                }
//                else if(str[0] == 'N')
//                {
//                    scanf("%d",&x);
//                    if(a[1].ms<x)
//                    {
//                        if(a[1].nsm<x)
//                            printf("wait for me\n");
//                        else
//                        {
//                            ans = query(1,x,1,n,1);
//                            insert(1,ans,ans+x-1,1,n,1);
//                            printf("%d,don't put my gezi\n",ans);
//                        }
//                    }
//                    else
//                    {
//                        ans = query(0,x,1,n,1);
//                        insert(1,ans,ans+x-1,1,n,1);
//                        printf("%d,don't put my gezi\n",ans);
//                    }
//                }
//                else
//                {
//                    scanf("%d%d",&x,&y);
//                    study(x,y,1,n,1);
//                    printf("I am the hope of chinese chengxuyuan!!\n");
//                }
//            }
//        }
//
//        return 0;
//    }

}
