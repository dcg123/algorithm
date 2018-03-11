package LCA;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by user on 2017/10/13.
 */
public class Main2 {
    static int  MAX=40002;
    class edge
    {
        int start;
        int end;
        int length;
    }
    static Vector<edge> tree[]=new Vector[MAX];
    static int distance[]=new int[MAX];
    static int visit[]=new int[MAX];
    static int set[]=new int[MAX];
    static int ancestor[]=new int[MAX];
    static int n, m;
    static Main2 main=new Main2();
    static int Father(int i)
    {
        if(set[i] != i)
        {
            set[i] = Father(set[i]);
        }
        return set[i];
    }
    static void Union(int u, int v)
    {
        set[Father(u)] = Father(v);
    }
    static void LCA(int u)
    {
        set[u] = u;
        ancestor[Father(u)] = u;//将该节点所在集合的代表的祖先设置为x
        visit[u] = 1;//标记该节点已经访问过
        for(int i = 0; i < tree[u].size(); ++i)
        {
            int v = tree[u].get(i).end;
            if(visit[v]==0)
            {
                distance[v] = distance[u] + tree[u].get(i).length;//到达v点的值
                LCA(v);
                Union(u, v);//吧这两个点合并到一颗树上
                ancestor[Father(u)] = u;//将该节点所在集合的代表的祖先设置为x
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int T;
        T=scanner.nextInt();
            while(T-- > 0)
            {
                n=scanner.nextInt();
                m=scanner.nextInt();
                for(int i = 1; i <= n; ++i)
                {
                    tree[i]=new Vector<edge>();
                }
                Arrays.fill(distance,0);
                Arrays.fill(visit,0);
                for(int k = 0; k < n-1; ++k)
                {
                    int i,j;
                    i=scanner.nextInt();
                    j=scanner.nextInt();
                    int length=scanner.nextInt();
                    edge e=main.new edge();
                    e.length=length;
                    e.end = j;
                    e.start=i;
                    tree[i].add(e);
                    edge temp=main.new edge();
                    temp.start=j;
                    temp.end=i;
                    temp.length=length;
                    tree[j].add(temp);
                }
                LCA(1);
                for(int k = 0; k < m; ++k)
                {
                    int u,v;
                    u=scanner.nextInt();
                    v=scanner.nextInt();
                    System.out.printf("%d\n",Math.abs(distance[u]+distance[v]-2*distance[ancestor[v]]));
                }
            }
        }


}
