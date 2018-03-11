package 线段树;

import java.util.Scanner;

/**
 * Created by user on 2017/10/14.
 */
public class poj3468 {
    static int MAX=100000+10;
    static int a[]=new int[MAX];
    static int n,q;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        q=scanner.nextInt();
        scanner.nextLine();
        String str=scanner.nextLine();
        String b[]=str.split(" ");
        for (int i=1;i<=n;i++){
            add(i,Integer.valueOf(b[i-1]));
        }
        for (int i=0;i<q;i++){
             str=scanner.nextLine();
             b=str.split(" ");
            int x=Integer.valueOf(b[1]);
            int y=Integer.valueOf(b[2]);
            if (b[0].equals("Q")){
                System.out.println(query(y)-query(x-1));
            }
            if (b[0].equals("C")){
                int cost=Integer.valueOf(a[3]);
                for (int j=x;j<=y;j++){
                    add(j,cost);
                }
            }
        }
    }

    private static int query(int k) {
        int sum=0;
        while (k>0){
            sum+=a[k];
            k-=k&-k;
        }
        return sum;
    }

    private static void add(int k, Integer sum) {
        while (k<=n){
            a[k]+=sum;
            k+=k&-k;
        }
    }
}
