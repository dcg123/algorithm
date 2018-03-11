package 图论.强连通分量tarjan求缩点;

import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

/**
 * Created by user on 2017/10/18.
 */
public class 连通图变强连通图最少添加多少边 {
    /**
     * 题意：这里有一个东西要你证明，就是有n个式子，用1到n标记，
     * 有m个关系，每个关系为a b 表示a推导出b，那么我们要这n个式子都是等价的最少还需要多少个关系
     分析：这里我们把n个式子看做n个点，
     那么要是n个点等价就是任意一个点能推导出任意的另一个点，意思就是最后要是一个强连通，
     问最少要添加多少条边，我们根据已有的关系建图之后，强连通缩点，然后我们分别求叶子和根的数量，
     那么最多的那个就是我们要的答案，但是当缩点只有一个点的时候，答案是 0
     */
    static Vector<Integer> v[]=new Vector[105];
    static int n,ans;
    static int dfn[]=new int[105];
    static int low[]=new int[105];
    static int belong[]=new int[105];
    static int in[]=new int[105],out[]=new int[105];
    static boolean flag;
    static boolean instack[]=new boolean[105];
    static Stack<Integer> s =new Stack<Integer>();
    static int count=0,num=0;
    static void tarjan(int u){
        low[u]=dfn[u]= ++count;
        instack[u]=true;
        s.push(u);
        int t;
        for (int i=0;i<v[u].size();i++){
            t=v[u].get(i);
            if (dfn[t]==0){
                tarjan(t);
                low[u]=Math.min(low[u],low[t]);
            }
            else if (instack[t]){
                low[u]=Math.min(low[u],dfn[t]);
            }
        }
        if (dfn[u]==low[u]){
            num++; //强连通分量个数
            flag=true;
            while(flag){
                t=s.peek();
                if (t==u) flag=false;
                s.pop();
                instack[t]=false;
                belong[t]=num; //缩点，同一个连通分量的标记为同一号
            }
        }
    }
    static void getans(){
        for (int i=1;i<=n;i++){
            if (dfn[i]==0)
                tarjan(i);
        }
        for (int i=1;i<=n;i++){//缩点后求出入度和出度
            for (int j=0;j<v[i].size();j++){
                if (belong[i]!=belong[v[i].get(j)]){
                    ++in[belong[v[i].get(j)]];
                    ++out[belong[i]];
                }
            }
        }
        //求出入度为0的跟 和出度为0的叶子结点个数
        int root=0,son=0;
        for (int i=1;i<=n;i++){
            if (in[i]==0){
                root++;
            }
            if (out[i]==0){
                son++;
            }
        }
        if (root==0||son==0){
            System.out.println(0);
        }else
        System.out.println(root>son?root:son);
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int T,t;
        T=scanner.nextInt();
        while(T-->0){
            n=scanner.nextInt();
            scanner.nextLine();
            count=num=0;
            while(!s.empty()) s.pop();
            for (int i=0;i<105;i++) {
                in[i]=out[i]=0;
                low[i]=dfn[i]=belong[i]=0;
                v[i]=new Vector<Integer>();
            }
            for (int i=1;i<=n;i++){
                String str=scanner.nextLine();
                String a[]=str.split(" ");
                int count=0;
                while(Integer.valueOf(a[count])!=0){
                    v[i].add(Integer.valueOf(a[count]));
                    count++;
                }
            }
            getans();
            if (num==1) System.out.println(0);
            else System.out.println(ans);
        }
    }
}
