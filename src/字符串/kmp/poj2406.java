package 字符串.kmp;

import java.util.Scanner;

/**
 * Created by user on 2017/8/20.
 */
public class poj2406 {
    /**
     * 给出一个字符串 问它最多由多少相同的字串组成
     * kmp求最小循环节
     *
     * 大意：给出一个字符串 问它最多由多少相同的字串组成

     如  abababab由4个ab组成
     */
    static int MAX_N=1000000+10;
    static int next[]=new int[MAX_N];
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String str=scanner.nextLine();
            if(str.equals(".")){
                break;
            }
            getNext(str);
            int ans=1;
            int len=str.length();
            if(len%(len-next[len])==0){
                ans=len/(len-next[len]);
            }
            System.out.println(ans);
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
