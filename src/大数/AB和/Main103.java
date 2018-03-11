package 大数.AB和;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by user on 2017/10/8.
 */
public class Main103 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        int count=0;
        while (t-->0){
            count++;
            BigInteger a=scanner.nextBigInteger();
            BigInteger b=scanner.nextBigInteger();
            System.out.println("Case "+count+":");
            String str=a+" + "+b+" = "+(a.add(b));
            System.out.println(str);
        }
    }
}
