package 图论.tsp问题;

/**
 * Created by user on 2017/10/13.
 */
public class Main {
    /**
     * 从开始点出发 每个顶点经过一次回到起始点的最小费用
     */
    //dp
    public static void main(String[] args) {
        int dp[][]=new int[100][100];
        int mp[][]=new int[100][100];
        int n=5;
        dp[(1<<n)][0]=0;
        for (int s=(1<<n)-2;s>=0;s--){
            for (int v=0;v<n;v++){
                for (int u=0;u<n;u++){
                    if ((s>> u & 1)==0){
                        dp[s][v]=Math.min(dp[s][v], dp[s | 1<<u][u]+mp[v][u]);
                    }
                }
            }
        }
    }
}
