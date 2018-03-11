package 并查集.有向图并查集;

/**
 * Created by user on 2017/10/11.
 */
public class hdu1325 {
    /**
     * 问题描述
     一棵树是一个众所周知的数据结构，它是空的（null，void，nothing），
     或者是一组一个或多个通过定向边连接的节点，满足以下属性。
     只有一个节点，称为根，没有定向边缘指向。

     除根之外的每个节点都有一个指向它的边。

     有从根到每个节点的有向边的唯一序列。

     例如，考虑下面的插图，其中节点由圆圈表示，边缘由带箭头的线表示。前两个是树，但最后一个是树。
     */
    /**
     * #include<stdio.h>
     int pre[100020],flag[100020];
     int find(int x)//不能路径压缩，递归找根结点；
     {
     if(pre[x]==x)
     return x;
     else
     return find(pre[x]);
     }
     int main()
     {
     int m,n,i,k,p=1;
     while(scanf("%d %d",&m,&n)!=EOF)
     {
     if(m<0&&n<0)
     break;
     int tot=0,ans=0;
     if(m+n==0)//m=0,n=0时条件；
     {
     printf("Case %d is a tree.\n",p++);
     continue;
     }
     for(i=1;i<=100010;i++)
     {
     pre[i]=i;
     flag[i]=0;
     }
     flag[n]=flag[m]=1;//标记m,n出现过；
     pre[n]=m;
     //这道题和前篇博客hdu小希的迷宫类似,但这道题有方向性,详看第一幅图的方向;
     //由n指向m，而不能由m指向n,这样查找父亲结点时就能查出入度大于1的节点了;
     //可以让m,n颠倒位置看看测试 1 2 3 2 0 0,这组数据is not a tree；
     while(scanf("%d %d",&m,&n) && (m+n))
     {
     flag[m]=flag[n]=1;
     int fx=find(m);
     int fy=find(n);
     if(fx!=fy)
     pre[n]=m;//同上；
     else ans=1;
     }
     if(ans)//有环；
     {
     printf("Case %d is not a tree.\n",p++);
     continue;
     }
     for(i=1;i<=100010;i++)
     {
     if(flag[i] && pre[i]==i)
     tot++;
     if(tot>1) break;
     }
     if(tot>1)//入度大于1了或者成树林了；
     printf("Case %d is not a tree.\n",p++);
     else printf("Case %d is a tree.\n",p++);
     }
     return 0;
     }
     */
}
