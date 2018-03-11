package 图论.拓扑排序;

import java.net.Inet4Address;
import java.util.Scanner;

/**
 * Created by user on 2017/10/12.
 */
public class hdu1285 {
    static int n,m;
    static int in[]=new int[510];
    static boolean map[][]=new boolean[510][510];
    static int ans[]=new int[510];
    static int k;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            n=scanner.nextInt();
            m=scanner.nextInt();
            if (n+m==0){
                break;
            }
            for (int i=0;i<510;i++){
                for (int j=0;j<510;j++){
                    map[i][j]=false;
                }
            }
            scanner.nextLine();
            for (int i=0;i<m;i++){
                String str=scanner.nextLine();
                String a[]=str.split(" ");
                int u=Integer.valueOf(a[0]);
                int v=Integer.valueOf(a[1]);
                if (!map[u][v]){
                    map[u][v]=true;
                    in[v]++;
                }
            }
            topsort();
            for (int i=1;i<=k;i++){
                System.out.println(ans[k]);
            }
        }
    }

    private static void topsort() {
         k=1;
        for (int i=1;i<=n;i++){
            for (int j=1;j<=n;j++){
                if (in[j]==0){//吧入度为0的点加入 并删除想关联的边
                    in[j]--;
                    ans[k++]=j;
                    for (int l=1;l<=n;l++){
                        if (map[j][l]){
                            in[l]--;
                        }
                    }
                    break;
                }
//                if (j>=n){
//                    System.out.println("存在环");
//                    return;
//                }
            }
        }

    }
}
