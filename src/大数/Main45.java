package 大数;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by user on 2017/10/8.
 */
public class Main45 {
    //先算出来2^k*2^k 之后减去1，最后除3即可
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while (t-->0){
            int k=scanner.nextInt();
            BigInteger s=new BigInteger("2");
            BigInteger ss=new BigInteger("3");
            BigInteger sum=s.pow(k).multiply(s.pow(k)).subtract(BigInteger.ONE).divide(ss);
            System.out.println(sum);
        }
    }
}
