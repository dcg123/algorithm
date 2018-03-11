package 贪心;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by user on 2017/10/2.
 */
public class Main6 {
    static double a[]=new double[610];
    static int n;
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while (t-->0){
            n=scanner.nextInt();
            for (int i=0;i<n;i++){
                a[i]=scanner.nextDouble();
            }
            Arrays.sort(a,0,n);
            double sum=20;
            int ans=0;
            int s=5;
            while (sum>0){
                sum-=2*Math.sqrt(a[s]*a[s]-1);
                ans++;
                s--;
            }
            System.out.println(ans);
        }
    }
}
