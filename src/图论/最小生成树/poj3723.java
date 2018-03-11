package 图论.最小生成树;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class poj3723 {

	/**
	 * @param args
	 * 题意：要征兵n个男兵和m个女兵，每个花费10000元，
	 * 但是如果已经征募的男士兵中有和将要征募的女士兵关系好的，
	 * 那么可以减少花费，给出关系，求最小花费。

	分析：这个题目初始一个是个二分图，以为可以从这里入手，但是这个题目这个性质没用。
	初始花费没人10000，那么减去其中有关系的就是当前的花费。
	要是花费最少，那么减去的最大即可，又因为没人只征募一次，
	即最多选择一个，所以减去一个最大生成树就ok
	 */
	class Node{
		int x,y,v;
	}
	class cmp implements Comparator<Node>{
		@Override
		public int compare(Node o1, Node o2) {
			// TODO Auto-generated method stub
			return o1.v>o2.v?1:0;
		}
		
	}
	static int f[]=new int[20000+2];
	static int t,n,m,r,ans;
	static Node node[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		t=scan.nextInt();
		poj3723 poj=new poj3723();
		node=new Node[50000+2];
		while(t>0){
			n=scan.nextInt();
			m=scan.nextInt();
			r=scan.nextInt();
			init();
			for(int i=0;i<r;i++){
				node[i]=poj.new Node();
				node[i].x=scan.nextInt();
				node[i].y=scan.nextInt();
				node[i].v=scan.nextInt();
			}
			kruskal();
			System.out.println((n+m)*10000-ans);
			t--;
		}
	}
	private static void kruskal() {
		// TODO Auto-generated method stub
		poj3723 poj=new poj3723();
		Arrays.sort(node,0,r,poj.new cmp());
		for(int i=0;i<r;i++){
			if(un(node[i].x,node[i].y+n)){
				ans+=node[i].v;
			}
		}
	}
	private static boolean un(int x, int y) {
		// TODO Auto-generated method stub
		int fa=find(x);
		int fb=find(y);
		if(fa==fb){
			return false;
		}
		f[fa]=fb;
		return true;
	}
	private static int find(int x) {
		// TODO Auto-generated method stub
		if(f[x]==x)  
	        return x;  
	    return f[x] = find(f[x]);
	}
	private static void init() {
		// TODO Auto-generated method stub
		for(int i=0;i<=n+m;i++)
			f[i]=i;
		ans=0;
	}

}
