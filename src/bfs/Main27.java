package bfs;

import java.util.Scanner;

/**
 * Created by user on 2017/10/3.
 */
public class Main27 {
    static int n,m;
    static int a[][]=new int[110][110];
    static int d[][]={{0,-1},{0,1},{-1,0},{1,0}};
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while (t-->0){
            m=scanner.nextInt();
            n=scanner.nextInt();
            for (int i=0;i<m;i++){
                for (int j=0;j<n;j++){
                    a[i][j]=scanner.nextInt();
                }
            }
            int sum=0;
            for (int i=0;i<m;i++){
                for (int j=0;j<n;j++){
                    if (a[i][j]==1){
                        dfs(i,j);
                        sum++;
                    }
                }
            }
            System.out.println(sum);
        }
    }

    private static void dfs(int x, int y) {
        a[x][y]=0;
        for (int i=0;i<4;i++){
            int dx=x+d[i][0];
            int dy=y+d[i][1];
            if (check(dx,dy)&&a[dx][dy]==1){
                dfs(dx,dy);
            }
        }
    }

    private static boolean check(int dx, int dy) {
        if (dx>=0&&dx<m&&dy>=0&&dy<n){
            return true;
        }
        return false;
    }
}
