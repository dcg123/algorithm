package 图论.欧拉图;

import java.util.Arrays;
import java.util.Scanner;


public class Fleury算法求欧拉路径{

	/**
	 * @param args
	 */
	static int N=1005;
	static int n, m, flag, top, sum, du[]=new int[N], ans[]=new int[5005], map[][]=new int[N][N];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		while(scan.hasNext()){
			n=scan.nextInt();
			m=scan.nextInt();
			if(n+m==0){
				break;
			}
			Arrays.fill(du, 0);
		//	Arrays.fill(map, 0);
			for(int i=1;i<=n;i++){
				int x,y;
				x=scan.nextInt();
				y=scan.nextInt();
				map[x][y]++;
				map[y][x]++;
				du[x]++;
				du[y]++;
			}
			flag=1;
			sum=0;
			for(int i=1;i<=n;i++){
				if(du[i]%2==1){
					sum++;
					flag=i;
				}
			}
			if(sum==0||sum==2){
				fleury(flag);
			}
		}
	}
	private static void fleury(int x) {
		// TODO Auto-generated method stub
		top=1;
		ans[top]=x;
		while(top>0){
			int k=0;
			for(int i=1;i<=n;i++){
				if(map[top][1]>=1){
					k=1;
					break;
				}
			}
			if(k==0){
				System.out.println(ans[top]);
				top--;
			}
			else if(k==1){
				top--;
				dfs(ans[top+1]);
			}
		}
	}
	private static void dfs(int x) {
		// TODO Auto-generated method stub
		ans[++top]=x;
		for(int i=1;i<=n;i++){
			if(map[x][i]>=1){
				map[x][i]--;
				map[i][x]--;
				dfs(i);
				break;
			}
		}
	}

}
