

        import java.math.BigDecimal;
        import java.util.Scanner;

public class hdu1063 {

    /**
     * @param args java大数
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        BigDecimal a;
        int n;
        while(scan.hasNext()){
            a=scan.nextBigDecimal();
            n=scan.nextInt();
            String s=a.pow(n).stripTrailingZeros().toPlainString();
            if(s.charAt(0)=='0'){
                s=s.substring(1);
            }
            System.out.println(s);
        }
    }

}
