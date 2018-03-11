package bfs;



        import java.util.Scanner;

/**
 * Created by user on 2017/8/9.
 */
public class aoj0118 {
    /**
     * 题意：
     在H * W的矩形果园里有苹果、梨、蜜柑三种果树， 相邻（上下左右）的同种果树属于同一个区域，给出果园的果树分布，求总共有多少个区域。 （原题的样图中苹果为リ，梨为カ，蜜柑为ミ， 图中共10个区域）
     输入：
     多组数据，每组数据第一行为两个整数H，W（H <= 100, W <= 100）， H =0 且 W = 0代表输入结束。以下H行W列表示果园的果树分布， 苹果是@，梨是#， 蜜柑是*。
     输出：
     对于每组数据，输出其区域的个数。
     */
    static int MAX_N=100+2;
    static int dir[][]={{-1,0},{0,1},{1,0},{0,-1}};
    static char map[][]=new char[MAX_N][MAX_N];
    static int h,w,ans;
    public static void  main(String args[]){
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            h=scanner.nextInt();
            w=scanner.nextInt();
            if(w+h==0){
                break;
            }
            scanner.nextLine();
            for (int i=0;i<h;i++){
                String str=scanner.nextLine();
                char a[]=str.toCharArray();
                for(int j=0;j<w;j++){
                    map[i][j]=a[j];
                }
            }
            ans=0;
            for(int i=0;i<h;i++){
                for(int j=0;j<w;j++){
                    if(map[i][j]!='x'){
                        dfs(i,j,map[i][j]);
                        ans++;
                    }
                }
            }
            System.out.println(ans);
        }
    }

    private static void dfs(int x, int y,char s) {
        map[x][y]='x';
        for(int i=0;i<4;i++){
            int dx=x+dir[i][0];
            int dy=y+dir[i][1];
            if(dx>=0&&dx<h&&dy>=0&&dy<w&&map[dx][dy]==s){
                dfs(dx,dy,map[dx][dy]);
            }
        }
    }
}
