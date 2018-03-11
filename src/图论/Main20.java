package 图论;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by user on 2017/10/6.
 */
public class Main20 {
    static int n,s;
    static int maxn = 100000 + 5;
    static Vector<Integer> vector[]=new Vector[maxn];
    static int p[]=new int[maxn];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while (t-->0){
            n=scanner.nextInt();
            s=scanner.nextInt();
            scanner.nextLine();
            for (int i=0;i<=n;i++){
                vector[i]=new Vector<Integer>();
            }
            Arrays.fill(p,0);
            for (int i=0;i<n-1;i++){
                String str=scanner.nextLine();
                String a[]=str.split(" ");
                int u=Integer.valueOf(a[0]);
                int v=Integer.valueOf(a[1]);
                vector[u].add(v);
                vector[v].add(u);
            }
            dfs(s,-1);
            for (int i=1;i<=n;i++){
                System.out.print(p[i]+" ");
            }
            System.out.println();
        }
    }

    private static void dfs(int u, int fa) {
        int d=vector[u].size();
        p[u]=fa;
        for (int i=0;i<d;i++){
            int v=vector[u].get(i);
            if (v!=fa){
                dfs(v,u);
            }
        }
    }
}
