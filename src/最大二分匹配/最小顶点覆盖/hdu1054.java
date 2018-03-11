package 最大二分匹配.最小顶点覆盖;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by user on 2017/10/11.
 */
public class hdu1054 {
    /**
     * //最小顶点覆盖 == 最大匹配（双向图）/2；
     * 图G的顶点覆盖是一个顶点集合V，使得G中的每一条边都接触V中的至少一个顶点。我们称集合V覆盖了G的边。
     * 最小顶点覆盖是用最少的顶点来覆盖所有的边。顶点覆盖数\tau是最小顶点覆盖的大小。
     */
    static boolean vis[]=new boolean[1505];
    static int ret[]=new int[1505];
    static int n,m;
    static Vector<Integer> vector[]=new Vector[1505];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            n=scanner.nextInt();
            if (n==0){
                break;
            }
            for (int i=0;i<=n;i++){
                vector[i]=new Vector<Integer>();
            }
            scanner.nextLine();
            for (int i=0;i<n;i++){
                String str=scanner.nextLine();
                String a[]=str.split(" ");
                int u=a[0].charAt(0)-'0';
                int k=a[0].charAt(3)-'0';
                for (int j=0;j<k;j++){
                    int v=Integer.valueOf(a[j+1]);
                    vector[u].add(v);
                    vector[v].add(u);
                }
            }
            int sum=0;
            Arrays.fill(ret,-1);
            for (int i=0;i<n;i++){
                Arrays.fill(vis,false);
                if (find(i)){
                    sum++;
                }
            }
            System.out.println(sum/2);
        }
    }

    private static boolean find(int cur) {
        int d=vector[cur].size();
        for (int i=0;i<d;i++){
            int v=vector[cur].get(i);
            if (!vis[v]){
                vis[v]=true;
                if (ret[v]==-1||find(ret[v])){
                    ret[v]=cur;
                    return true;
                }
            }
        }
        return false;
    }
}
