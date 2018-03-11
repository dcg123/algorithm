package 大数.大数阶乘;


        import java.math.BigInteger;
        import java.util.Scanner;

public class 阶乘的位数 {
    public static void main(String []args)throws Exception{
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        while(t--!=0){
            String a=cin.next();
            int n = Integer.parseInt(a);
            System.out.println(digit(n));
        }
        cin.close();
    }
    public static int digit(int n){
        double sum=0;
        for(int i=1;i<=n;i++)
        {
            double t = Math.log10(i);
            sum+=t;
        }

        return (int)sum+1;
    }
}