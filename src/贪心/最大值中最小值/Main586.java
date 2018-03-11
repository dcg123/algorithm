package 贪心.最大值中最小值;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by user on 2017/10/11.
 */
public class Main586 {
    //简单的说就是给你一段长度，在这一段中给出m个点，
    // 然后在这m个点中选出k个点，让这k个点之间相邻两个点的之间距离的最小值最大
    //思路：通过二分枚举这个最小值，然后通过贪心的思想找出满足要求的最大的这个最小值
    static int n,c;
    static int pos[]=new int[100005];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            n=scanner.nextInt();
            c=scanner.nextInt();
            for (int i=0;i<n;i++){
                pos[i]=scanner.nextInt();
            }
            Arrays.sort(pos,0,n);
            System.out.printf("%d\n", binary_search());
        }
    }

    private static int  binary_search() {
        int l = 0;
        int r = pos[n-1]-pos[0];
        int mid;
        while (l<=r){
            mid = (l+r)/2;
            if (judge(mid) <= c-1){
                r=mid-1;
            }else {
                l=mid+1;
            }
        }
        return l-1;
    }

    private static int judge(int x) {
        int cnt=1;
        int sum=pos[0];
        for(int i = 1; i < n; i ++)
        {
            if(pos[i] - sum >= x) //不要区分，满足就把牛放在这点，sum更新为此点坐标，应为青蛙那不能跳过来，就是前面一点
            {
                cnt ++;
                sum = pos[i];
            }
        }
        return cnt;
    }
}
