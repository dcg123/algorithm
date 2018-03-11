package 基础dp.背包问题;

import java.util.Scanner;

public class ny49 {

	/**
	 * @param args
	 * 小明今天很开心，家里购置的新房就要领钥匙了，
	 * 新房里有一间他自己专用的很宽敞的房间。更让他高兴的是，
	 * 妈妈昨天对他说：“你的房间需要购买哪些物品，怎么布置，你说了算，
	 * 只要不超过N 元钱就行”。今天一早小明就开始做预算，但是他想买的东西太多了，
	 * 肯定会超过妈妈限定的N 元。于是，他把每件物品规定了一个重要度，分为5 等：
	 * 用整数1~5 表示，第5 等最重要。他还从因特网上查到了每件物品的价格（都是整数元）。
	 * 他希望在不超过N 元（可以等于N 元）的前提下，使每件物品的价格与重要度的乘积的总和最大。
	 * 设第j 件物品的价格为v[j]，重要度为w[j]，共选中了k 件物品，编号依次为j1...jk，
	 * 则所求的总和为：v[j1]*w[j1]+..+v[jk]*w[jk]请你帮助金明设计一个满足要求的购物单.
	 */
	static int MAX_N=25+2;
	static int w[]=new int[MAX_N];
	static int v[]=new int[MAX_N];
	static int dp[]=new int[30010];
	static int n,m;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		n=scan.nextInt();
		m=scan.nextInt();
		for(int i=0;i<m;i++){
			w[i]=scan.nextInt();
			v[i]=scan.nextInt();
		}
		dp[0]=1;
		for(int i=0;i<m;i++){
			for(int j=n;j>=w[i];j--){
				if(dp[j-w[i]]>0&&dp[j-w[i]]+w[i]*v[i]>dp[j]){
					dp[j]=dp[j-w[i]]+w[i]*v[i];
				}
			}
		}
		int ans=Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++){
			if(dp[i]>ans){
				ans=dp[i];
			}
		}
		System.out.println(ans-1);
	}

}
