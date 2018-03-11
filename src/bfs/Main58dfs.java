package bfs;

import java.util.Scanner;

/**
 * Created by user on 2017/10/3.
 */
public class Main58dfs {
    static int d[][]={{0,-1},{0,1},{-1,0},{1,0}};
    static int map[][] =
            {
                    {1,1,1,1,1,1,1,1,1},
                    {1,0,0,1,0,0,1,0,1},
                    {1,0,0,1,1,0,0,0,1},
                    {1,0,1,0,1,1,0,1,1},
                    {1,0,0,0,0,1,0,0,1},
                    {1,1,0,1,0,1,0,0,1},
                    {1,1,0,1,0,1,0,0,1},
                    {1,1,0,1,0,0,0,0,1},
                    {1,1,1,1,1,1,1,1,1}
            };
    static int sx,sy,ex,ey;
    static boolean vis[][]=new boolean[10][10];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        scanner.nextLine();
        while (t-->0){
            String str=scanner.nextLine();
            String [] b = str.split("\\s+");
            sx=Integer.valueOf(b[0]);
            sy=Integer.valueOf(b[1]);
            ex=Integer.valueOf(b[2]);
            ey=Integer.valueOf(b[3]);
            int sum=dfs(sx,sy,0);
            System.out.println(sum);
        }
    }

    private static int dfs(int x,int y,int cnt) {
        vis[x][y]=true;
        if (x==ex&&y==ey){
            return cnt;
        }
        for (int i=0;i<4;i++){
            int dx=x+d[i][0];
            int dy=y+d[i][1];
            if (dx>=0&&dx<=8&&dy>=0&&dy<=8&&map[dx][dy]==0&&!vis[dx][dy]){
                vis[dx][dy]=true;
                cnt++;
                dfs(dx,dy,cnt);
                vis[dx][dy]=false;
            }
        }
        return 0;
    }
}
