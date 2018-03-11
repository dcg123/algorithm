package 基础dp.背包问题;

import java.util.Scanner;

public class hdu1114 {

	/**
	 * @param args
	 *            给出小猪钱罐的重量和装满钱后的重量，然后是几组数据，每组数据包括每种钱币的价值与重量
	 *
	 *            要求出重量最少能装满钱罐时的最大价值
	 */
	static int MAX_N = 500 + 2;
	static int dp[] = new int[1000005];
	static int w[] = new int[MAX_N];
	static int v[] = new int[MAX_N];
	static int t, n;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		t = scan.nextInt();
		while (t > 0) {
			int em = scan.nextInt();
			int to = scan.nextInt();
			int s = to - em;
			n = scan.nextInt();
			for (int i = 0; i < n; i++) {
				v[i] = scan.nextInt();
				w[i] = scan.nextInt();
				dp[i] = 1000000;
			}
			for (int i = 0; i <= s; i++) {
				dp[i] = 10000000;
			}
			dp[0] = 1;
			for (int i = 0; i < n; i++) {
				for (int j = w[i];j<=s;j++) {
					if (dp[j - w[i]] > 0 ) {
						dp[j] =Math. min(dp[j],dp[j-w[i]]+v[i]);  
					}
				}
			}
			if(dp[s] == 10000000)  {
				System.out.println("This is impossible.");
			}else{
				System.out.println("The minimum amount of money in the piggy-bank is "+(dp[s]-1)+".");
			}

			t--;
		}
	}

}
