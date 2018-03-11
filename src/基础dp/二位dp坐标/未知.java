package 基础dp.二位dp坐标;

import java.util.Scanner;

public class 未知 {

	/**
	 * @param args
	 */
	static int MAX_N=1000+2;
	static int z[][]=new int[MAX_N][MAX_N];
	static int h[][]=new int[MAX_N][MAX_N];
	static int dp[][]=new int[MAX_N][MAX_N];
	static int n,m;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		n=scan.nextInt();
		m=scan.nextInt();
		for(int i=1;i<=n;i++){
			for(int j=2;j<=m;j++){
				h[i][j]=scan.nextInt();
			}
		}
		for(int i=1;i<=n-1;i++){
			for(int j=1;j<=m;j++){
				z[i][j]=scan.nextInt();
			}
		}
		dp[n][0]=99999999;
		for(int i=n;i>=1;i--){
			for(int j=1;j<=m;j++){
				dp[i][j]=Math.min(dp[i+1][j]+z[i][j],dp[i][j-1]+h[i][j]);
			}
		}
		System.out.println(dp[1][m]);
	}

}
