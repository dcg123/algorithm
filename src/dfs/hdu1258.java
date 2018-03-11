package dfs;

/**
 * Created by user on 2017/10/17.
 */


        import java.util.Scanner;

public class hdu1258 {

    /**
     * @param args
     * 题目大意：就是给你一个数 t 和数 n，然后有n个数，
     * 问 t 是否能用 n 个数中的某几个数相加组成，如果能，把所有的情况输出
     */
    static int max=20;
    static int a[]=new int[max];
    static int ans[]=new int[max];
    static int sum,n;
    static boolean flag=false;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        String str;
        while(scan.hasNext()){
            str=scan.nextLine();
            String s[]=str.split(" ");
            sum=Integer.valueOf(s[0]);
            n=Integer.valueOf(s[1]);
            if(sum==0||n==0){
                break;
            }
            for(int i=1;i<=n;i++){
                a[i]=Integer.valueOf(s[i+1]);
            }
            System.out.println("Sums of "+sum+":");
            flag=false;
            dfs(1,1,0);
            if(!flag){
                System.out.println("NONE");
            }
        }
    }
    private static void dfs(int x, int count, int m) {
        // TODO Auto-generated method stub
        int last;
        if(m>sum){
            return ;
        }
        if(m==sum){
            flag=true;
            for(int i=1;i<count;i++){
                if(i==count-1){
                    System.out.println(ans[i]);
                }else{
                    System.out.print(ans[i]+"+");
                }
            }
        }
        last=-1;
        for(int i=x;i<=n;i++){
            if(last!=a[i]){
                last=a[i];
                ans[count]=a[i];
                dfs(i+1,count+1,m+a[i]);
            }
        }
    }

}
