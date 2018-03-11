package 数据结构;

import java.util.Scanner;

/**
 * Created by user on 2017/10/5.
 */
public class Main739 {
    static int a[]=new int[100000+5];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            int Min=Integer.MAX_VALUE;
            int Max=Integer.MIN_VALUE;
            for (int i=0;i<n;i++){
                a[i]=scanner.nextInt();
                if (i>=1){
                    Min=Math.min(Min,a[i-1]);
                    Max=Math.max(Max,a[i]-Min);
                }
            }
            System.out.println(Max);
        }
    }
}
