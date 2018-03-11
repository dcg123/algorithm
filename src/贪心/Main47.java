package 贪心;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by user on 2017/10/2.
 */
public class Main47 {
    static int a[]=new int[1005];
    static int n;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while (t-->0){
            n=scanner.nextInt();
            for (int i=0;i<n;i++){
                a[i]=scanner.nextInt();
            }
            int sum=getMask();
            System.out.println(sum);
        }
    }

    static int getMask() {
        if (n==1){
            return a[0];
        }
        else if (n==2){
            return a[0]+a[1];
        }else {
            Arrays.sort(a,0,n);
            int sum=0;
            while (true){
                if (n==2){
                    sum+=a[1];
                    break;
                }else if (n==3){
                    sum+=a[0]+a[1]+a[2];
                }else {
                    int t1 = a[0] + a[1] + a[1] + a[n-1];   //方案1
                    int t2 = a[0] + a[0] + a[n-1] + a[n-2]; //方案2
                    sum += (t1 > t2 ? t2 : t1);
                    n -= 2;
                }
            }
            return sum;
        }
    }
}
