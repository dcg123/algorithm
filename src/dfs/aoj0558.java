package dfs;



        import java.util.Comparator;
        import java.util.LinkedList;
        import java.util.Queue;
        import java.util.Scanner;

/**
 * Created by user on 2017/8/9.
 */
public class aoj0558 {
    /**
     * 在H * W的地图上有N个奶酪工厂，分别生产硬度为1-N的奶酪。
     * 有一只吃货老鼠准备从老鼠洞出发吃遍每一个工厂的奶酪。
     * 老鼠有一个体力值，初始时为1，每吃一个工厂的奶酪体力值增加1（每个工厂只能吃一次），
     * 且老鼠只能吃硬度不大于当前体力值的奶酪。

     老鼠从当前格走到相邻的无障碍物的格（上下左右）需要时间1单位，有障碍物的格不能走。
     走到工厂上时即可吃到该工厂的奶酪，吃奶酪时间不计。问吃遍所有奶酪最少用时。
     */
    static int MAX_N=1000+2;
    static  int dir[][]={{-1,0},{0,1},{1,0},{0,-1}};
    static int w,h,n;
    static char map[][]=new char[MAX_N][MAX_N];
    class Node{
        int x,y;
    }

    /**
     * 明天吧硬度从小到大排序
     */
    static aoj0558 aoj=new aoj0558();
    static Node node []=new Node[10];
    static Node start=aoj.new Node(),end=aoj.new Node();
    static Boolean vis[][]=new Boolean[MAX_N][MAX_N];
    class cmp implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return 0;
        }
    }
    public static void  main(String args[]){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            w=scanner.nextInt();
            h=scanner.nextInt();
            n=scanner.nextInt();
            scanner.nextLine();
            int t=0;
            for(int i=0;i<h;i++){
                String str=scanner.nextLine();
                char a[]=str.toCharArray();
                for(int j=0;j<w;j++){
                    map[i][j]=a[j];
                    if(map[i][j]<='9'&&map[i][j]>='1'){
                        node[t]=aoj.new Node();
                        node[t].x=i;
                        node[t++].y=j;
                    }else if(map[i][j]=='S'){
                        start.x=i;
                        start.y=j;
                    }
                }
            }
            int step=0;

            for(int i=1;i<=n;i++){
                end.x=node[i].x;
                end.y=node[i].y;
                step+=bfs(start,end);
                start.x=end.x;
                start.y=end.y;
                map[end.x][end.y]='.';
            }
            System.out.println(step);
        }
    }

    private static int bfs(Node start, Node end) {
        int ans=0;
        Queue<Node> queue=new LinkedList<>();
        // Node s=aoj.new Node();
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                vis[i][j]=false;
            }
        }
        queue.offer(start);
        vis[start.x][start.y]=true;
        while(queue.size()!=0){
            Node p=queue.poll();
            if(p.x==end.x&&p.y==end.y){
                break;
            }
            for(int i=0;i<4;i++){
                int dx=p.x+dir[i][0];
                int dy=p.y+dir[i][1];
                if(check(dx,dy)&&map[dx][dy]!='X'&&!vis[dx][dy]){
                    Node s=aoj.new Node();
                    s.x=dx;
                    s.y=dy;
                    queue.offer(s);
                    vis[dx][dy]=true;
                    ans++;
                }
            }
        }
        return ans;
    }

    private static boolean check(int dx, int dy) {
        if(dx>=0&&dx<h&&dy>=0&&dy<w){
            return true;
        }
        return false;
    }
}
