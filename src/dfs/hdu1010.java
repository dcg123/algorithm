package dfs;

import java.util.Scanner;


public class hdu1010 {

	/**
	 * @param args
	 * 题意:根据地图,'S'为开始位置,'D'为门的位置,' . '为空地,'X'为墙,不能经过,
	问:在指定的时间,是否能到达'门'的位置.
	 */
	static int d[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int MAX_N=10;
	static char map[][]=new char[MAX_N][MAX_N];
	static boolean vis[][]=new boolean[MAX_N][MAX_N];
	static int n,m,t,dx,dy;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		while(scan.hasNext()){
			n=scan.nextInt();
			m=scan.nextInt();
			t=scan.nextInt();
			if(n+m+t==0){
				break;
			}
			scan.nextLine();
			int x=0,y=0;
			for(int i=0;i<n;i++){
				String str=scan.nextLine();
				char a[]=str.toCharArray();
				for(int j=0;j<m;j++){
					map[i][j]=a[j];
					if(map[i][j]=='s'){
						x=i;y=j;
						map[i][j]='.';
					}
					if(map[i][j]=='D'){
						dx=i;
						dy=j;
					}
				}
			}
			int step=0;
			init();
			int res=dfs(x,y,step);
			if(res==0){
				System.out.println("NO");
			}else{
				System.out.println("YES");
			}
		}
	}
	private static int dfs(int x, int y, int step) {
		// TODO Auto-generated method stub
		if(step>t){
			return 0;
		}
		if(map[x][y]=='D'){
			return step;
		}
		for(int i=0;i<4;i++){
			int sx=x+d[i][0];
			int sy=y+d[i][1];
			if(ok(sx,sy)&&!vis[sx][sy]&&map[sx][sy]!='X'){
				vis[sx][sy]=true;
				dfs(sx,sy,step+1);
				vis[sx][sy]=false;
			}
		}
		return 0;
	}
	private static boolean ok(int sx, int sy) {
		// TODO Auto-generated method stub
		if(sx<0||sx>=n||sy<0||sy>=m){
			return false;
		}
		return true;
	}
	private static void init() {
		// TODO Auto-generated method stub
		for(int i=0;i<MAX_N;i++){
			for(int j=0;j<MAX_N;j++){
				vis[i][j]=false;
			}
		}
	}

}
