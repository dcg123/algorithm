package dfs;

/**
 * Created by user on 2017/10/17.
 */
public class ny46 {
    /**
     * 题的大概意思就是 给一个正整数n，求2 ^ n 最少的乘法次数
     * (可以利用其前面求出来的结果,例如 求2 ^ 4 有 2 * 2  = 2 ^ 2 ,    2 ^ 2  * 2 ^ 2 = 2 ^ 4.
     * 一共两次)

     思路：对于2 ^ n来说,如果 整数n 如果是奇数,
     就等于2 ^ (n - 1)这个数在乘上2,也就是2 ^ (n - 1)次数在加1.如果是偶数,
     就等于2 ^ (n / 2)  * 2 ^(n / 2);也就是2 ^(n - 1)次数加1;
     */
//    include <stdio.h>
//
//
//    int MinCal(int n)
//
//
//    {
//        int s;
//        if(n == 1)
//            return 0;
//        if(n == 2)
//            return 1;
//        if(n & 1)
//            s = MinCal(n - 1) + 1;
//        else
//            s = MinCal(n / 2) + 1;
//        return s;
//    }
//
//
//    int main()
//
//
//    {
//        int m;
//        scanf("%d",&m);
//        while(m--)
//        {
//            int n;
//            scanf("%d",&n);
//            printf("%d\n",MinCal(n));
//        }
//        return 0;
//    }
}
