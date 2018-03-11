package 最大二分匹配.最小边覆盖;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by user on 2017/10/16.
 */
public class aoj2251 {
    /**
     * 国际圣诞礼品公司：International Christmas Present Company (ICPC)是一家圣诞礼品快递公司，由M条路连起的N户人家发起了L次订单，
     * 分别要求在时刻t准时将礼物送到p处。求最少需要几个圣诞老人？
     * @param args
     * 边覆盖(edge covering)一类覆盖.指一类边子集.具体地说，图的一个边子集，
     * 使该图上每一节点都与这个边子集中的一条边关联.只有含孤立的图没有边覆盖.边覆盖也称为边覆盖集.
     * 图G的最小边覆盖就是指边数最少的覆盖.图G的最小边覆盖的边数称为G的边覆盖数
     *
     * 不妨考虑最坏情况，L个订单分配给L个圣诞老人。再考虑如何省下人力，假设处理完订单Q_i，
     * 还有时间步行到Q_j指定的地址，那么这两个订单可以交给同一个人处理。
     * 于是建立二分图，可以合并的订单之间连一条边，最小边覆盖即为所求。
     */
    static int MAX_V=1000*2+16;
    static int v;
    static Vector<Integer> vector[]=new Vector[MAX_V];
    static int match[]=new int[MAX_V];
    static boolean used[]=new boolean[MAX_V];
    static int MAX_N=100;
    static int MAX_L=1000;
    static int INF=0x3f3f3f3f;
    static int distance_matrix[][]=new int[MAX_N][MAX_N];		// 两点间最短路
    static int p[]=new int[MAX_N], t[]=new int[MAX_N];					// 房间编号，时刻
    static int n,m,l;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            n=scanner.nextInt();
            m=scanner.nextInt();
            l=scanner.nextInt();
            v=l*2;
            for (int i=0;i<v;i++){
                vector[i]=new Vector<Integer>();
            }
            Arrays.fill(distance_matrix,INF);
            for (int i=0;i<m;i++){
                int u,v,d;
                u=scanner.nextInt();
                v=scanner.nextInt();
                d=scanner.nextInt();
                distance_matrix[u][v]=distance_matrix[v][u]=d;
            }
            for (int i=0;i<l;i++){
                p[i]=scanner.nextInt();
                t[i]=scanner.nextInt();
            }
            for (int k = 0; k < n; ++k)
            {
                distance_matrix[k][k] = 0;
                for (int i = 0; i < n; ++i)
                {
                    for (int j = 0; j < n; ++j)
                    {
                        distance_matrix[i][j]=Math.min(distance_matrix[i][j], distance_matrix[i][k] + distance_matrix[k][j]);
                    }
                }
            }
            for (int i = 0; i < l; ++i)
            {
                for (int j = 0; j < l; ++j)
                {
                    if (i != j && t[i] + distance_matrix[p[i]][p[j]] <= t[j])
                    {
                        add_edge(2 * i, 2 * j + 1);	// 可以在i之后处理j，连一条边
                    }
                }
            }
            System.out.printf("%d\n", l - bipartite_matching());
        }
    }

    private static int bipartite_matching() {
        //二分匹配
        return 0;
    }

    private static void add_edge(int u, int v) {
        vector[u].add(v);
        vector[v].add(u);
    }
}
