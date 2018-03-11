package dfs;

import java.util.Scanner;

public class hdu1539 {
	/**
	 * @param args
	 *            Description
	 *            公司现在要发明一种新的碎纸机，要求新的碎纸机能够把纸条上的数字切成最接近而不超过target值。比如，
	 *            target的值是50，
	 *            而纸条上的数字是12346，应该把数字切成四部分，分别是1,2,34,6。因为这样所得到的和43(=1+2+34+6)
	 *            是所有可能中最接近而不超过50的。（比如1,23,4和6 就不可以,因为它们的和不如43接近50，而12, 34,
	 *            6也不可以，因为它们的和超过50了）。碎纸还有以下三个要求： 1、如果target的值等于纸条上的值，则不能切。
	 *            2、如果没有办法把纸条上的数字切成小于target
	 *            ，则输出error。如target是1而纸条上的数字是123，则无论你如何切得到的和都比1大。
	 *            3、如果有超过一种以上的切法得到最佳值
	 *            ，则输出rejected。如target为15，纸条上的数字是111，则有以下两种切法11、1或者1、11.
	 *            你的任务是编写程序对数字进行划分以达到最佳值
	 */
	static int MAX_N;
	static int path[] = new int[MAX_N];
	static int ans_path[] = new int[MAX_N];
	static int targt, len, ans, count, num, tag = 2;
	static String str;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			str = scan.nextLine();
			String s[] = str.split(" ");
			len = s[1].length() - 1;
			targt = Integer.valueOf(s[0]);
			dfs(0, 0, 0);
		}
	}

	private static void dfs(int pos, int sum, int step) {
		// TODO Auto-generated method stub
		if (sum > targt) {
			return;
		}
		if (pos == len) {
			if (sum == ans) {
				tag = 2;
			} else if (sum > ans) {
				ans = sum;
				num = step;
				tag = 1;
				for (int i = 0; i < step; i++) {
					ans_path[i] = path[i];
				}
			}
			return;
		}
		int tmp = 0;
		for (int i = pos; i < len; i++) {
			tmp = tmp * 10 + str.charAt(i) - '0';
			path[step] = tmp;
			dfs(i + 1, sum + tmp, step + 1);
		}
	}

}
