package bfs.迷宫;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by user on 2017/10/10.
 */
public class Main82 {
    static int m,n;
    static char map[][]=new char[25][25];
    class Node{
        int x,y;
    }
    static boolean vis[][]=new boolean[25][25];
    static int d[][]={{0,-1},{0,1},{-1,0},{1,0}};
    static Main82 main82=new Main82();
    static int k[]=new int[25];

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            m=scanner.nextInt();
            n=scanner.nextInt();
            if(m==0&&n==0){
                break;
            }
            scanner.nextLine();
            int sx=0,sy=0;
            Arrays.fill(k,0);
            for (int i=0;i<m;i++){
                String str=scanner.nextLine();
                char a[]=str.toCharArray();
                for (int j=0;j<n;j++){
                    map[i][j]=a[j];
                    if (map[i][j]=='S'){
                        map[i][j]='.';
                        sx=i;
                        sy=j;
                    }
                    if(map[i][j]>='a'&&map[i][j]<='e')  k[map[i][j]-'a']++;
                }
            }
            for (int i=0;i<25;i++){
                for (int j=0;j<25;j++){
                    vis[i][j]=false;
                }
            }
            if (bfs(sx,sy)){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }

    private static boolean bfs(int x, int y) {
        Queue<Node> queue=new LinkedList<Node>();
        Node temp=main82.new Node();
        temp.x=x;
        temp.y=y;
        queue.offer(temp);
        vis[x][y]=true;
        while (queue.size()!=0){
            Node cur=queue.poll();
            if (map[cur.x][cur.y]=='G'){
                return true;
            }
            if (map[cur.x][cur.y]>='A'&&map[cur.x][cur.y]<='E'){
                if (k[map[cur.x][cur.y]-'A']==0){
                    map[cur.x][cur.y]='.';
                }else {
                    if (queue.isEmpty()){
                        return false;
                    }
                    else {
                        queue.offer(cur);
                        continue;
                    }
                }
            }
            for (int i=0;i<4;i++){
                int dx=cur.x+d[i][0];
                int dy=cur.y+d[i][1];
                if (check(dx,dy)){
                    Node ss=main82.new Node();
                    ss.x=dx;
                    ss.y=dy;
                    queue.offer(ss);
                    vis[dx][dy]=true;
                }
            }
        }
        return  false;
    }

    private static boolean check(int dx, int dy) {
        if (dx<0||dx>=m||dy<0||dy>=n||vis[dx][dy]){
            return false;
        }
        if (map[dx][dy]=='X'){
            return false;
        }
        if (map[dx][dy]>='a'&&map[dx][dy]<='e')
            k[map[dx][dy]-'a']--;
        return true;
    }
}
