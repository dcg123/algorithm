package 数学.数论曼哈顿距离;

/**
 * Created by user on 2017/10/10.
 */
public class Main7 {
    //给去n个点 找出一个点到这些点最短距离
    /**
     *
     * 初次接触这样的题，以为很复杂，其实可以看成走方格，怎样走路径和最短，只能上下和左右走，可以分步计算上下和左右走的路径和，同时利用中位线定理可知，中点为起始点,即sum=

     min（∑|x[i]-x|)+min（∑|y[i]-y|),x,y为排序后的坐标.

     可以简化为

     假设有5个数，那么sum=x[2]-x[0]+x[2]-x[1]+x[3]-x[2]+x[4]-x[2]=x[3]-x[1]+x[4]-x[0]

     推导可知

     for(i=0;i<m/2;++i)
     sum+=x[m-1-i]-x[i]+y[m-1-i]-y[i];

     Ac code:

     #include<stdio.h>
     #include<cstring>
     #include<algorithm>
     using namespace std;
     int x[21],y[21];
     int main()
     {
     int test,m,i,sum;
     scanf("%d",&test);
     while(test--)
     {
     sum=0;
     scanf("%d",&m);
     for(i=0;i<m;++i)
     scanf("%d%d",&x[i],&y[i]);
     sort(x,x+m);                  //对x坐标的点进行排序
     sort(y,y+m);                  //对y坐标的点进行排序
     for(i=0;i<m/2;++i)
     sum+=x[m-1-i]-x[i]+y[m-1-i]-y[i];
     printf("%d\n",sum);
     }
     }
     */
}
