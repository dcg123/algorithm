package 数据结构.树状数组;

/**
 * Created by user on 2017/10/11.
 */
public class hdu1541 {
    /**
     * N个气球排成一排，从左到右依次编号为1,2,3 .... N
     * 。每次给定2个整数ab（a <= b），lele便为骑上他的“小飞鸽“牌电动车从气球一个开始到气球b依次给每个气球涂一次颜色。但是ñ次以后乐乐已经忘记了第我个气球已经涂过几次颜色了，
     * 你能帮他算出每个气球被涂过几次颜色吗？
     * #include <stdio.h>
     #include <string.h>
     const int MAXN=110000;
     int n,c[MAXN];
     int lowbit(int x)
     //计算2^k
     {
     x=x&-x;
     return x;
     }
     void update(int num,int val)
     //向下查询，num是要更新的子节点，val是要修改的值
     {
     while(num>0)
     {
     c[num]+=val;
     num-=lowbit(num);
     }
     }
     int getSum(int num)
     //向上统计每个区间被染色的次数
     {
     int sum=0;
     while(num<=n)
     {
     sum+=c[num];
     num+=lowbit(num);
     }
     return sum;
     }
     int main()
     {
     int a,b;
     while(scanf("%d",&n),n)
     {
     memset(c,0,sizeof(c));
     for(int i=0;i<n;i++)
     {
     scanf("%d%d",&a,&b);
     //将b以下区间+1
     update(b,1);
     //将a以下区间-1
     update(a-1,-1);
     }
     for(int j=1;j<n;j++)
     {
     printf("%d ",getSum(j));
     }
     printf("%d\n",getSum(n));
     }
     return 0;
     }
     */
}
