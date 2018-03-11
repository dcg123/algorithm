package 最大二分匹配;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class hdu4751 {

	/**
	 * @param args
	 * 题目大意：给定一个些人物关系问是否能把所有的人分成两组，使得每一组的人都相互认识
	解题思路：任意两个人如果不是相互认识就建边，然后采用染色的方法判断是否为二分图即可
	 */
	static int maxn=110;
	static int n;
	static int map[][]=new int[maxn][maxn];
	static int col[]=new int[maxn];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		while(scan.hasNext()){
			n=scan.nextInt();
			if(n==-1){
				break;
			}
			init();
			for(int i=1;i<=n;i++){
				while(true){
					int a=scan.nextInt();
					if(a==0){
						break;
					}
					map[i][a]=1;
				}
			}
			int flag=0;
			for(int i=1;i<=n;i++){
				if(col[i]==0){
					col[i]=1;
					if(bfs(i,n)==0){
						flag=1;
					}
				}
			}
			if(flag==1){
				System.out.println("NO");
			}else{
				System.out.println("YES");
			}
		}
	}
	private static int bfs(int s, int n) {
		// TODO Auto-generated method stub
		Queue<Integer> queue=new LinkedList<>();
		queue.offer(s);
		while(queue.size()!=0){
			int c=queue.poll();
			for(int i=1;i<=n;i++){
				if(i==c||(map[i][c]==1)&&map[c][i]==1){
					continue;
				}
				else if(col[i]==0){
					if(col[c]==1){
						col[i]=2;
					}
					if(col[c]==2)col[i]=1;
					
					queue.offer(i);
				}
				else if(col[c]==col[i]){
					return 0;
				}
			}
		}
		return 1;
	}
	private static void init() {
		// TODO Auto-generated method stub
		for(int i=0;i<110;i++){
			col[i]=0;
			for(int j=0;j<110;j++){
				map[i][j]=0;
			}
		}
	}

}
