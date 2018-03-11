package 字符串.kmp;

import java.util.Scanner;

/**
 * Created by user on 2017/8/20.
 */
public class hdu1711 {
    /**
     * 题意：给出一个待匹配串和一个模式串，
     * 问模式串在哪个位置被匹配，输出最小位置，若没有匹配，输出-1
     */
    static int MAX_N=10000+10;
    static int next[]=new int[1000000+10];
    static int st1[]=new int[1000000+10];
    static int str2[]=new int[MAX_N];
    static int a,b;
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        while (n-->0){
            a=scanner.nextInt();
            b=scanner.nextInt();
            for(int i=0;i<a;i++){
                st1[i]=scanner.nextInt();
            }
            for(int j=0;j<b;j++){
                str2[j]=scanner.nextInt();
            }
            getNext(str2);
            kmp(st1,str2);
        }
    }
    private static void kmp( int T[], int P[]) {
        int i = 0, j = 0;
        while (i < a&&j<b) {
            if (j == -1 || T[i] == P[j]) {
                i++;
                j++;
            } else{
                j = next[j];
            }

        }
        if(j<b)
            System.out.println("-1");
        else
            System.out.println(i-b+1);
    }
    private static void getNext( int P[]) {
        int i = 0, j = -1;
        next[0] = -1;
        while (i < b) {
            if (j == -1 || P[i] == P[j]) {
                i++;
                j++;
                next[i] = j;
            } else
                j = next[j];
        }
    }
}
