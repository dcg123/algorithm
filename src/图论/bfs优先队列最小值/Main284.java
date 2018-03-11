package 图论.bfs优先队列最小值;

import java.util.*;

/**
 * Created by user on 2017/10/7.
 */
public class Main284 {
    static int n,m;
    static int ex,ey;
    static int d[][]={{0,-1},{0,1},{-1,0},{1,0}};
    class Node{
        int x,y;
        int cost;
    }
    static Main284 main284=new Main284();
    static char map[][]=new char[310][310];
    static Comparator<Node> comparator=new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.cost<o2.cost?-1:1;
        }
    };
    static boolean vis[][]=new boolean[310][310];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            n=scanner.nextInt();
            m=scanner.nextInt();
            if (n+m==0){
                break;
            }
            scanner.nextLine();
            int sx=0,sy=0;
            for (int i=0;i<n;i++){
                String str=scanner.nextLine();
                char a[]=str.toCharArray();
                for (int j=0;j<m;j++){
                    map[i][j]=a[j];
                    if (map[i][j]=='Y'){
                        map[i][j]='E';
                        sx=i;
                        sy=j;
                    }
                    if (map[i][j]=='T'){
                        ex=i;
                        ey=j;
                    }
                }
            }
            int ans=bfs(sx,sy);
            if (ans==0)
            System.out.println("-1");
            else
                System.out.println(ans);
        }
    }

    private static int bfs(int x, int y) {
        init();
        Queue<Node> queue=new PriorityQueue<Node>(310*310,comparator);
        vis[x][y]=true;
        Node temp=main284.new Node();
        temp.x=x;
        temp.y=y;
        temp.cost=0;
        queue.offer(temp);
        while (queue.size()!=0){
            Node cur=queue.poll();
            if (cur.x==ex&&cur.y==ey){
                return cur.cost;
            }
            for (int i=0;i<4;i++){
                int dx=cur.x+d[i][0];
                int dy=cur.y+d[i][1];
                if (dx>=0&&dx<n&&dy>=0&&dy<m&&!vis[dx][dy]&&map[dx][dy]!='S'&&map[dx][dy]!='R'){
                    vis[dx][dy]=true;
                    Node ss=main284.new Node();
                    ss.x=dx;
                    ss.y=dy;
                    int d=cur.cost;
                    if (map[dx][dy]=='E'){
                        d+=1;
                    }
                    if (map[dx][dy]=='B'){
                        d+=2;
                    }
                    if (map[dx][dy]=='T'){
                        d+=1;
                    }
                    ss.cost=d;
                    queue.offer(ss);
                }
            }
        }
        return 0;
    }

    private static void init() {
        for (int i=0;i<310;i++){
            for (int j=0;j<310;j++){
                vis[i][j]=false;
            }
        }
    }
}
