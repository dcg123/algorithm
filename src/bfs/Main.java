package bfs;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    /**
     * @param args
     */
    static char map[][]=new char[202][202];
    static int n,m;
    static int f_x,f_y;
    static boolean vis[][]=new boolean[202][202];
    static int dx[] = {-1, 1, 0, 0}; 
    static int dy[] = {0, 0, 1, -1,};
    static boolean move=false;
    class Node{
        int x;
        int y;
        int step;
        public Node(){
            
        }
        public Node(int x,int y,int step){
            this.x=x;
            this.y=y;
            this.step=step;
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        int s_x = 0,s_y = 0;
        String str;
        while(((str=scan.nextLine()).length())!=0){
        	String  d[]=str.split(" ");
        	if(d.length!=2){
        		break;
        	}
        	n=Integer.valueOf(d[0]);
        	m=Integer.valueOf(d[1]);
            for(int i=0;i<n;i++){
                str=scan.nextLine();
                char a[]=str.toCharArray();
                for(int j=0;j<a.length;j++){
                    map[i][j]=a[j];
                    if(map[i][j]=='a'){
                        s_x=i;
                        s_y=j;
                    }
                }
            }
            dfs(s_x,s_y);
            if(!move){
                System.out.println("Poor ANGEL has to stay in the prison all his life.");
            }
        }
    }
    private static void dfs(int x, int y) {
        // TODO Auto-generated method stub
        for(int i=0;i<202;i++){
            for(int j=0;j<202;j++){
                vis[i][j]=false;
            }
        }
        Queue<Node> queue=new LinkedList<Node>();
        Main hdu=new Main();
        Node node=hdu.new Node();
        node.x=x;
        node.y=y;
        node.step=0;
        queue.offer(node);
        vis[x][y]=true;
        while(queue.size()!=0){
            Node a=queue.poll();
            if(map[a.x][a.y]=='r'){
                System.out.println(a.step);
                move=true;
                return ;
            }
            if(map[a.x][a.y]=='x'){
                map[a.x][a.y]='.';
                int astep=a.step+1;
                Node b=hdu.new Node(a.x,a.y,astep);
                queue.offer(b);
                continue;
            }
            for(int i=0;i<4;i++){
                int ax=a.x+dx[i];
                int ay=a.y+dy[i];
                if(check(ax,ay)){
                    if(!vis[ax][ay]&&map[ax][ay]!='#'){
                        int astep=a.step+1;
                        vis[ax][ay]=true;
                        Node b=hdu.new Node(ax,ay,astep);
                        queue.offer(b);
                    }
                }
            
            }
        }
    }
    private static boolean check(int x, int y) {
        // TODO Auto-generated method stub
        if(x<0||x>=n||y<0||y>=m){
            return false;
        }
        return true;
    }

}