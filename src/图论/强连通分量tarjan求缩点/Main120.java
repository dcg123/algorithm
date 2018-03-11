package 图论.强连通分量tarjan求缩点;

import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

/**
 * Created by user on 2017/10/7.
 * 利用tarjan+缩点，tarjan算法求出所有强连通分量，
 * 然后同一个连通分量标记为同一个值，相当于看成一个点，于是将图简化，然后再看，所有入度为0或者出度为0的点都需要添加一条边，可以由出度为0的一条连向入度为0的一条，剩下的随便加一条，
 * 注意特殊情况，当只有一个连通分量时，入度和出度都为0，但是结果应该为0
 */
public class Main120 {
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
        for (int i=1;i<=n;i++){
            for (int j=0;j<v[i].size();j++){
                if (belong[i]!=belong[v[i].get(j)]){
                    ++in[belong[v[i].get(j)]];
                    ++out[belong[i]];
                }
            }
        }
        int a1=0,a2=0;
        for (int i=1;i<=num;i++){
            if (in[i]==0){
                a1++;
            }
            if (out[i]==0) a2++;
        }
        ans = a1>a2?a1:a2;
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
