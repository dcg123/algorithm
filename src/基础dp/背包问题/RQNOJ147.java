package 基础dp.背包问题;

import java.util.Scanner;

public class RQNOJ147 {

	/**
	 * @param args
	 * 有一个箱子容量为V（正整数，0＜＝V＜＝20000），同时有n个物品（0＜n＜＝30＝，每个物品有一个体积（正整数）。
	要求n个物品中，任取若干个装入箱内，使箱子的剩余空间为最小。
	 */
	static int MAX_N=30+2;
	static int a[]=new int[MAX_N];
	static int n,v;
	static int dp[]=new int[MAX_N];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		v=scan.nextInt();
		n=scan.nextInt();
		for(int i=0;i<n;i++){
			a[i]=scan.nextInt();
		}
		for(int i=0;i<n;i++){
			for(int j=v;j>=a[i];j--){
				dp[j]=Math.max(dp[j], dp[j-a[i]]+a[i]);
			}
		}
		System.out.println(v-dp[v]);
	}

}
