package dfs.整数划分;

/**
 * Created by user on 2017/10/17.
 */
public class ny176 {
    /**
     * 把一个正整数m分成n个正整数的和，有多少种分法？

     例：把5分成3个正正数的和，有两种分法：

     1 1 3

     1 2 2


     */
//    #include <stdio.h>
//    int f(int m,int n)
//    {
//        if(m==n||n==1)
//            return 1;
//        else if(m<n)
//            return 0;
//        else if(m>n)
//            return f(m-1,n-1)+f(m-n,n);
//    }
//    int main()
//    {
//        int T;
//        scanf("%d",&T);
//        while(T--)
//        {
//            int m,n;
//            scanf("%d%d",&m,&n);
//            printf("%d\n",f(m,n));
//        }
//        return 0;
//    }
//AC
//首先 定义f ( i , j )为整数  i  分成 j  个整数 的情况
//经过分析可得f（i， j ）可转化为两个部分：
//一：  假设 分成的  j  个整数中 不包含1。。那么 此时 f （ｉ－ｊ，ｊ）就是这部分的总情况，既然想让他不包含１，
// 就先将ｊ个整数都分为１，此时ｉ变为ｉ－ｊ，再将ｉ分为ｊ个整数，
// 这ｊ个整数再加上原先分的１，就肯定不会再有１出现了。如果i-j<j的话，f （ｉ－ｊ，ｊ）的值为0
//二：　假设分成的ｊ个整数至少有一个１。。那么此时ｆ（ｉ－１，ｊ－１）
//
}
