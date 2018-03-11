package 数据结构.逆序对;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by user on 2017/10/4.
 */
public class Main117 {
    static int a[]=new int[1000010],temp[]=new int[1000010];
    static long ans;
    static void merarray(int l,int mid,int r)
    {
        int i=l,j=mid+1;
        int k=0;
        while(i<=mid&&j<=r)
        {
            if(a[i]<=a[j])
                temp[k++]=a[i++];
            else
            {
                temp[k++]=a[j++];
                ans+=(long)(mid-i+1);//统计
            }
        }
        while(i<=mid)
            temp[k++]=a[i++];
        while(j<=r)
            temp[k++]=a[j++];
        for(i=0; i<k; i++)
            a[l+i]=temp[i];
    }

    static void mersort(int l,int r)
    {
        if(l<r)
        {
            int mid=(l+r)>>1;
            mersort(l,mid);
            mersort(mid+1,r);
            merarray(l,mid,r);
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int t,i,n;
        t=scanner.nextInt();
        while(t-->0)
        {
            n=scanner.nextInt();
            for(i=1; i<=n; i++)
                a[i]=scanner.nextInt();
            ans=(long)0;
            mersort(1,n);
            System.out.println(ans);
        }

    }
}
