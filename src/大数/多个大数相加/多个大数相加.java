package 大数.多个大数相加;

        import java.math.BigInteger;
        import java.util.Scanner;

public class 多个大数相加
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        while (n-- > 0)
        {
            BigInteger b = new BigInteger("0");
            while (input.hasNextBigInteger())
            {
                BigInteger c = new BigInteger("0");
                c = input.nextBigInteger();
                if (!c.equals(BigInteger.valueOf(0)))
                {
                    b = b.add(c);
                }
                else
                {
                    System.out.println(b);
                    if (n != 0)
                    {
                        System.out.println();
                    }
                    break;
                }
            }
        }
        input.close();
    }
}