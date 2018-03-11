package dfs;


        import java.util.Scanner;

public class AOj0118 {

    /**
     * @param args
     * 题意：
    在H * W的矩形果园里有苹果、梨、蜜柑三种果树，
    相邻（上下左右）的同种果树属于同一个区域，给出果园的果树分布，
    求总共有多少个区域。 （原题的样图中苹果为リ，梨为カ，蜜柑为ミ， 图中共10个区域）
    输入：
    多组数据，每组数据第一行为两个整数H，W（H <= 100, W <= 100），
    H =0 且 W = 0代表输入结束。以下H行W列表示果园的果树分布， 苹果是@，梨是#， 蜜柑是*。
    输出：
    对于每组数据，输出其区域的个数。
     */
    static int MAX_H=100;
    static char farm[][]=new char[MAX_H][MAX_H];
    static int n,m;
    static int ans=0;
    static int direction[][] = {
            { -1, 0 },
            { 1, 0 },
            { 0, -1 },
            { 0, 1 },
    };
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            n=scan.nextInt();
            m=scan.nextInt();
            if(n==0||m==0){
                break;
            }
            scan.nextLine();
            for(int i=0;i<n;i++){
                String str=scan.nextLine();
                char a[]=str.toCharArray();
                for(int j=0;j<m;j++){
                    farm[i][j]=a[j];
                }
            }
            ans=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(farm[i][j]!='x'){
                        dfs(i,j,farm[i][j]);
                        ans++;
                    }
                }
            }
            System.out.println();
        }
    }
    private static void dfs(int x, int y, char c) {
        // TODO Auto-generated method stub
        farm[x][y]='x';
        for(int i=0;i<4;i++){
            int xx=direction[i][0]+x;
            int yy=direction[i][1]+y;
            if(xx>0&&xx<n&&yy>0&&yy<m&&farm[xx][yy]==c){
                dfs(xx,yy,c);
            }
        }
    }

}
