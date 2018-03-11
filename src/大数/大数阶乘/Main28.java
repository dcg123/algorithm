package 大数.大数阶乘;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by user on 2017/10/8.
 */
public class Main28 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        BigInteger m=scanner.nextBigInteger();
        BigInteger sum=BigInteger.ONE;
      //  System.out.println(sum.compareTo(BigInteger.ONE));
        for (BigInteger i=m;i.compareTo(BigInteger.ONE)<0?false:true;i=i.subtract(BigInteger.ONE)){
            sum=sum.multiply(i);
        }
        System.out.println(sum);
    }
}
