package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by user on 2017/10/10.
 */
public class Main483 {
    static int n,m,ex,ey;
    static int map[][]=new int[10][10];
    static Main483 main483=new Main483();
    static int d[][]={{0,-1},{0,1},{-1,0},{1,0}};
    class Node{
        int x,y,time,steps;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while (t-->0){
            n=scanner.nextInt();
            m=scanner.nextInt();
            int sx=0,sy=0;
            for (int i=0;i<n;i++){
                for (int j=0;j<m;j++){
                    map[i][j]=scanner.nextInt();
                    if (map[i][j]==2){
                        sx=i;
                        sy=j;
                        map[i][j]=1;
                    }
                    if (map[i][j]==3){
                        ex=i;
                        ey=j;
                    }
                }
            }
            int ans=bfs(sx,sy);
            System.out.println(ans);
        }
    }

    private static int bfs(int x, int y) {
        Queue<Node> queue=new LinkedList<Node>();
        Node temp=main483.new Node();
        temp.x=x;
        temp.y=y;
        temp.time=6;
        temp.steps=0;
        queue.offer(temp);
        int k=1;
        while (queue.size()!=0){
            Node cur=queue.poll();
            if (cur.time==1){
                continue;
            }
            if (cur.x==ex&&cur.y==ey){
                return cur.steps;
            }
            for (int i=0;i<4;i++){
                int dx=d[i][0]+cur.x;
                int dy=d[i][1]+cur.y;
                if (dx>=0&&dx<n&&dy>=0&&dy<m&&map[dx][dy]!=0){
                    Node ss=main483.new Node();
                    ss.x=dx;
                    ss.y=dy;
                    ss.steps=cur.steps+1;
                    ss.time=cur.time-1;
                    if (map[dx][dy]==4){
                        map[dx][dy]=1;
                        ss.time=6;
                    }
                    queue.offer(ss);
                }
            }
        }
        return -1;
    }
}
