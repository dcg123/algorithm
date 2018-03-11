package 动态规划.背包;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by user on 2017/10/6.
 */
public class Main1328 {
    static int a[]=new int[1000+10];
    static int dp[]=new int[1000+10];
    static int m;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String str=scanner.nextLine();
            m=scanner.nextInt();
            String b[]=str.split(" ");
            for (int i=0;i<b.length;i++){
                a[i+1]=Integer.valueOf(b[i]);
            }
            Arrays.fill(dp,0);
            dp[0]=1;//表示当前为i的和是否已经找到
            for (int i=1;i<=b.length;i++){
                for (int j=m;j>=a[i];j--){
                    if (dp[j-a[i]]==1){
                        dp[j]=1;
                    }
                }
            }
            if (dp[m]==1){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
            scanner.nextLine();
        }
    }
}
