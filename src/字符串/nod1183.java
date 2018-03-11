package 字符串;

import java.util.Scanner;

/**
 * Created by user on 2017/8/17.
 */
public class nod1183 {
    /**
     * 是指两个字串之间，由一个转成另一个所需的最少编辑操作次数。许可的编辑操作包括将一个字符替换成另一个字符，插入一个字符，删除一个字符。

     先定义这样一个函数——edit(i, j)，它表示第一个字符串的长度为i的子串到第二个字符串的长度为j的子串的编辑距离。
     显然可以有如下动态规划公式：
     ● if i == 0 且 j == 0，edit(i, j) = 0
     ● if i == 0 且 j > 0，edit(i, j) = j
     ● if i > 0 且j == 0，edit(i, j) = i
     ● if i ≥ 1  且 j ≥ 1 ，edit(i, j) == min{ edit(i-1, j) + 1, edit(i, j-1) + 1, edit(i-1, j-1) + f(i, j) }，当第一个字符串的第i个字符不等于第二个字符串的第j个字符时，f(i, j) = 1；否则，f(i, j) = 0。
     */
    static int MAX_N=1000+2;
    static int dp[][]=new int[MAX_N][MAX_N];
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        String str1=scanner.nextLine();
        char a[]=str.toCharArray();
        char b[]=str1.toCharArray();
        for(int i=0;i<a.length;i++){
            dp[i][0]=i;
        }
        for (int j=0;j<b.length;j++){
            dp[0][j]=j;
        }
        for(int i=1;i<a.length+1;i++){
            for(int j=1;j<b.length+1;j++){
                int temp=Math.min(dp[i-1][j]+1,dp[i][j-1]+1);
                int d;
                if(a[i-1]==b[j-1]){
                    d=0;
                }else{
                    d=1;
                }
                dp[i][j]=Math.min(temp,dp[i-1][j-1]+d);
            }
        }
        System.out.println(dp[a.length][b.length]);
    }
}
