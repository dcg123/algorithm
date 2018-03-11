package 数据结构.树状数组;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by user on 2017/10/11.
 */
public class hdu1166 {
    /**
     * 每组数据第一行一个正整数N（N <= 50000），表示敌人有Ñ个工兵营地，
     * 接下来有Ñ个正整数，第I个正整数ai代表第i个工兵营地里开始时有ai个人（1 <= ai <= 50）。
     接下来每行有一条命令，命令有4种形式：
     （1）添加ij，i和j为正整数，表示第i个营地增加j个人（j不超过30）
     （2）Sub ij，i and j为正整数，表示第i个营地减少j个人（j不超过30）;
     （3）查询ij，i和j为正整数，i <= j，表示询问第i到第j个营地的总人数;
     （4）结束表示结束，这条命令在每组数据最后出现;
     每组数据最多有40000条命令
     * @param args
     */
    static int n;
    static int c[]=new int[50000+10];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        int count=0;
        while (t-->0){
            count++;
            n=scanner.nextInt();
            Arrays.fill(c,0);
            //创建树
            scanner.nextLine();
            String str=scanner.nextLine();
            String a[]=str.split(" ");
            for (int i=1;i<=n;i++){
                add(i,Integer.valueOf(a[i-1]));
            }
            System.out.println("Case "+count+":");
            while (scanner.hasNextLine()){
                str=scanner.nextLine();
                if (str.equals("End")){
                    break;
                }
                a=str.split(" ");
                int x=Integer.valueOf(a[1]);
                int y=Integer.valueOf(a[2]);
                if (a[0].equals("Query")){
                    System.out.println(query(y)-query(x-1));
                }else if (a[0].equals("Add")){
                    add(x,y);
                }else if (a[0].equals("Sub")){
                    add(x,-y);
                }
            }
        }
    }



    private static int query(int k) {
        int sum=0;
        while (k>0){
            sum+=c[k];
            k-=k&-k;
        }
        return sum;
    }

    private static void add(int k, int num) {
        while (k<=n){
            c[k]+=num;
            k+=k&-k;
        }
    }
}
