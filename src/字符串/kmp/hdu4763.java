package 字符串.kmp;

import java.util.Scanner;

/**
 * Created by user on 2017/8/20.
 */
public class hdu4763 {
    /**
     * 题目描述：

     　　现有一字符串S，要求在S中找到最长的子串E，使得S满足格式“EAEBE”，其中A，B可以为任意的S子串。
     也就是说子串E既是S的前缀也是S的后缀，同时还在S中间出现，但不与前缀E与后缀E重叠。
     */
    static int MAX_N=1001000;
    static int next[]=new int[MAX_N];
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        scanner.nextLine();
        while (n-->0){
            String str1=scanner.nextLine();
            getNext(str1);
            int len=str1.length();

            int sum=0;
            for(int i=0;i<str1.length();i++){
                if(str1.charAt(0)!=str1.charAt(i)){
                    sum=1;
                }
            }
            if(sum==0){
                sum=str1.length()/3;
            }else{
                sum=0;
                int ans = next [str1.length()];
                for(int i = ans; i >0 && sum==0; i=next[i])
                {
                    for(int j = i*2; j <= str1.length()-i; j++)
                    {
                        if(next[j]>=i)
                            sum=i;
                    }
                }
            }
            System.out.println(sum);
        }
    }

    private static void getNext(String str1) {
        int i=0,j=-1;
        next[0]=-1;
        while (i<str1.length()){
            if(j==-1||str1.charAt(i)==str1.charAt(j)){
                i++;
                j++;
            }else{
                j=next[j];
            }
        }
    }
}
