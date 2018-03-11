package 图论.欧拉图;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by user on 2017/9/25.
 */
public class Main {
    static int maxe=1995+10;
    static int maxv=44+10;
    class Node{
        int u,v;
    }
    static Main main=new Main();
    static int n,m;
    static int degree[]=new int[maxv];//每个点的度数
    static int vis[]=new int[maxv];//标记边是否被走过
    static int ans[]=new int[maxv];//最终结果存在这里
    static int cnt;//当前存在ans中的边下标
    static Node edges[]=new Node[maxe];
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int x=scanner.nextInt();
            int y=scanner.nextInt();
            if(x==0){
                break;
            }

            cnt=n=m=0;
            int John_home = Math.min(x,y);
            Arrays.fill(degree,0);
            Arrays.fill(vis,0);
           do {
               int z=scanner.nextInt();
               edges[z]=main.new Node();
               edges[z].u=x;
               edges[z].v=y;
               degree[x]++;
               degree[y]++;
               m++;
               n=Math.max(n,Math.max(x,y));
           }while (scanner.hasNext()&&(x=scanner.nextInt())!=0&&(y=scanner.nextInt())!=0);
           if (!ok()){
               System.out.println("Round trip does not exist.");
           }else {
               euler(John_home);
               System.out.print(ans[m-1]);
               for (int i=m-2;i>=0;i--){
                   System.out.print(" "+ans[i]);
               }
               System.out.println();
           }
        }
    }

    private static void euler(int s) {
        for (int i=1;i<=m;i++){
            if (vis[i]==0&&(edges[i].u==s||edges[i].v==s)){
                vis[i]=1;
                euler(edges[i].u+edges[i].v-s);
                ans[cnt++]=i;
            }
        }
    }

    private static boolean ok() {
        for(int i=1;i<=n;i++)if(degree[i]%2!=0) return false;
        return true;
    }
}
