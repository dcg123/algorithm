package 基础dp;

import java.util.Scanner;

public class poj2229 {

	/**
	 * @param args
	 * 将一个数N分解为2的幂之和共有几种分法？
	 * 定义dp[i]为i的分解方案数。dp[0] = 2 ^ 0 = 1，递推到 N 。
	 * 若i为偶数，则dp[i] = dp[i / 2] + dp[i – 1] + 1，否则dp[i] = dp[i – 1] + 1。
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		int dp[]=new int[1000005];
		dp[1]=1;
		dp[2]=2;
		for(int i=3;i<=1000000;i++){
			if(i%2!=0){
				dp[i]=dp[i-1];
			}
			else{
				dp[i]=dp[i-2]+dp[i/2];
			}
			if(dp[i]>1000000000){
				dp[i]%=1000000000;
			}
		}
		int n=scan.nextInt();
		System.out.println(dp[n]);
		
	}

}
