package 基础dp.一维dp子序列;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class hdu1069 {

	/**
	 * @param args
	 * 题意：
	一堆科学家研究猩猩的智商，给他M种长方体，每种N个。
	然后，将一个香蕉挂在屋顶，让猩猩通过 叠长方体来够到香蕉。

	现在给你M种长方体，计算，最高能堆多高。
	要求位于上面的长方体的长要大于（注意不是大于等于）下面长方体的长，上面长方体的宽大于下面长方体的宽。
	 */
	class Node {
		int w, h, l;
	}

	static int MAX_N = 5000 + 2;
	static int dp[] = new int[MAX_N];

	class cmp implements Comparator<Node> {

		@Override
		public int compare(Node a, Node b) {
			// TODO Auto-generated method stub
//			if(a.w == b.w) return a.l < b.l?1:-1;  
//		    else return a.w < b.w?1:-1;  
			return a.w-b.w;
				
		}
	}

	static int n;
	static hdu1069 p = new hdu1069();
	static Node node[] = new Node[181];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		int len = 0;
		for (int i = 0; i < n; i++) {
			int z1 = scan.nextInt(), z2 = scan.nextInt(), z3 = scan.nextInt();
			node[len] = p.new Node();
			node[len].l = z1;
			node[len].w = z2;
			node[len++].h = z3;

			// System.out.println(len);
			node[len] = p.new Node();
			node[len].l = z1;
			node[len].w = z3;
			node[len++].h = z2;
			node[len] = p.new Node();
			node[len].l = z2;
			node[len].w = z1;
			node[len++].h = z3;
			node[len] = p.new Node();
			node[len].l = z2;
			node[len].w = z3;
			node[len++].h = z1;
			node[len] = p.new Node();
			node[len].l = z3;
			node[len].w = z1;
			node[len++].h = z2;
			node[len] = p.new Node();
			node[len].l = z3;
			node[len].w = z2;
			node[len++].h = z1;
		}
		Arrays.sort(node, 0, len, p.new cmp());
		int ans=0;
		ans=dp[0] = node[0].h;
		ans = dp[0] = node[0].h;
		for(int i = 1; i < len; ++i) {
			dp[i] = node[i].h;
			for(int j = i - 1; j >= 0; --j) 
				if(node[i].w < node[j].w && node[i].l < node[j].l)
					dp[i] = Math.max(dp[i], dp[j] + node[i].h);
			ans =Math. max(ans, dp[i]);
		}
		System.out.println(ans);
	}

}