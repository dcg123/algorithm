package 基础dp.二维最长公共子序列问题;

import java.util.Scanner;

public class poj2533 {

	/**
	 * @param args
	 * 最长上升子序列（LIS）
	 */
	static int MAX_N=1000+2;
	static int dp[]=new int[MAX_N];
	static int a[]=new int[MAX_N];
	static int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		for(int i=0;i<n;i++){
			a[i]=scan.nextInt();
			dp[i]=1;
		}
		
		for(int i=1;i<n;i++){
			for(int j=0;j<i;j++){
				if(a[j]<a[i]&&dp[i]<dp[j]+1){
					dp[i]=dp[j]+1;
				}
			}
		}
		int ans=-1;
		for(int i=0;i<n;i++)
			if(ans<dp[i])
				ans=dp[i];
		System.out.println(ans);
	}

}
