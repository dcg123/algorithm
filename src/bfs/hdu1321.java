package bfs;



        import java.util.LinkedList;
        import java.util.Queue;
        import java.util.Scanner;

public class hdu1321 {

    /**
     * @param args
     * 根据地图,问可以到达多少地方.'@'为起点, ' . '为路,可以到达, ' # '为墙,不能通过.
     */
    static int dir[][]={{-1,0},{0,1},{1,0},{0,-1}};//上，右，下，左
    static int MAX=25;
    static boolean  vis[][]=new boolean [MAX][MAX];//访问标志
    static char map[][]=new char[MAX][MAX];
    static int n,m;
    static int s_x,s_y;//开始的位置
    static int step;
    class Node{//定义每个位置的类
        int x;
        int y;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        while((n=scan.nextInt())!=0&&(m=scan.nextInt())!=0){
            String str=scan.nextLine();//接收回车符
            for(int i=0;i<m;i++){
                str=scan.nextLine();
                char b[]=str.toCharArray();
                for(int j=0;j<n;j++){
                    map[i][j]=b[j];
                    if(map[i][j]=='@'){
                        s_x=i;
                        s_y=j;
                    }
                }
            }
            int ans=bfs();
            System.out.println(ans);
        }
    }
    private static int bfs() {
        // TODO Auto-generated method stub
        //初始化
        step=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                vis[i][j]=false;
            }
        }
        Queue<Node> queue=new LinkedList<Node>();
        hdu1321 hdu=new hdu1321();
        Node node=hdu.new Node();
        node.x=s_x;
        node.y=s_y;

        vis[s_x][s_y]=true;
        queue.offer(node);
        while(queue.size()!=0){
            Node node1=queue.poll();
            step++;
            for(int i=0;i<4;i++){
                int xx=node1.x+dir[i][0];
                int yy=node1.y+dir[i][1];
                if(xx>=0&&xx<m&&yy>=0&&yy<n&&!vis[xx][yy]&&map[xx][yy]=='.'){
                    vis[xx][yy]=true;
                    Node node2=hdu.new Node();
                    ////这里非常坑的一点就是 直接使用前面定义
                    //node这个区赋值 加入队列的话 会改变上一个node加入队列的值 到最后 加入的节点 是最后一次的赋值 必须要重新new一个
                    //类
                    node2.x=xx;
                    node2.y=yy;

                    queue.offer(node2);
                }
            }
        }
        return step;
    }

}
