package bfs;



        import java.util.LinkedList;
        import java.util.Queue;
        import java.util.Scanner;

public class hdu1044 {

    /**
     * @param args
     * 题目大意：给一个地图，地图中有一个入口，一个出口，并散落一些珠宝，
     * 一个人从入口处开始在规定的时间内到达出口，并
     * 在这个过程中获得最大的珠宝，其中每个珠宝只能获取一次。
     */
    static int maxn=55;
    class Node{
        int x,y;
        int key;
        int num;
        public int getX() {
            return x;
        }
        public void setX(int x) {
            this.x = x;
        }
        public int getY() {
            return y;
        }
        public void setY(int y) {
            this.y = y;
        }
        public int getKey() {
            return key;
        }
        public void setKey(int key) {
            this.key = key;
        }
        public int getNum() {
            return num;
        }
        public void setNum(int num) {
            this.num = num;
        }

    }
    static char e[][]=new char[maxn][maxn];
    static int val[]=new int[11];
    static boolean vis[][][];
    static int dir[][] = { {1,0},{-1,0},{ 0,1},{0,-1} };

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        int T,tt=0;
        T=scan.nextInt();
        while(T>0){
            int n,m,t,k,x1 = 0,y1=0,x2=0,y2=0;
            n=scan.nextInt();
            m=scan.nextInt();
            t=scan.nextInt();
            k=scan.nextInt();
            for(int i=0;i<k;i++){
                val[i]=scan.nextInt();
            }
            for(int i=0;i<n;i++){
                String str=scan.next();
                char a[]=str.toCharArray();
                for(int j=0;j<m;j++){
                    e[i][j]=a[j];
                    if(e[i][j]=='@'){
                        x1=i;
                        y1=j;
                        e[i][j]='.';
                    }
                    if(e[i][j]=='<'){
                        x2=i;
                        y2=j;
                        e[i][j]='.';
                    }
                }
            }
            System.out.println("Cse "+(++tt)+":");
            bfs(x1,y1,x2,y2,n,m,t);
            T--;
        }
    }

    private static void bfs(int x1, int y1, int x2, int y2, int n, int m, int t) {
        // TODO Auto-generated method stub
        Queue<Node> queue=new LinkedList<Node>();
        vis=new boolean[1100][maxn][maxn];
        hdu1044 hdu=new hdu1044();
        Node node=hdu.new Node();
        Node f,g;
        g=hdu.new Node();
        int k,xx,yy,key,ans=-1;
        node.setX(x1);
        node.setY(y1);
        node.setKey(0);
        node.setNum(0);
        vis[0][x1][y1]=true;
        queue.offer(node);
        while(queue.size()!=0){
            f=queue.poll();
            for(int i=0;i<4;i++){
                g.x=f.x+dir[i][0];
                g.y=f.y+dir[i][1];
                if(g.x<0||g.y<0||g.x>=n||g.y>=m||e[g.x][g.y]=='*')continue;
                if(e[g.x][g.y]!='.')g.key=(f.key|(1<<(e[g.x][g.y]-'A')));
                else g.key=f.key;
                if(vis[g.key][g.x][g.y])continue;
                vis[g.key][g.x][g.y]=true;
                g.num=f.num+1;
                if(g.x==x2&&g.y==y2)
                    ans=max(ans,cal(g.key));
                if(g.num==t)continue;
                queue.offer(g);
            }
        }
        if(ans==-1)
            System.out.println("Impossible");
        else
            System.out.println("The best score is "+ans);

    }

    private static int max(int ans, int cal) {
        // TODO Auto-generated method stub
        return ans>cal?ans:cal;
    }

    private static int cal(int key) {
        // TODO Auto-generated method stub
        int ans=0;
        for(int i=0,j=1;i<10;i++,j=j*2){
            if((j&key)==1)ans+=val[i];
        }
        return ans;
    }

}
