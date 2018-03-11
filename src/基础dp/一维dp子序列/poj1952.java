package 基础dp.一维dp子序列;

import java.util.Scanner;

public class poj1952 {

	/**
	 * @param args
	 * 这题要求最长下降子序列的长度和个数
	 */
	static int MAX_N = 5000 + 2;
	static int a[] = new int[MAX_N];
	static int dp[] = new int[MAX_N];
	static int maxnum[] = new int[MAX_N];
	static int n;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int n = scan.nextInt();
			for (int i = 0; i < n; i++) {
				a[i] = scan.nextInt();
				dp[i] = 1;
				maxnum[i] = 0;
			}
			for (int i = 1; i < n; i++) {
				for (int j = 0; j < i; j++) {
					if (a[j] > a[i] && dp[i] < dp[j] + 1) {
						dp[i] = dp[j] + 1;
					}
				}
			}
			for (int i = 0; i < n; i++) {
				if (dp[i] == 1) {
					maxnum[i] = 1;
				}
			}
			// �ҳ�ǰi�����а�����i���� ���غϵķ�����
			for (int i = 1; i <= n; i++) {
				for (int j = i - 1; j > 0; j--) {
					if (a[j] > a[i]) {
						if (dp[j] + 1 == dp[i]) {
							maxnum[i] += maxnum[j];
						}
					}
					if (a[j] == a[i]) {
						if (dp[i] == 1)
							maxnum[i] = 0;

						break;
					}
				}
			}
			int maxx = -1;
			for (int i = 1; i <= n; i++) {
				if (dp[i] > maxx)
					maxx = dp[i];
			}
			int ans = 0;
			for (int i = 1; i <= n; i++) {
				if (dp[i] == maxx)
					ans += maxnum[i];
			}
			System.out.println(maxx+" "+ans);
		}
	}

}
