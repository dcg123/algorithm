package 图论.欧拉图;

import java.util.Arrays;
import java.util.Scanner;

public class poj2337 {

	/**
	 * @param args
	 * 题意：给你一些单词，能否将这些单词首尾连接起来，
	 * 即前一个单词的最后一个字母和后一个单词的第一个字母相同，
	 * 若能输出该序列，若有多种则按字典序输出该序列。
	 */
	class Edge {
		int to, next;
		int index;
		boolean flag;
	}

	static Edge edge[] = new Edge[2010];
	static int head[] = new int[30], tot;
	static int in[] = new int[30], out[] = new int[30];
	static int cnt;
	static int ans[] = new int[1010];
	static String str[] = new String[100];
	static poj2337 poj = new poj2337();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		int n;
		while ((t--) > 0) {
			n = scan.nextInt();
			scan.nextLine();
			for (int i = 0; i < n; i++) {
				str[i] = scan.nextLine();
			}
			Arrays.sort(str, 0, n);
			init();
			Arrays.fill(in, 1);
			Arrays.fill(out, 0);
			int start = 100;
			for (int i = n - 1; i >= 0; i--) {
				int u = str[i].charAt(0) - 'a';
				int v = str[i].charAt(str[i].length() - 1) - 'a';
				addedge(u, v, i);
				out[u]++;
				in[v]++;
				if (u < start)
					start = u;
				if (v < start)
					start = v;
			}
			int cc1 = 0, cc2 = 0;
			for (int i = 0; i < 26; i++) {
				if (out[i] - in[i] == 1) {
					cc1++;
					start = i;// �����һ�����ȱ���ȴ�1�ĵ㣬�ʹ������������������С�ĵ����
				} else if (out[i] - in[i] == -1)
					cc2++;
				else if (out[i] - in[i] != 0)
					cc1 = 3;
			}
			if (!((cc1 == 0 && cc2 == 0) || (cc1 == 1 && cc2 == 1))) {
				System.out.printf("***\n");
				continue;
			}
			cnt = 0;
			dfs(start);
			if (cnt != n)// �ж��Ƿ���ͨ
			{
				System.out.printf("***\n");
				continue;
			}
			 for(int i = cnt-1; i >= 0;i--)
		        {
		            System.out.println(str[ans[i]]);
		            if(i > 0)System.out.printf(".");
		            else System.out.printf("\n");
		        }
		}
	}

	private static void dfs(int u) {
		// TODO Auto-generated method stub
		for (int i = head[u]; i != -1; i = edge[i].next)
			if (!edge[i].flag) {
				edge[i].flag = true;
				dfs(edge[i].to);
				ans[cnt++] = edge[i].index;
			}
	}

	private static void addedge(int u, int v, int index) {
		// TODO Auto-generated method stub
		edge[tot] = poj.new Edge();
		edge[tot].to = v;
		edge[tot].next = head[u];
		edge[tot].index = index;
		edge[tot].flag = false;
		head[u] = tot++;
	}

	private static void init() {
		// TODO Auto-generated method stub
		tot = 0;
		Arrays.fill(head, -1);
	}

}
