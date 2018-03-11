package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by user on 2017/10/3.
 */
public class Main1321 {
    static int d[][]={{0,-1},{0,1},{-1,0},{1,0}};
    static int m,n,ex,ey;
    static int map[][]=new int[210][210];
    static boolean vis[][]=new boolean[210][210];
    static int we[]=new int[40000],ni[]=new int[40000];
    class Node{
        int x,y;
    }
    static Main1321 main1321=new Main1321();
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while (t-->0){
            m=scanner.nextInt();
            n=scanner.nextInt();
            for (int i=0;i<m;i++){
                for (int j=0;j<n;j++){
                    map[i][j]=scanner.nextInt();
                }
            }
            ex=scanner.nextInt();
            ey=scanner.nextInt();
            ex--;
            ey--;
            int q=scanner.nextInt();
            for (int i=0;i<q;i++){
                we[i]=scanner.nextInt();
                ni[i]=scanner.nextInt();
            }
            boolean flag=false;
            for (int i=0;i<q;i++){
                init();
                if (bfs(we[i]-1,ni[i]-1)){
                    flag=true;
                    break;
                }
            }
            if (flag){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
    }

    private static void init() {
        for (int i=0;i<210;i++){
            for (int j=0;j<210;j++){
                vis[i][j]=false;
            }
        }
    }

    private static boolean bfs(int x, int y) {
        Queue<Node> queue=new LinkedList<Node>();
        vis[x][y]=true;
        Node temp=main1321.new Node();
        temp.x=x;
        temp.y=y;
        queue.offer(temp);
        while (queue.size()!=0){
            Node s=queue.poll();
            if (s.x==ex&&s.y==ey){
                return true;
            }
            for (int i=0;i<4;i++){
                int dx=s.x+d[i][0];
                int dy=s.y+d[i][1];
                if (dx>=0&&dx<m&&dy>=0&&dy<n&&!vis[dx][dy]&&(map[dx][dy]<=map[x][y])){
                    vis[dx][dy]=true;
                    Node ss=main1321.new Node();
                    ss.x=dx;
                    ss.y=dy;
                    queue.offer(ss);
                }
            }
        }
        return false;
    }
}
