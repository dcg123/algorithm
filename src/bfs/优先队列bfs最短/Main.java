package bfs.优先队列bfs最短;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by user on 2017/10/3.
 */
public class Main {
    static int n,m,ex,ey;
    static char map[][]=new char[110][110];
    static boolean vis[][]=new boolean[110][110];
    class Node{
        int x,y;
        int cost;
    }
    static int d[][]={{0,-1},{0,1},{-1,0},{1,0}};
    static Comparator<Node> OrderIsdn = new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.cost<o2.cost?-1:1;
        }

    };
    static Main main1100=new Main();
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while (t-->0){
            n=scanner.nextInt();
            m=scanner.nextInt();
            scanner.nextLine();
            int sx = 0,sy=0;
            for (int i=0;i<n;i++){
                String str=scanner.nextLine();
                char a[]=str.toCharArray();
                for (int j=0;j<m;j++){
                    map[i][j]=a[j];
                    if (map[i][j]=='s'){
                        sx=i;
                        sy=j;
                        map[i][j]='0';
                    }
                    if (map[i][j]=='l'){
                        ex=i;
                        ey=j;
                    }
                }
            }
            int ans=bfs(sx,sy);
            if (ans==0){
                System.out.println("-1");
            }else {
                System.out.println(ans);
            }
        }
    }
    static int bfs(int x,int y){
        init();
        Queue<Node> queue=new PriorityQueue<Node>(110,OrderIsdn);
        vis[x][y]=true;
        Node temp=main1100.new Node();
        temp.x=x;
        temp.y=y;
        temp.cost=0;
        queue.offer(temp);
        while (queue.size()!=0){
            Node s=queue.poll();
            if (s.x==ex&&s.y==ey){
                return s.cost;
            }
            for (int i=0;i<4;i++){
                int dx=s.x+d[i][0];
                int dy=s.y+d[i][1];
                    if (dx>=0&&dx<n&&dy>=0&&dy<m&&!vis[dx][dy]&&map[dx][dy]!='#'){
                        vis[dx][dy]=true;
                        int dist=0;
                        if (map[dx][dy]>='A'&&map[dx][dy]<='Z'){
                            dist=map[dx][dy]-'A'+1;
                        }
                    Node ss=main1100.new Node();
                    ss.x=dx;
                    ss.y=dy;
                    ss.cost=s.cost+dist;
                    queue.offer(ss);
                }
            }
        }
        return 0;
    }
    private static void init() {
        for (int i=0;i<110;i++){
            for (int j=0;j<110;j++){
                vis[i][j]=false;
            }
        }
    }
}
