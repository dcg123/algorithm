package 字符串.kmp;

import java.util.Scanner;

/**
 * Created by user on 2017/8/20.
 */
public class poj1961 {
    /**
     * (KMP求一个串的重复子串）
     *
     * KMP的前缀函数处理出来的前缀数组表示当当前字符失配后，要向前调到哪一个位置可以继续匹配。也就是代表着跳到的那个位置之前的所有字符与当前失配字母前的相同数量个字母是相匹配的。

     题目大意：
     给出一个字符串，求他之前大于1的循环节.
     */
    static int MAX_N=1000010;
    static int next[]=new int[MAX_N];
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        int T=1;
        int length, add;
        while (scanner.hasNext()){
            int len=scanner.nextInt();
            if(len==0){
                break;
            }
            scanner.nextLine();
            String str=scanner.nextLine();
            getNext(str);
            System.out.printf("Test case #%d\n", T++);
            for(int i = 1; i <= len; ++i)
            {
                length = i - next[i]; //循环节的长度
                if(i != length && i % length == 0) //如果有多个循环
                    System.out.println(i+" "+i/length);
            }
            System.out.printf("\n");
        }
    }

    private static void getNext(String str) {
        int i=0,j=-1;
        next[0]=-1;
        while (i<str.length()){
            if(j==-1||str.charAt(i)==str.charAt(j)){
                i++;
                j++;
                next[i]=j;
            }else{
                j=next[j];
            }
        }
    }
}
