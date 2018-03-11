package 数据结构;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by user on 2017/10/5.
 */
public class Main1073 {
    static int n,m;
    static int a[]=new int[30000+10];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while (t-->0){
            n=scanner.nextInt();
            m=scanner.nextInt();
            scanner.nextLine();
            String str=scanner.nextLine();
            String b[]=str.split(" ");
            for (int i=0;i<n;i++){
                a[i]=Integer.valueOf(b[i]);
            }

            str=scanner.nextLine();
            b=str.split(" ");
            for (int i=0;i<b.length;i++){
                Arrays.sort(a,0,Integer.valueOf(b[i]));
                System.out.println(a[i]);
            }
        }
    }
}
