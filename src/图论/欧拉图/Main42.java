package 图论.欧拉图;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

/**
 * Created by user on 2017/10/6.
 */
public class Main42 {
    /**
     * 欧拉定理 : 如果一个网络是连通的并且奇顶点的个数等于0或2，
     * 那么它可以一笔画出；否则它不可以一笔画出。
     所以这个题先用DFS搜索图是否连通，然后再判断奇结点个数就行了。
     */
    static Vector<Integer> vector[]=new Vector[1000+5];
    static int p,q;
    static int du[]=new int[1000+10];
    static boolean vis[]=new boolean[1000+10];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while (t-->0){
            p=scanner.nextInt();
            q=scanner.nextInt();
            scanner.nextLine();
            for (int i=0;i<=p;i++){
                vector[i]=new Vector<Integer>();
            }
            Arrays.fill(vis,false);
            Arrays.fill(du,0);
            for (int i=0;i<q;i++){
                String str=scanner.nextLine();
                String a[]=str.split(" ");
                int u=Integer.valueOf(a[0]);
                int v=Integer.valueOf(a[1]);
                vector[u].add(v);
                vector[v].add(u);
                du[u]++;
                du[v]++;
            }
            boolean flag=true;
            //判断图是否联通
            dfs(1);
            for (int i=1;i<=p;i++){
                if (!vis[i]){
                    flag=false;
                    break;
                }
            }
            if (flag){
                int k=0;
                for (int i=1;i<=p;i++){
                    if (du[i]%2==1){
                        k++;
                    }
                }
                if (k==0||k==2){
                    System.out.println("Yes");
                }else {
                    System.out.println("No");
                }
            }else {
                System.out.println("No");
            }
        }
    }

    private static void dfs(int u) {
        vis[u]=true;
        int d=vector[u].size();
        for (int i=0;i<d;i++){
            int v=vector[u].get(i);
            if (!vis[v])dfs(v);
        }
    }
}
