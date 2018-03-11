package dfs;

import java.util.Scanner;


public class poj1321 {

	/**
	 * @param args
	 * 在一个给定形状的棋盘（形状可能是不规则的）上面摆放棋子，棋子没有区别。
	 * 要求摆放时任意的两个棋子不能放在棋盘中的同一行或者同一列，‘
	 * 请编程求解对于给定形状和大小的棋盘，摆放k个棋子的所有可行的摆放方案C。
	 */
	static int k,n,totle,num;
	static char map[][]=new char[10][10];
	static boolean vis[]=new boolean[10];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		while(scan.hasNext()){
			n=scan.nextInt();
			k=scan.nextInt();
			if(n==-1&&k==-1){
				break;
			}
			scan.nextLine();
			for(int i=0;i<n;i++){
				String str=scan.nextLine();
				char a[]=str.toCharArray();
				for(int j=0;j<n;j++){
					map[i][j]=a[j];
				}
			}
			num=0;
			totle=0;
			dfs(0);
			System.out.println(totle);
		}
	}
	private static void dfs(int s) {
		// TODO Auto-generated method stub
		if(num==k){
			totle++;
			return;
		}
		if(s>=n){
			return ;
		}
	
		for(int i=0;i<n;i++){
			if(!vis[i]&&map[s][i]=='#'){
				vis[i]=true;
				num++;
				dfs(s+1);
				num--;
				vis[i]=false;
			}
		}
		dfs(s+1);
	}

}
