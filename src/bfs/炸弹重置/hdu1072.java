package bfs.炸弹重置;

        import java.util.LinkedList;
        import java.util.Queue;
        import java.util.Scanner;

public class hdu1072{

    /**
     * @param args
     * 在n×m的地图上，0表示墙，1表示空地，2表示人，3表示目的地，
     * 4表示有定时炸弹重启器。定时炸弹的时间是6，人走一步所需要的时间是1。每次可以上、下、左、右移动一格。当人走到4时如果炸弹的时间不是0，
     * 可以重新设定炸弹的时间为6。如果人走到3而炸弹的时间不为0时，成功走出。求人从2走到3的最短时间
     */
    static int dx[] = {-1,0,1,0 };
    static int dy[] = { 0,-1,0,1 };
    static int n,m,f_x,f_y;
    static int[][] map=new int [9][9];
    static int vis[][] =new int[9][9];
    class Node{
        int x;
        int y;
        int to_time;
        int now_time;
        public Node(){

        }
        public Node(int x,int y,int to_time,int now_time){
            this.x=x;
            this.y=y;
            this.to_time=to_time;
            this.now_time=now_time;
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        int t;
        int  s_x = 0,s_y=0;
        t=scan.nextInt();
        while(t>0){
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    vis[i][j]=0;
                }
            }
            n=scan.nextInt();
            m=scan.nextInt();
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    map[i][j]=scan.nextInt();
                    if(map[i][j]==2){
                        s_x=i;
                        s_y=j;
                    }
                    if(map[i][j]==3){
                        f_x=i;
                        f_y=j;
                    }
                }
            }
            System.out.println(bfs(s_x,s_y));
            t--;
        }
    }
    private static int bfs(int x, int y) {
        // TODO Auto-generated method stub
        Queue<Node> queue=new LinkedList<Node>();
        hdu1072 hdu=new hdu1072();
        Node node1=hdu.new Node();
        vis[x][y]=6;
        node1.x=x;
        node1.y=y;
        node1.to_time=0;
        node1.now_time=6;
        queue.offer(node1);
        while(queue.size()!=0){
            Node b=queue.poll();
            if(b.x==f_x&&b.y==f_y){
                return b.to_time;
            }
            for(int i=0;i<4;i++){
                int ssx=b.x+dx[i];
                int ssy=b.y+dy[i];
                if(judge(ssx,ssy)){
                    if(map[ssx][ssy]==4){
                        if(b.now_time==1)
                            continue;
                        int to_time=b.to_time+1;
                        int nowtime=6;
                        if(nowtime==0||nowtime<=vis[ssx][ssy]){
                            continue;
                        }
                        vis[ssx][ssy]=nowtime;
                        Node c=hdu.new Node(ssx,ssy,to_time,nowtime);
                        queue.offer(c);
                    }else{
                        int to_time=b.to_time+1;
                        int nowtime=b.now_time-1;
                        if(nowtime==0||nowtime<=vis[ssx][ssy]){
                            continue;
                        }
                        vis[ssx][ssy]=nowtime;
                        Node c=hdu.new Node(ssx,ssy,to_time,nowtime);
                        queue.offer(c);
                    }
                }
            }
        }
        return -1;
    }
    private static boolean judge(int x, int y) {
        // TODO Auto-generated method stub
        if(x<0||y<0||x>=n||y>=m){
            return false;
        }
        if(map[x][y]==0){
            return false;
        }
        return true;
    }

}