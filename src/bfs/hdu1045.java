package bfs;


        import java.util.Scanner;

public class hdu1045 {

    /**
     * @param args
     * //这题意思是给出一张图，图中'X'表示wall,'.'表示空地,可以放置blockhouse
    //同一条直线上只能有一个blockhouse，除非有wall隔开，问在给出的图中
    //最多能放置多少个blockhouse
     */
    static int n;
    static char map[][]=new char[5][5];

    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,1,-1};
    static int max;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        while((n=scan.nextInt())>0){
            for(int i=0;i<n;i++){
                String str=scan.next();
                char a[]=str.toCharArray();
                for(int j=0;j<a.length;j++){
                    map[i][j]=a[j];
                }
            }
            max=0;
            dfs(0);
            System.out.println(max);
        }
    }
    private static void dfs(int ans) {
        // TODO Auto-generated method stub
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(ok(i,j)){
                    map[i][j]='1';
                    dfs(ans+1);
                    map[i][j]='.';
                }
            }
            if(max<ans){
                max=ans;
            }
        }
    }
    private static boolean ok(int x, int y) {
        // TODO Auto-generated method stub
        int x1,y1;
        if(map[x][y]!='.')
            return false;
        for(int i=0;i<4;i++){
            x1=x+dx[i];
            y1=y+dy[i];
            while(true){
                if(x1<0||y1<0||x1>=n||y1>=n||map[x1][y1]=='X')
                    break;
                else if(map[x1][y1]=='1'){
                    return false;
                }
                x1+=dx[i];
                y1+=dy[i];
            }
        }

        return true;
    }

}
