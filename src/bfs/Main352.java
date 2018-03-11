package bfs;

import java.util.Scanner;

/**
 * Created by user on 2017/10/3.
 */
public class Main352 {
    static int a[]=new int[30];
    static int n,total=0,m;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            n=scanner.nextInt();
            total=0;
            m=20001;
            for (int i=1;i<=n;i++){
                a[i]=scanner.nextInt();
                total+=a[i];
            }
            dfs(1,0);
            System.out.println(m);
        }
    }

    private static void dfs(int cur, int sum) {
        if(cur==n+1) return;
        int t;
        t=(int)(Math.abs(total-2*sum));
        if(t<m)
            m=t;
        dfs(cur+1,sum+a[cur]);
        dfs(cur+1,sum);
    }
}
