package 贪心.最大值中最小值;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by user on 2017/10/11.
 */
public class Main619 {
    static int MAX=500005;
    static int L,n,m;
    static int stone[]=new int[MAX];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            L=scanner.nextInt();
            n=scanner.nextInt();
            m=scanner.nextInt();
            for (int i=0;i<n;i++){
                stone[i]=scanner.nextInt();
            }
            int l,r;
            Arrays.sort(stone,0,n);
            stone[n]=L;
            r=L;
            l=0;
            //找出二分区间的左值
            for(int i = 1; i <= n; i ++)//找二分区间的左值
            {
                if(stone[i] - stone[i-1] > l) l = stone[i]-stone[i-1];
            }
            int mid;
            while (l<=r){
                mid=(l+r)/2;
                if (jump(mid)<=m){
                    r=mid-1;
                }else {
                    l=mid+1;
                }
            }
            System.out.println(l);
        }
    }

    private static int jump(int x) {
        int cnt=1;
        int sum=0;
        for(int i = 0; i <= n; i ++)
        {
            if(stone[i] - sum == x )//如果这个石头到sum这点的距离刚好是x，那么刚好能跳过，sum更新为这个石头坐标
            {
                cnt ++;
                sum = stone[i];
            }
            else if(stone[i] - sum > x)//青蛙不能从sum跳到stone，那么，sum就更新为前面那个石头的坐标
            {
                cnt ++;
                sum = stone[i-1];
            }
        }
        return cnt;
    }
}
