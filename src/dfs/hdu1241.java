package dfs;

import java.util.Scanner;


public class hdu1241 {

	/**
	 * @param args
	 *  遍历所有点，求出连通块的数量，每到一块油田，就采用DFS或者BFS消除该油田以及附近连通的油田。
	 */
	static int dir[][]={{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,1},{1,-1},{-1,-1}};  
	static int MAX_N=120;
	static char [][]map=new char[MAX_N][MAX_N];
	static int n,m;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		while(scan.hasNext()){
			n=scan.nextInt();
			m=scan.nextInt();
			if(n+m==0){
				break;
			}
			scan.nextLine();
			for(int i=0;i<n;i++){
				String str=scan.nextLine();
				char a[]=str.toCharArray();
				for(int j=0;j<m;j++){
					map[i][j]=a[j];
				}
			}
			int ans=0;
			for(int i=0;i<n;i++){
				for(int j=0;j<m;j++){
					if(map[i][j]=='@'){
						ans++;
						map[i][j]='*';
						dfs(i,j);
						
					}
				}
			}
			System.out.println(ans);
		}
	}
	private static void dfs(int x, int y) {
		// TODO Auto-generated method stub
		for(int i=0;i<8;i++){
			int dx=x+dir[i][0];
			int dy=y+dir[i][1];
			if(dx>=0&&dx<n&&dy>=0&&dy<m){
				if(map[dx][dy]=='@'){
					map[dx][dy]='*';
					dfs(dx,dy);
				}
			}
		}
	}

}
