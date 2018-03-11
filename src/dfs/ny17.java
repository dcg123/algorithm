package dfs;
import java.util.Scanner;
public class ny17 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner input=new Scanner(System.in);
        int n,m;
        String str;
        int []MaxLen=new int[10001];
        char[] s=new char[10001];
        n=input.nextInt();
        int max=0;
        while(n>0){
            str=input.next();
            s=str.toCharArray();
            LIS(MaxLen,s);
            for(int i=0;i<s.length;i++){
                if(max<MaxLen[i]){
                    max=MaxLen[i];
                }
            }
            System.out.println(max);
            max=0;
            n--;
        }
    }

    private static void LIS(int[] maxLen, char[] s) {
        // TODO Auto-generated method stub
        for(int i=0;i<s.length;i++){
            maxLen[i]=1;
            for(int j=0;j<i;j++){
                if(s[i]>s[j]){
                    if(maxLen[i]<maxLen[j]+1){
                        maxLen[i]=maxLen[j]+1;
                    }
                }
            }
        }
    }

}
