package 图论.强连通分量tarjan求缩点;

import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

/**
 * Created by user on 2017/10/18.
 */
public class poj2186 {
    /**
     * 题意：有N头牛，M个关系，每个关系为 a b，表示牛a认为牛b 收欢迎，
     * 那么问根据所给信息判断有多少头牛是收到所有的牛的欢迎，而且这里a认为b受欢迎，
     * b认为c受欢迎，那么a也会认为c受欢迎，
     分析：这里我们根据M个关系建图，然后对于这个图缩点，那么，根据上面的缩点分析，
     我们只要求叶子的个数，因为别的缩点都指向叶子，叶子处在最高层，就是最受欢迎的，
     那么我们根据所有缩点的out[i]=0的个数，判断，如果只有一个，那么这个缩点(强连通分量)
     的牛都是最受欢迎的，(这里注意，
     叶子数为0就是表示只有一个强连通分量，那么所有的牛都是最受欢迎的)，如果有多个就输出0
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
        for (int i=1;i<=n;i++){//计算缩点后每个点的出度和入度
            for (int j=0;j<v[i].size();j++){
                if (belong[i]!=belong[v[i].get(j)]){
                    ++in[belong[v[i].get(j)]];
                    ++out[belong[i]];
                }
            }
        }//计算出度为0 的点 叶子结点 如果 出度为0的点等于1的话 输出这个联通分量的个数 如多多余1个输出0
        int a1=0,a2=0;
        for (int i=1;i<=num;i++){
            if (out[i]==0) {
                a2++;
                a1=i;
            }
        }
        if(a2>1){
            System.out.println(0);
        }else {
            int sum=0;
            for (int i=1;i<=n;i++){
                if (belong[i]==a2){
                    sum++;
                }
            }
            System.out.println(sum);
        }
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
