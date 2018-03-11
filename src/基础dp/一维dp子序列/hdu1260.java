package 基础dp.一维dp子序列;

import java.util.Scanner;

public class hdu1260 {

	/**
	 * 　知道一个人买票花的时间和和前面那个人一起买票花的时间，问最少花多少时间可以把票卖完..

	 　　输入：

	 　　　　给出T，表示有T组样例

	 　　　　给出n，表示有n个人买票..

	 　　　　给出n个数表示这个人单独买票会花的时间..

	 　　　　给出n-1个数，表示这个人和前面那个人一起买票会花的时间..
	 *
	 * @param args
	 *            动态转移方程 dp[i]表示前i个人需要的最短时间 每个状态 有两种策虐两种方式 单独一个人 或相邻的两个人一起买
	 *            dp[i]=min(dp[i-1]+v[i],dp[i-2]+s[i]);
	 */
	static int MAX_N = 2000 + 2;
	static int dp[] = new int[MAX_N];
	static int s[] = new int[MAX_N];
	static int a[] = new int[MAX_N];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t > 0) {
			int k = scan.nextInt();
			for (int i = 1; i <= k; i++) {
				s[i] = scan.nextInt();
			}
			for (int i = 2; i <= k; i++) {
				a[i] = scan.nextInt();
			}
			if (k == 1) {
				System.out.printf("08:00:%02d am\n", s[1]);
				continue;
			}
			init();
			dp[0] = 0;
			dp[1] = s[1];
			for (int i = 2; i <= k; i++) {
				dp[i] = Math.min(dp[i - 1] + s[i], dp[i - 2] + a[i]);
			}
			int ss=dp[k]%60;  
	       dp[k]/=60;  
	       int  mm=dp[k]%60;  
	        dp[k]/=60;  
	        int hh=(dp[k]+8)%12;  
	        dp[k]=(dp[k]+8)/12;  
	        System.out.printf("%02d:%02d:%02d ",hh,mm,ss);  
	        if(dp[k]%2>0)  System.out.println("pm");
	        else    System.out.println("am");
			t--;
		}
	}

	private static void init() {
		// TODO Auto-generated method stub
		for (int i = 0; i < MAX_N; i++) {
			dp[i] = 0;
		}
	}

}
