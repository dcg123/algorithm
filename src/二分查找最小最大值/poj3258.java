package 二分查找最小最大值;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by user on 2017/8/15.
 */
public class poj3258 {
    /**
     * 大致题意：
     一条河长度为 L，河的起点(Start)和终点(End)分别有2块石头，S到E的距离就是L。
     河中有n块石头，每块石头到S都有唯一的距离
     问现在要移除m块石头（S和E除外），每次移除的是与当前最短距离相关联的石头，
     要求移除m块石头后，使得那时的最短距离尽可能大，输出那个最短距离。
     */
    static int MAX_N=50000+5;
    static int a[]=new int[MAX_N];
    static int l,n,m;
    public  static  void main(String args[]){
        Scanner scanner=new Scanner(System.in);

        l=scanner.nextInt();
        n=scanner.nextInt();
        m=scanner.nextInt();
        for(int i=1;i<=n;i++){
            a[i]=scanner.nextInt();
        }
        a[0]=0;
        a[++n]=l;
        Arrays.sort(a,0,n+1);
        int mid,low=0,high=l;
        while (high>=low){
            mid = (high + low) / 2;
            int pre = 0, count = 0;
            for(int i = 1; i <= n; i ++){
                int dis = a[i] - a[pre];
                if(dis < mid) count ++;
                else pre = i;
            }
            if(count > m) high = mid - 1;
            else low = mid + 1;
        }
        System.out.println(high);
    }
}
