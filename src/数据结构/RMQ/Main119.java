package 数据结构.RMQ;

import java.util.Scanner;

/**
 * Created by user on 2017/10/4.
 */
public class Main119 {
    static int N = 100010;
    static int maxsum[][]=new int[N][20], minsum[][]=new int[N][20];
    static void RMQ(int num) //预处理->O(nlogn)
    {
        for(int j = 1; j < 20; ++j)
            for(int i = 1; i <= num; ++i)
                if(i + (1 << j) - 1 <= num)
                {
                    maxsum[i][j] = Math.max(maxsum[i][j - 1], maxsum[i + (1 << (j - 1))][j - 1]);
                    minsum[i][j] = Math.min(minsum[i][j - 1], minsum[i + (1 << (j - 1))][j - 1]);
                }
    }

    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int num, query;
        int src, des;
        num=scanner.nextInt();
        query=scanner.nextInt();
        scanner.nextLine();
        String str=scanner.nextLine();
        String a[]=str.split(" ");
        for(int i = 1; i <= num; ++i) //输入信息处理
        {
            maxsum[i][0]=Integer.valueOf(a[i-1]);
            minsum[i][0] = maxsum[i][0];
        }
        RMQ(num);
        while(query-->0) //O(1)查询
        {
            str=scanner.nextLine();
            a=str.split(" ");
            src=Integer.valueOf(a[0]);
            des=Integer.valueOf(a[1]);
            int k = (int)(Math.log(des - src + 1.0) / Math.log(2.0));
            int maxres = Math.max(maxsum[src][k], maxsum[des - (1 << k) + 1][k]);
            int minres = Math.min(minsum[src][k], minsum[des - (1 << k) + 1][k]);
            System.out.printf("%d\n", maxres - minres);
        }
    }
}
