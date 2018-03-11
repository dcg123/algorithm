package 基础dp.二维最长公共子序列问题;

import java.util.Scanner;

public class poj1458 {

	/**
	 * @param args
	 *   给你两个字符串, 要你求出两个字符串的最长公共子序列长度.
	 */
	static int MAX_N=1000+5;
	static int dp[][]=new int[MAX_N][MAX_N];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		while(scan.hasNext()){
			String s1=scan.next();
			String s2=scan.next();
			for(int i=0;i<MAX_N;i++){
				for(int j=0;j<MAX_N;j++){
					dp[i][j]=0;
				}
			}
			for(int i=1;i<=s1.length();i++){
				for(int j=1;j<=s2.length();j++){
					if(s1.charAt(i-1)==s2.charAt(j-1)){
						dp[i][j]=dp[i-1][j-1]+1;
					}else{
						dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
					}
				}
			}
			System.out.println(dp[s1.length()][s2.length()]);
		}
	}

}
