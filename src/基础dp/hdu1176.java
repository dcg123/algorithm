package 基础dp;

import java.util.Scanner;

/**
 * Created by user on 2017/10/15.
 */
public class hdu1176 {
    /**
     * 都说天上不会掉馅饼，但有一天gameboy正走在回家的小径上，
     * 忽然天上掉下大把大把的馅饼。说来gameboy的人品实在是太好了，
     * 这馅饼别处都不掉，就掉落在他身旁的10米范围内。馅饼如果掉在了地上当然就不能吃了，
     * 所以gameboy马上卸下身上的背包去接。但由于小径两侧都不能站人，所以他只能在小径上接。
     * 由于gameboy平时老呆在房间里玩游戏，虽然在游戏中是个身手敏捷的高手
     * ，但在现实中运动神经特别迟钝，每秒种只有在移动不超过一米的范围内接住坠落的馅饼。
     */
    static int N=100000+10;
    static int dp[][]=new int[N][12];
    static int n;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            n=scanner.nextInt();
            if (n==0){
                break;
            }
            for (int i=0;i<N;i++){
                for (int j=0;j<12;j++){
                    dp[i][j]=0;
                }
            }
            int MAX_time=0;
            for (int i=0;i<n;i++){
                int loction=scanner.nextInt();
                int time=scanner.nextInt();
                ++dp[time][loction];
                if (MAX_time<time){
                    MAX_time=time;
                }
            }
            System.out.println(solved(MAX_time));
        }
    }

    private static int solved(int max_time) {
        for (int i=max_time-1;i>=0;i--){
            dp[i][0] = Math.max(dp[i+1][0], dp[i+1][1]) + dp[i][0];
            for (int j = 1; j < 10; ++j){
                dp[i][j] = Math.max(dp[i+1][j-1], Math.max(dp[i+1][j], dp[i+1][j+1])) + dp[i][j];
            }
            dp[i][10] = Math.max(dp[i+1][10], dp[i+1][9]) + dp[i][10];
        }
        return dp[0][5];
    }
}
