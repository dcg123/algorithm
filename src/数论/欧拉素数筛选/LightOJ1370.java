package 数论.欧拉素数筛选;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by user on 2017/10/15.
 */
public class LightOJ1370 {

    //存在精度问题
    static int MAXN = 1010000+5;
    static int prime[]=new int[MAXN];///存素数的
    static int cnt;///素数的个数
    static boolean p[]=new boolean[MAXN];///判断素数滴
    static void isprime()///素数筛
    {
        cnt = 0;
        Arrays.fill(p,true);
        p[1] = false;
        for(int  i=2; i<MAXN; i++)
        {
            if(p[i])
            {
                prime[cnt++] = i;
                for(long  j=i*i; j<MAXN; j+=i){
                    p[(int)j] = false;
                  //  System.out.println(j);
                }
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        isprime();
        ///cout<<prime[cnt-1]<<endl;
        int t=scanner.nextInt();
        int m,num;
        for(int cas=1; cas<=t; cas++)
        {
            m=scanner.nextInt();
            long sum = 0;
            while(m-->0)
            {
                num=scanner.nextInt();
                for(int i=num+1; ; i++)///找到第一个素数
                {
                    if(p[i])
                    {
                        sum += i;
                        break;
                    }
                }
            }
            System.out.println("Case "+cas+": +"+sum+" Xukha");
        }

    }
}
