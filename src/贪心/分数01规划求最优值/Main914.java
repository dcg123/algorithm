package 贪心.分数01规划求最优值;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by user on 2017/10/10.
 */
public class Main914 {
    static int N = 11000;
    static int w[]=new int[N],v[]=new int[N];
    static double y[]=new double[N];
    static int n,c;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            n=scanner.nextInt();
            c=scanner.nextInt();
            if (n==0&&c==0){
                break;
            }
            double ma=0;
            for (int i=0;i<n;i++){
                w[i]=scanner.nextInt();
                v[i]=scanner.nextInt();
                double cmp=v[i]/w[i];
                if(cmp>ma)
                    ma=cmp;
            }
            System.out.printf("%.2f\n",reach(ma));
        }
    }

    private static double reach(double enf) {
        double l=0,r=enf,mid;
        while (l<=r)
        {
            mid=(l+r)/2;
            if(chack(mid))
                l=mid;
            else
                r=mid;
        }
        return l;
    }

    private static boolean chack(double x) {//枚举单位价值最大值
        for(int i=0;i<n;i++)
        {
            y[i]=v[i]-x*w[i];
        }
        Arrays.sort(y,0,n);
        double sum=0;
        for(int i=0;i<c;i++)
        {
            sum+=y[n-i-1];
        }
        return sum>=0;
    }
}
