package 基础dp.二位dp坐标;

import java.util.Scanner;

public class poj1163 {

	/**
	 * @param args
	 * 有一个由非负整数组成的三角形，第一行只有一个数，除了最下行之外每个数的左下方和右下方各有一个数，从第一行的数开始，每次可以往左下和右下走一格，
	 * 直到走到最下行，把沿途经过的数全部加起来，如何才能使这个和最大？？
	 */
	static int MAX_N=100+2;
	static int dp[][]=new int[MAX_N][MAX_N];
	static int map[][]=new int[MAX_N][MAX_N];
	static int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		n=scan.nextInt();
		for(int i=1;i<=n;i++){
			for(int j=1;j<=i;j++){
				map[i][j]=scan.nextInt();
			}
		}
		dp[0][0]=0;
		for(int i=1;i<=n;i++){
			for(int j=1;j<=i;j++){
				dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-1])+map[i][j];
				//System.out.println(i+" "+j+" "+dp[i][j]);
			}
		}
		int ans=Integer.MIN_VALUE;
		for(int i=1;i<=n;i++){
			if(ans<dp[n][i]){
				ans=dp[n][i];
			}
		}
		System.out.println(ans);
	}

}
