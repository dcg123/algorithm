package bfs;


        import java.util.Scanner;

/**
 * Created by user on 2017/8/9.
 */
public class poj1979 {
    /**
     *有一个矩形的房间，里面铺满了方形的瓷砖。每一个瓷砖有红色还有黑色两种，人只能站在黑色的瓷砖上不能站在红色的瓷砖上，
     * 每次只能走前后左右四个方向的四个瓷砖，计算能够到达的黑色瓷砖的总面积数。
     */
    static int MAX_N=20+2;
    static char map[][]=new char[MAX_N][MAX_N];
    static int n,m,ans;
    static int dir[][]={{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            n=scanner.nextInt();
            m=scanner.nextInt();
            if(n+m==0){
                break;
            }
            scanner.nextLine();
            int sx = 0,sy = 0;
            for(int i=0;i<m;i++){
                String str=scanner.nextLine();
                char a[]=str.toCharArray();
                for(int j=0;j<n;j++){
                    map[i][j]=a[j];
                    if(map[i][j]=='@'){
                        sx=i;
                        sy=j;
                        map[i][j]='.';
                    }
                }
            }
            ans=0;
            dfs(sx,sy);
            System.out.println(ans);
        }
    }
    public static  void  dfs(int sx,int sy){
        for(int i=0;i<4;i++){
            int dx=sx+dir[i][0];
            int dy=sy+dir[i][1];
            if(check(dx,dy)&&map[dx][dy]=='.'){
                ans++;
                map[dx][dy]='#';
                dfs(dx,dy);
            }
        }
    }

    private static boolean check(int dx, int dy) {
        if(dx>=0&&dx<m&&dy>=0&&dy<n){
            return true;
        }
        return false;
    }
}
