package dfs;

/**
 * Created by user on 2017/10/17.
 */
public class poj2965 {
    /**
     * 题目大意：冰箱4X4开关， -  是开，+  是关，要求开关是全开的。有操作，对某个开关操作，
     * 但会同时影响到同行同列的开关（开变成关，关变成开）。让求最少操作数，和操作点的位置。
     */

//    #include<cstdio>
//    using namespace std;
//    int a[4][4]={0};
//    int main()
//    {
//        char str;
//        for(int i=0;i<4;i++)
//        {
//            for(int j=0;j<4;j++)
//            {
//                cin>>str;
//                if(str=='+')
//                {
//                    for(int t=0;t<4;t++)
//                    {
//                        a[i][t]^=1;//奇数次为1，偶数次为0
//                        a[t][j]^=1;//将同行列的都操作一次
//                    }
//                    a[i][j]^=1;//因为上面循环中操作了操作点两次，所以再来一次（即减一次）
//                }
//            }
//        }
//
//        int sum=0;//计算奇数的个数
//        for(int i=0;i<4;i++)
//            for(int j=0;j<4;j++)
//                if(a[i][j])
//                    sum++;
//        printf("%d\n",sum);
//
//        for(int i=0;i<4;i++)
//        {
//            for(int j=0;j<4;j++)
//            {
//                if(a[i][j])
//                    printf("%d %d\n",i+1,j+1);
//            }
//        }
//        return 0;
//    }
}
