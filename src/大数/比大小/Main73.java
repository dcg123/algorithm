package 大数.比大小;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by user on 2017/10/8.
 */
public class Main73 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            BigInteger a=scanner.nextBigInteger();
            BigInteger b=scanner.nextBigInteger();
            if (a.compareTo(BigInteger.ZERO)==0&&b.compareTo(BigInteger.ZERO)==0){
                break;
            }
            int ans=a.compareTo(b);
            if (ans<0){
                System.out.println("a<b");
            }else if (ans==0){
                System.out.println("a==b");
            }else {
                System.out.println("a>b");
            }
        }
    }
}
