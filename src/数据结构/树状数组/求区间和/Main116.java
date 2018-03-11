package 数据结构.树状数组.求区间和;

import java.util.Scanner;

/**
 * Created by user on 2017/10/4.
 */
public class Main116 {
    static int n,m;
    static int c[]=new int[1000000+5];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        m=scanner.nextInt();
        scanner.nextLine();

        String str=scanner.nextLine();
        String a[]=str.split(" ");
        for (int i=1;i<=n;i++){
            add(i,Integer.valueOf(a[i-1]));
        }
        for (int i=0;i<m;i++){
            str=scanner.nextLine();
            a=str.split(" ");
            int x=Integer.valueOf(a[1]);
            int y=Integer.valueOf(a[2]);
            if (a[0].equals("QUERY")){
                if(x > y)
                {
                    int t = x;
                    x = y;
                    y = t;
                }
                System.out.printf("%d\n",query(y) - query(x - 1));
            }else {
                add(x,y);
            }
        }
    }
    static void add(int k,int num)
    {
        while(k <= n)
        {
            c[k] += num;
            k += k & -k;
        }
    }
    static int query(int k)
    {
        int sum = 0;
        while(k>0)
        {
            sum += c[k];
            k -= k & -k;
        }
        return sum;
    }
}
