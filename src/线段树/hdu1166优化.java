package 线段树;

import com.sun.javafx.image.impl.IntArgb;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by user on 2017/10/14.
 */
public class hdu1166优化 {
    static int N= 50005;
    static int a[]=new int[N],c[]=new int[N];
    static int n;
    static int lowbit(int x)
    {
        return x&(x^(x-1));
    }
    static void update(int p,int x)
    {
        while(p<=n)
        {
            c[p]+=x;
            p+=lowbit(p);
        }
    }
    static int sum(int p) //前p相的和
    {
        int sum=0;
        while(p>0)
        {
            sum+=c[p];
            p-=lowbit(p);
        }
        return sum;
    }

    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int t,i,m,k;
        int a1,a2;
        t=scanner.nextInt();
        for(k=1;k<=t;k++)
        {
            n=scanner.nextInt();
           // scanner.nextLine();
            Arrays.fill(a,0);
            Arrays.fill(c,0);
          //  String str=scanner.nextLine();
           // String b[]=str.split(" ");
            for(i=1;i<=n;i++)    //初值为0
            {
                m= scanner.nextInt();
                a[i]+=m;
                update(i, m);
            }
            scanner.nextLine();
            System.out.printf("Case %d:\n",k);
            while(scanner.hasNextLine())
            {
                String str=scanner.nextLine();
                String b[]=str.split(" ");
                if (b[0].equals("End")){
                    break;
                }
                a1=Integer.valueOf(b[1]);
                a2=Integer.valueOf(b[2]);
                if(b[0].equals("Add"))
                {
                    a[a1]+=a2;
                    update(a1,a2);
                }
                else if(b[0].equals("Sub"))
                {
                    a[a1]-=a2;
                    update(a1,-a2);
                }
                else if(b[0].equals("Query"))
                {
                    System.out.printf("%d\n",sum(a2)-sum(a1-1));
                }
            }
        }

    }

}
