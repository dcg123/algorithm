package bfs;



        import java.util.Scanner;

public class hdu1035 {

    /**
     * @param args
     * 给你一个起点，你按照矩阵中路径给出的指令走就是了，输出走的步数或者循环状态的步数
     */
    static char map[][]=new char[21][21];
    static int mat[][]=new int[21][21];
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner (System.in);
        int n,m,t;
        while(((n=scan.nextInt())!=0)&&((m=scan.nextInt())!=0)&&((t=scan.nextInt())!=0)){
            int step=1;
            int x=1,y=t;
            int flag=0;
            for(int i=1;i<=n;i++){
                String str=scan.next();
                char b[]=str.toCharArray();
                for(int j=1;j<=m;j++){
                    map[i][j]=b[j-1];
                }
            }
            for(int i=0;i<21;i++){
                for(int j=0;j<21;j++){
                    mat[i][j]=0;
                }
            }
            int loop=0;
            while(true){
                if(map[x][y]=='N'&&mat[x][y]==0){
                    mat[x][y]=step;
                    x--;
                }else if(map[x][y]=='S'&&mat[x][y]==0){
                    mat[x][y]=step;
                    x++;
                }else if(map[x][y]=='E'&&mat[x][y]==0){
                    mat[x][y]=step;
                    y++;
                }else if(map[x][y]=='W'&&mat[x][y]==0){
                    mat[x][y]=step;
                    y--;
                }else if(map[x][y]!=0){
                    step--;
                    flag=1;
                    loop=step-mat[x][y]+1;
                    break;
                }else if(x<1||y<1||x>n||y>m){
                    step--;break;
                }
                step++;
            }
            if(flag==1){
                System.out.println((step-loop)+" step(s) before a loop of "+loop+" step(s)");
            }else{
                System.out.println(step+" step(s) to exit");
            }
        }
    }

}
