package 数论;

import java.util.Scanner;

/**
 * Created by user on 2017/8/15.
 */
public class aoj0005 {
    /**
     * 求两个数的最大公约数
     * @param agrs
     */
    public static void main(String agrs[]){
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            long a=scanner.nextLong();
            long b=scanner.nextLong();
            long s=gcd(a,b);

            System.out.println(s+" "+a/s*b);
        }
    }

    private static long  gcd(long a, long b) {
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
}
