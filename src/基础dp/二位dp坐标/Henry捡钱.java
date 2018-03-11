package 基础dp.二位dp坐标;

import java.util.Scanner;

public class Henry捡钱 {

	/**
	 * @param args
	 */
	static int MAX_N=100;
	static int map[][]=new int[MAX_N][MAX_N];
	static int dp[][]=new int[MAX_N][MAX_N];
	static int n,m;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		m=scan.nextInt();
		n=scan.nextInt();
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				map[i][j]=scan.nextInt();
			}
		}
		dp[0][0]=0;
		int mid=n/2;
		int left=mid;
		int right=mid;
	//	System.out.println(left+" "+right);
		left=left-2>1?left-2:1;
		right=right+2>n?n:right+2;
		//System.out.println(left+" "+right);
		//for(int i=left;i<=right;i++){
		//	dp[m][i]=map[m][i];
		//}
		for(int i=m;i>=1;i--){
			for(int j=1;j<=n;j++){
				for(int k=j-2;k<=j+2;k++){
					if(k>=left&&k<=right){
						dp[i][j]=Math.max(dp[i+1][k]+map[i][j], dp[i][j]);
					}
				}
			}
			//left = left - 2 > 1 ? left - 2 : 1;  
           // right = right + 2 > n  ? n  : right + 2; 
		}
		int ans=Integer.MIN_VALUE;
		for(int i=0;i<n;i++){
			if(dp[1][i]>ans){
				ans=dp[1][i];
			}
		}
		System.out.println(ans);
	}

}
