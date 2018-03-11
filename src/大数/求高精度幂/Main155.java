package 大数.求高精度幂;

import java.io.BufferedInputStream;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by user on 2017/10/8.
 */
public class Main155 {
    public static void main(String[] args) {
        Scanner cin=new Scanner(new BufferedInputStream(System.in));
        BigDecimal a,s;
        int p;
        while(cin.hasNext()) {
            a=cin.nextBigDecimal();
            p=cin.nextInt();
            s=BigDecimal.valueOf(1);
            for(int i=1;i<=p;++i) {
                s=s.multiply(a);
            }
            s=s.stripTrailingZeros();//末尾去掉0

            if(s.compareTo(BigDecimal.valueOf(1))<0) {
                String ans=s.toPlainString();//返回大数类不带指数
                for(int i=1;i!=ans.length();++i) {
                    System.out.print(ans.charAt(i));
                }
                System.out.println();
            }
            else {
                String ans=s.toPlainString();
                System.out.println(ans);
            }

        }
    }
}
