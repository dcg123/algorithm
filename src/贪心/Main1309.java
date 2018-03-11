package 贪心;

import java.util.Scanner;
import java.util.Vector;

/**
 * Created by user on 2017/10/3.
 */
public class Main1309 {
    static int maxn = 100000 + 5;
    static int n;
    static Vector<Integer> vector[]=new Vector[maxn];
    static int p[]=new int[maxn];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while (t-->0){
            n=scanner.nextInt();
            int s=scanner.nextInt();
            init();
            for (int i=0;i<n-1;i++){
                int u=scanner.nextInt(),v=scanner.nextInt();
                vector[u].add(v);
                vector[v].add(u);
            }
            p[s]=-1;
            dfs(s,-1);
            for (int i=1;i<n;i++){
                System.out.println(p[i]+" ");
            }
            System.out.println(p[n]);
        }
    }

    private static void dfs(int u, int fa) {
        int d=vector[u].size();
        for (int i=0;i<d;i++){
            int v=vector[u].get(i);
            if (v!=fa){
                dfs(u,p[v]=u);
            }
        }
    }

    private static void init() {
        for (int i=0;i<=n;i++){
            vector[i]=new Vector<Integer>();
        }
    }
}
