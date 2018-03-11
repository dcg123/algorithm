package 基础dp.二维最长公共子序列问题;

import java.util.Scanner;

public class poj3356 {

	/**
	 * @param args  编辑距离
	 * 题意：
	由字符串 s1 通过下列三种操作
	　1、插入一个字符；
	2、删除一个字符；
	　3、改变一个字符
	变换到字符串 s2 所需要的最少操作次数（亦即最短编辑距离问题）
	 */
	static int MAX_N=1000+2;
	static int dp[][]=new int[MAX_N][MAX_N];
	static int l1,l2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		String str=scan.nextLine();
		String s=scan.nextLine();
		String ss[]=str.split(" ");
		String sss[]=s.split(" ");
		l1=Integer.valueOf(ss[0]);
		l2=Integer.valueOf(sss[0]);
		String x=ss[1];
		String y=sss[1];
		for(int i=1;i<=l1;i++){
			for(int j=1;j<=l2;j++){
				if(x.charAt(i)-1==y.charAt(j-1)){
					dp[i+1][j+1]=dp[i][j]+1;
					//System.out.println(dp[i][j]);
				}else{
					dp[i+1][j+1]=Math.max(dp[i][j+1],dp[i+1][j]);
					//System.out.println(dp[i][j]);
				}
			}
		}
		String z="";
		for(int i=1;i<=l1;i++){
			for(int j=1;j<=l2;j++){
//				if(a[i]==b[j]){
//					z+=a[i];
//				}else if(dp[i][j-1]>dp[i-1][j]){
//					j++;
//				}else{
//					i++;
//				}
			}
		}
		System.out.println(dp[l1][l2]+" "+z);
	}

}
