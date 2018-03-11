package dfs;

import java.util.Scanner;


public class poj2488 {

	/**
	 * @param args
	 *  任选一个起点，按照国际象棋马的跳法，
	 *  不重复的跳完整个棋盘，如果有多种路线则选择字典序最小的路线
	 *  （路线是点的横纵坐标的集合，注意棋盘的横坐标的用大写字母，纵坐标是数字)
	 */
	static int MAX_N=27;
	static int dx[] = {-1, 1, -2, 2, -2, 2, -1, 1}; 
	static int dy[] = {-2, -2, -1, -1, 1, 1, 2, 2};
	static boolean vis[][]=new boolean[MAX_N][MAX_N];
	static int t,p,q;
	class Path{
		char x,y;
	}
	static Path path[]=new Path[500];
	static boolean success=false;
	static poj2488 poj=new poj2488();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		t=scan.nextInt();
		for(int c=1;c<=t;c++){
			p=scan.nextInt();
			q=scan.nextInt();
			init();
			vis[1][1]=true;
			success=false;
			dfs(1,1,1);
			System.out.println("Scenario #"+c+":");
			if(success){
				for(int i=1;i<=p*q;i++){
					//System.out.println(path[i].y);
					System.out.print(path[i].y+""+path[i].x);
				}
				System.out.println();
			}else{
				System.out.println("impossible");
			}
			if(c!=t){
				System.out.println();
			}
		}
	}
	private static void dfs(int x, int y,int num) {
		// TODO Auto-generated method stub
		path[num]=poj.new Path();
		path[num].y=(char)(y+64);
		path[num].x=(char)(x+'0');
		if(num==p*q){
			success=true;
		}
		for(int i=0;i<8;i++){
			int xx=x+dx[i];
			int yy=y+dy[i];
			if(xx>0&&xx<=p&&yy>0&&yy<=q&&!vis[xx][yy]&&!success){
				vis[xx][yy]=true;
				dfs(xx,yy,num+1);
				vis[xx][yy]=false;
			}
		}
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
