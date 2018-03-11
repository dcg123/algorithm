package 基础dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 *            �����ܶ���������ݣ��ֱ������ǵ����غ����٣�Ϊ��֤������Խ���ܵ�Խ����Ҫ��һ�����ݣ������ɸ�������ɣ�
	 *            ��֤����������������Ӷ��������μ�С������������������ж������󣬲������ش�С���������Щ�����˳��
	 */
	class Node {
		int w, s, pos;
	}

	static int MAX_N = 1005;
	static Main hud = new Main();
	static int dp[] = new int[MAX_N];
	static int path[] = new int[MAX_N];
	static Node node[] = new Node[MAX_N];
	static int ans[] = new int[MAX_N];

	class cmp implements Comparator<Node> {

		@Override
		public int compare(Node o1, Node o2) {
			// TODO Auto-generated method stub
			return o1.w - o2.w > 0 ? 1 : -1;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int num = 0;
		 while(scan.hasNext()){
		 // int w=scan.nextInt();
		 // int s=scan.nextInt();
		 node[num]=hud.new Node();
		 node[num].w=scan.nextInt();
		 node[num].s=scan.nextInt();
		 node[num].pos=num+1;
		 num++;
		 }
//		for (int i = 0; i < 9; i++) {
//			node[num] = hud.new Node();
//			node[num].w = scan.nextInt();
//			node[num].s = scan.nextInt();
//			node[num].pos = num + 1;
//			num++;
//		}
		Arrays.sort(node, 0, num, hud.new cmp());
		int pos = -1, mx = 0;
		for (int i = 0; i < num; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (node[j].w < node[i].w && node[j].s > node[i].s) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
					path[i] = j;
					//System.out.println(j);
				}
			}

		}
		for(int i=0;i<num;i++){
			if(mx<dp[i]){
				mx=dp[i];
				pos=i;
			}
		}
		System.out.println(mx);
		print(pos);
	}

	private static void print(int pos) {
		// TODO Auto-generated method stub
		if(pos == 0)return ;
	    print(path[pos]);
	    System.out.printf("%d\n", node[pos].pos);
	}

}
