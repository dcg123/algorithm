package 尺取法;

import java.util.Scanner;

public class poj3276 {

	/**
	 * @param args
	 * N头牛排成一列1<=N<=5000。每头牛或者向前（表示为F）或者向后（表示为B）。
	 * 为了让所有牛都面向前方，农
	 * 夫每次可以将K头连续的牛转向1<=K<=N，求操作的最少次数M和对应的最小K。
	 */
	static int dir[]=new int[5000+2];
	static int n;
	static int f[]=new int[5000+2];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		n=scan.nextInt();
		scan.nextLine();
		for(int i=0;i<n;i++){
			String str=scan.nextLine();
			if(str.equals("F")){
				dir[i]=0;
			}else{
				dir[i]=1;
			}
		}
		sovle();
	}
	private static void sovle() {
		// TODO Auto-generated method stub
		int M=n,K=1;
		for(int k=1;k<=n;k++){
			int m=calc(k);
			if(m>0&&M>m){
				M=m;
				K=k;
			}
		}
		System.out.println(K+" "+M);
		System.out.println(5<<1);
	}
	private static int calc(int k) {
		// TODO Auto-generated method stub
		init();
		int res=0;
		int sum=0;
		for(int i=0;i+k<=n;i++){
			if((dir[i]+sum)%2!=0){
				res++;
				f[i]=1;
			}
			sum+=f[i];
			if(i-k+1>=0){
				sum-=f[i-k+1];
			}
		}
		for(int i=n-k+1;i<n;i++){
			if((dir[i]+sum)%2!=0){
				return -1;
			}
			if(i-k+1>=0){
				sum-=f[i-k+1];
			}
		}
		return res;
	}
	private static void init() {
		// TODO Auto-generated method stub
		for(int i=0;i<n;i++){
			f[i]=0;
		}
	}

}
