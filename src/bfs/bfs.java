package bfs;



        import java.util.LinkedList;
        import java.util.Queue;
        import java.util.Scanner;

public class bfs {

    /**
     * @param args
     */

    static int MAXN=100;
    static int n,m;
    static char map[][]=new char[MAXN][MAXN];
    static int d[][]=new int[MAXN][MAXN];
    static int sx,sy,dx,dy;
    static int x[] = { 1,0,-1,0 }, y[] = { 0,1,0,-1 };
    class node{
        int sx,sy;
        public node(int sx,int sy){
            this.sx=sx;
            this.sy=sy;
        }
        public int getSx() {
            return sx;
        }

        public int getSy() {
            return sy;
        }



    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        n=scan.nextInt();
        m=scan.nextInt();

        for(int i=0;i<n;i++){
            String str=scan.next();
            char a[]=str.toCharArray();
            for(int j=0;j<a.length;j++){
                map[i][j]=a[j];

            }
        }
        sx=0;
        sy=0;
        dx=n-1;
        dy=m-1;
        bfs();
        System.out.println(d[dx][dy]);

    }
    private static void bfs() {
        // TODO Auto-generated method stub
        Queue<node> queue = new LinkedList<node>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                d[i][j]=Integer.MAX_VALUE;
            }
        }
        bfs bf=new bfs();
        node node1=bf.new node(sx,sy);
        queue.offer(node1);
        d[sx][sy] = 0;  //从起点出发将距离设为0，并放入队列首端
        while(queue.size()!=0){
            int t=0;
            node first=queue.poll();
            for(int i=0;i<4;i++){
                int nx=first.getSx()+x[i];
                int ny=first.getSy()+y[i];
                if(nx>=0&&nx<n&&ny>=0&&ny<m&&map[nx][ny]!='X'&&d[nx][ny]==Integer.MAX_VALUE){
                    node node2=bf.new node(nx,ny);
                    queue.offer(node2);
                    d[nx][ny]=d[first.getSx()][first.getSy()]+1;
                    if(nx==dx&&ny==dy){
                        break;
                    }
                }
                t=i;
            }
            if((t+1)!=4){
                break;
            }

        }
    }


}
