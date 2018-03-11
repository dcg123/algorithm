package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class poj3278 {

	/**
	 * @param args
	 *            题意： FJ要抓奶牛。 开始输入N（FJ的位置）K（奶牛的位置）。
	 *            FJ有三种移动方法： 1、向前走一步，耗时一分钟。
	 *            2、向后走一步，耗时一分钟。 3、向前移动到当前位置的两倍N*2，耗时一分钟。
	 *            问FJ抓到奶牛的最少时间。PS：奶牛是不会动的。
	 */
	static int n, k;
	static boolean vis[] = new boolean[100000 + 2];
	static int step[] = new int[100000 + 2];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		k = scan.nextInt();
		if (n >= k) {
			System.out.println(n - k);
		} else {
			int ans=bfs();
			System.out.println(ans);
		}
	}

	private static int bfs() {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new LinkedList<Integer>();
		int next=0;
		while (!queue.isEmpty()) {
			queue.clear();
		}
		queue.offer(n);
		vis[n] = true;
		step[n]=0;
		while(!queue.isEmpty()){
			int from=queue.poll();
			for(int i=0;i<3;i++){
				if(i==0){
					next=from+1;
				}
				if(i==1){
					next=from-1;
				}
				if(i==2){
					next=from*2;
				}
				if(next<0||next>100001){
					continue;
				}
				if(!vis[next]){
					step[next]=step[from]+1;
					queue.offer(next);
					vis[next]=true;
				}
				if(next==k){
					return step[k];
				}
			}
		}
		return 0;
	}

}
