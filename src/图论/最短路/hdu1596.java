package 图论.最短路;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by user on 2017/10/13.
 */
public class hdu1596 {
    static int n;
    static double d[]=new double[1000+10];
    static boolean vis[]=new boolean[1000+10];
    static double map[][]=new double[1000+10][1000+10];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            n=scanner.nextInt();
            scanner.nextLine();
            init();
            for (int i=1;i<=n;i++){
                String str=scanner.nextLine();
                String a[]=str.split(" ");
                for (int j=1;j<=n;j++){
                    map[i][j]=Double.valueOf(a[j-1]);
                }
            }
            int q=scanner.nextInt();
            scanner.nextLine();
            for (int i=0;i<q;i++){
                String str=scanner.nextLine();
                String a[]=str.split(" ");
                int x=Integer.valueOf(a[0]);
                int y=Integer.valueOf(a[1]);
                spfa(x,y);
            }
        }
    }

    private static void spfa(int start, int end) {
        Queue<Integer> queue=new LinkedList<Integer>();
        Arrays.fill(vis,false);
        Arrays.fill(d,0);
        d[start]=1;
        vis[start]=true;
        queue.offer(start);
        while (queue.size()!=0){
            int cur=queue.poll();
            vis[cur]=false;
            for (int i=1;i<=n;i++){
                if (d[i]<d[cur]*map[cur][i]){
                    d[i]=d[cur]*map[cur][i];
                    if (!vis[i]){
                        vis[i]=true;
                        queue.offer(i);
                    }
                }
            }
        }
        if (d[end]==0){
            System.out.println("What a pity!");
        }else {
            System.out.printf("%.3f\n",d[end]);
        }
    }

    private static void init() {
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if (i==j){
                    map[i][j]=0;
                }else {
                    map[i][j]=9999999;
                }
            }
        }
    }
}
