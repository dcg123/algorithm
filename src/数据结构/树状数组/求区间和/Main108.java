package 数据结构.树状数组.求区间和;

import java.util.Scanner;

/**
 * Created by user on 2017/10/4.
 */
public class Main108 {
    static int maxn = 1000000;
    static int c[]=new int[maxn + 5];
    static int n,m;
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
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        m=scanner.nextInt();
        scanner.nextLine();
        String str=scanner.nextLine();
        String a[]=str.split(" ");
        for(int i = 1;i <= n;++i){
           // int value=scanner.nextInt();
            add(i,Integer.valueOf(a[i-1]));//创建树
        }
        while(m-->0)
        {
            int x,y;
            x=scanner.nextInt();
            y=scanner.nextInt();
            if(x > y)
            {
                int t = x;
                x = y;
                y = t;
            }
            System.out.printf("%d\n",query(y) - query(x - 1));//查询
        }
    }
}
