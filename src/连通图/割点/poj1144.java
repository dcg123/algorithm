package 连通图.割点;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

/**
 * Created by user on 2017/10/14.
 */
public class poj1144 {
    static int MAX=105;
    static Vector<Integer> vector[]=new Vector[MAX];
    static int low[]=new int[MAX];
    static int dfn[]=new int[MAX];
    static boolean isStack[]=new boolean[MAX];
    static int cnt[]=new int[MAX];
    static int n,countDfn,count;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            n=scanner.nextInt();
            if (n==0){
                break;
            }
            scanner.nextLine();
            init();
                while (scanner.hasNextLine()){
                    String str=scanner.nextLine();
                    String a[]=str.split(" ");
                    if (Integer.valueOf(a[0])==0){
                        break;
                    }
                    int i=Integer.valueOf(a[0]);
                    for (int j=0;j<a.length-1;j++){
                        int v=Integer.valueOf(a[1+j]);
                        vector[i].add(v);
                        vector[v].add(i);
                    }
                }

            solve();
        }
    }

    private static void solve() {
        for (int i=1;i<=n;i++){
            if (dfn[i]==0){
                dfs(i,-1);
            }
        }
        for (int i=1;i<=n;i++){
            if (cnt[i]==1){
                count++;
            }
        }
        System.out.println(count);
    }

    private static void dfs(int u,int fa) {
        low[u]=dfn[u]=++countDfn;
        isStack[u]=true;
        int child=0;
        for (int i=0;i<vector[u].size();i++){
            int v=vector[u].get(i);
            if (dfn[v]==0){
                child++;
                dfs(v,u);
                low[u]=Math.min(low[u],low[v]);
                if (low[v]>=dfn[u]){
                    cnt[u]=1;
                }
            }
            else if (v!=fa){
                low[u]=Math.min(low[u],dfn[v]);
            }
        }
        if (fa<0&&child==1){
            cnt[u]=0;
        }
    }

    private static void init() {
        for (int i=0;i<=n;i++){
            vector[i]=new Vector<Integer>();
        }
        Arrays.fill(dfn,0);
        Arrays.fill(cnt,0);
        Arrays.fill(low,0);
        Arrays.fill(isStack,false);
        count=0;
        countDfn=0;
    }
}
