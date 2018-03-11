package 数论.素数;

import java.util.Scanner;

/**
 * Created by user on 2017/10/15.
 */
public class Lightoj1259 {
    //给你一个偶数n，问有多少种方案找到两个数a,b，且a+b=n,a<=b，a和b是素数
    static int MAXN =10000010;
    static boolean v[]=new boolean[MAXN];
    static int cnt;
    static int prime[]=new int[666666];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        db();
        int t=scanner.nextInt();
        for (int k=1;k<=t;k++){
            int n=scanner.nextInt();
            int ans=0;
            for (int i=0;i<cnt;i++){
                if(prime[i]>n/2+1)
                    break;
                if(!v[n-prime[i]]&&n>=prime[i]*2)
                    ans++;
            }
            System.out.println("Case "+k+": "+ans);
        }
    }

    private static void db() {
        cnt=0;
        v[1]=true;
        for (int i=2;i<=10000000;i++){
            if (!v[i]){
                prime[++cnt]=i;
                for (int j=i*2;j<=10000000;j+=i){
                    v[j]=true;
                }
            }
        }
    }
}
