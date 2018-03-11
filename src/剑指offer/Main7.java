package 剑指offer;

/**
 * Created by user on 2017/11/29.
 */
public class Main7 {
    public static void main(String[] args) {
        System.out.println(Fibonacci(8));
    }
    public static int Fibonacci(int n) {
        int f1=1;
        int f2=1;
        int sum=0;
        if (n<=2&&n>0){
            return 1;
        }else if (n==0){
            return 0;
        }
        else {
            for (int i=3;i<=n;i++){
                sum=f1+f2;
                f1=f2;
                f2=sum;
            }
            return sum;
        }
    }
}
