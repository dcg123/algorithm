package 图论.最短路;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by user on 2017/10/13.
 */
public class hdu1142 {
    /**
     * 题目意思注意点：题目不是求最短路有多少条，而是，假如有一条A到B的路，
     * 而B到家的最短路比A到家的最短路要小，那么就可以从A到B，B到家，
     * 这可以算作一条路可走。求共有多少条这样的路从1点到家（2）。
     解题：先算出每个点到点2的最短路算出来，然后用深搜+标记，减少时间，算出共有多少条路可走到家。
     */
    static int n,m;
    static int map[][]=new int[1000+10][1000+10];
    static int d[]=new int[1000+10];
    static boolean vis[]=new boolean[1000+10];
    static int path[]=new int[1000+10];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            n=scanner.nextInt();
            if (n==0){
                break;
            }
            m=scanner.nextInt();
            scanner.nextLine();
            for (int i=0;i<1000+10;i++){
                for (int j=0;j<1000+10;j++){
                    if (i==j)
                        map[i][j]=0;
                    else
                    map[i][j]=999999999;
                }
            }
            for (int i=0;i<m;i++){
                String str=scanner.nextLine();
                String a[]=str.split(" ");
                int u=Integer.valueOf(a[0]);
                int v=Integer.valueOf(a[1]);
                int cost=Integer.valueOf(a[2]);
                map[u][v]=map[v][u]=cost;
            }
            spfa();
            //深搜 搜出所有符合的条件
            Arrays.fill(path,-1);
            int ans=dfs(1);
            System.out.println(ans);
        }
    }

    static int dfs(int x)
    {
        if(path[x]!=-1)  //记忆化
            return path[x];
        if(x==2)
            return 1;
        path[x]=0;
        for(int i=1;i<=n;i++)
        {
            if(map[x][i]!=999999999&&d[x]>d[i])
                path[x]+=dfs(i);
        }
        return path[x];
    }

    private static void spfa() {
        Queue<Integer> queue=new LinkedList<Integer>();
        Arrays.fill(d,999999999);
        Arrays.fill(vis,false);
        for (int i=1;i<=n;i++){
            if (map[2][i]!=999999999){
                d[i]=map[2][i];
                vis[i]=true;
                queue.offer(i);
            }
        }
        d[2]=0;
        vis[2]=true;
        while (queue.size()!=0){
            int cur=queue.poll();
            vis[cur]=false;
            for (int i=1;i<=n;i++){
                if (d[cur]+map[cur][i]<d[i]){
                    d[i]=d[cur]+map[cur][i];
                    if (!vis[i]){
                        vis[i]=true;
                        queue.offer(i);
                    }
                }
            }
        }
    }
}
