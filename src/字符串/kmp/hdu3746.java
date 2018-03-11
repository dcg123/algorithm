package 字符串.kmp;

import java.util.Scanner;

/**
 * Created by user on 2017/8/21.
 */
public class hdu3746 {
    /**
     * 题目的意思很简单，就是CC喜欢循环的东西。现
     * 在给你一个字符串， 问你需要再加多少个字符串才可以补齐一个循环。
     是不是很抽象？ 这里我们就要用到next数组了。
     next 数组有人叫前缀数组，我觉得是 前后缀匹配数组
     他可以吧前面的字符和后面的字符进行匹配，这样大大节省了时间。
     */
    static int MAX_N=100010;
    static int next[]=new int[MAX_N];
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        scanner.nextLine();
        while (n-->0){
            String str=scanner.nextLine();
            getNext(str);
            int len=str.length();
            if(next[len]==0)
            {
                System.out.println(len);
                continue;
            }
            int t=len-next[len];
            if(len%t==0)System.out.printf("0\n");
            else
            {
                System.out.printf("%d\n",t-len%t);
            }
        }
    }
    private static void getNext(String str) {
        int i = 0, j = -1;
        next[0] = -1;
        while (i < str.length()) {
            if (j == -1 || str.charAt(i) == str.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else
                j = next[j];
        }
    }
}
