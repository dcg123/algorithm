package 基础dp;

import java.util.Scanner;

public class poj2385 {

	/**
	 * @param args
	 * 题意很简单，两颗苹果树每一分会有树落下苹果，有人去接，
	 * 但是来回两个树之间的次数是一定的，所以求出在最大次数时最多能接到多少苹果。
	 *
	 * 状态方程一开始是想对了，但是还是有些细节没有注意啊。
	比如：开始的时候在tree1下面，这样如果给出显示第2颗树落下苹果的话，初始化代码就得改变，所以分两种情况。
	另外就是dp状态方程dp[i][j] = max(dp[i-1][j], dp[i-1][j-1])
	dp[i][j]标示在时间i，已经来回了j次时的最大苹果数目。
	这样dp方程肯定苹果数目不会变的，所以要注意，如果当前的次数刚到当前树下，dp[i][j]++;
	 */
//#include <stdio.h>
//#include <stdlib.h>
//#include <string.h>
//	int arr[1005];
//	int dp[1005][35];
//	int main()
//	{
//		int t,w;
//		while (scanf("%d %d", &t, &w) != EOF)
//		{
//			memset(dp, 0, sizeof(dp));
//			for (int i = 1; i <= t; ++ i )
//			{
//				scanf("%d", &arr[i]);
//			}
//			//初始化，开始在第一颗树下
//			if (arr[1] == 1)
//			{
//				dp[1][0] = 1;
//				dp[1][1] = 0;
//			}
//			if (arr[1] == 2)
//			{
//				dp[1][1] = 1;
//				dp[1][0] = 0;
//			}
//
//			for (int i = 2; i <= t; ++ i)
//			{
//				for (int j = 0; j <= w; ++ j)
//				{
//					//初始化
//					if (j == 0)
//					{
//						dp[i][j] = dp[i - 1][j] + arr[i] % 2;
//						continue;
//					}
//					//dp状态方程
//					dp[i][j] = dp[i - 1][j] > dp[i - 1][j - 1] ? dp[i - 1][j] : dp[i - 1][j - 1];
//					//如果本次是在第i颗树下，就会多收获一个苹果
//					if (j % 2 + 1 == arr[i])
//					{
//						dp[i][j] ++;
//					}
//				}
//			}
//			//找最大值
//			int ans = dp[t][0];
//			for (int i = 0; i <= w ; ++ i)
//			{
//				if (ans < dp[t][i])
//				{
//					ans = dp[t][i];
//				}
//			}
//			printf("%d\n", ans);
//		}
//		return 0;
//	}

}
