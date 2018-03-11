import java.util.*;

/**
 * Created by user on 2017/10/20.
 */
public class Main {
    static int MAX=10000+10;
    static boolean vis[]=new boolean[MAX];
    static Vector<Node> vector[]=new Vector[MAX];
    static int d[]=new int[MAX];
    static int map[]=new int[MAX];
    class Node{
        int from,to,cost;
        Node(int from,int to,int cost){
            this.from=from;
            this.to=to;
            this.cost=cost;
        }
    }
    static Main main2=new Main();
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        for (int i=0;i<=n;i++){
            vector[i]=new Vector<Node>();
        }
        scanner.nextLine();
        String str=scanner.nextLine();
        String a[]=str.split(" ");
        for (int i=1;i<=n;i++){
            map[i]=Integer.valueOf(a[i-1]);
        }
        long sum=0;
        for (int i=1;i<=n;i++){
            for (int j=1;j<=n;j++){
                if (i==j||i>j){
                    continue;
                }
                long d=getDis(i,j);
                if (d>sum){
                    sum=d;
                }
//                vector[i].add(main2.new Node(i,j,d));
//                vector[j].add(main2.new Node(j,i,d));
            }
        }
       // spfa();
        System.out.println(sum);
    }

    private static void spfa() {
        Queue<Integer> queue=new LinkedList<Integer>();
        Arrays.fill(d,0);
        Arrays.fill(vis,false);
        queue.offer(1);
        vis[1]=true;
        d[1]=0;
        while (queue.size()!=0){
            int cur=queue.poll();
            vis[cur]=false;
            for (int i=0;i<vector[cur].size();i++){
                int v=vector[cur].get(i).to;
                if (d[v]<d[cur]+vector[cur].get(i).cost){
                    d[v]=d[cur]+vector[cur].get(i).cost;
                    if (!vis[v]){
                        vis[v]=true;
                        queue.offer(v);
                    }
                }
            }
        }
    }

    private static long getDis(int i, int j) {
        return Math.abs(i*i-j*j)+Math.abs(map[i]*map[i]-map[j]*map[j]);
    }
}
