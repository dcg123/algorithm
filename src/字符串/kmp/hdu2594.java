package 字符串.kmp;

import java.util.Scanner;

/**
 * Created by user on 2017/8/20.
 */
public class hdu2594 {
    /**
     * 题意：给定两个字符串s1,s2,求最长的s1前缀ss使得ss为s2的最长后缀,输出该字符串和其长度。
     */
    static int MAX_N=50000+10;
    static int next[]=new int[MAX_N];
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String s1=scanner.nextLine();
            String s2=scanner.nextLine();
            getNext(s1);
            kmp(s1,s2);
        }
    }

    private static void kmp( String s1, String s2) {
        int i = 0, j = 0;
        while (i < s2.length()) {
            if (j == -1 || s1.charAt(j) == s2.charAt(i)) {
                i++;
                j++;
            } else{
                j = next[j];
            }

        }
        if(j<=0)
            System.out.println(j);
        else {
            for (int k = 0; k < j; k++) {
                System.out.print(s1.charAt(k));
            }
            System.out.println(" "+j);
        }
    }
    private static void getNext(String s1) {
        int i = 0, j = -1;
        next[0] = -1;
        while (i < s1.length()) {
            if (j == -1 || s1.charAt(i) == s1.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else
                j = next[j];
        }
    }
}
