package 二分查找最小最大值;

/**
 * Created by user on 2017/10/17.
 */
public class poj3273 {
    /**
     * 题目大意：给你n个数把他们连续的分成m组，问最小的那一组的最大值。
     思路：用最小的那一个元素和总和进行二分。。。然后判断最小那组为mid时，分组的个数。
     */
//    #include <cstdio>
//#include <iostream>
//#include <algorithm>
//#include <cstring>
//#include <cmath>
//
//    using namespace std;
//
//    int a[100010];
//    int N,M;
//
//    bool f(int mid)         //最小值为mid的时的个数
//    {
//        int sum=0;
//        int len=1;
//        for(int i=1;i<=N;i++)
//        {
//            if(sum+a[i]<=mid)
//            {
//                sum+=a[i];
//            }
//            else
//            {
//                sum=a[i];
//                len++;
//            }
//        }
//        if(len>M) return false;
//        else return true;
//    }
//
//    int main(int argc, char const *argv[])
//    {
//        while(cin>>N>>M)
//        {
//            double high=0,low=0;
//            for(int i=1;i<=N;i++)
//            {
//                cin>>a[i];
//                high+=a[i];
//                if(low<a[i])
//                {
//                    low=a[i];
//                }
//            }
//            int mid=(low+high)/2;
//            while(low<high)
//            {
//
//                if(!f(mid))
//                {
//                    low=mid+1;
//                }
//                else
//                {
//                    high=mid-1;
//                }
//                mid=(low+high)/2;
//            }
//            cout<<mid<<endl;
//        }
//        return 0;
//    }
}
