package bfs;

import java.util.Scanner;

public class poj3803 {

	/**
	 * @param args
	 * 给定一个连通网络，网络的结点数<=1000，求出这个网络的所有割点编号，
	 * 并求出若删去其中一个割点k后，对应的，原网络会被分割为多少个连通分量？
	 */
	class Node{
		int x,y,step;
	}
	static char map[][]=new char[50][50];
	static boolean vis[][]=new boolean[50][50];
	static int w,h;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int t=scan.nextInt();
		for(int i=0;i<t;i++){
			int x,y,x1,y1;
			w=scan.nextInt();
			h=scan.nextInt();
			scan.nextLine();
			for(int j=0;j<h;j++){
				String str=scan.nextLine();
				char a[]=str.toCharArray();
				for(int k=0;k<w;k++){
					map[i][j]=a[k];
					if(map[i][j]=='S'){
						x=j;
						y=k;
					}
					if(map[i][j]=='E'){
						x1=j;
						y1=k;
					}
				}
			}
			init();
			int ans=Integer.MAX_VALUE;
			//dfs(x,y,x1,y1);
		}
	}
	private static void dfs(int x, int y, int x1, int y1) {
		// TODO Auto-generated method stub
		
	}
	private static void init() {
		// TODO Auto-generated method stub
		for(int i=0;i<35;i++){
			for(int j=0;j<35;j++){
				vis[i][j]=false;
			}
		}
	}

}
