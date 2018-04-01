package leetcode.数组;

/**
 * @author dcg
 * Created by user on 2018/4/1.
 */
public class le64 {
    /**
     * 给定一个只含非负整数的 m x n 网格，找到一条从左上角到右下角的可以使数字之和最小的路径。
     *
     * 动态规划思想：不难推出dp[i][j]=grid[i][i]+min(dp[i-1][j],dp[i][j+1])
     *
     *  当心处理边界情况
     */
    public static void main(String[] args) {
        int grid[][]={{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
    }
    public static int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int result[][]=new int[m][n];
        result[0][0]=grid[0][0];
        for (int i=1;i<m;i++){
            result[i][0]=grid[i][0]+result[i-1][0];
        }
        for (int i=1;i<n;i++){
            result[0][i]=grid[0][i]+result[0][i-1];
        }
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                result[i][j]=grid[i][j]+Math.min(result[i][j-1],result[i-1][j]);
            }
        }
        return result[m-1][n-1];
    }
}
