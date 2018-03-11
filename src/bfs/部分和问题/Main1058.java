package bfs.部分和问题;

import java.util.Scanner;

/**
 * Created by user on 2017/10/4.
 */
public class Main1058 {
    static int n, k;
    static int a[]=new int[25], b[]=new int[25];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        k=scanner.nextInt();
        for (int i=0;i<n;i++){
            a[i]=scanner.nextInt();
        }
        if (dfs(0,0)){
            System.out.println("YES");
            for(int i = 0; i < n; ++i)
                if(b[i]==1) System.out.printf("%d ", a[i]);
            System.out.printf("\n");
        }else {
            System.out.println("NO");
        }
    }

    private static boolean dfs(int i, int sum) {
        if (i==n){
            return sum==k;
        }
        b[i]=0;
        if (dfs(i+1,sum)){
            return true;
        }
        b[i]=1;
        if (dfs(i+1,sum+a[i])){
            return true;
        }
        return false;
    }
}
