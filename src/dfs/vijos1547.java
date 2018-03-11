package dfs;

import java.util.Scanner;


public class vijos1547 {

	/**
	 * @param args
	 * 有3部车在k个城市间旅游，每次只能移动一部车，去第k个城市的前提是前k-1个城市都去过。
	求旅行完k个城市的最短距离
	 */
	static int MAX_N=100+2;
	static int map[][]=new int[MAX_N][MAX_N];
	static int n,ans;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		n=scan.nextInt();
		for(int i=0;i<MAX_N;i++){
			for(int j=0;j<MAX_N;j++){
				map[i][j]=(1 << 31) - 1;  
			}
		}
		for(int i=1;i<=n;i++){
			for(int j=i+1;j<=n;j++){
				map[i][j]=scan.nextInt();
			}
		}
		ans=(1 << 31) - 1;  
		dfs(1,1,1,1,0);
		System.out.println(ans);
	}
	private static void dfs(int num, int a, int b, int c, int d) {
		// TODO Auto-generated method stubif
		if(num==n){
			ans=Math.min(ans, d);
			return ;
		}
		dfs(num+1,num+1,b,c,d+map[a][num+1]);
		dfs(num+1,a,num+1,c,d+map[b][num+1]);
		dfs(num+1,a,b,num+1,d+map[c][num+1]);
	}

}
