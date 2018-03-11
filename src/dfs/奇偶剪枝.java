package dfs;


        import java.util.Scanner;

public class 奇偶剪枝 {

    /**
     * @param args
     * 题意:根据地图,'S'为开始位置,'D'为门的位置,' . '为空地,'X'为墙,不能经过,
    问:在指定的时间,是否能到达'门'的位置.
    注意:路不可以重复经过,时间也要刚好是 t ,不能少.
    思路:还是DFS,不能用BFS,因为BFS求的是最短路径,而此题的路径不一定最短.
    剪枝是关键,奇偶剪枝.
    奇偶剪枝原理:
    要理解奇偶剪枝,先了解一下曼哈顿距离,从一个点到达另外一个点的最短路径长度(时间)可以根据两点坐标求出,
    路径长度(非最短)与最短路径的长度同奇偶,它们的差一定是偶数!举个例子,就像两个偶数的差差是偶数,两个个数的差也是偶数.
    本题还有一个剪枝:n*m-wall与t的关系,wall为'X'的数量,解释一下,n*m为区域总数,
    所以m*n-wall<=t 一定不到到达终点,注意,少时等号在杭电上运行时间为546MS,而加上等号运行时间才为78MS!
     */
    static int MAXN=7;
    static char map[][]=new char [MAXN][MAXN];
    static String temp[]=new String[MAXN];
    static int flag=0;
    static int d[][]={{0,1},{1,0},{0,-1},{-1,0}};
    static int n,m;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        int t;
        int sx = 0,sy = 0,dx = 0,dy = 0;
        while(((n=scan.nextInt())!=0)&&((m=scan.nextInt())!=0)&&((t=scan.nextInt())!=0)){
            for(int i=1;i<=n;i++){
                temp[i]=scan.next();
                char a[]=temp[i].toCharArray();
                for(int j=1;j<=m;j++){
                    map[i][j]=a[j-1];
                    if(map[i][j]=='S'){
                        sx=i;
                        sy=j;
                    }
                    else if(map[i][j]=='D'){
                        dx=i;
                        dy=j;
                    }
                }
            }


            flag=0;

            dfs(sx,sy,t,dx,dy);

            if(flag==0){
                System.out.println("没有");
            }else{
                System.out.println("是");
            }

        }
    }
    private static void dfs(int sx, int sy, int t, int dx, int dy) {
        // TODO Auto-generated method stub
        if(flag==1){
            return ;
        }else if(t==0){
            if(sx==dx&&sy==dy){
                flag=1;
                return  ;
            }
            else{
                return ;
            }
        }else{
            for(int i=0;i<4;i++){
                int nx=sx+d[i][0];
                int ny=sy+d[i][1];
                if (nx>0&&nx<=n&&ny>0&&ny<=m&&(map[nx][ny]=='.'||map[nx][ny]=='D')){
                    map[nx][ny]='X';
                    dfs( nx,ny,dx,dy,t-1) ;
                    map[nx][ny]='.';
                }
            }
        }
    }


}
