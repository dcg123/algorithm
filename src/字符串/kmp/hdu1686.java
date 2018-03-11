package 字符串.kmp;

import java.util.Scanner;

/**
 * Created by user on 2017/8/20.
 */
public class hdu1686 {
    /**
     * HDU的题意就是，给你一个字符串A，一个字符串B，求A在B中总共出现了几次，注意，重复的也算。
     比如说
     str1 = "ABA"
     str2 = "ABABABA"
     这样的话，那么str1就在str2中出现了三次。
     */
    static int MAX_N=1000000+10;
    static int next[]=new int[MAX_N];
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        scanner.nextLine();
        while (t-->0){
            String str1=scanner.nextLine();
            String str2=scanner.nextLine();
            getNext(str1);
            kmp(str2,str1);
        }
    }
    private static void kmp( String s, String t) {
        int i = 0, j = 0, ans = 0;
        int lt = s.length(), lp = t.length();

        while (i < lt) {
            if (j == -1 || s.charAt(i) ==t.charAt(j)) {
                i++;
                j++;
            } else
                j = next[j];
            if (j == lp) {
                ans++;
                j=next[j];
            }
        }
        System.out.println(ans);
    }
    private static void getNext( String str2) {
        int i = 0, j = -1;
        next[0] = -1;

        while (i < str2.length()) {
            if (j == -1 || str2.charAt(i) == str2.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else
                j = next[j];
        }
    }
}
