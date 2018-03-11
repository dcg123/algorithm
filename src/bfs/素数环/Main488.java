package bfs.素数环;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by user on 2017/10/10.
 */
public class Main488 {
    static int n;
    static int a[]=new int[25];
    static int vis[]=new int[25];
    static int prime[]={0,0,1,1,0,1,0,1,0,0,0,1,0,1,0,0,0,1,0,1,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,0,0,1,0,1,0,0};
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=0;
        while (scanner.hasNext()){
            t++;
            n=scanner.nextInt();
            if (n==0){
                break;
            }
            if (n==1){
                System.out.println("Case "+t+":");
                System.out.println("1");
            }
            else if (n%2==1){
                System.out.println("Case "+t+":");
                System.out.println("No Answer");
            }else {
                System.out.println("Case "+t+":");
                Arrays.fill(vis,0);
                a[1]=1;
                dfs(2);
            }

        }
    }

    private static void dfs(int count) {
        if (count==n+1&&prime[a[n]+a[1]]==1){
            for (int i=1;i<=n;i++){
                System.out.printf("%d ",a[i]);
            }
            System.out.println();
        }
        else {
            for (int i=2;i<=n;i++){
                if (vis[i]==0&&prime[i+a[count-1]]==1){
                    vis[i]=1;
                    a[count]=i;
                    dfs(count+1);
                    vis[i]=0;
                }
            }
        }
    }
}
