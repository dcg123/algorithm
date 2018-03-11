package 大数.大数取模;



        import java.math.BigInteger;
        import java.util.Scanner;

public class hdu1212 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        BigInteger a,b;
        while(scan.hasNext()){
            a=scan.nextBigInteger();
            b=scan.nextBigInteger();
            BigInteger result[]=a.divideAndRemainder(b);//求出余数的除法操作
            System.out.println(result[1]);
        }
    }

}
