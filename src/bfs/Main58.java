package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by user on 2017/10/3.
 */
public class Main58 {
    static int d[][]={{0,-1},{0,1},{-1,0},{1,0}};
    static int map[][] =
    {
        {1,1,1,1,1,1,1,1,1},
        {1,0,0,1,0,0,1,0,1},
        {1,0,0,1,1,0,0,0,1},
        {1,0,1,0,1,1,0,1,1},
        {1,0,0,0,0,1,0,0,1},
        {1,1,0,1,0,1,0,0,1},
        {1,1,0,1,0,1,0,0,1},
        {1,1,0,1,0,0,0,0,1},
        {1,1,1,1,1,1,1,1,1}
    };
    class Node{
        int x,y,steps;
    }
    static boolean vis[][]=new boolean[10][10];
    static Main58 main58=new Main58();
    static int sx,sy,ex,ey;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        scanner.nextLine();
        while (t-->0){

            String str=scanner.nextLine();
            String [] b = str.split("\\s+");
            sx=Integer.valueOf(b[0]);
            sy=Integer.valueOf(b[1]);
            ex=Integer.valueOf(b[2]);
            ey=Integer.valueOf(b[3]);
            int sum=bfs();
            System.out.println(sum);
        }
    }

    private static int bfs() {
        for (int i=0;i<10;i++){
            for (int j=0;j<10;j++){
                vis[i][j]=false;
            }
        }
        Queue<Node> queue=new LinkedList<Node>();
        Node temp=main58.new Node();
        temp.x=sx;
        temp.y=sy;
        temp.steps=0;
        queue.offer(temp);
        vis[sx][sy]=true;
        while (queue.size()!=0){
            Node s=queue.poll();
            if (s.x==ex&&s.y==ey){
                return s.steps;
            }
            for (int i=0;i<4;i++){
                int dx=d[i][0]+s.x;
                int dy=d[i][1]+s.y;
                if (dx>=0&&dx<=8&&dy>=0&&dy<=8&&map[dx][dy]==0&&!vis[dx][dy]){
                    Node ss=main58.new Node();
                    ss.x=dx;
                    ss.y=dy;
                    ss.steps=s.steps+1;
                    queue.offer(ss);
                    vis[dx][dy]=true;
                }
            }
        }
        return 0;
    }
}
