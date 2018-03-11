package 图论.最短路;

import java.util.Scanner;

/**
 * Created by user on 2017/8/13.
 */
public class poj2139 {
    /**
     * 题目大意：有n头牛，如果两头牛同拍一部电影，这他们之间的距离为一，如果两头牛都和第三头牛拍过同一部电影，
     * 那么它们之间的距离经第三头牛传递就为2，
     * ，，求那一头牛与其它牛距离的平均值最小，把他乘一百输出。（求的时候，先扩大一百倍再求平均值）
     */
    static int MAX_N=305;
    static int map[][]=new int[MAX_N][MAX_N];
    static int n,m;
    static int a[]=new int[MAX_N];
    public static void main(String srga[]){
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        m=scanner.nextInt();
        init();
        while((m--)>0)
        {
            int x=scanner.nextInt();
            for(int i=0;i<x;i++)
                a[i]=scanner.nextInt();
            for(int i=0;i<x;i++)
                for(int j=i+1;j<x;j++)
                    map[a[i]][a[j]]=map[a[j]][a[i]]=1;
        }
        for(int k=1;k<=n;k++)
            for(int i=1;i<=n;i++)
                for(int j=1;j<=n;j++)
                    map[i][j]=Math.min(map[i][j],map[i][k]+map[k][j]);
        int minn=Integer.MAX_VALUE;
        for(int i=1;i<=n;i++)
        {
            int maxn=0;
            for(int j=1;j<=n;j++)
                maxn+=map[i][j];
            minn=Math.min(minn,100*maxn/(n-1));
        }
        System.out.println(minn);
    }

    private static void init() {
        for(int i=0;i<305;i++)
            for(int j=0;j<305;j++)
                if(i!=j)
                    map[i][j]=map[j][i]=100000000;
    }
}
