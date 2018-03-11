package bfs.优先队列打印路径;


        import java.util.LinkedList;
        import java.util.Queue;
        import java.util.Scanner;

public class hdu1026 {

    /**
     * @param args
     */
    static int n,m;
    static int MAX=105;
    static int x[]={0,1,0,-1},y[]={1,0,-1,0};
    static int sx,sy,dx,dy;
    static char map[][]=new char[MAX][MAX];
    static int t[][]=new int[MAX][MAX];
    static int fa[][]=new int[MAX][MAX];
    static int trace[][]=new int[MAX*MAX][2];
    class Node{
        int sx,sy;
        public Node(int sx,int sy){
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
        while(((n=scan.nextInt())!=0)&&((m=scan.nextInt())!=0)){

            for(int i=0;i<MAX;i++){
                for(int j=0;j<MAX;j++){
                    t[i][j]=Integer.MAX_VALUE;
                }
            }
            t[0][0]=0;;
            for(int i=0;i<n;i++){
                String str=scan.next();
                char a[]=str.toCharArray();
                for(int j=0;j<m;j++){
                    map[i][j]=a[j];
                }
            }
            sx=0;
            sy=0;
            dx=n-1;
            dy=m-1;
            bfs();

            if(t[dx][dy]==Integer.MAX_VALUE){
                System.out.println("God please help our poor hero.");
                System.out.println("FINISH");
                continue;
            }
            System.out.println("It takes "+t[dx][dy]+" seconds to reach the target position, let me show you the way.");
            int rx=n-1,ry=m-1,c=2;
            trace[1][0]=rx;
            trace[1][1]=ry;
            while(!(rx==0&&ry==0)){
                int i=fa[rx][ry];
                int fx=rx-x[i];
                int fy=ry-y[i];
                trace[c][0]=fx;
                trace[c][1]=fy;
                c++;
                rx=fx;
                ry=fy;
            }
            int k=1;
            for(int i=c-1;i>=1;i--){
                int rrx=trace[i][0],rry=trace[i][1];
                if(map[rrx][rry]>='1'&&map[rrx][rry]<='9'){
                    int tt=map[rrx][rry]-'0';
                    for(int j=1;j<=tt;j++)
                    {
                        System.out.println(k+"s:FIGHT AT ("+rrx+","+rry+")");
                        k++;
                    }
                }
                if(i!=1){
                    System.out.println(k+"s:("+trace[i][0]+","+trace[i][1]+")"+"->("+trace[i-1][0]+","+trace[i-1][1]+")");
                    k++;
                }
            }
            System.out.println("FINISH");
        }
    }
    private static void bfs() {
        // TODO Auto-generated method stub
        Queue<Node> queue=new LinkedList<Node>();
        hdu1026 hdu=new hdu1026();
        Node  node =hdu.new Node(sx,sy);
        queue.offer(node);
        while(queue.size()!=0){
            Node frist=queue.poll();
            int ssx=frist.getSx();
            int ssy=frist.getSy();
            for(int i=0;i<4;i++){
                int tx=ssx+x[i];
                int ty=ssy+y[i];
                if(tx>=0&&tx<n&&ty>=0&&ty<m&&map[tx][ty]=='.'){
                    if(t[tx][ty]>t[ssx][ssy]+1){
                        t[tx][ty]=t[ssx][ssy]+1;
                        fa[tx][ty]=i;//记录如何由上一点找到该点的
                        Node  node1=hdu.new Node(tx,ty);
                        queue.offer(node1);
                    }
                }
                if(tx>=0&&tx<n&&ty>=0&&ty<m&&map[tx][ty]>='1'&&map[tx][ty]<='9'){
                    int k=map[tx][ty]-'0';
                    if(t[tx][ty]>t[ssx][ssy]+k+1)
                    {
                        t[tx][ty]=t[ssx][ssy]+k+1;
                        fa[tx][ty]=i;
                        Node  node1=hdu.new Node(tx,ty);
                        queue.offer(node1);
                    }
                }
            }
        }
    }

}
//#include <iostream>
//#include <queue>
//using namespace std;
//
//        int m, n;
//        char map[102][102];
//        int dir[4][2]={1,0, 0,1, -1,0, 0,-1};
//        int flag[102][102];
//        int fight[102][102];
//        int totTime;
//
//        struct Node{
//        int x;
//        int y;
//        int time;
//        bool operator<(const Node &a) const {
//        return a.time<time;
//    }
//            };
//            bool bfs()
//            {
//            priority_queue<Node>que;
//        struct Node start;
//        start.x=start.y=start.time=0;
//        que.push(start);
//        map[0][0]='X';
//
//        while (!que.empty())
//        {
//        struct Node cur=que.top();
//        que.pop();
//        if(cur.x==n-1 && cur.y==m-1){
//        totTime=cur.time;
//        return true;
//        }
//        for (int i=0; i<4; i++){
//        int xtmp=cur.x+dir[i][0];
//        int ytmp=cur.y+dir[i][1];
//        if(map[xtmp][ytmp]=='X') continue;
//        if(xtmp<n && xtmp>=0 && ytmp<m && ytmp>=0 ){
//        struct Node nextstep;
//        nextstep.x=xtmp;
//        nextstep.y=ytmp;
//        if(map[nextstep.x][nextstep.y]!='.') {
//        nextstep.time=cur.time+1+map[nextstep.x][nextstep.y]-'0';
//        fight[nextstep.x][nextstep.y]=map[nextstep.x][nextstep.y]-'0';
//        } else
//        nextstep.time=cur.time+1;
//        flag[nextstep.x][nextstep.y]=i+1;
//        que.push(nextstep);
//        map[xtmp][ytmp]='X';
//        }
//        }
//        }
//        return false;//没有到达，则返回false
//        }
//
//        int seconds;
//        void printRoad(int x, int y)
//        {
//        if(flag[x][y]==0) return ;
//        int pre_x, pre_y;
//        pre_x=x-dir[flag[x][y]-1][0];
//        pre_y=y-dir[flag[x][y]-1][1];
//        printRoad(pre_x, pre_y);
//        printf("%ds:(%d,%d)->(%d,%d)\n",seconds++,pre_x,pre_y,x,y);
//        while(fight[x][y]--)
//        printf("%ds:FIGHT AT (%d,%d)\n",seconds++,x,y);
//
//        }
//        int main(){
////    freopen("D:/Documents/work/in.txt", "r", stdin);
////    freopen("D:/Documents/work/out.txt",  "w", stdout);
//        int i, j;
//        while(~scanf("%d%d", &n, &m))
//        {
//        memset(fight,0,sizeof(fight));
//        memset(flag,0,sizeof(flag));
//        for(i=0; i<n; i++)
//        for(j=0; j<m; j++)
//        cin>>map[i][j];
//        if(bfs()){
//        seconds=1;
//        printf("It takes %d seconds to reach the target position, let me show you the way.\n",totTime);
//        printRoad(n-1,m-1);
//        } else {
//        printf("God please help our poor hero.\n");
//        }
//        printf("FINISH\n");
//        }
//
//        return 0;
//        }