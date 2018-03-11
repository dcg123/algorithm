package 贪心;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by user on 2017/10/2.
 */
public class Main71 {
    static int n,weight;
    static int a[]=new int[310];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while (t-->0){
            weight=scanner.nextInt();
            n=scanner.nextInt();
            for (int i=0;i<n;i++){
                a[i]=scanner.nextInt();
            }
            Arrays.sort(a,0,n);
            int begin=0,end=n-1;
            int ans=0;
            while (begin<=end){
                if (a[end]+a[begin]>weight){
                    ans++;
                    end--;

                }else {
                    ans++;
                    begin++;
                    end--;
                }
            }
            System.out.println(ans);
        }
    }
}
