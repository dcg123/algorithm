package bfs;

/**
 * Created by user on 2017/10/17.
 */



        import java.util.LinkedList;
        import java.util.Queue;
        import java.util.Scanner;

/**
 * Created by user on 2017/8/9.
 */
public class poj3669 {
    /**
     * 意：巨大流星雨即将袭来。每个流星会对击中的地方以及周围（上下左右四格）造成破坏。
     * Bessie开始时位于（0, 0）位置，并希望逃到一处不会被袭击到的地方（在第一象限内）。
     * 已知每移动一格需要1个时间单位，被流星破坏后的地方不能再进入。
     * 给出M个流星在T时刻击中的地方（X, Y），问Bessie能否逃到安全的地方，
     * 若能输出最短时间，否则输出-1。

     分析：依旧是迷宫问题。不同的是，需要自己构建出迷宫。
     首先将maze的所有格初始化为INF，表示这个格子被袭击的时间为INF（即永远不会被袭击）。
     对于每一个流星，将其影响反映到maze上，如果破坏范围由重叠，那么格子显示的是较早的破坏时间（
     因为一旦破坏了就不能进入）
     即maze[x][y] = min(maze[x][y], T)。迷宫构建起来后，回到问题本身。求最短时间，可以用BFS做到。
     使用d[x]][y] 来保存移动到该格时的最小时间。而对于约束条件，就是对于下一步能否移动到该地方，
     要看下一个时刻该地方是否会被破坏，若不会则可以，即可d[x][y] + 1 < maze[x][y]。另外，
     需要特别注意的是，若有流星在0时刻袭击（0, 0）位置，则无法逃生。
     */
    static int MAX_N=400+2;
    static int map[][]=new int[MAX_N][MAX_N];
    static int m,mx,my,t;
    static  int dir[][]={{-1,0},{0,1},{1,0},{0,-1}};
    static boolean vis[][]=new boolean[MAX_N][MAX_N];
    static int INF=100000000;
    class Node{
        int x;int y;int step;
    }
    static poj3669 poj=new poj3669();

    public  static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        m=scanner.nextInt();
        init();
        for(int i=0;i<m;i++){
            mx=scanner.nextInt();
            my=scanner.nextInt();
            t=scanner.nextInt();
            if (map[mx][my]==INF){
                map[mx][my]=t;
            }
            for(int j=0;j<4;j++){
                int dx=mx+dir[j][0];
                int dy=my+dir[j][1];
                if(check(dx,dy)&&(map[dx][dy]>t||map[dx][dy]==INF)){
                    map[dx][dy]=t;
                }
            }

        }
        int count=bfs(0,0,0);
        System.out.println(count);
    }

    private static int bfs(int x, int y, int ans) {
        if(map[x][y]==0){
            return -1;
        }
        Queue<Node> queue;queue=new LinkedList<Node>();
        if(!queue.isEmpty()){
            queue.clear();
        }
        vis[x][y]=true;
        Node first=poj.new Node();
        first.x=x;
        first.y=y;
        first.step=ans;
        queue.offer(first);
        while(queue.size()!=0){
            Node from=queue.poll();
            int sx=from.x,sy=from.y;
            if(map[sx][sy]==INF){
                return from.step;
            }
            for(int i=0;i<4;i++){
                int dx=sx+dir[i][0];
                int dy=sy+dir[i][1];
                if(check(dx,dy)&&!vis[dx][dy]&&(from.step+1<map[dx][dy]||map[dx][dy]==INF)){
                    vis[dx][dy]=true;
                    Node to=poj.new Node();
                    to.x=dx;
                    to.y=dy;
                    to.step=from.step+1;
                    queue.offer(to);
                }
            }
        }
        return -1;
    }

    private static boolean check(int dx, int dy) {
        if(dx>=0&&dy>=0){
            return true;
        }
        return false;
    }

    public static void init(){
        for(int i=0;i<MAX_N;i++){
            for(int j=0;j<MAX_N;j++){
                map[i][j]=INF;
            }
        }
    }
}
