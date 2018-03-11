package 基础dp.二维最长公共子序列问题;

import java.util.Scanner;

public class hdu1176 {

	/**
	 * @param args
	 * 都说天上不会掉馅饼，但有一天gameboy正走在回家的小径上，忽然天上掉下大把大把的馅饼。说来gameboy的人品实在是太好了，这馅饼别处都不掉，就掉落在他身旁的10米范围内。馅饼如果掉在了地上当然就不能吃了，所以gameboy马上卸下身上的背包去接。但由于小径两侧都不能站人，所以他只能在小径上接。由于gameboy平时老呆在房间里玩游戏，虽然在游戏中是个身手敏捷的高手，但在现实中运动神经特别迟钝，每秒种只有在移动不超过一米的范围内接住坠落的馅饼。现在给这条小径如图标上坐标：


	为了使问题简化，假设在接下来的一段时间里，馅饼都掉落在0-10这11个位置。开始时gameboy站在5这个位置，因此在第一秒，他只能接到4,5,6这三个位置中其中一个位置上的馅饼。问gameboy最多可能接到多少个馅饼？
	 */
	static int MAX_N = 100000 + 2;
	static int map[][] = new int[MAX_N][11];
	static int n;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			n = scan.nextInt();
			if (n == 0) {
				break;
			}
			init();
			int max = 0;
			for (int i = 1; i <= n; i++) {
				int d = scan.nextInt();
				int t = scan.nextInt();
				map[t][d]++;
				if (max < t) {
					max = t;
				}
			}
			for (int i = max-1; i >=0 ; i--) {
				for (int j = 1; j <= 9; j++) {
					
						map[i][j]+=maxi(map[i+1][j-1],map[i+1][j],map[i+1][j+1]);
					
				}
				map[i][0]+=Math.max(map[i+1][0],map[i+1][1]);
				map[i][10]+=Math.max(map[i+1][10],map[i+1][9]);
			}
			System.out.println(map[0][5]);
		}
	}

	private static void init() {
		// TODO Auto-generated method stub
		for(int i=0;i<MAX_N;i++){
			for(int j=0;j<11;j++)
			map[i][j]=0;
		}
	}

	private static int maxi(int a, int b, int c) {
		// TODO Auto-generated method stub
		int max1;
	    max1=a>b?a:b;
	    max1=max1>c?max1:c;
	    return max1;
		
	}

}
