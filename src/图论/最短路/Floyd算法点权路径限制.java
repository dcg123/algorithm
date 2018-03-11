package 图论.最短路;

import java.util.Scanner;


public class Floyd算法点权路径限制 {

	/**
	 *  Floyd算法，求从任意节点i到任意节点j的最短路径
	 *  cost[][]:初始化为INF（cost[i][i]：初始化为0）
	 *  val[]:点权，lowcost[][]:除起点、终点外的点权之和+最短路径
	 *  path[][]:路径限制，要求字典序最小的路径，下标1~N
	 */
	private static final  int MAXN = 110;
	private static  final  int cost[][]=new int[MAXN][MAXN];
//点权
	private static final int dre[]=new int[MAXN];
	private static final int INF=2147483647;
//字典序最小最短路径
	private static final int path[][] =new int[MAXN][MAXN];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		Floyd(n);
	}
	private static void Floyd(int n) {
		// TODO Auto-generated method stub
		for(int i=1;i<=n;i++){
			for(int j=1;j<=n;j++){
				path[i][j]=j;
			}
		}
		for(int k=1;k<=n;k++){
			for(int i=1;i<=n;i++){
				for(int j=1;j<=n;j++){
					int tem=cost[i][k]+cost[k][j]+dre[k];
					if(tem<cost[i][j]){
						cost[i][j]=tem;
						path[i][j]=path[i][k];
					}
					else if(cost[i][j]==tem&&path[i][j]>path[i][k]){
						path[i][j]=path[i][k];
					}
				}
			}
		}
	}

}
