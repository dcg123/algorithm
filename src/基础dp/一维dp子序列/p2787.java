package 基础dp.一维dp子序列;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class p2787 {

	/**
	 * @param args
	 */
	class Node{
		int x,y;
	}
	static int MAX_N=5000+2;
	static int dp[]=new int[MAX_N];
	class cmp implements Comparator<Node>{

		@Override
		public int compare(Node o1, Node o2) {
			// TODO Auto-generated method stub
			return o1.x-o2.x>0?1:-1;
		}
		
	}
	static int n;
	static p2787 p=new p2787();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		n=scan.nextInt();
		Node node[]=new Node[n+1];
		for(int i=0;i<n;i++){
			int a=scan.nextInt();
			int b=scan.nextInt();
			node[i]=p.new Node();
			node[i].x=a;
			node[i].y=b;
			dp[i]=1;
		}
		Arrays.sort(node,0,n,p.new cmp());
		for(int i=1;i<n;i++){
			for(int j=0;j<i;j++){
				if(node[j].y<node[i].y&&dp[j]+1>dp[i]){
					dp[i]=dp[j]+1;
				}
			}
		
		}
		int max=-1;
		for(int i=0;i<n;i++){
			if(max<dp[i]){
				max=dp[i];
			}
			
		}
		System.out.println(max);
	}

}
