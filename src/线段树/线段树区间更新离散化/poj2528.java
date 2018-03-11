package 线段树.线段树区间更新离散化;

/**
 * Created by user on 2017/10/20.
 */
public class poj2528 {
    /**
     * 题目大意：给你一个无限长的板子，然后依次往上面贴n张等高的海报，问你最后能看到多少张海报。

     思路分析：线段树区间更新问题，但是要注意，给的长度的可能非常大，有1e9，不加处理直接维护一个线段树肯定会

     MLE,TLE,但是我们注意到一共最多只有2e4个点，因此我们可以用离散化的思想先对区间进行预处理，所谓的离散化，

     在我理解看来就是将一个很大的区间映射为一个很小的区间，而不改变原有的大小覆盖关系，但是注意简单的离散化可能
     */
//    #include <iostream>
//#include <cstdio>
//#include <cstring>
//#include <algorithm>
//#include <cmath>
//    using namespace std;
//const int maxn=20000+100;//点的数目
//    int tree[maxn<<4];
//    int li[maxn],ri[maxn];
//    int lisan[3*maxn];
//    bool visit[3*maxn];
//    void pushdown(int p)
//    {
//        tree[p<<1]=tree[(p<<1)|1]=tree[p];
//        tree[p]=-1;
//    }
//    void update(int p,int l,int r,int x,int y,int v)
//    {
//        if(x<=l&&y>=r)
//        {
//            tree[p]=v;
//            return;
//        }
//        if(tree[p]!=-1) pushdown(p);
//        int mid=(l+r)>>1;
//        if(y<=mid) update(p<<1,l,mid,x,y,v);
//        else if(x>mid) update((p<<1)|1,mid+1,r,x,y,v);
//        else update(p<<1,l,mid,x,mid,v),update((p<<1)|1,mid+1,r,mid+1,y,v);
//    }
//    int ans;
//    void query(int p,int l,int r)
//    {
//        //cout<<p<<endl;
//        if(tree[p]!=-1)
//        {
//            if(!visit[tree[p]])
//            {
//                ans++;
//                visit[tree[p]]=true;
//            }
//            return;
//        }
//        if(l==r) return;
//        //if(tree[p]!=-1) pushdown(p);
//        int mid=(l+r)>>1;
//        query(p<<1,l,mid);
//        query((p<<1)|1,mid+1,r);
//    }
//    int main()
//    {
//        int T;
//        scanf("%d",&T);
//        int n;
//        while(T--)
//        {
//            scanf("%d",&n);
//            memset(tree,-1,sizeof(tree));
//            memset(visit,false,sizeof(visit));
//            int tot=0;
//            for(int i=0;i<n;i++)
//            {
//                scanf("%d%d",&li[i],&ri[i]);
//                lisan[tot++]=li[i];
//                lisan[tot++]=ri[i];
//            }
//            sort(lisan,lisan+tot);//tot是数组长度
//            int m=unique(lisan,lisan+tot)-lisan;
//            int t=m;
//            for(int i=1;i<t;i++)
//            {
//                if(lisan[i]-lisan[i-1]>1)
//                    lisan[m++]=lisan[i-1]+1;
//            }
//            sort(lisan,lisan+m);
//            //for(int i=0;i<m;i++)
//            //cout<<lisan[i]<<" ";
//            //cout<<endl;
//            for(int i=0;i<n;i++)
//            {
//                int x=lower_bound(lisan,lisan+m,li[i])-lisan;
//                int y=lower_bound(lisan,lisan+m,ri[i])-lisan;
//                update(1,0,m-1,x,y,i);
//            }
//            ans=0;
//            query(1,0,m-1);
//            printf("%d\n",ans);
//        }
//    }
}
