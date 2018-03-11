package 基础dp.最长公共子序列;

import java.util.Scanner;

public class hdu1087 {

	/**
	 * @param args
	 * 最长公共子序列
	 */
	static int MAX_N=1000+2;
	static int dp[]=new int[MAX_N];
	static int num[]=new int[MAX_N];
	static int t,n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		while(scan.hasNext()){
			n=scan.nextInt();
			if(n==0){
				break;
			}
			for(int i=1;i<=n;i++){
				num[i]=scan.nextInt();
				dp[i]=num[i];
			}
			for(int i=2;i<=n;i++){
				
				for(int j=1;j<i;j++){
					if(num[j]<num[i]&&dp[i]<dp[j]+num[i]){
						dp[i]=dp[j]+num[i];
					}
				}
			}
			int ans=-1;
			for(int i=1;i<=n;i++){
				if(ans<dp[i]){
					ans=dp[i];
				}
				
			}
			System.out.println(ans);
		}
	}

}
