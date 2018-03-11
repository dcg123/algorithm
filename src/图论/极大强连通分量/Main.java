package 图论.极大强连通分量;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

/**
 * Created by user on 2017/10/14.
 */

/**
 * 求极大联通分量
 * poj2186 给出关系图 找出有多个牛是被所有牛所欢迎的
 * 找出联通快 缩点  形成一个DAG图
 */
public class Main {
    static Vector<Integer> vector[]=new Vector[100000];
    static int dfn[]=new int[100000];
    static int low[]=new int[100000];
    static Stack<Integer> stack=new Stack<Integer>();
    static int n,m;
    static int num,count,cnt;
    static int belong[]=new int[100000];
    static boolean isStack[]=new boolean[100000];
    static int x[]=new int[100000],y[]=new int[100000];
    static int out[]=new int[100000];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        m=scanner.nextInt();
        scanner.nextLine();
        for (int i=1;i<=n;i++){
            vector[i]=new Vector<Integer>();
        }
        for (int i=0;i<m;i++){
            String str=scanner.nextLine();
            String a[]=str.split(" ");
            int u=Integer.valueOf(a[0]);
            int v=Integer.valueOf(a[1]);
            x[i]=u;
            y[i]=v;
            vector[y[i]].add(x[i]);
        }
        tarjan();
        for (int i=1;i<=m;i++){
            if (belong[x[i]]!=belong[y[i]]){
                out[belong[x[i]]]++;
            }
        }
        int ans=0;
        for (int i=1;i<=cnt;i++){
            if (out[i]==0){
                ans++;
            }
        }
        if (ans>1){
            System.out.println("0");
        }else {
            ans=0;
            for (int i=1;i<=n;i++){
                if (out[belong[i]]==0){
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }

    private static void tarjan() {
        Arrays.fill(dfn,0);
        Arrays.fill(low,0);
        Arrays.fill(isStack,false);
        if (!stack.empty())stack.clear();
        Arrays.fill(belong,0);
        num=0;
        count=0;cnt=0;
        for (int i=1;i<=n;i++){
            if (dfn[i]==0){
                dfs(i);
            }
        }
    }

    private static void dfs(int u) {
        low[u]=dfn[u]=++num;
        isStack[u]=true;
        stack.push(u);
        for (int i=0;i<vector[u].size();i++){
            int v=vector[u].get(i);
            if (dfn[v]==0){
                dfs(v);
                low[u]=Math.min(low[u],low[v]);
            }else  if (isStack[u]){
                low[u]=Math.min(low[u],dfn[v]);
            }
        }
        if (low[u]==dfn[u]){
            cnt++;
            int v;
            do {
                v=stack.pop();
                belong[v]=cnt;
                isStack[v]=false;
            }while (v!=u);
        }
    }
}
