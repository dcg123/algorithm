package 字符串.kmp;

import java.util.Scanner;

/**
 * Created by user on 2017/8/20.
 */
public class poj3461 {
    /**
     * 题目大意：
     给你两个字符串p和s，求出p在s中出现的次数。
     */
     static int MAX_N=1000000+10;
     static int next[]=new int[MAX_N];
     public static void main(String args[]){
         Scanner scanner=new Scanner(System.in);
         int n=scanner.nextInt();
         scanner.nextLine();
         while (n-->0){
             String str1=scanner.nextLine();
             String str2=scanner.nextLine();
             getNext(str1);
             kmp(str2,str1);
         }
     }

    public static void kmp(String s,String t){
         int ans=0;
         int i=0,j=0;
        for(i=0;i<s.length();i++)
        {
            while(j>0&&t.charAt(j)!=s.charAt(i))
                j=next[j];
            if(t.charAt(j)==s.charAt(i))j++;
            if(j==t.length())
            {
                ans++;
                j=next[j];
            }
        }
         System.out.println(ans);
    }
    private static void getNext(String str1) {
        int j,k;
        j=0;
        k=-1;
        next[0]=-1;
        while(j<str1.length())
        {
            if(k==-1||str1.charAt(j)==str1.charAt(k))
            {
                next[++j]=++k;
            }
            else k=next[k];
        }
    }
}
