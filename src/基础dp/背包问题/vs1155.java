package 基础dp.背包问题;

import java.util.Scanner;

public class vs1155 {

	/**
	 * @param args
	 */
	static int MAX_N=60+2;
	static int w[]=new int[MAX_N];
	static int v[]=new int[MAX_N];
	static int p[]=new int[MAX_N];
	static int q1[]=new int[MAX_N];
	static int q2[]=new int[MAX_N];
	static int dp[]=new int[32000+10];
	static int n,m;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		n=scan.nextInt()/10;
		m=scan.nextInt();
		for(int i=0;i<m;i++){
			w[i]=scan.nextInt()/10;
			v[i]=scan.nextInt();
			p[i]=scan.nextInt();
		}
		dp[0]=1;
		for(int i=0;i<m;i++){
			int t1=0,t2=0,k1=0,k2=0;
			if(p[i]==0){
				for(int k=i+1;k<m;k++){
					if(p[k]==i){
						t1=k;
						k1=1;
						break;
					}
				}
				
				 for (int k = t1 + 1; k <m;k++)  
		            {  
		                if (p[k] == i)  
		                {  
		                    t2 = k;  
		                    k2 = 1;  
		                    break;  
		                }  
		            }  
				 
				for(int j=n;j>=w[i];j--){
					if(dp[j-w[i]]>=0){
						dp[j]=Math.max(dp[j], dp[j-w[i]]+w[i]*v[i]);
						if(j-w[i]-w[t1]>=0&&k1==1){
							dp[j]=Math.max(dp[j], dp[j-w[i]-w[t1]]+w[i]*p[i]+w[t1]*p[t2]);
						}
						if(j-w[i]-w[t1]-w[t2]>=0&&k1==1&&k2==1){
							dp[j]=Math.max(dp[j], dp[j-w[i]-w[t1]-w[t2]]+w[i]*p[i]+w[t1]*p[t2]*w[t2]*p[t2]);
						}
					}
				}
		  
			}
		}
		int ans=Integer.MIN_VALUE;
		for(int i=0;i<n;i++){
			if(dp[i]>ans){
				ans=dp[i];
			}
		}
		System.out.println((ans-1)*10);
	}

}
