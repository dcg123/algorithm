package dfs;

        import java.util.Scanner;

public class poj1979 {

    /**
     * @param args
     * 就像是小时候玩的吃豆子的游戏，上下左右走，然后统计一共能吃到多少个豆子。
     */
    static char map[][]=new char[20+5][20+5];
    static int n,m;
    static int ans=0;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            int sx = 0,sy = 0;
            n=scan.nextInt();
            m=scan.nextInt();
            if(n==0||m==0){
                break;
            }
            scan.nextLine();
            for(int i=0;i<m;i++){
                String str=scan.nextLine();
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
            System.out.println(sx+" "+sy);
            System.out.println(ans);
        }
    }
    private static void dfs(int sx, int sy) {
        // TODO Auto-generated method stub
        if(sx>0&&sx<m&&sy>0&&sy<n&&map[sx][sy]=='.'){
            ans++;
            map[sx][sy]='#';
        }else{
            return ;
        }
        dfs(sx-1,sy);
        dfs(sx,sy-1);
        dfs(sx,sy+1);
        dfs(sx+1,sy);
    }

}
