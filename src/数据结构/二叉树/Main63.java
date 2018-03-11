package 数据结构.二叉树;

import java.util.Scanner;

/**
 * Created by user on 2017/10/4.
 */
public class Main63 {
    static int d,a;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            d=scanner.nextInt();
            a=scanner.nextInt();
            if (d+a==0){
                break;
            }
            int ans=1;
            d--;
            while(d-->0)
            {
                if(a%2==1)
                {
                    ans=ans*2;
                    if(a==1) continue;
                    a=a/2+1;
                }
                else
                {
                    ans=ans*2+1;
                    a=a/2;
                }
            }
            System.out.println(ans);
        }
    }
}
