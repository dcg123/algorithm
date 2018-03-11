package 字符串;

import java.util.Scanner;

/**
 * Created by user on 2017/8/15.
 */
public class nod1088 {
    /**
     * 文串是指aba、abba、cccbccc、aaaa这种左右对称的字符串。
     输入一个字符串Str，输出Str里最长回文子串的长度。
     Input
     输入Str（Str的长度 <= 1000)
     Output
     输出最长回文子串的长度L。
     Input示例
     daabaac
     Output示例
     5
     * @param args
     */
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        int res=0;
        int length=str.length();
        char a[]=str.toCharArray();
        for(int i=0;i<length;i++){

            for(int j=0;(i-j)>=0&&(i+j)<length;j++){
                if(a[i-j]!=a[i+j]){
                    break;
                }
                int temp=2*j+1;
                if(temp>res){
                    res=temp;
                }
            }

            for(int j=0;(i-j)>=0&&i+j<length;j++){
                if(a[i-j]!=a[i+j]){
                    break;
                }
                int tmp=2*j+2;
                if (tmp >= res)
                    res = tmp;
            }
        }
    }
}
