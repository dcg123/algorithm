package 图论.spfa;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by user on 2017/10/6.
 */
public class Main426 {
    /**
     * 首先，题目可能有多组测试数据，每个测试数据的第一行为经纪人数量N（当N=0时，输入数据结束），
     然后接下来N行描述第i（1<=i<=N）个经纪人与其他经纪人的关系（教你如何画图）。每行开头数字M为
     该行对应的经纪人有多少个经纪人朋友（该节点的出度，可以为0），然后紧接着M对整数，每对整数表
     示成a,b,则表明该经纪人向第a个经纪人传递信息需要b单位时间（即第i号结点到第a号结点的孤长为b）
     ，整张图为有向图，即弧Vij 可能不等于弧Vji（数据很明显，这里是废话）。当构图完毕后，求当从该
     图中某点出发，将“消息”传播到整个经纪人网络的最小时间，输出这个经纪人号和最小时间。最小时
     间的判定方式为——从这个经纪人（结点）出发，整个经纪人网络中最后一个人接到消息的时。如果有
     一个或一个以上经纪人无论如何无法收到消息，输出“disjoint”（有关图的连通性，你们懂得，但
     据其他同学说，POJ测试数据中不会有，就是说，你不判定，一样能过，题目数据够水的）。
     poj 上的测试数据 Floyd都能过
     */
    static int maxn=1000+10;
    static int INF=9999999;
    static int map[][]=new int[maxn][maxn];
    static int d[]=new int[maxn];
    static boolean vis[]=new boolean[maxn];
    static int n;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            n=scanner.nextInt();
            if (n==0){
                break;
            }
            scanner.nextLine();
            init();
            for (int i=1;i<=n;i++){
                    int m=scanner.nextInt();
                    if (m==0){
                        continue;
                    }
                    for (int j=0;j<m;j++){
                        int u=scanner.nextInt(),cost=scanner.nextInt();
                        map[i][u]=cost;
                    }
            }
            //判断是否是连通图
            dfs(1);
            boolean flag=true;
            for (int i=1;i<=n;i++){
                if (!vis[i]){
                    flag=false;
                    break;
                }
            }
            if (!flag){
                System.out.println("disjoint");
                continue;
            }
            //遍历每个点 求出每个点到其他点的最小时间 和经纪人的编号
            int time=Integer.MAX_VALUE;
            int num=0;
            for (int i=1;i<=n;i++){
                Arrays.fill(vis,false);
                Arrays.fill(d,INF);
                spfa(i);
                Arrays.sort(d,1,n+1);
                if (time>d[n]){
                    time=d[n];
                    num=i;
                }
            }
            System.out.println(num+" "+time);
        }
    }

    private static void spfa(int s) {
        Queue<Integer> queue=new LinkedList<Integer>();
        for (int i=1;i<=n;i++){
            if (map[s][i]!=INF){
                d[i]=map[s][i];
                queue.offer(i);
                vis[i]=true;
            }
        }
        d[s]=0;
        vis[s]=true;
        queue.offer(s);
        while (queue.size()!=0){
            int cur=queue.poll();
            vis[cur]=false;
            for (int i=1;i<=n;i++){
                if (map[cur][i]!=INF&&d[cur]+map[cur][i]<d[i]){
                    d[i]=d[cur]+map[cur][i];
                    if (!vis[i]){
                        vis[i]=true;
                        queue.offer(i);
                    }
                }
            }
        }
    }

    private static void dfs(int s) {
        vis[s]=true;
        for (int i=1;i<=n;i++){
            if (i!=s&&map[s][i]!=INF&&!vis[i]){
                dfs(i);
            }
        }
    }

    private static void init() {
        for (int i=0;i<=n;i++){
            for (int j=0;j<=n;j++){
                map[i][j]=INF;
            }
        }
    }
}
