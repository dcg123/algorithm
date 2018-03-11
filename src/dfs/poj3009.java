package dfs;



        import java.util.Scanner;

public class poj3009 {

    /**
     * @param args
     * 就是要求把一个冰壶从起点“2”用最少的步数移动到终点“3”
    其中0为移动区域，1为石头区域，冰壶一旦想着某个方向运动就不会停止，
    也不会改变方向（想想冰壶在冰上滑动），除非冰壶撞到石头1 或者 到达终点 3
     */
    static int w,h;
    static int map[][]=new int[20+2][20+2];
    static int min;
    static int step=0;
    static int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    static int sx,sy,ex,ey;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            w=scan.nextInt();
            h=scan.nextInt();
            if(w==0&&h==0){
                break;
            }
            for(int i=0;i<h;i++){
                for(int j=0;j<w;j++){
                    map[i][j]=scan.nextInt();
                    if(map[i][j]==2){
                        sx=i;
                        sy=j;
                        map[i][j]=0;
                    }
                    if(map[i][j]==3){
                        ex=i;
                        ey=j;
                    }
                }
            }
            min=Integer.MAX_VALUE;
            dfs(0,sx,sy);
            if(min==Integer.MAX_VALUE){
                System.out.println("-1");
            }else{
                System.out.println(min);
            }

        }
    }

    private static void dfs(int step, int x, int y) {
        // TODO Auto-generated method stub
        if(step>=10){
            return ;
        }
        for(int i=0;i<4;i++){
            int k=x+dir[i][0];
            int v=y+dir[i][1];
            if(ok(k,v)){
                if(map[k][v]==1){
                    continue;
                }
                while(map[k][v]==0){
                    k+=dir[i][0];
                    v+=dir[i][1];
                    if(!ok(k,v)){
                        break;
                    }
                }

                if(ok(k,v)){
                    if(map[k][v]==3){
                        if(step+1<min){
                            min=step+1;
                            return ;
                        }
                    }
                    if(map[k][v]==1){
                        map[k][v]=0;
                    }
                    dfs(step+1,k-dir[i][0],v-dir[i][1]);
                    map[k][v]=1;
                }

            }
        }
    }

    private static boolean ok(int x, int y) {
        // TODO Auto-generated method stub
        if(x>=0&&x<h&&y>=0&&y<w){
            return true;
        }
        return false;
    }

}
