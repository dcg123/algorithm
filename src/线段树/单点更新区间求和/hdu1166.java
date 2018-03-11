package 线段树.单点更新区间求和;

import java.util.Scanner;

/**
 * Created by user on 2017/10/14.
 */
public class hdu1166 {
    /**
     * 第一行一个整数T，表示有T组数据。
     每组数据第一行一个正整数N（N<=50000）,表示敌人有N个工兵营地，接下来有N个正整数,第i个正整数ai代表第i个工兵营地里开始时有ai个人（1<=ai<=50）。
     接下来每行有一条命令，命令有4种形式：
     (1) Add i j,i和j为正整数,表示第i个营地增加j个人（j不超过30）
     (2)Sub i j ,i和j为正整数,表示第i个营地减少j个人（j不超过30）;
     (3)Query i j ,i和j为正整数,i<=j，表示询问第i到第j个营地的总人数;
     (4)End 表示结束，这条命令在每组数据最后出现;
     */
    static int MAX=50000+10;
    static int n;
    static int a[]=new int[MAX];

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while (t-->0){
            n=scanner.nextInt();
            scanner.nextLine();
            String str=scanner.nextLine();
            String b[]=str.split(" ");
            for (int i=1;i<=n;i++){
                int value= Integer.valueOf(b[i-1]);
                add(i,value);
            }
            while (scanner.hasNextLine()){
                str=scanner.nextLine();
                b=str.split(" ");
                if (b[0].equals("End")){
                    break;
                }
                int x=Integer.valueOf(b[1]);
                int y=Integer.valueOf(b[2]);
                if (b[0].equals("Query")){
                   if (x>y){
                       int temp=x;
                       x=y;
                       y=temp;
                   }
                   System.out.println(query(y)-query(x-1));
                }else if (b[0].equals("Sub")){
                    add(x,-y);
                }else {
                    add(x,y);
                }
            }
        }
    }

    private static int query(int k) {
        int sum=0;
        while (k>0){
            sum+=a[k];
            k-=k&(k^(k-1));
        }
        return sum;
    }

    private static void add(int k, int sum) {
        while (k<=n){
            a[k]+=sum;
            k+=k&(k^(k-1));
        }
    }
}
