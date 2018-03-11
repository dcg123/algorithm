package 大数.最小公倍数;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by user on 2017/10/8.
 */
public class Main517 {
    public static void main(String[] args) {

            Scanner cin = new Scanner(System.in);
            BigInteger[] s = new BigInteger[102];
            s[1] = new BigInteger("1");
            s[2] = new BigInteger("2");
            int i;
            for(i = 3; i < 102; i ++){
                s[i] = new BigInteger(((Integer)i).toString());
                BigInteger temp = s[i-1].gcd(s[i]);
                s[i] = s[i].multiply(s[i-1]).divide(temp);
                //System.out.println(s[i]);
            }
            int n;
            while(cin.hasNext()){
                n = cin.nextInt();
                System.out.println(s[n]);
            }

    }
}
