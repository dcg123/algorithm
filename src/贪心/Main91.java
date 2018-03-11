package 贪心;

import java.util.Scanner;

/**
 * Created by user on 2017/10/2.
 */
public class Main91 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int s[] = {1,2,6,24,120,720,5040,40320,362880};
        int t=scanner.nextInt();
        while (t-->0){
            int n=scanner.nextInt();
            for (int i=8;i>=0;i--){
                if (n>=s[i]){
                    n-=s[i];
                    if (n==0){
                        System.out.println("Yes");
                        break;
                    }
                }
            }
            if (n!=0){
                System.out.println("No");
            }
        }
    }
}
