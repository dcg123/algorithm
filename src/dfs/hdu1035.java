package dfs;

import java.util.Scanner;


public class hdu1035 {

	/**
	 * @param args
	 */
	static int h,w,begin;
	static char map[][]=new char[12][12];
	static int vis[][]=new int[12][12];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		while(scan.hasNext()){
			h=scan.nextInt();
			w=scan.nextInt();
			if(w+h==0){
				break;
			}
			begin=scan.nextInt();
		
			scan.nextLine();
			
			for(int i=0;i<h;i++){
				String str=scan.nextLine();
				char a[]=str.toCharArray();
				for(int j=0;j<w;j++){
					map[i][j]=a[j];
				}
			}
			init();
			int step=1;
			boolean flag=false;
			int loop=0;
			int y=begin-1;
			//x1=0;
			int x1=0;
			int x=0;
			while(true){
				if(x1<0||y<0||x1>=h||y>=w){
					step--;
					break;
				}
				else if(map[x1][y]=='W'&&vis[x1][y]==0){
					vis[x1][y]=step;
					y--;
				}
				else if(map[x1][y]=='S'&&vis[x1][y]==0){
					vis[x1][y]=step;
					x1++;
				}else if(map[x1][y]=='E'&&vis[x1][y]==0){
					vis[x1][y]=step;
					y++;
				}else if(map[x1][y]=='N'&&vis[x1][y]==0){
					vis[x1][y]=step;
					x1--;
				}
				else if(vis[x1][y]==1){
					step--;
					loop=step-vis[x1][y]+1;
					flag=true;
					break;
				}
				step++;
			}
			int a=step-loop;
			if(flag){
				System.out.println(a+" step(s) before a loop of "+step+" step(s)");
			
			}else{
				System.out.println(step+" step(s) to exit");
			}
			
		}
	}
	private static void init() {
		// TODO Auto-generated method stub
		for(int i=0;i<12;i++){
			for(int j=0;j<12;j++){
				vis[i][j]=0;
			}
		}
	}

}
