package 图论.spfa判断是否存在环;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * Created by user on 2017/10/6.
 */
public class Main973 {
    static double map[][]=new double[550][550];
    static boolean vis[]=new boolean[550];
    static int used[]=new int[550];
    static int n,m;
    static double d[]=new double [550];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while (t-->0){
            n=scanner.nextInt();
            m=scanner.nextInt();
            scanner.nextLine();
            Arrays.fill(vis,false);
            Arrays.fill(used,0);
            Arrays.fill(d,0);
            inti();
            for (int i=0;i<m;i++){
                String str=scanner.nextLine();
                String a[]=str.split(" ");
                int u=Integer.valueOf(a[0]);
                int f=Integer.valueOf(a[1]);
                int v=Integer.valueOf(a[2]);
                if (map[u][v]<f){
                    map[u][v]=f;
                }
            }
            if (spfa(1)){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
    }

    private static boolean spfa(int s) {
        Queue<Integer> queue=new LinkedList<Integer>();
        queue.offer(s);
        vis[s]=true;
        d[s]=1.0;
        used[s]++;
        while (queue.size()!=0){
            int cur=queue.poll();
            vis[cur]=false;
            for (int i=1;i<=n;i++){
                if (map[cur][i]>0&&d[i]<d[cur]*map[cur][i]){
                    d[i]=d[cur]*map[cur][i];
                    if (!vis[i]){
                        vis[i]=true;
                        queue.offer(i);
                        used[i]++;
                        if (used[i]>=n){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private static void inti() {
        for (int i=0;i<510;i++){
            for (int j=0;j<510;j++){
                map[i][j]=0;
            }
        }
    }
}
