package bfs;

import java.util.Scanner;
import java.util.Vector;

/**
 * Created by user on 2017/10/3.
 */
public class Main20 {
    static int maxn = 100000 + 5;
    static int n; //n个城市
    static Vector<Integer> G[]=new Vector[maxn];
    static int p[]=new int[maxn]; //存储每个节点的父节点
    static Scanner scanner=new Scanner(System.in);
    static void read_tree() //读入树
    {
        int u,v;
        for(int i=0; i<n-1; i++) //n-1条边
        {
            String str=scanner.nextLine();
            String a[]=str.split(" ");
            u=Integer.valueOf(a[0]);
            v=Integer.valueOf(a[1]);
            G[u].add(v);
            G[v].add(u);
        }
    }

    static void dfs(int u, int fa) //递归转化以u为根的子树，u的父节点为fa
    {
        int d = G[u].size(); //节点u的相邻点个数
        for(int i=0; i<d; i++)
        {
            int v = G[u].get(i); //节点u的第i个相邻节点v
            if(v != fa) //千万不要忘记判断v是否和其父节点相等，否则会引起无限递归
            {
                dfs(v, p[v] = u);
            }
        }
    }

    public static void main(String args[])
    {
        int t; //测试数据的个数
        int u; //从s出发
        t=scanner.nextInt();
        while(t-->0)
        {

            n=scanner.nextInt();
            u=scanner.nextInt();
            for (int i=0;i<=n;i++){
                G[i]=new Vector<Integer>();
            }
            scanner.nextLine();
            read_tree(); //读入边
            p[u] = -1; //表示根节点的父节点不存在
            dfs(u, -1);

	 /*	输出从u（树的根）出发，走到i号节点，必须经过
		的上个节点，即以u为根，i号节点的上一个节点。
	  */
            for(int i=1; i<=n-1; i++)
            {
                System.out.printf("%d ",p[i]);
            }
            System.out.printf("%d\n",p[n]);
        }

    }
}
