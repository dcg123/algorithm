package 连通图.强连通分量缩点;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

/**
 * Created by user on 2017/10/14.
 */
public class hdu1236 {
    /**
     * 题目大意：有n个学校，学校之间可以传递信息，例如学校 a 可以 传达信息给 b ，
     * 即a ——> b , 但 b 不一定 能传递信息给 a 。
     * 告诉你每个学校能够向哪些学校传递信息，然后有两个问题：
     问题一：至少要向几个学校传递 原始 信息，才能保证所有学校都能收到信息。
     问题二：至少要添加多少组关系（每组关系类型如右：a 可以 向 b 传递信息），
     才能保证 给任意一个学校原始信息后，其他所有学校都能收到信息。
     解题思路：这道题其实就是一个有n个顶点的有向图，先用 tarjan 缩点 ，
     然后分别统计出 入度为0 和 出度为0 的强连通分量个数ansA 和 ansB，那么，
     问题一的答案就是ansA , 问题二的答案就是max（ansA ， ansB），
     但是有特例：当只有一个强连通分量时，问题二的答案就是0 。
     */
    static int MAX=105;
    static Vector<Integer> vector[]=new Vector[MAX];
    static int id[]=new int[MAX];
    static int low[]=new int[MAX];
    static int dfn[]=new int[MAX];
    static Stack<Integer> stack=new Stack<Integer>();
    static boolean isStack[]=new boolean[MAX];
    static int ind[]=new int[MAX];//记录每个强连通分量的入度
    static int out[]=new int[MAX];//记录每个强连通分量的出度
    static int n,m,anA,anB,count,countDfn;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        scanner.nextLine();
        init();
        for (int i=1;i<=n;i++){
            String str=scanner.nextLine();
            String ss[]=str.split(" ");
            int k=0;
            while (Integer.valueOf(ss[k])!=0){
                vector[i].add(Integer.valueOf(k));
                k++;
            }
        }
        solve();

    }

    private static void solve() {
        for (int i=1;i<=n;i++){
            if (dfn[i]==0){
                dfs(i);
            }
        }
        boolean flag=false;
        for(int i = 1 ; i <= n ; i ++)
        {
            for(int j = 0 ; j < vector[i].size() ; j ++)
            {
                int ta , tb ;
                ta = id[i] ;
                tb = id[ vector[i].get(j) ] ;
                if(ta != tb)
                {
                    ind[tb] ++ ;
                    out[ta] ++ ;
                }
            }
        }
        for(int i = 1 ; i <= count ; i ++)
        {
            if(ind[i] == 0)
                anA ++ ;
            if(out[i] == 0)
                anB ++ ;
        }
        if(count == 1)
        {
            anB = 0 ;
        }
        else
        {
            anB =Math. max(anB , anA) ;
        }
        System.out.println(anA);
        System.out.println(anB);
    }

    private static void dfs(int u) {
        low[u]=dfn[u]=++countDfn;
        stack.push(u);
        isStack[u]=true;
        for (int i=0;i<vector[u].size();i++){
            int t=vector[u].get(i);
            if (dfn[t]==0){
                dfs(t);
                low[u]=Math.min(low[u],low[t]);
            }
            else if (isStack[t]){
                low[u]=Math.min(low[u],dfn[t]);
            }
        }
        //缩点
        if (dfn[u]==low[u]){
            ++count; //强连通分量个数
            boolean flag=true;
            while(flag){
                int t=stack.peek();
                if (t==u) flag=false;
                stack.pop();
                isStack[t]=false;
                id[t]=count; //缩点，同一个连通分量的标记为同一号
            }
        }
    }

    private static void init() {
        for (int i=0;i<=n;i++){
            vector[i]=new Vector<Integer>();
        }
        Arrays.fill(dfn,0);
        Arrays.fill(low,0);
        Arrays.fill(id,0);
        Arrays.fill(out,0);
        Arrays.fill(ind,0);
        Arrays.fill(isStack,false);
        if (!stack.empty())
            stack.clear();
        countDfn=0;
        count=0;
        anA=0;
        anB=0;
    }
}
