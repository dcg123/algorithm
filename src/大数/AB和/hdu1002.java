package 大数.AB和;

import java.math.BigInteger;
import java.util.Scanner;


public class hdu1002 {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        int N;
        N = input.nextInt();
        for (int i = 1; i <= N; i++)
        {
            BigInteger a = input.nextBigInteger();
            BigInteger b = input.nextBigInteger();
            System.out.println ("Case " + i + ":");
            System.out.print (a + " + " + b + " = ");
            System.out.println (a.add(b));
            if (i != N)
            {
                System.out.println ();
            }
        }
    }
}