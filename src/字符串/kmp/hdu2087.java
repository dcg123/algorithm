package 字符串.kmp;

import java.util.Scanner;

/**
 * Created by user on 2017/8/20.
 */
public class hdu2087 {
    /**
     * 题意:
     给你两个串S和T，问你S中最多不重叠的包含了多少个T串？ 不重复
     析:
     直接用KMP算法,用T模式串去匹配S主串即可，但是当匹配成功的时候要看看当前匹配点离上一个匹配点是不是距离差>=T的长度。
     那么我们按上面的找法确实可以找到不重叠的串T的各个匹配点，
     我们如何保证这个结果就是最多匹配T串的结果？其实这个问题等价于
     给你n个长度相同的时间区间，然后要你找出最多的不重叠的那些时间区间？
     对于这个问题就是贪心的从左到右依次选取，证明过程也很简单。
     */
    static int next[]=new int[1010];

    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String str1=scanner.next();
            String str2=scanner.next();
            getNext(next,str2);
            kmp(next,str1,str2);
        }
    }

    private static void kmp(int[] next, String s, String t) {
        int i = 0, j = 0, ans = 0;
        int lt = s.length(), lp = t.length();
        char T[]=s.toCharArray();
        char P[]=t.toCharArray();
        while (i < lt) {
            if (j == -1 || T[i] == P[j]) {
                i++;
                j++;
            } else
                j = next[j];
            if (j == lp) {
                ans++;
                j = 0;
            }
        }
        System.out.println(ans);
    }

    private static void getNext(int[] next, String str2) {
        int i = 0, j = -1;
        next[0] = -1;
        char P[]=str2.toCharArray();
        while (i < str2.length()) {
            if (j == -1 || P[i] == P[j]) {
                i++;
                j++;
                next[i] = j;
            } else
                j = next[j];
        }
    }
}
