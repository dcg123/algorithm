package dfs;



//dfs代码
        import java.util.Scanner;

public class hdu1321 {

    /**
     * @param args
     * 根据地图,问可以到达多少地方.'@'为起点, ' . '为路,可以到达, ' # '为墙,不能通过.
     */
    static int dir[][]={{-1,0},{0,1},{1,0},{0,-1}};//上，右，下，左
    static int MAX=25;
    static char map[][]=new char[MAX][MAX];
    static int n,m;

    static int step=0;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        while((n=scan.nextInt())!=0&&(m=scan.nextInt())!=0){
            int s_x = 0,s_y = 0;//开始的位置
            String str=scan.nextLine();//接收回车符
            for(int i=0;i<m;i++){
                str=scan.nextLine();
                char b[]=str.toCharArray();
                for(int j=0;j<n;j++){
                    map[i][j]=b[j];
                    if(map[i][j]=='@'){
                        s_x=i;
                        s_y=j;
                    }
                }
            }
            step=0;
            dfs(s_x,s_y);
            System.out.println(step);
        }
    }
    private static void dfs(int x,int y) {
        // TODO Auto-generated method stub
        map[x][y]='#';
        step++;
        for(int i=0;i<4;i++){
            int xx=x+dir[i][0];
            int yy=y+dir[i][1];
            if(xx>=0&&xx<m&&yy>=0&&yy<n&&map[xx][yy]=='.'){
                dfs(xx,yy);
            }
        }
        return ;
    }

}
