package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by user on 2017/10/3.
 */
public class Main82 {
    /**
     * 一个叫ACM的寻宝者找到了一个藏宝图，它根据藏宝图找到了一个迷宫，
     * 这是一个很特别的迷宫，迷宫里有N个编过号的门（N<=5)，
     * 它们分别被编号为A,B,C,D,E.为了找到宝藏，ACM必须打开门，但是，开门之前必须在迷宫里找到这个打开这个门所需的所有钥匙（每个门都至少有一把钥匙），例如：现在A门有三把钥匙，ACM就必须找全三把钥匙才能打开A门。现在请你编写一个程序来告诉ACM，他能不能顺利的得到宝藏
     */
    static char map[][]=new char[25][25];
    static int d[][]={{0,-1},{0,1},{-1,0},{1,0}};
    static int n,m;
    static char get[]=new char[10];
    static boolean vis[][]=new boolean[25][25];
    class Node{
        int x,y;
    }
    static Main82 main82=new Main82();
    static int ex,ey;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            n=scanner.nextInt();
            m=scanner.nextInt();
            if (n+m==0){
                break;
            }
            int sx = 0,sy=0;
            scanner.nextLine();
            for (int i=0;i<n;i++){
                String str=scanner.nextLine();
                char a[]=str.toCharArray();
                for (int j=0;j<m;j++){
                    map[i][j]=a[j];
                    if (map[i][j]=='S'){
                      sx=i;
                      sy=j;
                      map[i][j]='.';
                    }
                    if (map[i][j]=='G'){
                        ex=i;
                        ey=j;
                        map[i][j]='.';
                    }
                }
            }
            boolean flag=bfs(sx,sy);
        }
    }
    static boolean bfs(int x,int y){
        vis[x][y]=true;
        Queue<Node> queue=new LinkedList<Node>();
        Node temp=main82.new Node();
        temp.x=x;
        temp.y=y;
        queue.offer(temp);
        while (queue.size()!=0){
            Node s=queue.poll();
            if (s.x==ex&&s.y==ey){
                return true;
            }
            for (int i=0;i<4;i++){
                int dx=x+d[i][0];
                int dy=y+d[i][1];
            }
        }
        return false;
    }
}
