package 最大二分匹配.二分染色;



        import java.util.LinkedList;
        import java.util.Queue;
        import java.util.Scanner;

public class Stain {

    /**
     * @param args
     * 二分图 染色法
     */
    static int g[][]=new int[105][105];
    static Stain st=new Stain();
    static int n,m;
    static int col[]=new int[105];
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        n=scan.nextInt();
        m=scan.nextInt();
        for(int i=0;i<m;i++){
            int a=scan.nextInt();
            int b=scan.nextInt();
            g[a][b]=1;
            g[b][a]=1;
        }
        boolean flag=true;
        for(int i=1;i<=n;i++){
            if(col[i]==-1&&!bfs(i,n)){
                flag=false;
                break;
            }
        }
        if(flag){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
    private static boolean bfs(int s, int n) {
        // TODO Auto-generated method stub
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(s);
        col[s]=1;
        while(queue.size()!=0){
            int from=queue.poll();
            for(int i=1;i<=n;i++){
                if(g[from][i]==1&&col[i]==-1){
                    queue.offer(i);
                    col[i]=1;
                }
                if(g[from][i]==1&&col[from]==col[i]){
                    return false;
                }
            }
        }
        return true;
    }

}
