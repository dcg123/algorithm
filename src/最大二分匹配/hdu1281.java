package 最大二分匹配;

import java.util.Scanner;

public class hdu1281 {

	/**
	 * @param args
	 * 题目描述：
	在一个N*M大小的棋盘中，有K个空位置，（
	1）在这些空位置上最多能放多少的“车”（一行或一列最多一个）。
	（2）空位置中，有的位置若不放“车”，
	就无法保证放尽量多的“车”，这样的格子被称做重要点，求重要点的个数
	 */
	static int max=105;
	static  int map[][]=new int[max][max];
	static int vis[]=new int[max];
	static int link[]=new int[max];
	static int n,m,k;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int iCase=0;
		while(scan.hasNext()){
			n=scan.nextInt();
			m=scan.nextInt();
			k=scan.nextInt();
			if(n==0||m==0){
				break;
			}
			iCase++;
			for(int i=0;i<k;i++){
				int a=scan.nextInt();
				int b=scan.nextInt();
				map[a][b]=1;
			}
			int ans=hungary();
			int cnt=0;
			for(int i=1;i<=n;i++){
				for(int j=1;j<=m;j++){
					if(map[i][j]==1){
						map[i][j]=0;
						if(ans>hungary()){
							cnt++;
						}
						map[i][j]=1;
					}
				}
			}
			System.out.println("Board "+iCase+" have "+cnt+" important blanks for "+ans+" chessmen.");
		}
		
	}
	private static int hungary() {
		// TODO Auto-generated method stub
		int res = 0;
		for(int i=0;i<105;i++)link[i]=0;
		for(int i=1;i<=n;i++){
			for(int j=0;j<105;j++)vis[j]=0;
			if(dfs(i)){
				res++;
			}
		}
		return res;
	}
	private static boolean dfs(int x) {
		// TODO Auto-generated method stub
		for(int i=1;i<=n;i++){
			if(map[x][i]==1&&vis[i]==0){
				vis[i]=1;
				if(link[i]==0||dfs(i)){
					link[i]=x;
					return true;
				}
			}
		}
		return false;
	}

}
