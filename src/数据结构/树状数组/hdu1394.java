package 数据结构.树状数组;

/**
 * Created by user on 2017/10/11.
 */
public class hdu1394 {
    /**
     * 题意：给定n个数的整数序列，每次可将序列首个数放到最后一位，
     * 其余数相对位置不变，通过这样的操作可以得到n种序列，
     * 要求这n种序列中倒置数的最小个数，即满足下标i<j,a[i]>a[j]。
     解题思路：
     先看一个序列倒置数的求法，输入一个数，然后就立刻判断此时前面出现比他大的数的个数，
     因为序列的数满足0~n,所以可以用树状数组c[p]表示其区间[p-2^k-1,p]对应下标数字出现的个数，
     那么区间a[p]~a[n]就是我们要求的此时（满足下标i>j）前面出现的比他大的数的个数,注意，
     树状数组的下标都是从1开始，所以要把输入的a+1。
     然后就讨论不同序列的情况，当某一时刻首位a[i]被移动到最后一位，
     那么原序列由a[i]组成的倒置数有a[i]-1个（此时a[i]加过1），
     也就是后面比他小的个数（因为是首位，前面不需要考虑）。同理，
     加到最后一个后，他前面有n-a[i]个数可以和a[i]形成倒置数。
     */

    /**
     * /Minimum Inversion Number
     #include<cstdio>
     #include<cstring>
     #define N 5010
     using namespace std;

     int c[N],n,a[N];

     int lowbit(int t)  //计算树状数组t区间管理的a的个数
     {
     return t&(-t); //t 二进制数后面k个0，返回值为2^k
     }
     void updata(int p,int f) //p在树状数组最先出现的地方是c[p]
     {
     while(p <= n){ //将后面所有包含a[p]的树状数组更新
     c[p] += f;
     p += lowbit(p);
     }
     }
     int getsum(int p) //求和 a[1] 到 a[p]
     {
     int s = 0;
     while(p > 0) {
     s += c[p];   //c[p] 只管理lowbit(p) 个数
     p -= lowbit(p); //那么接下来要算a[1] 到 a[p] - lowbit(p) 的区间和
     }
     return s;
     }
     void init()
     {
     for(int i = 0;i <= n;i++) c[i] = 0;
     }

     int main()
     {
     int i,s,mn;
     while(~scanf("%d",&n)){
     init();
     s = 0;
     for(i = 1;i <= n;i++){
     scanf("%d",&a[i]);
     a[i]++;                        //树状数组从下标1开始
     s += getsum(n) - getsum(a[i]);  //a[i]前面比它大的数，即可生成的倒置数
     // printf("s = %d \n",s);
     updata(a[i],1);                //让所有包含a[i]的树状数组+1
     // print();
     }
     mn = s;
     for(i = 1;i <= n;i++){
     s += n - a[i] - (a[i] - 1);//将a[i]从首位换到最后一位后，倒置数先减少 a[i] - 1(注意a[i]+1处理过了)
     if(s < mn) mn = s;         //然后又增加了 n-a[i],比较取最小的
     }
     printf("%d\n",mn);
     }
     return 0;
     }
     */
}
