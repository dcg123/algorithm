package bfs;

import java.util.Scanner;

/**
 * Created by user on 2017/10/3.
 */
public class Main32 {
    static int n,r;
    static int ans[]=new int[11];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        r=scanner.nextInt();
        dfs(n,0);
    }

    private static void dfs(int n, int cur) {
        if (cur==r){
            for (int i=0;i<cur;i++){
                System.out.print(ans[i]);
            }
            System.out.println();
            return;
        }else {
            for (int j=n;j>=1;j--){
                ans[cur]=j;
                dfs(--n,cur+1);
            }
        }
    }
}
