package 基础dp.二维最长公共子序列问题;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str;
		while ((str = in.readLine()) != null) {
			StringTokenizer toke1 = new StringTokenizer(str);
			StringTokenizer toke2 = new StringTokenizer(in.readLine());
			int m = Integer.parseInt(toke1.nextToken());
			String str1 = toke1.nextToken();
			int n = Integer.parseInt(toke2.nextToken());
			String str2 = toke2.nextToken();

			int[][] array = new int[m + 1][n + 1];

//			for (int i = 0; i <= m; i++) {
//				array[i][0] = i;
//			}
//			for (int i = 0; i <= n; i++) {
//				array[0][i] = i;
//			}

			for (int i = 1; i <= m; i++) {
				for (int j = 1; j <= n; j++) {
					if (str1.charAt(i - 1) == str2.charAt(j - 1))
						array[i][j] = Math.min(Math.min(array[i - 1][j - 1],
								array[i - 1][j] + 1), array[i][j - 1] + 1);
					else
						array[i][j] = Math.min(Math.min(
								array[i - 1][j - 1] + 1, array[i - 1][j] + 1),
								array[i][j - 1] + 1);
				}
			}
			System.out.println(array[m][n]);
		}
	}

}