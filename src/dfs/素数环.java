package dfs;



        import java.util.Scanner;

public class 素数环 {

    /**
     * @param args
     * 题意：输入一个数n,把1到n的自然数放到一个环里，保证相邻的两个数的和是素数。
    思路：素数打表+深搜。
     */
    static int prime[]={0,1,1,1,0,1,0,1,0,0,0,1,0,1,0,0,0,1
            ,0,1,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,0,0,1,0,0},n;//素数打表，因为n最大是20，所以只要打到40
    static int []vis=new int[50];
    static int []a=new int[50];
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        int ans=0;
        a[1]=1;
        while(scan.hasNext()){
            ans++;
            n=scan.nextInt();
            System.out.println("Case "+ans+":");
            for(int i=0;i<50;i++){
                vis[i]=0;
            }
            dfs(2);
            System.out.println();
        }
    }
    private static void dfs(int step) {
        // TODO Auto-generated method stub
        if(step == n+1 && prime[a[n]+a[1]]==1)//结束条件
        {
            for(int i = 1;i<n;i++)
                System.out.print(a[i]+" ");
            System.out.println(a[n]);
            return ;
        }
        for(int i = 2;i<=n;i++)
        {
            if(vis[i]==0 && prime[i+a[step-1]]==1)//此数未用并且与上一个放到环中的数相加是素数
            {
                a[step] = i;
                vis[i] = 1;
                dfs(step+1);
                vis[i] = 0;
            }
        }

    }

}
