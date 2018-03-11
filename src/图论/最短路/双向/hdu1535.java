package 图论.最短路.双向;

import java.util.*;

/**
 * Created by user on 2017/10/13.
 */
public class hdu1535 {
    /**
     * 题意：重1出发，每个车站安排一个人，然后所有人回来，问最小花费，注意路是单向的
     思路：两次SPFA，也就是巧妙的将路线进行了翻转
     */
    static int n,m;
    static boolean vis[]=new boolean[1000000+10];
    static int inf = 0x3f3f3f3f;
    class Node{
        int u,v,cost;
        Node(){
        }
        Node(int u,int v,int cost){
            this.u=u;
            this.v=v;
            this.cost=cost;
        }
    }
    static Node node[]=new Node[1000000+10];
    static hdu1535 hdu=new hdu1535();
    static ArrayList<Node> map[];
    static int d[]=new int[1000000+10];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        init();
        while (t-->0){
            n= scanner.nextInt();
            m=scanner.nextInt();
            scanner.nextLine();
            for (int i=0;i<m;i++){
                String str=scanner.nextLine();
                String a[]=str.split(" ");
                int u=Integer.valueOf(a[0]);
                int v=Integer.valueOf(a[1]);
                int cost=Integer.valueOf(a[2]);
                map[u].add(hdu.new Node(u,v,cost));//建立正向边
                node[i]=hdu.new Node(u,v,cost);
            }
            int sum=0;
            spfa(1);
            for (int i=2;i<=n;i++){
                sum+=d[i];
            }
            for (int i=0;i<=n;i++){
                map[i].clear();
            }
            //反向建边
            for (int i=0;i<m;i++){
                map[node[i].v].add(hdu.new Node(node[i].v,node[i].u,node[i].cost));
            }
            spfa(1);
            for (int i=2;i<=n;i++){
                sum+=d[i];
            }
            System.out.println(sum);
        }
    }

    private static void spfa(int s) {
        Arrays.fill(d,inf);
        Arrays.fill(vis,false);
        Queue<Integer> queue=new LinkedList<Integer>();
        d[s]=0;
        vis[s]=false;
        queue.offer(s);
        while (queue.size()!=0){
            int cur=queue.poll();
            vis[cur]=false;
            for (int i=0;i<map[cur].size();i++){
                Node temp=map[cur].get(i);
                if (d[temp.v]>d[cur]+temp.cost){
                    d[temp.v]=d[cur]+temp.cost;
                    if (!vis[temp.v]){
                        vis[temp.v]=true;
                        queue.offer(temp.v);
                    }
                }
            }
        }
    }
    private static void init() {
        map=new ArrayList[1000000+10];
        for (int i=0;i<1000000+10;i++){
            map[i]=new ArrayList<Node>();
        }
    }
}
