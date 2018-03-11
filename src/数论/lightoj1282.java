package 数论;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by user on 2017/10/15.
 */
public class lightoj1282 {
    //求n^k的前三位数和后三位数
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        for (int i=1;i<=t;i++){
            BigInteger n=scanner.nextBigInteger();
            int  k=scanner.nextInt();
            BigInteger sum=n.pow(k);
            String result=sum.toString();
            System.out.println("Case "+i+": "+result.substring(0,3)+" "+result.substring(result.length()-1-2));
        }
    }
}
