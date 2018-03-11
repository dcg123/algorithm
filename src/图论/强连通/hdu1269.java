package 图论.强连通;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by user on 2017/10/12.
 */
public class hdu1269 {
    /**
     * 题意 判断图中任意两点是否存在一个点可以到达另一个点 另一个点到达一个点
     *
     * 强连通分量
     */

    static int maxn=100005;
    static int inf=999999;
    static Vector<Integer> G[]=new Vector[maxn];
    static int dfn[]=new int[maxn],low[]=new int[maxn],s[]=new int[maxn];//依次对应，访问的序号，能到达的最早的，栈
    static int belong[]=new int[maxn];//连通分量的编号
    static boolean ins[]=new boolean[maxn];//是否在栈里
    static int cnt,num,top;//连通分量的编号，访问的序号，栈的指针
    static void dfs(int u){
        dfn[u]=low[u]=++num;//初始化两个值，自己为能找到的最先访问的祖先
        s[++top]=u;//吧当前访问的点存储在栈中
        ins[u]=true;//标记访问过
        int N=G[u].size();
        for(int i=0;i<N;i++){
            int v=G[u].get(i);
            if(dfn[v]==0){//如果没有访问过
                dfs(v);
                low[u]=Math.min(low[u],low[v]);//更新能找到的最早祖先
            }
            else if(ins[v]&&dfn[v]<low[u]){//如果访问过了，并且该点的DFN更小，则
                //flag[v]这个判断条件很重要，这样可以避免已经确定在其他联通图的v,因为u到v的单向边而影响到u的low
                low[u]=dfn[v]; //也就是已经确定了的联通图要剔除掉，剔除的办法就是判断其还在栈中，因为已经确定了的连通图的点
            }
        }
        //往后回溯的时候，如果发现DFN和low相同的节点，就可以把这个节点之后的节点全部弹栈，构成连通图
        if(low[u]==dfn[u]){
            cnt++;//记录连通图的数量
            int v;
            do{
                v=s[top--];//依次取出，直到u
                ins[v]=false;//设置为不在栈中
                belong[v]=cnt;//标记属于拿个联通分量
            }while(v!=u);
        }
    }

    static void Tarjan(int n){
        cnt=num=top=0;
        Arrays.fill(dfn,0);
        Arrays.fill(ins,false);
        Arrays.fill(belong,0);
        for(int i=1;i<=n;i++)if(dfn[i]==0){
            dfs(i);
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n,m;
        while(scanner.hasNext()){
            n=scanner.nextInt();
            m=scanner.nextInt();
            if (n+m==0){
                break;
            }
            scanner.nextLine();
            for (int i=0;i<=n;i++){
                G[i]=new Vector<Integer>();
            }
            for(int i=0;i<m;i++){
                int a,b;
                String str=scanner.nextLine();
                String c[]=str.split(" ");
                a=Integer.valueOf(c[0]);
                b=Integer.valueOf(c[1]);
                G[a].add(b);
            }
            Tarjan(n);
            boolean flag=true;
            for(int i=1;i<=n;i++){
                if(belong[i]!=cnt){
                   flag=false;
                    break;
                }
            }
            if (flag){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
    }
}
