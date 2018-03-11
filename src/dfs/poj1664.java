package dfs;

import java.util.Scanner;


public class poj1664 {

	/**
	 * @param args
	 *
	 * 把M个同样的苹果放在N个同样的盘子里，允许有的盘子空着不放，
	 * 问共有多少种不同的分法？（用K表示）5，1，1和1，5，1 是同一种法分。
	 * f(m,n)=1 �� m=1��n=1��
f(m,n)=f(m,m) ��m<n;
f(m,n)=1+f(m,m-1) ��m=n;
f(m,n)=f(m-n,n)+f(m,n-1);
	 */
	static int max=20+5;
	static int dp[][]=new int[max][max];
	static int m,n,sum;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int t=scan.nextInt();
		while(t>0){
			m=scan.nextInt();
			n=scan.nextInt();
			sum=0;
			init();
			System.out.println(dfs(m,n));
			t--;
		}
	}
	private static int dfs(int m,int n) {
		// TODO Auto-generated method stub
		if(dp[m][n]>0){
			return dp[m][n];
		}
		else if(m==1||n==1){
			dp[m][n]=1;
			return dp[m][n];
		}
		else if(m<n){
			dp[m][n]=dfs(m,m);
			return dp[m][n];
		}
		else if(m==n){
			dp[m][n]=1+dfs(m,m-1);
			return dp[m][n];
		}
		else{
			dp[m][n]=dfs(m-n,n)+dfs(m,n-1);
			return dp[m][n];
		}
	}
	private static void init() {
		// TODO Auto-generated method stub
		for(int i=0;i<max;i++){
			for(int j=0;j<max;j++){
				dp[i][j]=0;
			}
		}
	}

}
