package 数据结构.线段树.线段树单点更新和区间查询;

/**
 * Created by user on 2017/10/11.
 */
public class hdu1540 {
    /**
     * 大体思路比较简单，就是利用线段数求区间
     最大和最小值。
     这里假设其为              1 2 3 4 5 6 7
     则如果 其中有若干个村子被毁了，如果要求第4个村子
     只需求出来   1->4区间中被毁村子的最大值（2），

     和                 4->7 区间中被毁村子的最小值（5），

     根据两者求出村子的连续区间，即  2->5   所以其村子连续个数 为 5-2-1 = 2

     即minn - maxx -1


     特殊情况：  如果1 2 3 4 5 6 7 求2的连续区间 ，其最大为2，最小也为2

     则其连续个数为  0



     思路出来了，这里就借助线段树，来求区间的最大值和最小值。

     这里注意，对于没有被摧毁的村子，不加入到线段数节点，而是分别用

     0(求最大值时)和n+1(求最小值时)代替，这样能保证，其不影响加入村子的求极值

     而且最其在没有村子被摧毁的情况下，也能正确的求出解。

     例子：  1 2 3 4 5 6 7

     求村子3的连续区间，这里1->3  maxx为0  ;  3->n  minn为4

     所以其连续空间为4-0-1 =3  为正解

     可以自己再试其他例子



     到这里，线段树就构造好了

     求区间最大最小值，直接套线段树模板就好。

     下面直接上代码：






     [cpp] view plain copy
     #include <iostream>
     #include <stdio.h>
     #include <string.h>
     #include <math.h>
     #include <stdlib.h>
     #include <algorithm>
     #define INF 0x3f3f3f3f

     using namespace std;
     typedef long long ll;

     #define M 50015
     #define lson l,m,rt<<1
     #define rson m+1,r,rt<<1|1


     typedef struct SegTreeNode{
     int maxx;
     int minn;
     }segtree;   //线段树结构体，一个用来求最大值，一个用来求最小值

     segtree arr[M<<2];
     int n;
     int history[M<<2];//保存历史，用于R

     void build(int l,int r,int rt)//建树
     {
     if(l == r){
     arr[rt].minn = n+1;
     arr[rt].maxx = 0;
     return;
     }

     int m = (l+r)>>1;
     build(lson);
     build(rson);
     arr[rt].maxx = max(arr[rt<<1].maxx,arr[rt<<1|1].maxx);
     arr[rt].minn = min(arr[rt<<1].minn,arr[rt<<1|1].minn);
     }


     void update_maxx(int p,int sc,int l,int r ,int rt)//更新求最大值的线段树
     {
     if(l == r)
     {
     arr[rt].maxx = sc;
     return ;
     }
     int m = (l+r)>>1;

     if(p<=m)
     update_maxx(p,sc,lson);
     else
     update_maxx(p,sc,rson);

     arr[rt].maxx = max(arr[rt<<1].maxx,arr[rt<<1|1].maxx);
     }

     void update_minn(int p,int sc,int l,int r ,int rt)//更新求最小值的线段树
     {
     if(l == r)
     {
     arr[rt].minn = sc;
     return ;
     }
     int m = (l+r)>>1;

     if(p<=m)
     update_minn(p,sc,lson);
     else
     update_minn(p,sc,rson);

     arr[rt].minn = min(arr[rt<<1].minn,arr[rt<<1|1].minn);
     }






     int query_minn(int L,int R,int l,int r ,int rt)   //查找区间最小值
     {
     if(L<=l && r<=R)
     {
     return arr[rt].minn;
     }
     int m = (l + r) >>1;
     int ret = INF;
     if(L<=m)
     ret = min(ret,query_minn(L,R,lson));
     if(R>m)
     ret = min(ret,query_minn(L,R,rson));
     return ret;
     }


     int query_maxx(int L,int R,int l,int r ,int rt) //查找区间最大值
     {
     if(L<=l && r<=R)
     {
     return arr[rt].maxx;
     }
     int m = (l + r) >>1;
     int ret = 0;
     if(L<=m)
     ret = max(ret,query_maxx(L,R,lson));
     if(R>m)
     ret = max(ret,query_maxx(L,R,rson));
     return ret;
     }







     int main(int argc, char const *argv[])
     {
     int m,a,temp,count;
     char ch[10];
     while(scanf("%d %d",&n,&m) == 2)
     {
     count = 0;  //历史计算器
     memset(history,0,sizeof(history));
     memset(arr,0,sizeof(arr));
     build(1,n,1);
     while(m--)
     {
     scanf("%s",ch);
     if(ch[0] == 'D')
     {
     scanf("%d",&a);
     update_minn(a,a,1,n,1);//更新线段数的值，把a对应的值更新成a
     update_maxx(a,a,1,n,1);
     history[++count] = a;  //存储到历史记录中
     }
     else if(ch[0] == 'Q')
     {
     int re,max1,min1;
     scanf("%d",&a);
     max1=query_maxx(1,a,1,n,1);//根据线段树查询
     min1=query_minn(a,n,1,n,1);
     if(max1 == min1)         //考虑特殊情况
     printf("%d\n",0);
     else
     printf("%d\n",min1-max1-1);
     }
     else
     {
     temp = history[count--];
     update_minn(temp,n+1,1,n,1); //如果恢复，就把对应的值改为0或n+1
     update_maxx(temp,0,1,n,1);
     }
     }

     }
     return 0;
     }

     */
}
