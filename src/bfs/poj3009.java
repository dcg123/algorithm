package bfs;



        import java.util.Scanner;

/**
 * Created by user on 2017/8/9.
 */
public class poj3009 {
    /**
     * 题意不难懂，我大致翻译一下：
     就是要求把一个冰壶从起点“2”用最少的步数移动到终点“3”
     其中0为移动区域，1为石头区域，冰壶一旦想着某个方向运动就不会停止，
     也不会改变方向（想想冰壶在冰上滑动），除非冰壶撞到石头1 或者 到达终点 3
     */
    static int MAX_N=100+2;
    static int dir[][]={{-1,0},{0,1},{1,0},{0,-1}};
    static int map[][]=new int[MAX_N][MAX_N];
    static int h,w,ex,ey,ans=11;
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            w=scanner.nextInt();
            h=scanner.nextInt();
            if(w+h==0){
                break;
            }
            int sx=0,sy=0;
            for(int i=0;i<h;i++){
                for(int j=0;j<w;j++){
                    map[i][j]= scanner.nextInt();
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
            dfs(sx,sy,0);
            if(ans<10){
                System.out.println("-1");
            }else {
                System.out.println(ans);
            }
        }
    }

    private static void dfs(int sx, int sy,int step) {
        if(step>=10||step>ans){
            return ;
        }
        for(int i=0;i<4;i++){
            int dx=sx;
            int dy=sy;
            while(dx>=0&&dx<h&&dy>=0&&dy<w){
                switch (map[dx][dy]){
                    case 0:
                    {
                        dx+=dir[i][0];
                        dy+=dir[i][1];
                    }break;
                    case 3:
                    {
                        if(step+1<ans){
                            ans=step+1;
                        }
                        dx=-1;
                    }break;
                    case 1:
                    {
                        //出发地点四周不能有石块
                        if(!(dx-dir[i][0]==sx&&dy-dir[i][1]==sy)){
                            map[dx][dy]=0;
                            //后退一步 继续跑
                            dfs(dx-dir[i][0],dy-dir[i][1],step+1);
                            map[dx][dy]=1;
                        }
                        dx=-1;
                    }break;
                }
            }
        }
    }

    private static boolean check(int dx, int dy) {
        if(dx>=0&&dx<h&&dy>=0&&dy<w){
            return true;
        }
        return  false;
    }
}
